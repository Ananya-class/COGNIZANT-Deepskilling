
public abstract class DocumentFactory {

    // The Factory Method
    public abstract Document createDocument();

    // An optional helper operation that factories can perform on products
    public void printDocument() {
        Document doc = createDocument();
        doc.open();
        System.out.println("🖨️ Sending data stream to printer channel...");
        doc.close();
    }
}
