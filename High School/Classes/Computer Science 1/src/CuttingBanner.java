
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class CuttingBanner {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine().trim().toUpperCase();
        scan.close();
        String match = "CODEFORCES";
        char mat[] = match.toCharArray(); // need to be word
        char lin[] = a.toCharArray(); // Line
        ArrayList aa = new ArrayList(); // Line
        int count = 10;
        int goal = lin.length - 10;
        for (int i = 0; i < lin.length; i++) {
            aa.add(lin[i]);
        }
        for (int i = 0; i < 10; i++) {
            int last = 0;
            if (aa.contains(mat[i])) {
                int au = aa.indexOf(mat[i]);
                last = au;
                if (!(au == -1)) {
                    aa.remove(au);
                    count--;
                } else if (last == au) {
                    break;
                }
            }
        }
        String possible = aa.size() <= goal ? "YES" : "NO";
        System.out.println(possible);
    }
}
