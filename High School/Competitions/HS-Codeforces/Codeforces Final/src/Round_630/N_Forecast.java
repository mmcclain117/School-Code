package Round_630;

import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class N_Forecast {

    /**
     * Tags: Math
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
//        double opt = 0.000;
//        double per = 0.000;
//        int x =0;
//        double eq = ((a * pow (x, 2)) + ( b * x ) + c ); 
//        float r1 = (float) (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
        double r1 = (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
        double r2 = (-b - sqrt(b * b - 4 * a * c)) / (2 * a);
//        out.println("Root 1: "+ r1);
//        out.println("Root 2: "+ r2);
//        out.println(r1);
        if (r1 > r2) {
            out.printf("%.10f", r1);
            out.println();
            out.printf("%.10f", r2);
            out.println();
        } else {
            out.printf("%.10f", r2);
            out.println();
            out.printf("%.10f", r1);
            out.println();
        }
    }
}
