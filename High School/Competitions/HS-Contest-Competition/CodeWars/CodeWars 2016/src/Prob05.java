
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Letter Tax
//        Difficulty: Easy
//        Subject: Letter Placement
        Scanner scan = new Scanner(new File("prob05.txt"));
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            int b = scan.nextInt();
            String c = scan.nextLine();
            char ch[] = c.toCharArray();
            String fin = "";
            for (int ii = 0; ii < ch.length; ii++) {
                if (ii % b != 1) {
                    fin += ch[ii];
                }
            }
            fin = fin.trim();
            System.out.println(fin + " " + fin.length());
        }
    }

}
