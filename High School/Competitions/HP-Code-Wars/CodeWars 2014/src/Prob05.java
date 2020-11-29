
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Panagram
//        Points: 5
        Scanner scan = new Scanner(new File("prob05.txt"));
        String line = scan.nextLine();
        while (!".".equals(line)) {
            String modLine = line.substring(0, line.length() - 1);
            modLine = modLine.replaceAll("[^A-Z]+", "");
            int count[] = new int[26];// Count
            char ch[] = modLine.toCharArray();
            for (char c : ch) {
                count[c - 'A']++;
            }
            boolean perfect = true; // Perfect
            boolean semiPerfect = true; // Semi Perfect
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 0) {
                    perfect = false;
                    semiPerfect = false;
                    System.out.println("NEITHER: " + line);
                    break;
                } else if (count[i] > 1) {
//                    sper = false;
                    perfect = false;
                }
            }
            if (semiPerfect) {
                if (perfect) {
                    System.out.println("PERFECT: " + line);
                } else {
                    System.out.println("PANGRAM: " + line);
                }
            }
            line = scan.nextLine();
        }
    }

}
