
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Vertical Printing
//        Points: 3
        Scanner scan = new Scanner(new File("prob02.txt"));
        String a = scan.nextLine();
        int max = 0;
        ArrayList<String> sets = new ArrayList();
        while (!"END".equals(a) && scan.hasNext()) {
            sets.add(a);
            if (a.length() > max) {
                max = a.length();
            }
            a = scan.nextLine();
        }
        char set[][] = new char[sets.size() + 1][max + 1];
        for (int i = 0; i < sets.size(); i++) {
            String temp = sets.get(i);
            for (int j = 0; j < temp.length(); j++) {
                set[i][j] = temp.charAt(j); // fill in the names
            }
            for (int j = temp.length(); j < max; j++) {
                set[i][j] = ' '; // Fill in the empty
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < sets.size(); j++) {
                if (sets.size() - 1 != j) { // Check for spaces at the end
                    System.out.print(set[j][i] + "  ");
                } else {
                    System.out.print(set[j][i]);
                }
            }
            System.out.println();
        }
    }
}
