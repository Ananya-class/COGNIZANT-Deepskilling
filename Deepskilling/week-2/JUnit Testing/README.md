# JUnit 4 Basic Testing Exercises

[cite_start]A foundational unit testing module implementing the **Arrange-Act-Assert (AAA) pattern**, test fixtures, and comprehensive asset validation states using the JUnit 4 framework in Java[cite: 1, 15, 21, 39].

## 📌 Project Overview
Quality assurance via unit testing is a core pillar of production-grade software development. [cite_start]This repository transitions an application from manual verification workflows to automated assertions[cite: 4, 16, 21]. [cite_start]It demonstrates standard component lifecycle hooks (`@Before` and `@After`) alongside structural test patterns[cite: 39, 41, 44].

---

## 📂 Repository Structure

The module is structured as follows:

| File / Folder Name | Component Type | Description |
| :--- | :--- | :--- |
| `lib/` | **Dependency Binary** | [cite_start]Contains the foundational testing JARs (`junit-4.13.2.jar` and `hamcrest-core-1.3.jar`)[cite: 7, 11]. |
| `Calculator.java` | **Production Code** | [cite_start]A lightweight calculation service layer containing methods targeted for unit validation[cite: 18]. |
| `AssertionsTest.java` | **Test Suite** | [cite_start]Demonstrates different assertion states including equality, logical truths, and nullability pointers[cite: 21, 23]. |
| `AAALifecycleTest.java` | **Test Suite** | [cite_start]Showcases structural isolated test fixtures using the Arrange-Act-Assert sequence[cite: 39, 41, 43]. |

---

## 🛠️ Environment Setup & Classpath Execution

Because this project runs as a pure standalone Java application without an external build orchestrator (like Maven or Gradle), external library binaries must be fed manually to the Java Compiler (`javac`) and Runtime Environment (`java`) via the Classpath flag (`-cp`).

### Prerequisites
1. **Java Development Kit (JDK)**: Version 17 or higher.
2. [cite_start]**JUnit Binaries**: Ensure `junit-4.13.2.jar` and `hamcrest-core-1.3.jar` reside cleanly within your local `lib/` directory[cite: 7, 11].

### Compilation Command
To bundle your production logic alongside your testing suites while linking the dependencies, execute the following command in your VS Code terminal:
```powershell
javac -cp "lib/*" Calculator.java AssertionsTest.java AAALifecycleTest.java

``` 
Execution CommandTo invoke the native JUnit Console Test Runner engine and review your test assertions, run the target test class using the command below:
PowerShell:
java -cp ".;lib/*" org.junit.runner.JUnitCore AAALifecycleTest

 # 🔍 Core Concepts Covered
 
 1. Arrange-Act-Assert (AAA) Pattern   Tests are decoupled into clean, highly readable 
 steps:  
 Arrange: Establish the target state, instantiate instances, and configure variables.
  Act: Call the specific method under test to capture the output value.  
  Assert: Verify that the generated output exactly matches the expected business rule.  
  2. Test Fixtures Lifecycle Hooks   @Before (Setup): Allocates fresh, pristine memory states before each test method runs to prevent state pollution across separate evaluations.  
  @After (Teardown): Cleans up resources immediately after a test completes to keep system operations stable.  