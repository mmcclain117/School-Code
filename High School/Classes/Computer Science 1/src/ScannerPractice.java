
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class ScannerPractice {

    public static void main(String args[]) {
        Scanner kbReader = new Scanner(System.in);

        System.out.print("Enter your word here. ");
        String s = kbReader.next();
        System.out.println("Your word is " + s);
        System.out.println();

        System.out.print("Enter your integer here. ");
        int i = kbReader.nextInt();
        System.out.println("Your integer is " + i);
        System.out.println();

        System.out.print("Enter your double here. ");
        double d = kbReader.nextDouble();
        System.out.println("Your double is " + d);
        System.out.println();

        System.out.print("Enter your sentence here. ");
        String sent = kbReader.nextLine();
        System.out.println("Your sentence is " + sent);

    }
}
