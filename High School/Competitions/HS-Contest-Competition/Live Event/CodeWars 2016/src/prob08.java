
import java.io.File;
import java.util.Scanner;

public class prob08 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob08.txt"));

        int amt = scan.nextInt();
        while (--amt >= 0) {
            String in = scan.next();
            String string = "";
            int idx = 1;

            while (idx <= in.length()) {
                string = in.substring(0, idx++);
                System.out.printf("%" + in.length() + "s%n", string);
            }
            idx = 0;
            while (idx < in.length()) {
                string = in.substring(idx++, in.length());
                System.out.printf("%-" + in.length() + "s%n", string);
            }
        }
    }
}
