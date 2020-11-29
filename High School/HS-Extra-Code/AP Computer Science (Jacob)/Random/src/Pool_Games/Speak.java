package Pool_Games;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Speak {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println("Enter who is playing");
        String a = scan.nextLine();
        out.println("Enter who they are vs");
        String b = scan.nextLine();
        out.println("Enter who is solids");
        String c = scan.nextLine();
        out.println("8 Ball");
        String d = scan.nextLine();
        out.println("Winner");
        String e = scan.nextLine();
        out.println("winner And 8 ball same: Y or N");
        String gs = scan.nextLine();
        out.println("Balls Left");
        String f = scan.nextLine();
    }
}
