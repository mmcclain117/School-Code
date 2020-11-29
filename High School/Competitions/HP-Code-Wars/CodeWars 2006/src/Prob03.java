
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Backyard Pond Sizer
//        Points: 4
        Scanner scan = new Scanner(new File("prob03.txt"));
        String line = scan.nextLine();
        double linearLen; // Linear Length
        double linearWid; // Linear Width
        double surface; // Surface
        double volume; // Volume
        if ("R".equals(line)) { // Rectangle
            double length = scan.nextDouble(); // Length
            double width = scan.nextDouble(); // Width
            double d = scan.nextDouble() / 12;  //convert to feet.
            surface = length * width;
            volume = surface * d * 7.5;
            linearLen = length + (d * 2) + 2;
            linearWid = width + (d * 2) + 2;
        } else { // Circle
            double diameter = scan.nextDouble(); // Diameter
            double d = scan.nextDouble() / 12; // Convert to feet
            surface = Math.PI * ((diameter / 2) * (diameter / 2));
            volume = surface * d * 7.5;
            linearLen = diameter + (d * 2) + 2;
            linearWid = linearLen;
        }
        System.out.printf("Pond has a surface area of %.0f square feet.\n", Math.floor(surface));
        System.out.printf("Pond will hold %.0f gallons of water.\n", Math.floor(volume));
        System.out.printf("Pond will require a %.0f by %.0f foot liner.\n", Math.ceil(linearLen), Math.ceil(linearWid));
        scan.close();
    }
}
