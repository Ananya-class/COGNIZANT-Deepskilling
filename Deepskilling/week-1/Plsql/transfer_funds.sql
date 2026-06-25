-- ========================================================================
-- File: transfer_funds.sql
-- Objective: Transfer money between accounts with comprehensive validation.
-- ========================================================================

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_transfer_amount IN NUMBER
) AS
    v_from_balance    ACCOUNTS.Balance%TYPE;
    v_from_exists     NUMBER;
    v_to_exists       NUMBER;
BEGIN
    -- Validations
    IF p_transfer_amount <= 0 OR p_from_account_id = p_to_account_id THEN
        RAISE_APPLICATION_ERROR(-20011, 'Invalid transaction parameters.');
    END IF;
    
    SELECT COUNT(*) INTO v_from_exists FROM ACCOUNTS WHERE AccountID = p_from_account_id;
    SELECT COUNT(*) INTO v_to_exists   FROM ACCOUNTS WHERE AccountID = p_to_account_id;
    
    IF v_from_exists = 0 OR v_to_exists = 0 THEN
        RAISE_APPLICATION_ERROR(-20013, 'Account structural references not found.');
    END IF;

    SELECT Balance INTO v_from_balance FROM ACCOUNTS WHERE AccountID = p_from_account_id FOR UPDATE;

    IF v_from_balance < p_transfer_amount THEN
        RAISE_APPLICATION_ERROR(-20014, 'Insufficient funds.');
    END IF;

    -- Transaction Border Safe Check
    SAVEPOINT transfer_start;

    UPDATE ACCOUNTS SET Balance = Balance - p_transfer_amount WHERE AccountID = p_from_account_id;
    UPDATE ACCOUNTS SET Balance = Balance + p_transfer_amount WHERE AccountID = p_to_account_id;

    INSERT INTO TRANSACTIONS VALUES (TRANSACTIONS_SEQ.NEXTVAL, p_from_account_id, SYSDATE, p_transfer_amount, 'DEBIT');
    INSERT INTO TRANSACTIONS VALUES (TRANSACTIONS_SEQ.NEXTVAL, p_to_account_id, SYSDATE, p_transfer_amount, 'CREDIT');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('✓ Transfer of $' || p_transfer_amount || ' completed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO transfer_start;
        DBMS_OUTPUT.PUT_LINE('Transaction Error: ' || SQLERRM);
END TransferFunds;
/