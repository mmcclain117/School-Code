
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: Parallelogram Graph
//        Points: 5
        Scanner scan = new Scanner(new File("prob08.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int l = 0; l < a; l++) {
            String line = scan.nextLine();
            int len = line.length();
            for (int c = 0; c < len; c++) {
                for (int s = 1; s < len - c; s++) {
                    System.out.print(" ");
                }
                System.out.println(line.substring(0, (c + 1)));
            }
            for (int c = 0; c < len; c++) {
                System.out.println(line.substring((c + 1)));
            }
            System.out.println();
        }
    }
}
