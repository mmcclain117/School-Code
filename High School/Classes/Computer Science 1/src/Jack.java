
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Jack {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        System.out.print("Enter an index: ");
        int index = scanner.nextInt();
        System.out.println("\nYour sentence:\t" + sentence);
        System.out.println("Your index:\t" + index);
    }
}
