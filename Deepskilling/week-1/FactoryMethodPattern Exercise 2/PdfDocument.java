
public class PdfDocument implements Document {

    @Override
    public void open() {
        System.out.println("📕 Opening PDF document... Rendering vector layouts securely.");
    }

    @Override
    public void close() {
        System.out.println("🔒 Closing PDF reader container.");
    }
}
