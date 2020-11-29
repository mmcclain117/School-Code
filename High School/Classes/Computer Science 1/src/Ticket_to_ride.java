
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Ticket_to_ride {

    private static int v;
    private static short e;
    private static short p;
    private static int r;
    private static int t;

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("") {

            @Override
            public int read(CharBuffer cb) throws IOException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        short P = 1;
        short E = 2;
        short R = 10;
        short T = 15;
        short V = 28;/*;*/

        final double W = 35;
        final double Q = 50;
        System.out.println("p + e + r + t = V");
        System.out.println("");
    }

    private static void Write() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static abstract class File implements Readable {

        public File(String string) {
        }
    }
}
