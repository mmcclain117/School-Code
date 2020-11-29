
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Veggies {

    public static void main(String args[]) throws Exception {
        writeVeggies();
        Scanner scan = new Scanner(new File("veggies.txt"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            System.out.println("I like " + a);
        }
    }

    public static void writeVeggies() throws Exception {
        FileWriter fw = new FileWriter("veggies.txt");
        fw.write("candy\n"
                + "a\n"
                + "sdf\n"
                + "this \n"
                + "food \n"
                + "bannana\n"
                + "apple\n"
                + "candy\n"
                + "more candy");
        fw.close();
    }
}
