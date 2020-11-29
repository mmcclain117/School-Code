
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class ClockPower {

    public static void main(String[] args) throws Exception { // Done
        Scanner scan = new Scanner(new File("prob03.txt"));
        int b = scan.nextInt();
        scan.nextLine();
        for (int bbb = 0; b > bbb; b--) {
            int z = 0;
            String y = scan.nextLine();
            char a[] = y.toCharArray();
            for (int aa = 0; aa < a.length; aa++) {
                switch (a[aa]) {
                    case '1':
                        z += 30;
                        break;
                    case '2':
                        z += 75;
                        break;
                    case '3':
                        z += 75;
                        break;
                    case '4':
                        z += 60;
                        break;
                    case '5':
                        z += 75;
                        break;
                    case '6':
                        z += 90;
                        break;
                    case '7':
                        z += 45;
                        break;
                    case '8':
                        z += 105;
                        break;
                    case '9':
                        z += 90;
                        break;
                    case '0':
                        z += 90;
                        break;
                    case ':':
                        z += 20;
                        break;
                }
            }
            out.println(z + " milliamps");
        }
    }
}
