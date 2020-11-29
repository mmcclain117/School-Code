
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args)throws Exception {
//        Problem: Reversal of Field
//        Points: 2
        Scanner scan = new Scanner(new File("prob01.txt"));
        String a = scan.nextLine();
        ArrayList<String> ar = new ArrayList();
        char ch[] = a.toCharArray();
        for (char c : ch) {
            if (Character.isAlphabetic(c)) {
                ar.add((c + "").toUpperCase());
            }
        }
        String fin = Arrays.toString(ar.toArray());
        Collections.reverse(ar);
        String fin2 = Arrays.toString(ar.toArray());
//        System.out.println(fin + " " + fin2);
        System.out.println(a);
        if (fin.equals(fin2)) {
            System.out.println("-- is a palindrome");
        } else {
            System.out.println("-- is not a palindrome");
        }
        scan.close();
    }

}
