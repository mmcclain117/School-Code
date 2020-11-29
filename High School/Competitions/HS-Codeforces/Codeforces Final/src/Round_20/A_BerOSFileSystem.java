package Round_20;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_BerOSFileSystem {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b[] = a.split("[/]+");
//        for (String c : b) {
        for (int i = 0; i < b.length - 1; i++) {
            System.out.print(b[i] + "/");
        }
        if (b.length == 0) {
            System.out.println("/");
        } else {
            System.out.println(b[b.length - 1]);
        }
    }
}
