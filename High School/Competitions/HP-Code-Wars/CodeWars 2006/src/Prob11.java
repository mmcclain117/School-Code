
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
//        Problem: How Many Ways to Make Change?
//        Points: 12
        Scanner scan = new Scanner(new File("prob11.txt"));
        System.out.println("Enter amount of change to make (in cents):");
        int amount = scan.nextInt();
        int count = makeChange(amount, amount);
        System.out.print("There are " + count + " ways to make change for ");
        System.out.printf("$%.2f\n", (double) amount / 100.0);

        scan.close();
    }

    private static int makeChange(int amount, int coin) {
        int count = 0;
        if (amount >= 50 && coin >= 50) {
            count += makeChange(amount - 50, 50);
            if (amount == 50) {
                count++;
            }
        }
        if (amount >= 25 && coin >= 25) {
            count += makeChange(amount - 25, 25);
            if (amount == 25) {
                count++;
            }
        }
        if (amount >= 10 && coin >= 10) {
            count += makeChange(amount - 10, 10);
            if (amount == 10) {
                count++;
            }
        }
        if (amount >= 5 && coin >= 5) {
            count += makeChange(amount - 5, 5);
            if (amount == 5) {
                count++;
            }
        }

        if (amount > 0) {
            count++;
        }
        return count;
    }
}
