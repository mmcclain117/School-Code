
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Redundant Acronym Syndrome Syndrome
//        Points: 4
        Scanner scan = new Scanner(new File("prob04.txt"));
        String line = scan.nextLine();
        while (!line.equals("END")) {
            String b[] = line.split("\\s+");
            String fin = "";
            for (String c : b) {
                fin += c.charAt(0);
            }
            System.out.println((fin.toUpperCase()) + " " + b[b.length - 1]);
            line = scan.nextLine();
        }
    }

}
