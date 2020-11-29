
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Ultama {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob08.txt"));
        int a = scan.nextInt();
        while (a != 0) {
            for (int b = 0; a > b; b++) {
                String sr[];
                String t = scan.nextLine();
                sr = t.split("\\s+");
                out.println(sr[sr.length - 1 - a]);
                a = scan.nextInt();
            }
        }
    }

    public static void solution() throws Exception {
        Scanner in = new Scanner(new File("prob08.txt"));
        int num;
        while ((num = in.nextInt()) != 0) {
            String[] input = in.nextLine().trim().split("\\s+");
            out.println(input[input.length - 1 - num]);
        }
    }
}
