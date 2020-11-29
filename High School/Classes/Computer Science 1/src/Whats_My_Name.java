
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Whats_My_Name { // Chapter 7

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println("What is your first name?");
        String fi = scan.nextLine();
        out.print("What is your last name?");
        String las = scan.nextLine();
        out.println("Your full name is " + fi + " " + las);
    }
}
