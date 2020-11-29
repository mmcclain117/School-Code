
import java.util.*;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Prim2 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int z = totient(n);
        out.println(z);
    }

    public static int totient(int num) { //euler's totient function calculator. returns totient
        int count = 0;
        for (int a = 1; a < num; a++) { //definition of totient: the amount of numbers less than num coprime to it
            if (GCD(num, a) == 1) { //coprime
                count++;
            }
        }
        return (count);
    }

    public static int GCD(int a, int b) { //faster euclidean algorithm-see GCD for explanation
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return (b);
        }
        return (GCD(a % b, b));
    }
}
