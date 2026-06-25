
public class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("📝 Opening Microsoft Word document... Loading margins and styles.");
    }

    @Override
    public void close() {
        System.out.println("💾 Saving and closing Word document.");
    }
}
