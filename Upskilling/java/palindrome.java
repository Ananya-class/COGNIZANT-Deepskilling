
import java.util.Scanner;

class Palindrome {

    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String rev = new StringBuilder(str).reverse().toString();

        System.out.println(str.equals(rev) ? "Palindrome" : "Not");
    }
}
