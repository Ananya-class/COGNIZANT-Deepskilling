-- ========================================================================
-- File: exercise1_scenario1.sql
-- Objective: Loop through all customers, check age, and apply a 1% discount 
--            to loan interest rates for senior citizens (> 60 years old).
-- ========================================================================

DECLARE
    v_age NUMBER;
    v_discounted_rate LOANS.InterestRate%TYPE;
    v_loan_count NUMBER := 0;
    
    CURSOR c_senior_loans IS
        SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
        FROM CUSTOMERS c
        JOIN LOANS l ON c.CustomerID = l.CustomerID;
BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('SENIOR CITIZEN DISCOUNT PROCESSING');
    DBMS_OUTPUT.PUT_LINE('========================================');

    FOR r_cust IN c_senior_loans LOOP
        v_age := TRUNC((SYSDATE - r_cust.DOB) / 365.25);
        
        DBMS_OUTPUT.PUT_LINE('Customer: ' || r_cust.Name || ' (ID: ' || r_cust.CustomerID || ')');
        DBMS_OUTPUT.PUT_LINE('  DOB: ' || TO_CHAR(r_cust.DOB, 'DD-MON-YYYY') || ' | Age: ' || v_age);
        
        IF v_age > 60 THEN
            v_discounted_rate := r_cust.InterestRate * 0.99;
            
            UPDATE LOANS
            SET InterestRate = v_discounted_rate
            WHERE LoanID = r_cust.LoanID;
            
            v_loan_count := v_loan_count + 1;
            DBMS_OUTPUT.PUT_LINE('  Status: SENIOR CITIZEN - Applying 1% discount');
        ELSE
            DBMS_OUTPUT.PUT_LINE('  Status: Not eligible for discount');
        END IF;
        DBMS_OUTPUT.PUT_LINE('----------------------------------------');
    END LOOP;
    COMMIT;
END;
/