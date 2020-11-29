
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Easy {

    public static void main(String args[]) throws Exception {
        FileWriter fw = new FileWriter("L.txt");
        fw.write("23\n"
                + "193576\n"
                + "0");
        fw.flush();
        fw.close();
        Scanner scan = new Scanner(new File("L.txt"));
        int a = scan.nextInt();
        System.out.println(a);
        while (a == 0) {
            break;
        }
        for (int b = 0; b > a; b++) {
            a = (int) (Math.pow(10, (a % 10)));
        }
    }
}
