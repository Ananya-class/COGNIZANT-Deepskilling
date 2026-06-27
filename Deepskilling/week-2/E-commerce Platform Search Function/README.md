# E-Commerce Search Optimization Backend

A high-performance backend catalog lookup module designed to optimize product retrieval times across large e-commerce inventories. This project implements, benchmarks, and analyzes core searching algorithms written in Java to solve scalability bottlenecks.

## 📌 Project Overview
In large-scale e-commerce platforms, search latency directly impacts customer retention and conversion rates. This module provides a foundational framework to benchmark **Linear Search** versus **Binary Search** methodologies using standard Object-Oriented Programming (OOP) paradigms.

---

## 📂 Repository Structure

The project is structured cleanly to separate concerns between the data layer, algorithmic logic, execution runtime, and architectural analysis:

| File Name | Component Type | Description |
| :--- | :--- | :--- |
| `Product.java` | **Data Model** | Represents an individual inventory item with key search attributes (`productId`, `productName`, `category`). |
| `SearchAlgorithms.java` | **Business Logic** | House the clean, comment-free implementations of both sequential and logarithmic search algorithms. |
| `Main.java` | **Execution Layer** | Mock data factory and benchmark orchestrator that instantiates and executes the search logic. |
| `PROJECT_SUMMARY.md` | **Documentation** | Executive summary regarding project scope, feature sets, and business outcomes. |
| `ANALYSIS.md` | **Technical Whitepaper** | Deep-dive mathematical and architectural analysis comparing Big O complexities and infrastructure implications. |

---

## 🛠️ Local Environment Setup & Execution

Follow these steps to run and test this project locally inside **Visual Studio Code**:

### Prerequisites
1. **Java Development Kit (JDK)**: Ensure JDK 17 or higher is installed on your machine.
2. **VS Code Extensions**: Install the **Extension Pack for Java** by Microsoft.

### Compilation and Execution
1. Open Visual Studio Code and open the root folder containing these files (`File > Open Folder...`).
2. VS Code will automatically detect the Java project and build the workspace.
3. Navigate to `Main.java` via the Explorer sidebar.
4. Click the **Run** button located directly above the `main` method declaration, or press `F5`.

### Expected Console Output
Upon execution, the system outputs the success states of both retrieval engines:
```text
--- Linear Search Demonstration ---
Result for ID 102: Product{id=102, name='Desk Lamp', category='Home Decor'}

--- Binary Search Demonstration ---
Result for ID 102: Product{id=102, name='Desk Lamp', category='Home Decor'}