
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        int N = scan.nextInt();
        int N = 39;
        System.out.println(factorial(N));
        System.out.println(fact(N));
        System.out.println(facts(N));
        System.out.println(fs(N));
    }

    public static int fs(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n < 0) {
            System.out.println("Under");
        } else if (n > 32) {
            System.out.println("Over");
        } else if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
        return 1;
    }

    static int fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static BigInteger facts(int N) {
        int c;
        BigInteger inc = new BigInteger("1");
        BigInteger fact = new BigInteger("1");
        for (c = 1; c <= N; c++) {
            fact = fact.multiply(inc);
            inc = inc.add(BigInteger.ONE);
        }
        return fact;
    }

}
