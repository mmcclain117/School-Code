
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Names {

    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Name ");
        String a = input.nextLine();
        input.close();
        a = a.toLowerCase();
        for (int b = (a.length() - 1); b >= 0; b--) {
            System.out.println(a.substring(b, b + 1));
        }
    }
}
