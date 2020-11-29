
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Combine {

    public static void main(String[] args) throws Exception {
        Scanner scan1 = new Scanner(new File("C:\\Users\\Master\\Desktop\\MESSAGES\\Messages 1\\Text\\Aaron  Putnam.csv"));
//        scan1.nextLine();
        Scanner scan3 = new Scanner(new File("C:\\Users\\Master\\Desktop\\MESSAGES\\Messages 3\\Text\\Aaron  Putnam.csv"));
//        scan3.nextLine();
        ArrayList<String[]> scl1 = new ArrayList();
        ArrayList<String[]> scl3 = new ArrayList();
        /**
         * Put each line of scan1 into a String array seperated by colums Then
         * into scl1
         */
        while (scan1.hasNext()) {
            String te = scan1.nextLine();
            scl1.add(te.split("[,]"));
        }
        scan1.close();
        /**
         * Put each line of scan3 into a String array Seperated by collums Put
         * into scl3
         */
        while (scan3.hasNext()) {
            String te = scan3.nextLine();
            scl3.add(te.split("[,]"));
        }
        scan3.close();
        out.println(Arrays.toString(scl3.remove(0)));
        out.println(Arrays.toString(scl3.remove(1)));
        out.println(Arrays.toString(scl3.remove(0)));
        out.println(Arrays.toString(scl3.remove(0)));
        out.println(Arrays.toString(scl3.remove(0)));

        FileWriter fw1 = new FileWriter("C:\\Users\\Master\\Desktop\\Test Aaron.csv");
        for (String a[] : scl1) {
            for (String y : a) {
                fw1.write(y + ",");
            }
            fw1.write("\n");
        }
        for (String a[] : scl3) {
            for (String y : a) {
                fw1.write(y + ",");
            }
            fw1.write("\n");
        }
        fw1.flush();
        fw1.close();
    }
}
