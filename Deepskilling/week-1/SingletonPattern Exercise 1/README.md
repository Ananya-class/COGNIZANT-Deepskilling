# 🔒 Exercise 1: Implementing the Singleton Pattern

## 📌 Scenario
We need to ensure that a logging utility class in our application has **only one instance** throughout the application lifecycle to guarantee consistent logging behavior and save system resources.

---

## 🛠️ Design & Implementation Details
* **Pattern Used:** Singleton Method (Creational)
* **Thread Safety Mechanism:** Implemented using **Double-Checked Locking** along with a `volatile` instance variable to handle concurrent thread requests safely.
* **Reflection Protection:** Added an explicit fallback guard inside the private constructor to throw an exception if anyone attempts to bypass visibility using reflection tools.

---

## 📂 File Blueprint
* `Logger.java`: The core Singleton resource controller class featuring private instantiation gates and global factory methods.
* `SingletonTest.java`: The diagnostic test engine that runs checks to verify if distinct object variables resolve to the identical hash address.

---

## 🚀 How to Compile & Run

Make sure you have deleted any conflicting package headers from the code files, open your terminal inside this folder, and execute:

```powershell
# 1. Clean and compile all files
javac *.java

# 2. Run the validation engine
java SingletonTest



=== Starting Singleton Pattern Verification ===

[2026-06-25 10:50:12] [INFO] Initializing database connection pool...
[2026-06-25 10:50:12] [INFO] User authentication request received for 'Ananya'.

--- Verification Results ---
Instance 1 Memory HashCode: 12345678
Instance 2 Memory HashCode: 12345678
Are both instances identical? -> true

🎯 SUCCESS: The Singleton Pattern was successfully implemented! Only one Logger instance exists.