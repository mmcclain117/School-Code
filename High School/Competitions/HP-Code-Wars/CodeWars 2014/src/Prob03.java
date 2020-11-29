
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Clock Power
//        Points: 4
        Scanner scan = new Scanner(new File("prob03.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int ii = 0; ii < a; ii++) {
            String b = scan.nextLine();
            int sum = 20;
            b = b.replace(":", "");
            sum += co(b);
            System.out.println(sum + " milliamps");
        }
    }

    private static int co(String b) {
        char ch[] = b.toCharArray();
        int con = 0;
        int count[] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        for (char c : ch) {
            con += count[c - '0'];
        }
        return con * 15;
    }

}
