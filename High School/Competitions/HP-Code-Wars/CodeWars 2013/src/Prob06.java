import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Triangle Area
//        Points: 4
        Scanner scan = new Scanner(new File("prob06.txt"));
        String line = scan.nextLine();
        while (!"0 0 0 0 0 0 ".equals(line)) {
            String t[] = line.split("\\s");
            double x1 = Double.parseDouble(t[0]);
            double y1 = Double.parseDouble(t[1]);
            double x2 = Double.parseDouble(t[2]);
            double y2 = Double.parseDouble(t[3]);
            double x3 = Double.parseDouble(t[4]);
            double y3 = Double.parseDouble(t[5]);
            double a = dis(x1, x2, y1, y2);
            double b = dis(x2, x3, y2, y3);
            double c = dis(x3, x1, y3, y1);
            double ang = Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2);
            ang = Math.acos(ang / (2 * a * b));
            double area = a * b * Math.sin(ang);
            System.out.println(area / 2);
            line = scan.nextLine();
        }
    }

    private static double dis(double x0, double x1, double y0, double y1) {
        double a = Math.pow((x1 - x0), 2);
        double b = Math.pow((y1 - y0), 2);
        return Math.sqrt(a + b);
    }
}
