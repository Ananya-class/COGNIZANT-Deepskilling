-- ========================================================================
-- File: update_employee_bonus.sql
-- Objective: Update employee salaries based on department and bonus percentage.
-- ========================================================================

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department       IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) AS
    v_dept_count       NUMBER;
    v_bonus_amount     EMPLOYEES.Salary%TYPE;
    v_new_salary       EMPLOYEES.Salary%TYPE;
    
    CURSOR c_employees IS
        SELECT EmployeeID, Name, Salary
        FROM EMPLOYEES
        WHERE Department = p_department
        FOR UPDATE;
BEGIN
    -- Validations
    IF p_department IS NULL OR p_bonus_percentage < 0 OR p_bonus_percentage > 100 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Invalid inputs provided.');
    END IF;
    
    SELECT COUNT(*) INTO v_dept_count FROM EMPLOYEES WHERE Department = p_department;
    IF v_dept_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Department does not exist or has no employees.');
    END IF;

    DBMS_OUTPUT.PUT_LINE('========================================');
    DBMS_OUTPUT.PUT_LINE('EMPLOYEE BONUS UPDATE: ' || p_department);
    DBMS_OUTPUT.PUT_LINE('========================================');

    FOR r_emp IN c_employees LOOP
        v_bonus_amount := r_emp.Salary * (p_bonus_percentage / 100);
        v_new_salary   := r_emp.Salary + v_bonus_amount;
        
        UPDATE EMPLOYEES SET Salary = v_new_salary WHERE EmployeeID = r_emp.EmployeeID;
        DBMS_OUTPUT.PUT_LINE('Employee: ' || r_emp.Name || ' | New Salary: $' || v_new_salary);
    END LOOP;
    COMMIT;
END UpdateEmployeeBonus;
/