# Financial Forecasting Tool (Recursive Engine)

An algorithmic predictive application designed to project future portfolio valuations based on multi-year historical compound growth patterns. This project explores recursive logic and cache optimization techniques within a financial software framework.

## 📌 Project Overview
Predicting long-term market asset trajectories requires tracking cumulative returns compounding over distinct intervals. This module implements a clean divide-and-conquer strategy using **Recursion**, alongside an **Optimized Memoization Layer** to eliminate duplicate computations during deep multi-period calls.

---

## 📂 Repository Structure

| File Name | Component Type | Description |
| :--- | :--- | :--- |
| `GrowthData.java` | **Data Wrapper** | Encapsulates the initial capital value and variable historical rate arrays. |
| `FinancialForecaster.java` | **Algorithmic Core** | Houses both the native recursive stack-based computation and the top-down cached optimization method. |
| `Main.java` | **Execution Engine** | Orchestrates sample data parameters and logs execution values to standard console output. |
| `PROJECT_SUMMARY.md` | **Documentation** | Provides a business overview, design intents, and project milestones. |
| `ANALYSIS.md` | **Technical Paper** | Details the time-complexity transition from exponential scaling behaviors down to linear processing speed. |

---
## 🛠️ Local Environment Setup & Execution

Follow these steps to run and test this module inside **Visual Studio Code**:

### Prerequisites
1. **Java Development Kit (JDK)**: Ensure JDK 17 or higher is installed.
2. **VS Code Extensions**: Install the **Extension Pack for Java** by Microsoft.

### Compilation and Execution via Terminal
1. Open Visual Studio Code and make sure your terminal is inside the `Financial Forecasting` directory.
2. Compile the Java files:
   ```powershell
   javac Main.java GrowthData.java FinancialForecaster.java

## Run the application:

PowerShell
java Main


## Expected Console Output
Plaintext
--- Standard Recursive Forecasting ---
Value after 10 years: $17779.14

--- Optimized Memoized Forecasting ---
Value after 10 years: $17779.14
## 👥 Authors & Collaborators
Ananya Pantula - Lead Developer / SAC President
