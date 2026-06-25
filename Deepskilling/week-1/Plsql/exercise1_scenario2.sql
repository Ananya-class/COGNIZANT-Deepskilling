-- ========================================================================
-- File: exercise1_scenario2.sql
-- Objective: Iterate through all customers and set IsVIP flag to 'Y' 
--            for accounts with balances over $10,000.
-- ========================================================================

DECLARE
    v_vip_status VARCHAR2(1);
    
    CURSOR c_customers IS
        SELECT CustomerID, Name, Balance 
        FROM CUSTOMERS;
BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('VIP CUSTOMER CLASSIFICATION');
    DBMS_OUTPUT.PUT_LINE('========================================');

    FOR r_cust IN c_customers LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || r_cust.Name || ' | Balance: $' || r_cust.Balance);
        
        IF r_cust.Balance > 10000 THEN
            v_vip_status := 'Y';
            DBMS_OUTPUT.PUT_LINE('  Status: UPGRADED TO VIP ✓');
        ELSE
            v_vip_status := 'N';
            DBMS_OUTPUT.PUT_LINE('  Status: Standard Tier');
        END IF;
        
        UPDATE CUSTOMERS 
        SET IsVIP = v_vip_status, 
            LastModified = SYSDATE
        WHERE CustomerID = r_cust.CustomerID;
    END LOOP;
    COMMIT;
END;
/