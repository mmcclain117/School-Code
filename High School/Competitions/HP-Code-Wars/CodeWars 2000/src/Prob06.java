
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */

/* Used a # to add user input afterwards */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Find It 
//        Points: 5
        Scanner scan = new Scanner(new File("prob06.txt"));
        String s = scan.nextLine();
        ArrayList<String> ar = new ArrayList();
        while (!s.equals("#")) {
            ar.add(s);
            s = scan.nextLine();
        }
        String look = scan.nextLine().toLowerCase(); // Word looking for
        for (int i = 0; i < ar.size(); i++) {
            String tmp = ar.get(i).toLowerCase(); // Line checking
            if (tmp.contains(look)) {
                System.out.println(tmp);
            }
        }
    }
}
