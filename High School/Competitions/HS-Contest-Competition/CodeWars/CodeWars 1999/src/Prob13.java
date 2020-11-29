
import java.io.File;
import static java.lang.Math.abs;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Should work as using big integers but doesn't seem to so giving up */
public class Prob13 {

    public static void main(String[] args) throws Exception {
//        Problem: 128 Bit Math
//        Points: 10
        Scanner scan = new Scanner(new File("prob13.txt"));
        while (scan.hasNext()) {
            String line = scan.nextLine().trim();
            String split[] = line.split("[^A-Za-z0-9]+");
            String fin = ""; // What equal to
            String oper = line.split("[A-Za-z0-9]+")[1].trim(); // Operator
            String val1 = split[0].trim().substring(2).toUpperCase(); // Value 1
            String val2 = split[1].trim().substring(2).toUpperCase(); // Value 2
            BigInteger b1 = new BigInteger(val1, 16);
            BigInteger b2 = new BigInteger(val2, 16);
            if (oper.equals("+")) {
                oper = " + ";
                fin = Integer.toString(b1.add(b2).intValue(), 16);
            } else { // Becomes Subtraction (Doesn't work on second input)
                oper = " - ";
                fin = Integer.toString(abs(b1.subtract(b2).intValue()), 16);
            }
            System.out.println("0x" + val1 + oper + "0x" + val2 + " = 0x" + fin.toUpperCase());
        }
    }
}
