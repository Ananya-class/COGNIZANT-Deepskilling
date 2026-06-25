-- ========================================================================
-- File: exercise1_scenario3.sql
-- Objective: Fetch all loans due within the next 30 days and print 
--            reminder messages for the customers.
-- ========================================================================

DECLARE
    v_days_until_due NUMBER;
    
    CURSOR c_due_loans IS
        SELECT l.LoanID, l.CustomerID, c.Name, l.LoanAmount, l.EndDate
        FROM LOANS l
        JOIN CUSTOMERS c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate > SYSDATE AND l.EndDate <= SYSDATE + 30;
BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('LOAN PAYMENT REMINDERS');
    DBMS_OUTPUT.PUT_LINE('========================================');

    FOR r_loan IN c_due_loans LOOP
        v_days_until_due := TRUNC(r_loan.EndDate - SYSDATE);
        
        DBMS_OUTPUT.PUT_LINE('[REMINDER] Loan Due Within 30 Days!');
        DBMS_OUTPUT.PUT_LINE('  Loan ID: ' || r_loan.LoanID || ' | Customer: ' || r_loan.Name);
        DBMS_OUTPUT.PUT_LINE('  Amount: $' || r_loan.LoanAmount || ' | Days Left: ' || v_days_until_due);
        DBMS_OUTPUT.PUT_LINE('----------------------------------------');
    END LOOP;
END;
/