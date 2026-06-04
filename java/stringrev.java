
import java.util.Scanner;

class Reverse {

    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());

    }
}
