
public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("📊 Opening Excel Spreadsheet... Initializing formula grids and charts.");
    }

    @Override
    public void close() {
        System.out.println("💾 Auto-saving cells and closing Excel sheet.");
    }
}
