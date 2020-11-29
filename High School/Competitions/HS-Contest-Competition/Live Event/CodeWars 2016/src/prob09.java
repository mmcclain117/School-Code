
import java.io.File;
import java.util.Scanner;

public class prob09 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob09.txt"));

        while (scan.hasNextInt()) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();

            if (x == 0 || y == 0 || z == 0) {
                break;
            }

            int noPaint = determineNoPaint(x - 2, y - 2, z - 2);
            int paint = (x * y * z) - noPaint;

            if (paint > noPaint) {
                System.out.println("A " + x + "x" + y + "x" + z + " block is MORE than perfect.");
            } else if (paint == noPaint) {
                System.out.println("A " + x + "x" + y + "x" + z + " block is PERFECT.");
            } else {
                System.out.println("A " + x + "x" + y + "x" + z + " block is LESS than perfect.");
            }
        }
    }

    public static int determineNoPaint(int x, int y, int z) {
        int amt = x * y * z;
        return amt;
    }
}
