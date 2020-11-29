
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
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String num = scan.nextLine();
            String number = num.replaceAll("[^0-9]", "");
            System.out.print(num + " ");
            boolean valid = number.length() == 10; // Valid Length
            if (valid) {
                valid = Area(number.substring(0, 3));
            }
            if (valid) {
                valid = Exchange(number.substring(3, 6));
            }
            System.out.println(valid ? "VALID" : "INVALID");
        }
    }

    public static boolean Area(String a) {
        return a.charAt(0) != '1' && a.charAt(0) != '0' && a.charAt(1) != '9';
    }

    public static boolean Exchange(String a) {
        return a.charAt(0) != '1' && a.charAt(0) != '0' && !(a.charAt(1) == '1' && a.charAt(2) == '1');
    }

}
