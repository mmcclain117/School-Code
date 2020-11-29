
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Age {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("age.dat"));
        int a = scan.nextInt();
        int yage, oage, multi;
        for (int b = 0; b < a; b++) {
            yage = scan.nextInt();
            oage = scan.nextInt();
            multi = scan.nextInt();
            while (true) {
                if (yage * multi == oage) {
                    System.out.println(yage + "  " + oage);
                    break;
                }
                yage++;
                oage++;
                if (oage >= 1000) {
                    System.out.println("NEVER");
                    break;
                }

            }
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("age.dat");
        fw.write("3\n"
                + "2 14 4\n"
                + "10 20 2\n"
                + "30 31 3");
        fw.flush();
        fw.close();
    }
}
