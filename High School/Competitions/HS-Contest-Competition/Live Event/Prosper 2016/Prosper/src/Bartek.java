
import java.io.File;
import java.util.Scanner;

public class Bartek {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("bartek.dat"));

        while (scan.hasNextInt()) {
            int size = scan.nextInt();
            int diff = size - 1;
            for (int i = 0; i < diff; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < size; i++) {
                System.out.print("*");
            }

        }
    }

}
