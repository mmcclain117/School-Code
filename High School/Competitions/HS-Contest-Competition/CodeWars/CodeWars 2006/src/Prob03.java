
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob03.txt"));
        String a = scan.nextLine();
        double linearL; // Linear Length
        double linearW; // Linear Width
        double sur; // Surface
        double vol; // Volume
        if ("R".equals(a)) { // Rectangle
            double l = scan.nextDouble(); // Length
            double w = scan.nextDouble(); // Width
            double d = scan.nextDouble() / 12;  //convert to feet.
            sur = l * w;
            vol = sur * d * 7.5;
            linearL = l + (d * 2) + 2;
            linearW = w + (d * 2) + 2;
        } else { // Circle
            double dia = scan.nextDouble(); // Diameter
            double d = scan.nextDouble() / 12; // Convert to feet
            sur = Math.PI * ((dia / 2) * (dia / 2));
            vol = sur * d * 7.5;
            linearL = dia + (d * 2) + 2;
            linearW = linearL;
        }
        System.out.printf("Pond has a surface area of %.0f square feet.\n", Math.floor(sur));
        System.out.printf("Pond will hold %.0f gallons of water.\n", Math.floor(vol));
        System.out.printf("Pond will require a %.0f by %.0f foot liner.\n", Math.ceil(linearL), Math.ceil(linearW));
        scan.close();
    }
}
