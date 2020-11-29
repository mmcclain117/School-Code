
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class G {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("G.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            System.out.print("Problem " + (i + 1) + ": ");
            String b = scan.nextLine();
            if (!isPal(b)) {
                boolean work = false;
                ArrayList<Character> hs = new ArrayList();
                char ch[] = b.toCharArray();
                for (int p = 0; p < ch.length; p++) {
                    hs.add(ch[p]);
                }
                int con = 0;
                String temp = b;
                int time = 0;
                boolean fl = b.charAt(0) == b.charAt(b.length() - 1); // First or last
                while (temp.length() > 0) {
//                    System.out.println(temp);
//                    char te = temp.charAt(0);
                    int st = temp.length();
                    temp = temp.replaceAll(temp.substring(0, 1) + "", "");
                    int change = st - temp.length();
                    con += change % 2 != 0 ? 1 : 0;
                }
//                System.out.println(con);
                work = b.length() % 2 == 0 ? fl ? con > 2 : con > 1 : con > 1;
                if (!work) {
                    System.out.println("Close enough to a palindrome");
                } else {
                    System.out.println("Can't form a palindrome");
                }
            } else {
                System.out.println("This is a palindrome");
            }
        }
    }

    private static boolean isPal(String b) {
        ArrayList<Character> ar = new ArrayList();
        char ch[] = b.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            ar.add(ch[i]);
        }
        Collections.reverse(ar);
        String fin = "";
        for (char c : ar) {
            fin += c;
        }
        return fin.equals(b);
    }
}
