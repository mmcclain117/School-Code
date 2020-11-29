
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
//        Problem: Diamond in the Rough
//        Difficulty: Medium
//        Subject: Printing, Diamond
        Scanner scan = new Scanner(new File("prob11.txt"));
        int a = scan.nextInt(); // Size
        int b = scan.nextInt(); // Rows
        int c = scan.nextInt(); // Columns
        while (a != 0 && b != 0 && c != 0) {
            for (int r = 0; r < b; r++) {
                for (int row = 1; row <= a; row++) {
                    printDiamondRow(a, row, c);
                }
            }
            System.out.println();
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
        }
    }

    private static void printDiamondRow(int size, int row, int cols) {

        String fs; // First Slash
        String ss; // Second Slash
        if (row <= (size / 2)) {
            fs = "/";
            ss = "\\";
        } else {
            fs = "\\";
            ss = "/";
            row = (size - row) + 1;
        }
        int numSlashes = (size - (row * 2));
        int hashBefore = numSlashes / 2;
        int hashAfter = size - hashBefore;
        for (int col = 0; col < cols; col++) {
            for (int index = 0; index <= size; index++) {
                String toPrint = "";
                if (index < hashBefore || index > hashAfter) {
                    toPrint = "#";
                } else if (index < (hashBefore + row)) {
                    toPrint = fs;
                } else if (index < hashAfter) {
                    toPrint = ss;
                }
                System.out.print(toPrint);
            }
        }
        System.out.println();
    }
}
