
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Master
 */
public class IFeelFine {

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("Fine.txt");
        fw.write("5\n"
                + "2\n"
                + "3\n"
                + "1\n"
                + "3\n"
                + "2\n");
        fw.flush();
        fw.close();
        Scanner scan = new Scanner(new File("Fine.txt"));
        int a = scan.nextInt();
        int c = 0;
        for (int z = 0; a > z; z++) {
            int b = scan.nextInt();
            c += b;
        }
        double d = c / a;
        System.out.println("Total vacation time missed: " + c + " hours");
        System.out.println("Average daily time missed: " + d + " hours");
        scan.close();
        wrongalternate();
    }

    public static void wrongalternate() throws Exception {
        Scanner scan = new Scanner(new File("Fine.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();
        int f = scan.nextInt();
        int g = b + c + d + e + f;
        System.out.println("Total Vacation time missed: " + g + " hours");
        System.out.println("Average daily time missed: " + (g / a) + " hours");
    }
}
