
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob06.txt"));
        int a = scan.nextInt();
        int con = 0;
        for (int i = 2; i < a; i++) {
            if (isPrime(i)) {
                System.out.print(i);
                con++;
                if (con % 5 == 0) {
                    System.out.println();
                } else {
                    int len = (a + "").length() - (i + "").length();
                    if (con == 4) {
                        len--;
                    }
                    for (int h = 0; h < len + 5; h++) {
                        System.out.print(" ");
                    }
                    if (con == 2) {
                        System.out.print(" ");
                    }
                }
            }
        }
    }

    private static boolean isPrime(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
