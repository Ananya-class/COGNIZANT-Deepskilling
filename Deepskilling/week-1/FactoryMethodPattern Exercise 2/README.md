

```markdown
# 🖨️ Exercise 2: Implementing the Factory Method Pattern

## 📌 Scenario
We are developing a robust **Document Management System** that can dynamically create and process different types of digital documents (e.g., Word, PDF, Excel) without hardcoding the initialization logic inside the main client application.

---

## 🛠️ Design & Implementation Details
* **Pattern Used:** Factory Method Pattern (Creational)
* **Loose Coupling:** The client interactions rely entirely on abstract abstractions (`Document` and `DocumentFactory`). 
* **Scalability:** To add a new document type tomorrow (like a PowerPoint or HTML file), we simply add a new product class and its companion creator factory without modifying a single line of pre-existing code!

---

## 📂 File Blueprint
* `Document.java`: The primary interface defining standard document operations (`open()` / `close()`).
* `WordDocument.java`, `PdfDocument.java`, `ExcelDocument.java`: Concrete product representations.
* `DocumentFactory.java`: The abstract creator defining our core factory method hook.
* `WordFactory.java`, `PdfFactory.java`, `ExcelFactory.java`: Subclassed implementation factories that instantiate individual products.
* `FactoryMethodTest.java`: Test class demonstrating clean resource decoupling.

---

## 🚀 How to Compile & Run

Open your terminal directly inside this folder and run:

```powershell
# 1. Compile all decoupled classes 
javac *.java

# 2. Fire up the factory test setup
java FactoryMethodTest
📊 Expected Verification Output
Plaintext
=== Starting Factory Method Pattern Demonstration ===

--- Processing Word Request ---
📝 Opening Microsoft Word document... Loading margins and styles.
💾 Saving and closing Word document.

--- Processing PDF Request ---
📕 Opening PDF document... Rendering vector layouts securely.
🔒 Closing PDF reader container.

--- Testing Shared Factory Print Operation ---
📊 Opening Excel Spreadsheet... Initializing formula grids and charts.
🖨️ Sending data stream to printer channel...
💾 Auto-saving cells and closing Excel sheet.

🎯 SUCCESS: Factory Method Pattern implemented successfully!