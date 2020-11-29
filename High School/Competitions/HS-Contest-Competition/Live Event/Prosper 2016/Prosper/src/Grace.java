
import java.io.File;
import java.util.Scanner;

public class Grace {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("grace.dat"));

        while (scan.hasNextInt()) {
            int i = scan.nextInt();
            if (i % 3 == 0) {
                System.out.printf("%.1f%n", Math.pow(i, 2));
            } else if (i % 3 == 1) {
                System.out.printf("%.1f%n", Math.sqrt(i));
            } else if (i % 3 == 2) {
                System.out.printf("%.1f%n", Math.cbrt(i));
            }
        }
    }

}
