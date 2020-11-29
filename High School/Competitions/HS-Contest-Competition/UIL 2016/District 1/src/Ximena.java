
import java.io.File;
import java.util.Collections;
import java.util.Scanner;

public class Ximena {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("ximena.dat"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            int b = a.length() / 2;
            for (int i = 1; i < a.length(); i++) {
                System.out.print(a.charAt(a.length() - i));
            }
//            if (b * 2 != a.length()) {
//                System.out.print(a.charAt(b));
//            }
            for (int i = 0; i < a.length(); i++) {
                System.out.print(a.charAt(i));
            }
            System.out.println();
        }
    }

}
