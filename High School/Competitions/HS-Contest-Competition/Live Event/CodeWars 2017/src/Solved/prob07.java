package Solved;

import java.util.*;
import java.io.*;
import static java.lang.Math.abs;

public class prob07 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob07.txt"));
        int values = scan.nextInt();
        for (int i = 0; i < values; i++) {
            boolean found = false;
            double x = scan.nextDouble();
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            double c = scan.nextDouble();
            double m = scan.nextDouble();
            double n = scan.nextDouble();
            double[] array = new double[100];
            array[0] = x;
            double error = scan.nextDouble();
//	    System.out.println(x + " " + a + " " + b + " " + c + " " + m + " " + n + " " + error);
            for (int j = 0; j < 99; j++) {
                array[j + 1] = c + (a * array[j] + m) / (b * array[j] + n);
                if (abs(array[j] - array[j + 1]) <= error) {
                    System.out.println(array[j + 1]);
                    found = true;
                    break;
                }
            }

            if (found == false) {
                System.out.println("DIVERGES");
            }
        }

    }

}
