
import java.util.List;

public class SearchAlgorithms {

    public static Product linearSearch(List<Product> products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(List<Product> sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentId = sortedProducts.get(mid).getProductId();

            if (currentId == targetId) {
                return sortedProducts.get(mid);
            } else if (currentId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
