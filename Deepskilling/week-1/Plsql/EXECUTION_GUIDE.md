# 🚀 Step-by-Step Environment Setup & Execution Guide

Follow this guide to provision your temporary cloud-based Oracle database instance and execute the workload modules.

---

## 🛠️ Step 1: Provision the Mock Banking Environment

1. Navigate to your web browser, open [livesql.oracle.com](https://livesql.oracle.com), and authenticate using your Oracle account.
2. Paste the following schema initialization and seed script into the active **SQL Worksheet** editor canvas, then click **Run**:

```sql
-- ==========================================
-- 1. DATABASE SCHEMA INITIALIZATION
-- ==========================================

CREATE TABLE CUSTOMERS (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP VARCHAR2(1) DEFAULT 'N'
);

CREATE TABLE LOANS (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMERS(CustomerID)
);

CREATE TABLE ACCOUNTS (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMERS(CustomerID)
);

CREATE TABLE TRANSACTIONS (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(20)
);

CREATE TABLE EMPLOYEES (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Initialize global tracker sequence for transaction ledger entries
CREATE SEQUENCE TRANSACTIONS_SEQ START WITH 1 INCREMENT BY 1;

-- ==========================================
-- 2. LIVE SEED TEST DATA POPULATION
-- ==========================================

INSERT INTO CUSTOMERS VALUES (1, 'John Davis', TO_DATE('15-MAY-1960','DD-MON-YYYY'), 15000, SYSDATE, 'N');
INSERT INTO CUSTOMERS VALUES (2, 'Sarah Johnson', TO_DATE('22-AUG-1978','DD-MON-YYYY'), 8500, SYSDATE, 'N');
INSERT INTO CUSTOMERS VALUES (3, 'Michael Chen', TO_DATE('10-MAR-1985','DD-MON-YYYY'), 25000, SYSDATE, 'N');

-- Seed a loan that naturally falls inside the 30-day warning horizon
INSERT INTO LOANS VALUES (1, 1, 50000, 5.0, SYSDATE-365, SYSDATE+10); 

INSERT INTO ACCOUNTS VALUES (1, 1, 'Savings', 15000, SYSDATE);
INSERT INTO ACCOUNTS VALUES (2, 1, 'Checking', 5000, SYSDATE);
INSERT INTO ACCOUNTS VALUES (3, 2, 'Savings', 8500, SYSDATE);

INSERT INTO EMPLOYEES VALUES (101, 'Alice Smith', 'Manager', 80000, 'IT', SYSDATE-1000);
INSERT INTO EMPLOYEES VALUES (102, 'Bob Johnson', 'Developer', 65000, 'IT', SYSDATE-500);

COMMIT;



# These are standalone scripts that run instantly.

Open your code file in VS Code (e.g., exercise1_scenario1.sql).

Highlight all the text and copy it.

Go to your browser tab with Oracle Live SQL, clear the main code worksheet, and paste your code.

Click the blue Run button in the top right corner.

Click the DBMS Output tab right under your code window to view your report!

Repeat these exact steps for Scenarios 2 and 3.

🔧 Part 2: How to Run the Stored Procedures (Exercise 3)
Stored procedures require two separate steps: Compile (saving it to the database) and Execute (running it).

1. Monthly Interest (process_monthly_interest.sql)
Step A: Copy your procedure code from VS Code, paste it into Live SQL, and click Run. Look at the bottom log—it must say Procedure compiled.

Step B: Clear your worksheet screen, type this tiny snippet, and click Run:

SQL
BEGIN ProcessMonthlyInterest; END;
/
Check your DBMS Output tab to see your interest payments report.

2. Employee Bonus (update_employee_bonus.sql)
Step A: Copy your procedure code from VS Code, paste it into Live SQL, and click Run to compile it.

Step B: Clear your worksheet screen, type this snippet to give the IT department a 10% bonus, and click Run:

SQL
BEGIN UpdateEmployeeBonus('IT', 10); END;
/
3. Transfer Funds (transfer_funds.sql)
Step A: Copy your procedure code from VS Code, paste it into Live SQL, and click Run to compile it.

Step B (Success Test): Clear your worksheet screen, type this snippet to move $100 from Account 1 to Account 2, and click Run:

SQL
BEGIN TransferFunds(1, 2, 100); END;
/
Step C (Failure Test): Clear your worksheet screen, type this snippet to try moving a massive $500,000, and click Run:

SQL
BEGIN TransferFunds(1, 2, 500000); END;
/