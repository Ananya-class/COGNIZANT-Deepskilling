
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product> inventory = new ArrayList<>();
        inventory.add(new Product(105, "Wireless Mouse", "Electronics"));
        inventory.add(new Product(101, "Coffee Mug", "Kitchen"));
        inventory.add(new Product(104, "Running Shoes", "Apparel"));
        inventory.add(new Product(102, "Desk Lamp", "Home Decor"));
        inventory.add(new Product(103, "Mechanical Keyboard", "Electronics"));

        System.out.println("--- Linear Search Demonstration ---");
        Product linearResult = SearchAlgorithms.linearSearch(inventory, 102);
        System.out.println("Result for ID 102: " + linearResult);

        List<Product> sortedInventory = new ArrayList<>(inventory);
        sortedInventory.sort(Comparator.comparingInt(Product::getProductId));

        System.out.println("\n--- Binary Search Demonstration ---");
        Product binaryResult = SearchAlgorithms.binarySearch(sortedInventory, 102);
        System.out.println("Result for ID 102: " + binaryResult);
    }
}
