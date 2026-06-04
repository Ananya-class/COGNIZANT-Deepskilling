
import java.util.*;

class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            map.put(id, name);
        }

        System.out.print("Enter ID: ");
        int search = sc.nextInt();

        System.out.println(map.get(search));
    }
}
