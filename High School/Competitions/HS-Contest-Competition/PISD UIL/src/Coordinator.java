
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Coordinator {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("coordinator.dat"));
        int t = scan.nextInt();
        scan.nextLine();
        for (int aa = 0; t > aa; aa++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int a[] = new int[n];
            int ss[] = new int[m];
            int p[] = new int[m];
            int s[] = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }
            for (int ii = 0; ii < m; ii++) {
                s[ii] = scan.nextInt();
                p[ii] = scan.nextInt();
                ss[ii] = scan.nextInt();

            }
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("coordinator.dat");
        fw.write("2\n"
                + "2 2\n"
                + "20\n"
                + "25\n"
                + "0 60 20\n"
                + "60 120 20\n"
                + "2 3\n"
                + "10\n"
                + "20\n"
                + "0 30 10\n"
                + "15 45 10\n"
                + "25 30 5");
        fw.flush();
        fw.close();
    }
}
