# 🏦 Oracle PL/SQL Banking Assignment

Complete solution for Exercise 1 (Control Structures) and Exercise 3 (Stored Procedures) with detailed documentation and execution instructions verified via Oracle Live SQL.

📋 Table of Contents
- Project Overview
- Database Schema Layout
- Exercise 1: Control Structures
- Exercise 3: Stored Procedures
- Setup & Execution Guide
- Verification Queries
- Screenshot Checklist
- Git Workflow Summary

---

## 🎯 Project Overview

This banking system assignment demonstrates advanced production-level PL/SQL programming concepts:
* **Control Structures:** Iterative loops, conditional logic branches, and explicit row cursor streaming.
* **Stored Procedures:** Multi-parameter procedures containing explicit server-side guardrails and data validation.
* **Transaction Management:** Strict ACID compliance enforcement through atomic `COMMIT`, `ROLLBACK`, and transactional `SAVEPOINT` configurations.
* **Error Handling:** Graceful system exception management via custom `RAISE_APPLICATION_ERROR` interceptors.
* **Data Manipulation:** Multi-row relational alterations mapping complex `UPDATE` and `INSERT` auditing patterns.

### Target Execution Environment
* **Primary Compiler Engine:** [Oracle Live SQL Cloud Workbench](https://livesql.oracle.com) (Deployed to bypass nested virtualization policy locks on managed profiles)
* **Local Workspace Manager:** Visual Studio Code (VS Code)


``` COGNIZANT-Deepskilling/
└── Deepskilling/
    └── week-1/
        └── Plsql/
            ├── README.md                    # Main project blueprint with tables
            ├── EXECUTION_GUIDE.md           # Simple script runner guide
            │
            ├── exercise1_scenario1.sql      # Scenario 1: Senior Citizen Discount Loop
            ├── exercise1_scenario2.sql      # Scenario 2: VIP Customer Classification
            ├── exercise1_scenario3.sql      # Scenario 3: Loan Payment Reminders
            │
            ├── process_monthly_interest.sql # Scenario 1: Savings Interest Procedure
            ├── update_employee_bonus.sql    # Scenario 2: Employee Bonus Modifier
            └── transfer_funds.sql           # Scenario 3: Secure Fund Transfer Engine


---
```

## 📊 Database Schema Layout

### Entity Relationship & Core Structure

```text
  [ CUSTOMERS ] ─────── 1:N ───────► [ ACCOUNTS ]
        │                                  │
        │ 1:N                              │ 1:N
        ▼                                  ▼
   [ LOANS ]                        [ TRANSACTIONS ]
                                           ▲
  [ EMPLOYEES ] ─── (Admin/Payroll) ───────┘

```

1. CUSTOMERS TableColumn NameData TypeConstraint / RuleCustomerIDNUMBERPRIMARY KEYNameVARCHAR2(100)NOT NULLDOBDATEUsed for Age MetricsBalanceNUMBERRunning Liquid WorthLastModifiedDATESystem Update LogIsVIPVARCHAR2(1)' Y' or 'N' (Default)
2. ACCOUNTS TableColumn NameData TypeConstraint / RuleAccountIDNUMBERPRIMARY KEYCustomerIDNUMBERFOREIGN KEY -> CUSTOMERSAccountTypeVARCHAR2(20)'Savings' or 'Checking'BalanceNUMBERAvailable Liquid PoolLastModifiedDATETimestamp
3. LOANS TableColumn Name Data Type Constraint / Rule LoanID NUMBER PRIMARY KEY CustomerID NUMBER FOREIGN KEY -> CUSTOMERS LoanAmount NUMBER Principal Value InterestRate NUMBER Bounded Base IndexStartDate DATE Origination DateEndDate DATE Maturity Target Horizon
4. TRANSACTIONS TableColumn NameData TypeConstraint / RuleTransactionIDNUMBERPRIMARY KEY (Via Sequence)AccountIDNUMBERFOREIGN KEY -> ACCOUNTSTransactionDateDATEAuto System DateAmountNUMBERTransaction Value AmountTransactionTypeVARCHAR2(20)'DEBIT', 'CREDIT', 'INTEREST'
5. EMPLOYEES TableColumn NameData TypeConstraint / RuleEmployeeIDNUMBERPRIMARY KEYNameVARCHAR2(100)Employee Legal NamePositionVARCHAR2(50)Core Operational RoleSalaryNUMBERBase Compensation IndexDepartmentVARCHAR2(50)Unit Label (e.g., 'IT', 'HR')HireDateDATEStart Timestamp🔄 Exercise 1: Control Structures Scenario 1: Senior Citizen Discount File: exercise1_scenario1.sqlObjective: Scan the client network, establish ages from birth dates, and apply a 1% discount factor onto loan base values for any senior over60.

 ``` Expected Output Signature: Plaintext========================================

SENIOR CITIZEN DISCOUNT PROCESSING
========================================
Customer: John Davis (ID: 1)
  DOB: 15-MAY-1960 | Age: 66
  Status: SENIOR CITIZEN - Applying 1% discount
    Loan ID: 1 | Old Rate: 5% | New Rate: 4.95%
Scenario 2: VIP Customer ClassificationFile: exercise1_scenario2.sqlObjective: Loop through accounts and toggle the IsVIP state flag to 'Y' for records containing liquid balances exceeding $10,000.

Expected Output Signature:Plaintext========================================
VIP CUSTOMER CLASSIFICATION
========================================
Customer: Michael Chen | Balance: $25000.00
  Status: UPGRADED TO VIP ✓
Scenario 3: Loan Payment RemindersFile: exercise1_scenario3.sqlObjective: Isolate active obligations maturing inside a 30-day window and generate high-priority alerting reports.

Expected Output Signature:Plaintext========================================
LOAN PAYMENT REMINDERS
========================================
[REMINDER] Loan Due Within 30 Days!
  Loan ID: 1 | Customer: John Davis | Days Left: 10


```
## 🔧 Exercise 3: Stored Procedures Scenario
``` 1: ProcessMonthlyInterestFile: process_monthly_interest.sqlSignature: PROCEDURE ProcessMonthlyInterestObjective: Identify checking asset partitions, compute a 1% compound yield margin, alter respective balances, and push audit entries onto the transactional records.Scenario
2: UpdateEmployeeBonusFile: update_employee_bonus.sqlSignature: PROCEDURE UpdateEmployeeBonus(p_department IN VARCHAR2, p_bonus_percentage IN NUMBER)Objective: Dynamically apply compensation modifiers across user-specified corporate units with input validations guarding against null or out-of-bounds parameters.Scenario 3: TransferFundsFile: transfer_funds.sqlSignature: PROCEDURE TransferFunds(p_from_account_id IN NUMBER, p_to_account_id IN NUMBER, p_transfer_amount IN NUMBER)Objective: Execute an account-to-account double-entry transfer. Utilizes transaction savepoints to roll back state adjustments if an overdraft or liquidity block is hit during operation.🚀 Setup & Execution Guide (Oracle Live SQL)Step
``` 1: Initialize Database Objects & Seed Values. Paste the initial infrastructure block into your Live SQL editor worksheet to generate the schemas and seed entities:SQL--


 1. Create Baseline Tables
CREATE TABLE CUSTOMERS (
    CustomerID NUMBER PRIMARY KEY, Name VARCHAR2(100), DOB DATE, Balance NUMBER, LastModified DATE, IsVIP VARCHAR2(1) DEFAULT 'N'
);
CREATE TABLE LOANS (
    LoanID NUMBER PRIMARY KEY, CustomerID NUMBER, LoanAmount NUMBER, InterestRate NUMBER, StartDate DATE, EndDate DATE, FOREIGN KEY (CustomerID) REFERENCES CUSTOMERS(CustomerID)
);
CREATE TABLE ACCOUNTS (
    AccountID NUMBER PRIMARY KEY, CustomerID NUMBER, AccountType VARCHAR2(20), Balance NUMBER, LastModified DATE, FOREIGN KEY (CustomerID) REFERENCES CUSTOMERS(CustomerID)
);
CREATE TABLE TRANSACTIONS (
    TransactionID NUMBER PRIMARY KEY, AccountID NUMBER, TransactionDate DATE, Amount NUMBER, TransactionType VARCHAR2(20)
);
CREATE TABLE EMPLOYEES (
    EmployeeID NUMBER PRIMARY KEY, Name VARCHAR2(100), Position VARCHAR2(50), Salary NUMBER, Department VARCHAR2(50), HireDate DATE
);

-- 2. Create Audit Sequence Ledger Trace
CREATE SEQUENCE TRANSACTIONS_SEQ START WITH 1 INCREMENT BY 1;

-- 3. Load Sample Test Entities
INSERT INTO CUSTOMERS VALUES (1, 'John Davis', TO_DATE('15-MAY-1960','DD-MON-YYYY'), 15000, SYSDATE, 'N');
INSERT INTO CUSTOMERS VALUES (2, 'Sarah Johnson', TO_DATE('22-AUG-1978','DD-MON-YYYY'), 8500, SYSDATE, 'N');
INSERT INTO CUSTOMERS VALUES (3, 'Michael Chen', TO_DATE('10-MAR-1985','DD-MON-YYYY'), 25000, SYSDATE, 'N');
INSERT INTO LOANS VALUES (1, 1, 50000, 5.0, SYSDATE-365, SYSDATE+10); 
INSERT INTO ACCOUNTS VALUES (1, 1, 'Savings', 15000, SYSDATE);
INSERT INTO ACCOUNTS VALUES (2, 1, 'Checking', 5000, SYSDATE);
INSERT INTO ACCOUNTS VALUES (3, 2, 'Savings', 8500, SYSDATE);
INSERT INTO EMPLOYEES VALUES (101, 'Alice Smith', 'Manager', 80000, 'IT', SYSDATE-1000);
INSERT INTO EMPLOYEES VALUES (102, 'Bob Johnson', 'Developer', 65000, 'IT', SYSDATE-500);
COMMIT;
Step 2: Executing scriptsFor Exercise 1 Scripts: Open the target .sql source script from your local workspace repository folder copy, copy the contents, paste them directly into your Live SQL editor layout workspace canvas, and click Run. Always read terminal print outputs under the DBMS Output panel tab.For Exercise 3 Procedures: Run the code block defining your procedural parameters to compile it into the active cloud engine system database context (Procedure compiled). Clear your workspace panel layout, wrap your execution target call inside a standard container execution wrapper, and select run:SQLBEGIN
    TransferFunds(1, 2, 100);
END;
/
``` # ✅ Verification QueriesRun these specific diagnostic checks to audit state changes directly from the repository tracking sheets:SQL-- 1. Check schema table deployment consistency metrics
SELECT table_name FROM user_tables;

-- 2. Audit post-execution VIP user tiers
SELECT CustomerID, Name, Balance, IsVIP FROM CUSTOMERS WHERE IsVIP = 'Y';

-- 3. Monitor post-transfer accounting ledger rows
SELECT * FROM TRANSACTIONS ORDER BY TransactionID DESC;

``` ## 📸 Screenshot Checklist: 
[ ] Split-Screen verification image showing your VS Code local environment window canvas on the left side, with your browser displaying successful Oracle Live SQL console logs on the right.
[ ] Database Schema check returning exactly 5 user table objects.[ ] Senior citizen processing layout displaying John Davis (Age: 66) successfully gaining a 1% discount margin.
[ ] Successful fund transaction balance change layout alongside an overdraft failure test validation catch (ORA-20014: Insufficient funds).


```
 # 🐙 Git Workflow Summary: Maintain file consistency within your target subdirectory mapping path using these commands inside your integrated terminal window: Bash# Navigate to the target subdirectory mapping path context
cd C:\Users\anany\Desktop\COGNIZANT\Deepskilling\week-1\Plsql

# Initialize version tracking
git init
git remote add origin [https://github.com/Ananya-class/COGNIZANT-Deepskilling.git](https://github.com/Ananya-class/COGNIZANT-Deepskilling.git)

# Pull updates to sync local repository history with your online repository profile
git pull origin main --rebase

# Stage and record project progress snapshots
git add .
git commit -m "feat: implement and verify all 6 banking workspace scripts via Live SQL"

# Push updates directly up onto your online repository profile main path branch
git push -u origin main


# 👤 Author Profile ContextDeveloper
 Name: Ananya Pantula
Academic Tracker Node: Information Technology Student,
 Vignan’s Institute of Engineering for Women (Affiliated to JNTU-GV)
Assigned Assignment Phase: COGNIZANT Deepskilling Training Core Workspace Last
Updated: 25-JUN-2026 | Version: 1.0 |
Status: Completed for Deployment Validation
