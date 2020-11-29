
import java.util.*;

/**
 *
 * @author Master
 */
public class PrimesAndDivisors {

    public static int[] generatePrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 2, n + 1, true);
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int[] primes = new int[n + 1];
        int cnt = 0;
        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                primes[cnt++] = i;
            }
        }

        return Arrays.copyOf(primes, cnt);
    }

    public static int[] generatePrimesLinear(int n) {
        int[] lp = new int[n + 1];
        int[] primes = new int[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; ++i) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes[cnt++] = i;
            }
            for (int j = 0; j < cnt && primes[j] <= lp[i] && i * primes[j] <= n; ++j) {
                lp[i * primes[j]] = primes[j];
            }
        }
        return Arrays.copyOf(primes, cnt);
    }

    public static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] numberOfPrimeDivisors(int n) {
        int[] divisors = new int[n + 1];
        Arrays.fill(divisors, 2, n + 1, 1);
        for (int i = 2; i * i <= n; ++i) {
            if (divisors[i] == 1) {
                for (int j = i; j * i <= n; j++) {
                    divisors[j * i] = divisors[j] + 1;
                }
            }
        }
        return divisors;
    }

    public static ArrayList generateDivisorTable(int n) {
        int[] divisor = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            divisor[i] = i;
        }
        for (int i = 2; i * i <= n; i++) {
            if (divisor[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    divisor[j] = i;
                }
            }
        }
        ArrayList ar = new ArrayList();
        for (int i = 0; i < divisor.length; i++) {
            ar.add(divisor[i]);
        }
        return ar;
    }

    public static int phi(int n) {
        int res = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                res -= res / i;
            }
        }
        if (n > 1) {
            res -= res / n;
        }
        return res;
    }

    public static int[] generatePhi(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + i; j <= n; j += i) {
                res[j] -= res[i];
            }
        }
        return res;
    }

    // Usage example
    public static void main(String[] args) {
        int n = 100;
        int[] primes1 = generatePrimes(n);
        int[] primes2 = generatePrimesLinear(n);
        ArrayList ay = generateDivisorTable(n);
        int[] te = numberOfPrimeDivisors(n);
        System.out.println(primes1.length);
        System.out.println(primes2.length);
        System.out.println(ay);
        Integer a = ay.indexOf(primes2.length);
        System.out.println(Arrays.toString(te));
        n = 1000;
        int[] phi = generatePhi(n);
        for (int i = 0; i <= n; i++) {
            if (phi[i] != phi(i)) {
                System.err.println(i);
            }
        }
    }
}
