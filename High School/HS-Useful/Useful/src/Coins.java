
import java.util.Scanner;
// print the number of combinations of the coins of how you can make int m

/**
 *
 * @author Master
 */
public class Coins {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            long m = scan.nextInt();
            int a = scan.nextInt();
            int y[] = new int[a];
            for (int b = 0; b < a; b++) {
                y[b] = scan.nextInt();
            }
            shell(y);
            long hg = findCombinationsCount(m, y);
            System.out.println(hg);
        }
    }

    public static long findCombinationsCount(long amount, int coins[]) {
        return findCombinationsCount(amount, coins, 0);
    }

    public static long findCombinationsCount(long amount, int coins[], int checkFromIndex) {
        if (amount == 0) {
            return 1;
        } else if (amount < 0 || coins.length == checkFromIndex) {
            return 0;
        } else {
            long withFirstCoin = findCombinationsCount(amount - coins[checkFromIndex], coins, checkFromIndex);
            long withoutFirstCoin = findCombinationsCount(amount, coins, checkFromIndex + 1);
            return withFirstCoin + withoutFirstCoin;
        }
    }

    public static void shell(int[] a) {
        int increment = a.length / 2;
        while (increment > 0) {
            for (int i = increment; i < a.length; i++) {
                int j = i;
                int temp = a[i];
                while (j >= increment && a[j - increment] > temp) {
                    a[j] = a[j - increment];
                    j = j - increment;
                }
                a[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
}
