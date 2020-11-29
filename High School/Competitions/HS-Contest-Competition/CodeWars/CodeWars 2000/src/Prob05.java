
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.GroupLayout.Alignment;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob05.txt"));
        int max = 0;
        ArrayList<String> ar = new ArrayList();
        while (scan.hasNext()) {
            String s = scan.nextLine();
            ar.add(s);
            if (s.length() > max) {// Figure out the max length 
                max = s.length();
            }
        }
        /* Printing the top */
        for (int i = 0; i < max + 4; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("*");
        for (int i = 0; i < max + 2; i++) {
            System.out.print(" ");
        }
        System.out.println("*");

        for (String q : ar) {
            int tmpLen = q.length();
            int tmpPad = max - tmpLen; // Number of spaces
            int pad = (tmpPad / 2) + 1; //Number of spaces on each side
//            System.out.println(pad + " " + tmpLen + " "+ max);
            System.out.print("*");
            for (int i = 0; i < pad; i++) {
                System.out.print(" ");
            }
            System.out.print(q);
            if (tmpPad % 2 != 0) { // Odd number in word
                pad++;
            }
            for (int i = 0; i < pad; i++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        /* Printing the Bottom */
        System.out.print("*");
        for (int i = 0; i < max + 2; i++) {
            System.out.print(" ");
        }
        System.out.println("*");
        for (int i = 0; i < max + 4; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
