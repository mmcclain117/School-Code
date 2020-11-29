
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Blocks1 {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("blocks.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int b = 0; b < a; b++) {
            int blo = scan.nextInt();
            int xy[] = new int[10000];
            int aa = 0;
            while (scan.hasNext()) {
                xy[aa] = scan.nextInt();
                aa++;
            }
            Arrays.sort(xy);
//            add(xy, blo);
            out.println(Arrays.toString(xy));
        }
    }
//    public static add(int xy[] , blo) {
//        out.println(Arrays.toString(xy));
//    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("blocks.dat");
        fw.write("2\n"
                + "50\n"
                + "15 9 30 21 19 3 12 6 25 27\n"
                + "100\n"
                + "12 34 8 42 22 5");
        fw.flush();
        fw.close();
    }
}
