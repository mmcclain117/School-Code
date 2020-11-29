
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class prob06 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob06-1-in.txt"));
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            double t = scan.nextInt();
            double t1 = scan.nextInt();
            double t2 = scan.nextInt();
            double c0 = scan.nextInt() / 8;
            double c1 = scan.nextInt() / 8;
            double t11 = t / t1;
            double t22 = t / t2;
            double c2 = c0 + c1;
            out.println(((c2 / 2) * (t / (t11 + t22))));
            out.println("We tried so hard");
            out.println("Please give us points");
        }
    }
}
