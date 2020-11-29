
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Don't Use No Double Negatives
//        Difficulty: Easy
//        Subject: Repetition
        Scanner scan = new Scanner(new File("prob06.txt"));
        String a = scan.nextLine();
        while (!".".equals(a)) {
            String b = a; // Clone
            a = a.replaceAll("[^A-Z']", " ");
            String c[] = a.split("\\s+");
            int con = 0;
            for (String d : c) {
                if (isNeg(d)) {
//                    System.out.println(d);
                    con++;
                }
            }
            System.out.println(con + ": " + b);
            a = scan.nextLine();
        }
    }

    private static boolean isNeg(String a) {
        String b[] = {"DON'T", "CAN'T", "ISN'T", "HAVEN'T", "CANNOT", "WOULDN'T", "COULDN'T",
            "WON'T", "NO", "NOT", "NEVER", "NOBODY", "NOWHERE", "NEITHER", "AIN'T"};
        for (String c : b) {
            if (a.equals(c)) {
                return true;
            }
        }
        return false;
    }

}
