# 🏦 Oracle PL/SQL Core Banking System

This repository contains a robust, production-ready PL/SQL core banking system simulation. It focuses on automated financial operations, data integrity validations, and transactional safety guidelines through two primary modules: Advanced Control Structures (Loops, Cursors, and Date Arithmetic) and Parameterized Stored Procedures.

---

# 💻 Environment & Operational Setup Constraint
Due to security and administrative policy restrictions enforced on institutional student profiles (blocking Docker Desktop, nested virtualization, and local administrative privileges), this project bypasses local installations. 

Instead, it utilizes a cloud-native development workflow:
* **Code Workspace & File Management:** Visual Studio Code (VS Code)
* **Database Execution & Compiler Engine:** [Oracle Live SQL](https://livesql.oracle.com)
* **Version Control System:** Git & GitHub Cloud Repository

---
 # 📊 Database Schema Architecture

The relational engine operates on five core tables, managed via specific constraint boundaries:

1. **`CUSTOMERS`**: Stores baseline account owner details, liquid net worth values, and VIP status tracking.
2. **`ACCOUNTS`**: Tracks specialized asset pools categorized by service lines (e.g., Savings, Checking).
3. **`LOANS`**: Manages liability principal balances, assigned interest rates, and structural maturity lifecycles.
4. **`EMPLOYEES`**: Records internal administrative payroll statistics, hierarchies, and department assignments.
5. **`TRANSACTIONS`**: Serves as the central immutable ledger, auditing every account balance mutation with strict entry types (`DEBIT`, `CREDIT`, `INTEREST`).

---

# 🎯 Project Core Competencies
* **ACID Compliance:** Ensures zero financial leaks through explicit transaction blocks, validation checks, and automatic recovery protocols.
* **Cursor Management:** Implements bulk explicit cursors with `FOR UPDATE` data-concurrency locks.
* **Error Mitigation:** Utilizes `RAISE_APPLICATION_ERROR` blocks to intercept unauthorized execution paths or overdraft attempts.


The transaction engine acts on five interrelated entity sets structured with full relational integrity constraints:

  [ CUSTOMERS ] ─────── 1:N ───────► [ ACCOUNTS ]
        │                                  │
        │ 1:N                              │ 1:N
        ▼                                  ▼
   [ LOANS ]                        [ TRANSACTIONS ]
                                           ▲
  [ EMPLOYEES ] ─── (Admin/Payroll) ───────┘



  
CUSTOMERS: Holds primary client identification assets, automated age-calculation benchmarks via Date of Birth (DOB), and high-net-worth tier classifications (IsVIP).

ACCOUNTS: Categorizes capital holdings into specific banking product portfolios (Savings vs Checking) tied back to customer records via Foreign Key rules.

LOANS: Monitors liability balances, active interest percentages, and maturity schedules.

TRANSACTIONS: An immutable historical ledger tracking all financial balance mutations. Every movement generates a structured entry category (DEBIT, CREDIT, or INTEREST).

EMPLOYEES: Tracks the corporate payroll structure, department designations, and compensation metrics.

# 🎯 Technical Competencies & Implementation Scope
1. Advanced Control Structures (Exercise 1)
Explicit Cursor Processing: Bypasses memory overhead limits by streaming data via explicit cursors, using row-level context management.

Date Arithmetic Integration: Computes ages and deadlines dynamically relative to the runtime environment using SYSDATE calculations.

Conditional Control Formulations: Uses nested IF-THEN-ELSE and CASE conditional workflows to route accounts safely based on their data profile.

2. High-Integrity Stored Procedures (Exercise 3)
ACID Transaction Protocols: Protects the database state during multi-row transfers by wrapping updates in explicit transaction blocks, using named SAVEPOINT boundaries and automatic ROLLBACK recovery.

Native Server-Side Validations: Intercepts unauthorized states (such as negative deposits, non-existent accounts, or insufficient balances) using strict RAISE_APPLICATION_ERROR exception handling blocks.

Concurrency Controls: Uses FOR UPDATE clauses to lock data rows when fetching records, preventing race conditions or double-spending anomalies during simultaneous transactions.



# 📁 Repository Directory Manifest
Your workspace folder structure is organized into the following clear layout:


Plaintext

PlSql/


├── README.md                  # Comprehensive system overview (This file)
├── EXECUTION_GUIDE.md         # Database initialization seeds and manual runner notes
├── INDEX.md                   # Full script mapping guide and expected output logs
├── MANIFEST.md                # Final submission asset validation checklist
│
├── exercise1_scenario1.sql    # Loop engine checking ages and applying senior loan discounts
├── exercise1_scenario2.sql    # Conditional loop promoting high-value clients to VIP tier
├── exercise1_scenario3.sql    # Automated query tracking and alerting for near-due loans
│
├── process_monthly_interest.sql # Stored procedure generating passive interest entries
├── update_employee_bonus.sql    # Parameterized procedure processing salary modifications
└── transfer_funds.sql           # Double-entry ledger engine with rollback safety controls


# 🧪 Quick Diagnostic Verification
To prove the schema environment is running with complete database integrity, execute this data dictionary check inside your active cloud session:

# SQL
SELECT table_name FROM user_tables;
Required Output Assertions: The compiler response terminal must register exactly 5 distinct tables: CUSTOMERS, ACCOUNTS, LOANS, TRANSACTIONS, and EMPLOYEES.

# 🐙 Git Delivery Workflow Reference
Use these standard commands inside your integrated VS Code terminal panel to record your progress history and push your project to GitHub:

Bash
 Check current staging area and modified file status
git status

 Stage all documentation files and PL/SQL scripts
git add .

Save a snapshot to local history with a clear description
git commit -m "docs: compile and finalize enterprise-grade README documentation schema"

Push the local changes up to the remote master branch
git push origin main