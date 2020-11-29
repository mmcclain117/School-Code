package Round_540;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_CombinationLock {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();
        String st1 = scan.nextLine();
        String st2 = scan.nextLine();
        int set1[] = new int[num];
        int set2[] = new int[num];
        for (int i = 0; i < num; i++) {
            set1[i] = Integer.parseInt(st1.substring(i, i + 1));
            set2[i] = Integer.parseInt(st2.substring(i, i + 1));
        }
        int temp1, temp2;
        int result = 0;
        for (int i = 0; i < num; i++) {
            temp1 = set1[i];
            temp2 = set2[i];
            if (temp1 > temp2) {
                if (temp1 - temp2 > 5) {
                    result += (temp2 + 10) - temp1;
                } else {
                    result += temp1 - temp2;
                }
            } else if (temp1 < temp2) {
                if (temp2 - temp1 > 5) {
                    result += (temp1 + 10) - temp2;
                } else {
                    result += temp2 - temp1;
                }
            }
        }
        out.println(result);
    }
}
