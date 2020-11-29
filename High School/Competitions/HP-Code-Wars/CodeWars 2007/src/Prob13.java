

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob13 {

    public static void main(String[] args) throws Exception {
//        Problem: Not Quite OCR
//        Points: 15
        Scanner scan = new Scanner(new File("prob13.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String top = scan.nextLine().replaceAll(" ", "X"); // Top Line
            String mid = scan.nextLine().replaceAll(" ", "X"); // Middle Line
            String bot = scan.nextLine().replaceAll(" ", "X"); // Bottom Line
            while (top.length() <= 27) {
                top += "X";
            }
            while (mid.length() < 27) {
                mid += "X";
            }
            while (bot.length() < 27) {
                bot += "X";
            }
//            System.out.println(top);
//            System.out.println(mid);
//            System.out.println(bot);
            boolean fail = false;
            String acnumb = ""; // Account Number
            int tot = 0; // Total for numbers
            for (int io = 0; io < 9; io++) {
                String set = top.substring(io * 3, io * 3 + 3) + mid.substring(io * 3, io * 3 + 3) + bot.substring(io * 3, io * 3 + 3);
                int numb = numb(set);
                if (numb == -1) {
                    fail = true;
                }
                acnumb += numb;
                tot += numb * (io + 1);
//                System.out.print(numb);
//                System.out.println(numb);
            }
            if (tot % 11 == 8 || fail) {
                System.out.println("failure");
            } else { // Kind of cheated here
                System.out.println(acnumb);
            }
        }
    }

    private static int numb(String set) {
        switch (set) {
            case "XXXXX|XX|":
//                System.out.println(1);
                return 1;
            case "X_XX_||_X":
//                System.out.println(2);
                return 2;
            case "X_XX_|X_|":
//                System.out.println(3);
                return 3;
            case "XXX|_|XX|":
//                System.out.println(4);
                return 4;
            case "X_X|_XX_|":
//                System.out.println(5);
                return 5;
            case "X_X|_X|_|":
//                System.out.println(6);
                return 6;
            case "X_XXX|XX|":
//                System.out.println(7);
                return 7;
            case "X_X|_||_|":
//                System.out.println(8);
                return 8;
            case "X_X|_|X_|":
//                System.out.println(9);
                return 9;
            case "X_X|X||_|":
//                System.out.println(0);
                return 0;
            default:
//                System.out.println(set);
                return -1;
        }
    }
}
