

import java.io.File;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob13 {

    public static void main(String[] args) throws Exception {
//        Problem: Star Catalog
//        Points: 8
        Scanner scan = new Scanner(new File("prob13.txt"));
        int n = scan.nextInt(); // Number of stars
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String values[] = new String[8]; // Values into Objects
            Arrays.fill(values, "");
            int con = 0;
            boolean started = false;
            char ch[] = line.toCharArray();
            for (int o = 0; o < ch.length; o++) {
                if (ch[o] == ' ') {
                    if (started) {
                        started = !started;
                        con++;
                    }
                } else {
                    started = true;
                    values[con] += ch[o];
                }
            }
            String name = values[0]; // Star Name
            double raHours = Double.parseDouble(values[1]); // RA Hours
            double raMinutes = Double.parseDouble(values[2]); // RA Minuets
            double decDegrees = Double.parseDouble(values[3]); // Dec Degrees
            double decMinutes = Double.parseDouble(values[4]); // Dec Minutes
            double r = Double.parseDouble(values[7]); // Distance from Sol in light years
            double theta = (90 - (decDegrees + ((decDegrees > 0 ? decMinutes : -decMinutes) / 60))) * PI / 180;
            double phi = ((raHours * 15) + (raMinutes / 4)) * PI / 180;
            double x = r * sin(theta) * cos(phi);
            double y = r * sin(theta) * sin(phi);
            double z = r * cos(theta);
            System.out.printf("%s x=%.2f, y=%.2f, z=%.2f\n", name, x, y, z);
        }
    }
}
