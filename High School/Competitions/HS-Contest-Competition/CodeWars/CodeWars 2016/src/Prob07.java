
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: Share Your Letters
//        Points: 5
        Scanner scan = new Scanner(new File("prob07.txt"));
        int n = scan.nextInt(); // Number of cases
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String split[] = line.split("[ ]+");
            String s1 = similar(split[0], split[1]); // Same String 1 and String 2
            String s2 = similar(split[2], s1); // Same String 1 & 2 and String 3
            System.out.println(s2);
        }
    }

    /* Gets the letters that are in both String s1 and String s2 */
    private static String similar(String s1, String s2) {
        String fin = "";
        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            for (int o = 0; o < ch2.length; o++) {
                if (ch1[i] == ch2[o] && ch1[i] != '~') { // Same letters
                    fin += ch1[i];
                    ch1[i] = '~'; // Nullifies
                    ch2[o] = '~'; // Nullifies
                }
            }
        }
        return fin;
    }

}
