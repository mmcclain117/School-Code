
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class NRS {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("nrs.dat"));
        String num[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String line[] = a.split("\\s+");
            out.println("My name is " + line[0] + " " + line[1] + ", " + line[2] + ".");
            out.print("serial number");
            for (int i = 0; i < line[3].length() - 1; i++) {
                out.print(" " + num[Integer.parseInt(line[3].substring(i, i + 1))]);
            }
            out.println("!");
        }
    }
}
