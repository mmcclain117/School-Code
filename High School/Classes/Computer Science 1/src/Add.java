
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Add {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        out.print("Enter something like 8 + 33 + 1,345 + 137 : ");
        String s = scan.nextLine();
        Scanner sc = new Scanner(s);
        sc.useDelimiter("\\s*\\+\\s*");
        int sum = 0;
        while (sc.hasNextInt()) {
            sum = sum + sc.nextInt();
        }
        out.println("Sum is: " + sum);
    }
}
