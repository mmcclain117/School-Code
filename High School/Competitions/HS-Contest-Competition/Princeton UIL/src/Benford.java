
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Benford {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("benford.txt"));
        int a = scan.nextInt();
        int aa = 0;
        int bb = 0;
        for (int z = 0; a > z; z++) {
            int b = scan.nextInt();
            double cnt = 0;
            for (int y = 0; b > y; y++) {
                char c = scan.next().charAt(0);
                if (c == '1') {
                    cnt++;
                }
            }
            if (cnt / b >= .25 && cnt / b <= .35) {
                out.println("PASSED");
            } else {
                out.printf("Failed: %.2f", (cnt / b) * 100);
            }
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("beneford.txt");
        fw.write("2\n"
                + "4\n"
                + "10\n"
                + "5\n"
                + "9\n"
                + "2\n"
                + "3\n"
                + "17\n"
                + "100\n"
                + "49");
        fw.flush();
        fw.close();
    }
}
