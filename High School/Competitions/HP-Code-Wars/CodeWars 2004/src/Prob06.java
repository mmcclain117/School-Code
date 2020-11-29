
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
//        Problem: What's the Median?
//        Points: 5
        Scanner scan = new Scanner(new File("prob06.txt"));
        ArrayList<Integer> ar = new ArrayList();
        int a = scan.nextInt();
        while (a != 0) {
            ar.add(a);
            Collections.sort(ar);
            if (ar.size() == 1) {
                System.out.println(a);
            } else {
                median(ar);
            }
            a = scan.nextInt();
        }
    }

    private static void median(ArrayList<Integer> ar) {
        int size = ar.size() / 2;
        if (ar.size() % 2 == 1) { // 2 median numbers
            System.out.println(ar.get(size));
        } else { // 1 median number
            System.out.println((ar.get(size) + ar.get(size - 1)) / 2);

        }
    }
}
