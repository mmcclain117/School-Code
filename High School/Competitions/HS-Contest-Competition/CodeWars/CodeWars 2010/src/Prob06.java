
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: Product Review Site
//        Difficulty: Easy
//        Subject: Counting
        Scanner scan = new Scanner(new File("prob06.txt"));
        int a = scan.nextInt();
        int b[] = new int[5];
        while (a != 0) {
            int c = a == 1 ? b[0]++ : a == 2 ? b[1]++ : a == 3 ? b[2]++ : a == 4 ? b[3]++ : b[4]++;
            a = scan.nextInt();
        }
//        System.out.println(Arrays.toString(b));
        int sum = 0;
        int con = 0;
//        for (int i = 0; i < b.length; i++) {
        for (int i = 4; i >= 0; i--) {
            System.out.print(i + 1 + " (");
            System.out.printf("%2d) |", b[i]);
            for (int ii = 0; ii < b[i]; ii++) {
                System.out.print("=");
            }
            System.out.println();
            sum += b[i] * (i + 1);
            con += b[i];
        }
        System.out.printf("Average Rating: %.4f\n", ((double) sum / con));
    }

}
