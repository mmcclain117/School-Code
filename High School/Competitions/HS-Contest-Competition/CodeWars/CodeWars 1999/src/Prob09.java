
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Reversi
//        Points: 6
        Scanner scan = new Scanner(new File("prob09.txt"));
        ArrayList<String> ar = new ArrayList();
        while (scan.hasNext()) {
            String s = scan.nextLine().trim();
            if (s.equals("REVERSI")) { // Reverse the list
                Collections.reverse(ar);
            } else {
                ar.add(s);
            }
        }

        /* Prints the Phrase */
        for (String s : ar) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
