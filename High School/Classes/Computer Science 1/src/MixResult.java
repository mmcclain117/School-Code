
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class MixResult { // Chapter 5 Mine

    public static void main(String[] args) {
        double d1 = 37.9;
        double d2 = 1004.128;
        int i1 = 12;
        int i2 = 18;
        double prob1 = 57.2 * (i1 / i2) + 1;
        double prob2 = 57.2 * ((double) i1 / i2) + 1;
        double prob3 = 15 - i1 * (d1 * 3) + 4;
        int prob4 = 15 - i1 * (int) (d1 * 3) + 4;
        int prob5 = 15 - i1 * ((int) d1 * 3) + 4;
        String pro = "Problem";
        out.println(pro + "1: " + prob1);
        out.println(pro + "2: " + prob2);
        out.println(pro + "3: " + prob3);
        out.println(pro + "4: " + prob4);
        out.println(pro + "5: " + prob5);
    }
}
