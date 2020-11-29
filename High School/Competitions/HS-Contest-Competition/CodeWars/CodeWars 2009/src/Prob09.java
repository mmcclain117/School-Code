
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Formatting is a little off because I don't care */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Fun With Palindromes
//        Points: 6
        Scanner scan = new Scanner(new File("prob09.txt"));
        int st = scan.nextInt(); // Starting number
        int end = scan.nextInt(); // End number
        int value = 0; // Value flipping
        System.out.println("|NO.|Steps|Palindrome");
        System.out.println("|---|-----|--------------");
        for (int i = st; i <= end; i++) {
            value = i;
            int con = 0; // Step count
            while (value != palindrome(value)) {
//                System.out.println(value + " " + palindrome(value));
                value += palindrome(value);
                con++;
            }
            System.out.println("|" + i + "|    " + con + "| " + value);
        }
    }

    /* Return palindrome of a number */
    private static int palindrome(int a) {
        String s = a + ""; // Turn a to string
        String fin = ""; // Final string
        /* Reverse Number */
        for (int i = s.length() - 1; i >= 0; i--) {
            fin += s.charAt(i);
        }
        return Integer.parseInt(fin);
    }
}
