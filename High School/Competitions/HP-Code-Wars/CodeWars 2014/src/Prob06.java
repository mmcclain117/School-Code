
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Don't Use No Double Negatives
//        Points: 5
        Scanner scan = new Scanner(new File("prob06.txt"));
        String line = scan.nextLine();
        while (!".".equals(line)) {
            String b = line; // Clone
            line = line.replaceAll("[^A-Z']", " ");
            String c[] = line.split("\\s+");
            int count = 0;
            for (String d : c) {
                if (isNeg(d)) {
//                    System.out.println(d);
                    count++;
                }
            }
            System.out.println(count + ": " + b);
            line = scan.nextLine();
        }
    }

    /* See if it is a negative word */
    private static boolean isNeg(String word) {
        String negWords[] = {"DON'T", "CAN'T", "ISN'T", "HAVEN'T", "CANNOT", "WOULDN'T", "COULDN'T",
            "WON'T", "NO", "NOT", "NEVER", "NOBODY", "NOWHERE", "NEITHER", "AIN'T"};
        for (String tmp : negWords) {
            if (word.equals(tmp)) {
                return true;
            }
        }
        return false;
    }

}
