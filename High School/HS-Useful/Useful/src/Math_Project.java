
import static java.lang.Math.*;
import static java.lang.System.out;
import java.util.Random;

/**
 *
 * @author Master
 */
public class Math_Project {

    public static void main(String[] args) {
        random();
        Int();
        Double();
    }

    public static void random() {
        Random rnd = new Random();
        int bit = 1;
        out.println(rnd.nextInt());
        out.println(rnd.nextDouble());
        out.println(rnd.nextFloat());
        out.println(rnd.nextLong());
        out.println(rnd.nextBoolean());
    }

    public static void Int() {
        int a = 25;
        int a1 = 5;
        int b = 16;
        int b1 = 4;
        out.println(abs(a)); // get absoulte(int)
        out.println(getExponent(a)); // getExponent(float or double)
        out.println(max(a, b)); // finds greater(int , int)
        out.println(min(a, b)); // finds smaller(int , int)
        out.println(round(a)); // round(float) to int
    }

    public static void Double() {

    }
}
