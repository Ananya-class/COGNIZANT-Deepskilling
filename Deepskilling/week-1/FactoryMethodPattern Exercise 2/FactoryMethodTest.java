
public class FactoryMethodTest {

    public static void main(String[] args) {
        System.out.println("=== Starting Factory Method Pattern Demonstration ===\n");

        // 1. Instantiate the distinct document creators
        DocumentFactory wordCreator = new WordFactory();
        DocumentFactory pdfCreator = new PdfFactory();
        DocumentFactory excelCreator = new ExcelFactory();

        // 2. Generate and interact with a Word Document
        System.out.println("--- Processing Word Request ---");
        Document myWord = wordCreator.createDocument();
        myWord.open();
        myWord.close();

        // 3. Generate and interact with a PDF Document
        System.out.println("\n--- Processing PDF Request ---");
        Document myPdf = pdfCreator.createDocument();
        myPdf.open();
        myPdf.close();

        // 4. Test the collective factory operational method
        System.out.println("\n--- Testing Shared Factory Print Operation ---");
        excelCreator.printDocument();

        System.out.println("\n🎯 SUCCESS: Factory Method Pattern implemented successfully!");
    }
}
