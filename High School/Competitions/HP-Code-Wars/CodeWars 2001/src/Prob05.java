
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Golf
//        Points: 5
        Scanner scan = new Scanner(new File("prob05.txt"));
        System.out.println("                     Total     Total");
        System.out.println("Hole  Strokes  +/-   Strokes   +/-  ");
        System.out.println("====  =======  ===   =======   =====");
        int n = scan.nextInt(); // Number of clubs
        int distance[] = new int[n]; // DIstance of each club
        for (int i = 0; i < n; i++) {
            distance[i] = scan.nextInt();
        }
        int totStrokes = 0; // Total Number of Strokes
        int totPoM = 0; // Total +/-
        int h = scan.nextInt(); // Number of holes
        for (int i = 0; i < h; i++) {
            int dist = scan.nextInt(); // Distance
            int par = scan.nextInt(); // Number for par
            int strokes = 0; // Strokes 
            int con = 0;
            /* Gets the number of strokes */
            while (dist > 0) {
                while (con < distance.length) {
                    if (distance[con] > dist) {
                        con++;
                    } else {
                        dist -= distance[con];
                        strokes++;
                    }
                }
            }
            int PoM = strokes - par; // Plus or Minus
            totStrokes += strokes;
            totPoM += PoM;
//            System.out.print(h + "     " + sto + "        " + pom );
            System.out.printf("%-6s%-9s%-6s%-10s%-6s\n", i + 1, strokes, stringy(PoM), totStrokes, stringy(totPoM));
        }
    }

    /* Turns an int and adds a +/- to it */
    private static String stringy(int a) {
        if (a > 0) {
            return "+" + a;
        } else {
            return a + "";
        }
    }
}
