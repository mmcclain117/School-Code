package Beginner;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class W_TranslatorConusion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        char ch[] = a.toCharArray();
        char ch1[] = b.toCharArray();
        int con = 0;
        for (int i = 0; i < ch.length; i++) {
            if (!(ch[i] == ch1[i])) {
                con++;
            }
        }
        out.println("There are " + con + " differences between " + a + " and " + b + ".");
    }

}
