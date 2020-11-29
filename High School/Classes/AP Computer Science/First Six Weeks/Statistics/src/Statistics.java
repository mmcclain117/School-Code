
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;

public class Statistics {

    public static void main(String[] args) {
        Random rnd = new Random();
        double d[] = new double[1000];
        for (int i = 0; i < 1000; i++) {
            d[i] = rnd.nextDouble();
        }
        out.println(sum(d));
        out.println(product(d));
        out.println(average(d));
        out.println(min(d));
        out.println(max(d));
        out.println(Arrays.toString(mode(d)));
        out.println("\n\n\n" + Arrays.toString(d));
    }

    public static double sum(double[] d) {
        double sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
        }
        return sum;
    }

    public static double product(double[] d) {
        double product = 1;
        for (int i = 0; i < d.length; i++) {
            if (!(d[i] == 0)) {
                product *= d[i];
            } else {
                i++;
            }
        }
        return product;
    }

    public static double average(double[] d) {
        return product(d) / d.length;
    }

    public static double min(double[] d) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < d.length; i++) {
            if (d[i] < min) {
                min = d[i];
            }
        }
        return min;
    }

    public static double max(double[] d) {
        double max = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        return max;
    }

    public static double[] mode(double[] d) {
        Arrays.sort(d);
        double answer = 0;
        double times = 0;
        double amount = 0;
        double con = d[0]; // Counter
        for (int i = 0; i < d.length; i++) {
            while (con == d[i]) {
                times++;
                i++;
            }
            con = d[i];
            if (times >= answer) {
                answer = times;
                amount = d[i - 1];
            }
        }
        double modes[] = {times, amount};//
        return modes;
    }
}
