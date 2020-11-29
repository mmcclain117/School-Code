
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class lights {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("lights.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String val = scan.next();
//            out.println(val);
            int time = scan.nextInt();
            boolean values[] = new boolean[val.length()];
            for (int d = 0; d < val.length() - 1; d++) {
                values[d] = Integer.parseInt(val.substring(d, d + 1)) == 1;
            }
            scan.nextLine();
            for (int d = 0; d < time; d++) {
                String aa = scan.nextLine();
                String ar[] = aa.split("\\s+");
//                out.println(Arrays.toString(ar));
                if (ar.length == 2) {
                    values = all(ar, values);
                } else {
                    int i1 = Integer.parseInt(ar[1]);
                    int i2 = Integer.parseInt(ar[2]);
                    values = setting(ar[0], values, i1, i2);
                }
            }
            for (int h = 0; h < values.length; h++) {
                out.print(values[h] ? 1 : 0);
            }
            out.println();
        }
    }

    private static boolean[] all(String[] ar, boolean[] values) {
        String wh = ar[0];
        if (wh.equalsIgnoreCase("flip")) {
            for (int i = 0; i < values.length; i++) {
                values[i] = !values[i];
            }
        } else if (wh.equalsIgnoreCase("ON")) {
            Arrays.fill(values, true);
        } else {
            Arrays.fill(values, false);
        }
        return values;
    }

    private static boolean[] setting(String ar, boolean[] values, int i1, int i2) {
        if (ar.equalsIgnoreCase("flip")) {
            for (int i = i1; i < i2; i++) {
                values[i] = !values[i];
            }
        } else if (ar.equalsIgnoreCase("ON")) {
            Arrays.fill(values, i1, i2, true);
        } else {
            Arrays.fill(values, i1, i2, true);
        }
        return values;
    }

}
