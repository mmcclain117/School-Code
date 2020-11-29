
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class CheckDigit {

    public static void main(String args[]) throws Exception {
        Scanner scan1 = new Scanner(new File("prob02.txt"));
        for (int a = scan1.nextInt(); a > 0; a--) {
            int odd, even, sum, z, oddsum = 0, evensum = 0;
            String b = scan1.nextLine();
            Scanner scan = new Scanner(b);
            odd = scan.nextInt();
            out.print(odd + " ");
            oddsum += odd;
            even = scan.nextInt();
            out.print(even + " ");
            evensum += even;
            odd = scan.nextInt();
            out.print(odd + " ");
            oddsum += odd;
            even = scan.nextInt();
            out.print(even + " ");
            evensum += even;
            odd = scan.nextInt();
            out.print(odd + " ");
            oddsum += odd;
            even = scan.nextInt();
            out.print(even + " ");
            evensum += even;
            odd = scan.nextInt();
            out.print(odd + " ");
            oddsum += odd;
            even = scan.nextInt();
            out.print(even + " ");
            evensum += even;
            odd = scan.nextInt();
            out.print(odd + " ");
            oddsum += odd;
            even = scan.nextInt();
            out.print(even + " ");
            evensum += even;
            odd = scan.nextInt();
            out.print(odd + " ");
            oddsum += odd;
            sum = (oddsum * 3) + evensum;
            z = sum % 10;
            if (z > 0) {
                out.println(z - 10);
            } else {
                out.println(z);
            }
        }
    }
}
