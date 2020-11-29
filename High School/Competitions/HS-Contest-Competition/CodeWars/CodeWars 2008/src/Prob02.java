
/**
 * Problem: Magnificent
 */
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob02.txt"));
        float a = scan.nextFloat();
        float b = scan.nextFloat();
        float c = scan.nextFloat();
        while (a != 0 && b != 0 && c != 0) {
            float M = a / b;
            float ft = c / M;
            float M_round = Round(M, 2);
            float ft_round = Round(ft, 2);
            System.out.printf("%.2f %.2f%n", M_round, ft_round);
            a = scan.nextFloat();
            b = scan.nextFloat();
            c = scan.nextFloat();
        }
    }

    public static float Round(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float) tmp / p;
    }
}
