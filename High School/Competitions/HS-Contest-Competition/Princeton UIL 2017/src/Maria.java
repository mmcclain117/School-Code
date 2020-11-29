
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Maria {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("maria.dat"));
        String a = scan.nextLine();
        String b[] = a.split("\\s+");
        int c[] = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            c[i] = Integer.parseInt(b[i]);
        }
        for (int i = 0; i < c.length; i++) {
            int te = c[i];
            if (te == 1) {
                System.out.println("---");
                System.out.println("-*-");
                System.out.println("---");
                System.out.println("");
            }
            if (te == 2) {
                System.out.println("*--");
                System.out.println("---");
                System.out.println("--*");
                System.out.println("");
            }
            if (te == 3) {
                System.out.println("*--");
                System.out.println("-*-");
                System.out.println("--*");
                System.out.println("");
            }
            if (te == 4) {
                System.out.println("*-*");
                System.out.println("---");
                System.out.println("*-*");
                System.out.println("");
            }
            if (te == 5) {
                System.out.println("*-*");
                System.out.println("-*-");
                System.out.println("*-*");
                System.out.println("");
            }
            if (te == 6) {
                System.out.println("*-*");
                System.out.println("*-*");
                System.out.println("*-*");
                System.out.println("");
            }
        }
    }
}
