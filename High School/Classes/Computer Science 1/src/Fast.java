
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 *
 * @author Master
 */
public class Fast {

    public static void main(String args[]) throws Exception {
        FileWriter fw = new FileWriter("a.txt");
        write(fw);
        Scanner scan = new Scanner(new File("a.txt"));
        System.out.println("This food");
        System.out.println("Receipt");
        int c = 0;
        int d = 0;
        int e = 0;
        while (true) {
            String a = scan.nextLine();
            if (a.equals("Apple")) {
                c += 1;
            } else if (a.equals("Hamburgers")) {
                d += 1;
            } else if (a.equals("Candys")) {
                e += 1;
            } else if (a.equals("stop")) {
                break;
            } else {
                System.out.print("not there");
            }

        }
        System.out.println(c + " Apples: " + (" $2.15 each \t\t$" + c * 2.15));
        System.out.println(d + " Hamburgers: " + (" $2.50 each \t$" + d * 2.50));
        System.out.println(e + " Candy" + (" $3 each \t\t$" + e * 3));
        double f = (c * 2.15) + (d * 2.50) + (e * 3);
        System.out.println("Order total: \t\t\t$" + f);
    }

    public static void write(FileWriter fw) throws Exception {
        fw.write("Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Hamburgers\n"
                + "Candys\n"
                + "Apple\n"
                + "Candys\n"
                + "Hamburgers\n"
                + "Apple\n"
                + "Candys\n"
                + "stop");
        fw.flush();
        fw.close();
    }
}
