
/**
 * Problem: Redundant Acronym Syndrome Syndrome
 */
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob04.txt"));
        String a = scan.nextLine();
        while (!a.equals("END")) {
            String b[] = a.split("\\s+");
            String fin = "";
            for (String c : b) {
                fin += c.charAt(0);
            }
            System.out.println((fin.toUpperCase()) + " " + b[b.length - 1]);
            a = scan.nextLine();
        }
    }

}
