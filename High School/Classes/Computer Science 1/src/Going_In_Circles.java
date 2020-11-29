
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Going_In_Circles { // Chapter 7

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println("Enter in the area");
        int area = scan.nextInt();
        double ar = area / PI;
        double r = sqrt(ar);
        out.println("Radius of your Circle is " + r);
        out.println("Enter in the radius");
        double rad = scan.nextDouble();
        double are = PI * (rad * rad);
        out.println("Area of your Circle is " + are);
    }
}
