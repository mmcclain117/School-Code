package Done;

import java.io.File;
import java.util.Scanner;

public class Walter {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("walter.dat"));
        while (scan.hasNext()) {
            double l = scan.nextDouble(); // Length
            double w = scan.nextDouble(); // Width
            double t = scan.nextDouble(); // Thickness
            if ((l >= 3.5 && l <= 4.25) && (w >= 3.5 && w <= 6) && (t >= .007 && t <= .016)) {
                System.out.println("Small post card".toUpperCase());
            } else if ((l >= 4.25 && l <= 6) && (w >= 6 && w <= 11.5) && (t >= .007 && t <= .016)) {
                System.out.println("Large post card".toUpperCase());
            } else if ((l >= 3.5 && l <= 6.125) && (w >= 5 && w <= 11.5) && (t >= .016 && t <= .25)) {
                System.out.println("Small Envelope".toUpperCase());
            } else if ((l >= 6.125 && l <= 24) && (w >= 11 && w <= 18) && (t >= .25 && t <= .5)) {
                System.out.println("large envelope".toUpperCase());
            } else if ((l >= 4.25 && w >= 6 && t >= .5) && (2 * (l + w + t) <= 84)) {
                System.out.println("Small package".toUpperCase());
            } else if ((l >= 4.25 && w >= 6 && t >= .5) && (2 * (l + w + t) >= 84) && (2 * (l + w + t) <= 130)) {
                System.out.println("Large package".toUpperCase());
            } else {
                System.out.println("Unmailable".toUpperCase());
            }
        }
    }
}
