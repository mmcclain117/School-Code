
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Reverse + Add = Palidrome
//        Points: 5
        Scanner scan = new Scanner(new File("prob04.txt"));
        int a = scan.nextInt();
        String b = a + "";
        while (!palindrome(b).equals(b)) {
            b = (Integer.parseInt(b) + Integer.parseInt(palindrome(b))) + "";
        }
        System.out.println(b);
    }

    private static String palindrome(String b) {
        ArrayList ar = new ArrayList();
        char ch[] = b.toCharArray();
        for (char c : ch) {
            ar.add(c);
        }
        String fin = "";
        Collections.reverse(ar);
        for (int i = 0; i < ar.size(); i++) {
            fin += ar.get(i);
        }
        return fin;
    }

}
