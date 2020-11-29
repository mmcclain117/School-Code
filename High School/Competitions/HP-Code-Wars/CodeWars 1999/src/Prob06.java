
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/*
Brute forced finding the optimum values. 
Changed the formating for values
Didn't get the same output because the output is wrong
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Success comes in cans, not can'ts
//        Points: 3
        Scanner scan = new Scanner(new File("prob06.txt"));
        final double pi = 3.14159;
        while (scan.hasNext()) {
            double v = scan.nextDouble(); // Volume
            double area = 0.0; // Area
            double minH = Double.MAX_VALUE; // Minimum Height
            double minR = Double.MAX_VALUE; // Minimum Radius
            System.out.print("Volume = " + v + " in^3, ");
            double vm = v / 3.14159; // V/PI = HR^2
            /* Brute force finding radius (r) */
            for (double r = 0.1; r < v - 1; r += .1) {
//            for (double r = .1; r < v / 2; r += .1) { // Optimizing
                double tmpH = v / (pi * r * r);
                double tmpTot = tmpH + r; // Tmp Total Material
                if (tmpTot < minH + minR) { // Less material used
                    minH = tmpH;
                    minR = r;
                    area = 2 * pi * minR * (minR + minH);
                }
            }
            /* Printing out findings */
            System.out.printf("Area = %.1f in^2, ", area);
            System.out.printf("Height = %.2f in, ", minH);
            System.out.printf("Radius = %.2f in\n", minR);
//            System.out.printf("Total Material = %.3f in\n", minH + minR);

        }
    }
}
