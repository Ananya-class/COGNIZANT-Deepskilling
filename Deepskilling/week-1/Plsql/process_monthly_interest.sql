-- ========================================================================
-- File: process_monthly_interest.sql
-- Objective: Stored procedure to add 1% interest to all Savings accounts.
-- ========================================================================

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_interest_amount ACCOUNTS.Balance%TYPE;
    v_new_balance     ACCOUNTS.Balance%TYPE;

    CURSOR c_savings IS
        SELECT AccountID, CustomerID, Balance 
        FROM ACCOUNTS 
        WHERE AccountType = 'Savings'
        FOR UPDATE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('MONTHLY INTEREST PROCESSING');
    DBMS_OUTPUT.PUT_LINE('========================================');

    FOR r_acc IN c_savings LOOP
        v_interest_amount := r_acc.Balance * 0.01;
        v_new_balance := r_acc.Balance + v_interest_amount;
        
        UPDATE ACCOUNTS 
        SET Balance = v_new_balance, LastModified = SYSDATE
        WHERE AccountID = r_acc.AccountID;
        
        INSERT INTO TRANSACTIONS (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (TRANSACTIONS_SEQ.NEXTVAL, r_acc.AccountID, SYSDATE, v_interest_amount, 'INTEREST');
        
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || r_acc.AccountID || ' | Added: $' || v_interest_amount || ' | New Balance: $' || v_new_balance);
    END LOOP;
    COMMIT;
END ProcessMonthlyInterest;
/