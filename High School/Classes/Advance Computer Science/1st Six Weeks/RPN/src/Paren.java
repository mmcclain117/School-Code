
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

public class Paren {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("paren.txt"));
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String cur = scan.nextLine();
            ArrayStack as = new ArrayStack();
            char ch[] = cur.toCharArray();
//            out.println((int) '(');
            //] 93
            //[ 91
            //( 40
            //) 41
            for (char u : ch) {
                as.push((double) u);
            }
//            out.println(Arrays.toString(as.toStringA()));
            int a1 = 0;
            int a2 = 0;
            int a3 = 0;
            int a4 = 0;
            while (!(as.size() == 0)) {
                int temp = (int) as.pop();
                if (temp == 93) {
                    a1++;
                } else if (temp == 91) {
                    a2++;
                } else if (temp == 40) {
                    a3++;
                } else if (temp == 41) {
                    a4++;
                }
            }
//            out.println(a1 + " "+ a2 + " "+ a3 + " "+ a4);
            out.println(a1 == a2 && a3 == a4 ? "Yes" : "No");
        }
    }

    public static void attempt1() throws IOException {
        Scanner scan = new Scanner(new File("paren.txt"));
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String cur = scan.nextLine();
            while (cur.contains("()") || cur.contains("[]")) {
                cur = cur.replace("()", "");
                if (cur.length() == 0) {
                    break;
                }
                cur = cur.replace("[]", "");
                if (cur.length() == 0) {
                    break;
                }
//                out.println(cur);
            }
            out.println(cur.length() == 0 ? "Yes" : "No");
        }
    }
}
