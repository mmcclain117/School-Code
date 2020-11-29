
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: Letter Distribution
//        Points: 6
        Scanner scan = new Scanner(new File("prob08.txt"));
        String a = scan.nextLine();
        String fin = "";
        while (!"###".equals(a)) {
            fin += a;
            a = scan.nextLine();
        }
//        System.out.println(fin);
        fin = fin.toUpperCase().replaceAll("[^A-Z]+", ""); // Remove non letters
        char ch[] = fin.toCharArray();
        int cd[] = new int[26];
//        System.out.println(Arrays.toString(ch));
        for (int i = 0; i < ch.length; i++) {
            cd[ch[i] - 'A']++;
        }
//        System.out.println(Arrays.toString(cd));
        /* Selection sort style printout */
        for (int i = 0; i < 26; i++) {
            int max = -1; // Max number
            int mindex = -1; // Max number index
            for (int con = 0; con < 26; con++) { // Iterates
                if (cd[con] > max) {
                    max = cd[con];
                    mindex = con;
                }
            }
            System.out.print((char) (mindex + (int) 'A') + " ");
            for (int o = 0; o < max; o++) {
                System.out.print("*");
            }
            System.out.println();
            cd[mindex] = -1; // Has Been Visited
        }
    }
}
