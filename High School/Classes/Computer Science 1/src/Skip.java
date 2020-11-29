
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Skip {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a multiplier: ");
        int a = input.nextInt();
        System.out.print("Enter highest end value: ");
        int b = input.nextInt();
        for (int c = 0; c <= b; c += a) {
            System.out.println(c);
        }
    }
}
