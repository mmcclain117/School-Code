
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class GoldBach {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("prob09.txt"));
        int match = scan.nextInt();
        int ab = 0;
        for (int number = match / 2; number <= 1000; ab++) {
            int numb = match / 2;
            isPrime(numb);
            if (match == 0) {
                break;
            } else {
                if (number > match) {
                    number = match / 2;
                } else if (number == match) {

                }
                if (isPrime(number)) {
                    int b = match - number;
                    if (isPrime(b)) {
                        System.out.println(b + " + " + number + " = " + match);
                        match = scan.nextInt();
                    }
                } else if (isPrime(numb)) {
                    int b = match - number;
                    if (isPrime(b)) {
                        System.out.println(b + " + " + number + " = " + match);
                        match = scan.nextInt();
                    }
                }
                number++;
                numb--;
            }

        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
