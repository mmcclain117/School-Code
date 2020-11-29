
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Nth Prime Number
//        Points: 3
        Scanner scan = new Scanner(new File("prob04.txt"));
        ArrayList<Integer> inputs = new ArrayList();
        String line = scan.nextLine();
        while (!line.equals(".")) {
            inputs.add(Integer.parseInt(line));
            line = scan.nextLine();
        }
        int max = Collections.max(inputs);
        int primes[] = new int[max * max]; // Array of numbers
        boolean valid[] = new boolean[max * max]; // Array of primes
        Arrays.fill(valid, true); // Makes valid numbers
        valid[0] = false; // 0 isn't prime
        valid[1] = false; // 1 isn't prime
        /* Filling valid with prime numbers */
        for (int i = 0; i < valid.length; i++) {
            if (valid[i]) {
                int tmp = i + i;
                /* Eliminate multiples of current prime number */
                while (tmp < valid.length) {
                    valid[tmp] = false;
                    tmp += i;
                }
            }
        }
        int con = 0;
        /* Filling the array of primes with prime numbers */
        for (int i = 0; i < valid.length; i++) {
            if (valid[i]) {
                primes[con] = i;
                con++;
            }
        }
        String prefix[] = {"1st", "2nd", "3rd", "4th"}; // Beginning
        for (int a : inputs) {
            if (a < prefix.length) {
                System.out.print("The " + prefix[a]);
            } else {
                System.out.print("The " + a + "th");
            }
            System.out.println(" prime number is " + primes[a - 1] + ".");
        }
        System.out.println("Done.");
    }
}
