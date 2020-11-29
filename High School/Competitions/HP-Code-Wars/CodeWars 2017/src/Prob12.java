
import java.util.*;
import java.io.*;

/**
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: Tutors
//        Points: 7
        Scanner scan = new Scanner(new File("prob12.txt"));
        int a = scan.nextInt();
        for (int i = 0; i < a; i++) {
            int tot = scan.nextInt(); // Toutor
            int t1[] = new int[tot];
            for (int ii = 0; ii < tot; ii++) {
                t1[ii] = scan.nextInt();
            }
            int totr = scan.nextInt();
            int t2[] = new int[totr];
            for (int ii = 0; ii < totr; ii++) {
                t2[ii] = scan.nextInt();
            }
            if (false) {
                System.out.println("0");
            } else {
                long sum = 0;
                for (int ii = 0; ii < t1.length; ii++) {
                    for (int iii = 0; iii < t2.length; iii++) {
                        if (t1[ii] > t2[iii]) {
                            sum += 1;
                        } else {
                            break;
                        }
                    }
                }
                System.out.println(sum);
            }
        }
    }

}
