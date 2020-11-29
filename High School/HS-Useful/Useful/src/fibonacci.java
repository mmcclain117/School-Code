
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class fibonacci {

    public static int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacci(int n) {
        int i = 0;
        if (n <= 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        int las = 1;
        int last = 1;
        int sum = 2;
        int n = 3;
        for (int i = 2; i <= n; i++) {
            sum = last + las;
            las = last;
            last = sum;
        }
        out.println(sum);
        System.out.println("fib( 40 ) = " + fib(40));
        System.out.println("fib( 7 ) = " + fib(7));
        System.out.println("fibonacci( 7 ) = " + fibonacci(7));
    }
}
