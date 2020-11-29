
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Perfect Painting
//        Points: 6
        Scanner scan = new Scanner(new File("prob09.txt"));
        int l = scan.nextInt(); // Length
        int w = scan.nextInt(); // Width
        int h = scan.nextInt(); // Height
        while (!(l == 0 && w == 0 && h == 0)) {
            System.out.print("A " + l + "x" + w + "x" + h + " block is ");
            int total = l * w * h;// Total Number of blocks
            int color = l * h * 2 + (h - 2) * (w - 2) * 2 + l * (w - 2) * 2; // Colored Blocks
            int unColor = total - color; // Uncolored Blocks
            if (color == unColor) {
                System.out.println("PERFECT");
            } else if (color > unColor) {
                System.out.println("MORE than Perfect");
            } else if (color < unColor) {
                System.out.println("LESS than Perfect");
            }
//            System.out.println(total + " " + color + " " + unColor);
            l = scan.nextInt();
            w = scan.nextInt();
            h = scan.nextInt();
        }
    }

}
