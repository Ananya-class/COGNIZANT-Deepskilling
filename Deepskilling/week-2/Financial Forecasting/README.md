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

## 🛠️ Execution Context
Open this folder in **VS Code**, make sure your Java tooling is active, open `Main.java`, and run the file using `F5` or by using the inline editor links.