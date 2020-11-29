
import java.io.File;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: Diffraction Grating
//        Points: 10
        Scanner scan = new Scanner(new File("prob12.txt"));
        while (scan.hasNext()) {
            String line = scan.nextLine();
            double doubles[] = toDoubles(line);
            double y = caculateY(doubles[0], doubles[1], doubles[2]);
            System.out.printf("%.3f\n", y);
        }
    }

    /* String line to Double array */
    private static double[] toDoubles(String line) {
        String split[] = line.split("[ ]+");
        double tmp[] = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            tmp[i] = Double.parseDouble(split[i]);
        }
        return tmp;
    }

    /**
     * We know from the problem statement that sin t = lamda / d (assuming that
     * m = 1). By the definition of sine and cosine we know the following is
     * true for the given triangle.
     *
     * sin t = lamda / d cos t = x / d
     *
     * where t is the angle between side h and b.
     *
     * The pythagorean theorem tells us that x ^ 2 + lamda ^ 2 = d ^ 2. Which
     * follows that x = squareRoot(d ^ 2 - lamda ^ 2).
     *
     * Finally:
     *
     * cos t = squareRoot(d ^ 2 - lamda ^ 2) / d
     *
     */
    /* Calculates Cosine */
    private static double cosine(double lamda, double d) {
        return sqrt(pow(d, 2) - pow(lamda, 2)) / d;
    }

    /* Calculates Y */
    private static double caculateY(double lamda, double distance, double linesPerMm) {
        double d = 1000000 / linesPerMm; // Nanometers in Milimeter / linesPer milimeter
        double cosine = cosine(lamda, d);
        return (lamda * distance) / (d * cosine);
    }

}
