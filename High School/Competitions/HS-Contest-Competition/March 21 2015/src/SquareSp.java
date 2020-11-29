
import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class SquareSp {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("N2.txt"));
        int u = scan.nextInt();
        for (int b = 0; b < u; b++) {
            int c = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int yu = scan.nextInt();
            x = x / yu;
            y = y / yu;
            if (!(y - x == 1)) {
                out.println(u + " NO PATH");
            } else {
                out.println(u + " " + x * 2);
            }
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("N2.txt");
        fw.write("3\n"
                + "1 1 3 1\n"
                + "2 3 4 1\n"
                + "3 10 12 2");
        fw.flush();
        fw.close();
    }
}
