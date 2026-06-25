
import java.util.*;

class GuessGame {

    public static void main(String[] args) {
        int num = new Random().nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);

        int guess;
        do {
            guess = sc.nextInt();
            if (guess > num) {
                System.out.println("Too High"); 
            }else if (guess < num) {
                System.out.println("Too Low");
            }
        } while (guess != num);

        System.out.println("Correct!");
    }
}
