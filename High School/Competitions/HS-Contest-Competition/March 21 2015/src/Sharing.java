
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import static java.lang.Math.ceil;
import static java.lang.System.out;

/**
 *
 * @author Master and Kyle Fromm
 */
public class Sharing {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("K2.txt"));
        int a = scan.nextInt();
        for (int b = 0; b < a; b++) {
            int u = scan.nextInt();
            int y = scan.nextInt();
            double fr = 0;
            double jo = 0;
            for (int t = 0; t < y; t++) {
                String ty = scan.next();
                double uy = scan.nextDouble();
                if (ty.equals("Frankie")) {
                    fr += uy;
                } else {
                    jo += uy;
                }
            }
            ceil(fr);
            if (fr > jo) {
                double xx = (fr - jo) / 2;
                out.print("Frankie gives Johnny ");
                out.printf("%.2f", xx);
                out.println();
            } else if (fr < jo) {
                double xx = jo - fr;
                out.print("Johnny gives Frankie ");
                out.printf("%.2f", xx);
                out.println();
            }
            if (fr == jo) {
                out.println("Expenditures match");
            }
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("K2.txt");
        fw.write("4\n"
                + "50\n"
                + "4\n"
                + "Frankie 5.00\n"
                + "Frankie 5.00\n"
                + "Johnny 2.00\n"
                + "Johnny 12.00\n"
                + "20\n"
                + "3\n"
                + "Frankie 5.00\n"
                + "Johnny 10.00\n"
                + "Frankie 5.00\n"
                + "100\n"
                + "4\n"
                + "Frankie 20.00\n"
                + "Johnny 20.00\n"
                + "Frankie 23.42\n"
                + "Johnny 12.50\n"
                + "100\n"
                + "6\n"
                + "Frankie 1.00\n"
                + "Johnny 3.00\n"
                + "Frankie 1.99\n"
                + "Frankie 3.00\n"
                + "Johnny 0.99\n"
                + "Johnny 1.98");
        fw.flush();
        fw.close();
    }
}
