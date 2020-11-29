
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob14 {

    public static void main(String[] args) throws Exception {
//        Problem: Dee Scramble
//        Subject: Replace, Shifting Spot
//        Points: 11
        Scanner scan = new Scanner(new File("prob14.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        String b = scan.nextLine();
        String fin = "";
        b = b.replaceAll("~", " ");
        int m = 3;
        char ch[] = b.toCharArray();
        while (!fin.endsWith("-DEE")) {
            fin = "";
            int con = 0;
            for (int i = 0; i < a; i++) {
                fin += ch[con % a];
                con += m;
            }
            m++;
        }
        System.out.println(fin);
    }
}
