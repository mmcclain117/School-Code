
import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.*;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Manhunt {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("b.txt"));
        for (int a = scan.nextInt(); a > 0; a--) {
            double x = scan.nextDouble();
            double y = scan.nextDouble();
            double v = scan.nextDouble();
            double p = scan.nextDouble();
            double d2 = 0;
            double d = sqrt(pow(x, 2) + pow(y, 2)); //Distance
            System.out.println((int) d / p);
//            for(int b =0;b <100;b++) {
//                if(d > d2 ) {
//                    d += v;
//                    d += p;
//                    break;
//                }
//                else if(d2>d) {
//                    break;
//                }
//            }
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("b.txt");
        fw.write("3\n"
                + "20.0 10.0 5.0 10.0\n"
                + "10.0 10.0 3.0 15.0\n"
                + "0.0 0.0 5.0 10.0");
        fw.flush();
        fw.close();
    }
}
