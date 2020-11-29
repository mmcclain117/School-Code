
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Panagram
//        Difficulty: Easy
//        Subject: Repetition
        Scanner scan = new Scanner(new File("prob05.txt"));
        String a = scan.nextLine();
        while (!".".equals(a)) {
            String ca = a.substring(0, a.length() - 1);
            ca = ca.replaceAll("[^A-Z]+", "");
            int co[] = new int[26];// Count
            char ch[] = ca.toCharArray();
            for (char c : ch) {
                co[c - 'A']++;
            }
            boolean per = true; // Perfect
            boolean sper = true; // Semi Perfect
            for (int i = 0; i < co.length; i++) {
                if (co[i] == 0) {
                    per = false;
                    sper = false;
                    System.out.println("NEITHER: " + a);
                    break;
                } else if (co[i] > 1) {
//                    sper = false;
                    per = false;
                }
            }
            if (sper) {
                if (per) {
                    System.out.println("PERFECT: " + a);
                } else {
                    System.out.println("PANGRAM: " + a);
                }
            }
            a = scan.nextLine();
        }
    }

}
