
import java.io.File;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class rightTreeWrong {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("righttree.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            boolean s = false;
            String b = scan.nextLine();
            if ("1".equals(b)) {
                s = false;
            } else {
                char ch[] = b.toCharArray();
                int len = ch.length + 1; // length
                int tlen = ch.length + 1; // Temp length
                int con = 0;
//                System.out.println(len);
                while (tlen > 0) {
                    tlen -= Math.pow(2, con);
                    con++;
                }
//                System.out.println(tlen);
                s = tlen == 0;
                con = 0;
                int point = 1;
                if (!s && len > 4 && i == 4) {
//                    System.out.println(Arrays.toString(ch));
                    while (point < ch.length - 1) {
                        if (ch[point] == '1') {
                            point += Math.pow(2, con);
                        } else {
                            s = true;
                            break;
                        }
//                        s = ch[len - 2] == '1' && ch[len - 3] == '1';
                    }
                }
//                double sq = sqrt((double) len);
//                System.out.println(sq % 1);
            }
            String fin = s ? "not " : "";
            out.println("Tree " + (i + 1) + " is " + fin + "a right-tree");
        }
    }

}
