
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class prob08 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob08.txt"));
        int iter = scan.nextInt();
        int empty = 0;
        int dup = 0;
        int noc = 0;
        String names[] = new String[iter];
        int[] cubes = new int[iter];
        for (int i = 0; i < iter; i++) {
            String name = scan.next();
            int asg = scan.nextInt();
            cubes[i] = asg;
            if (asg == 0) {
                noc++;
            } else if (name.equals("NA")) {
                ++empty;
            } else {
                for (int k = 1; k < iter; ++k) {
                    if (cubes[k] == cubes[k - 1]) {
                        dup++;
                        k++;
                        break;
                    }
                }

            }
        }
        out.println("Empty Cubes: " + empty);
        out.println("Duplicate Cube asignments: " + dup);
        out.println("employes without cubes: " + noc);

    }

    public static boolean hasduplicate(int iter, String a) {
        Scanner scan = new Scanner(a);
        String names[] = new String[iter];
        boolean sds = false;
        int cubes[] = new int[iter];
        for (int i = 0; i < iter; i++) {
            names[i] = scan.next();
            cubes[i] = scan.nextInt();
            Arrays.sort(names);
            Arrays.sort(cubes);
        }
        for (int k = 1; k < iter; ++k) {
            if (cubes[k] == cubes[k - 1]) {
                sds = true;
            } else {
                sds = false;
            }
        }
        return sds;
    }
}
