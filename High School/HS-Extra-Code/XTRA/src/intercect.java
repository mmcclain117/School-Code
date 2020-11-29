
import java.util.*;
import java.io.*;

public class intercect {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("C:\\Users\\180869\\Desktop\\i.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine().replaceAll("[^0-9]", " ");
            String c = scan.nextLine().replaceAll("[^0-9]", " ");
//System.out.println(b);
            Scanner scan1 = new Scanner(b);
            int x11 = scan1.nextInt();
            int y11 = scan1.nextInt();
            int x21 = scan1.nextInt();
            int y21 = scan1.nextInt();
            Scanner scan2 = new Scanner(c);
            int x12 = scan2.nextInt();
            int y12 = scan2.nextInt();
            int x22 = scan2.nextInt();
            int y22 = scan2.nextInt();
            int c1 = ((y21 - y11) * 11) - ((x11 - x21) * y11);
            int c2 = ((y22 - y12) * 12) - ((x12 - x22) * y22);
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c1 == c2);
        }
    }
}
