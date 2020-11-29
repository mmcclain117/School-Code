
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
//        Problem: Diamond in the Rough
//        Points: 7
        Scanner scan = new Scanner(new File("prob11.txt"));
        int size = scan.nextInt(); // Size
        int row = scan.nextInt(); // Rows
        int col = scan.nextInt(); // Columns
        while (size != 0 && row != 0 && col != 0) {
            for (int c = 0; c < row; c++) { // By Columns
                for (int r = 1; r <= size; r++) {// By Row
                    printDiamondRow(size, r, col);
                }
            }
            System.out.println();
            size = scan.nextInt();
            row = scan.nextInt();
            col = scan.nextInt();
        }
    }

    /* Prints out the diamond */
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
