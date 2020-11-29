
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: I'll Take that Case
//        Points: 8
        Scanner scan = new Scanner(new File("prob12.txt"));
        int c = scan.nextInt(); // Cases Currently
        scan.nextLine();
        String ac[] = new String[c];
        for (int i = 0; i < c; i++) {
            ac[i] = scan.nextLine();
        }
        Arrays.sort(ac);
        int p = scan.nextInt(); // Cases Considering
        scan.nextLine();
        String mod[] = new String[c]; // Modified for chars only
        for (int i = 0; i < c; i++) {
            mod[i] = charify(ac[i]);
//            System.out.println(ac[i] + "   " + mod[i]);
        }
        String pc[] = new String[p];
        String modPc[] = new String[p]; // Modified for chars only
        for (int i = 0; i < p; i++) {
            pc[i] = scan.nextLine();
            modPc[i] = charify(pc[i]);
        }
        for (int i = 0; i < p; i++) {
            boolean match = false; // There is an anagram
            for (int o = 0; o < c; o++) {
                if (modPc[i].equals(mod[o])) { // They match
                    match = true;
//                    System.out.println(pc[i] + ":" + ac[o]);
                    System.out.println("Yes: " + ac[o]);
                    modPc[i] = "";
                    mod[o] = "";
                    break;
                }
            }
            if (!match) {
                System.out.println("No: no matching case");
            }
        }

    }

    /* Returns a sorted String */
    public static String charify(String a) {
        char ch[] = a.toCharArray();
        Arrays.sort(ch);
        String fin = "";
        for (char c : ch) {
            if (Character.isAlphabetic(c)) {
                fin += c;
            }
        }
        return fin;
    }
}
