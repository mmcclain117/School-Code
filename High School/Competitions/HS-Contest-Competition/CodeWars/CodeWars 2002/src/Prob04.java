
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Hangman
//        Points: 4
        Scanner scan = new Scanner(new File("prob04.txt"));
        String o1 = ""; // Output line 1
        String o2 = ""; // Output line 2
        String o3 = ""; // Output line 3
        String word = scan.nextLine();
        String left = word.toLowerCase();
        String guess = scan.nextLine();
        char ch[] = guess.toLowerCase().toCharArray();
        int wrong = 0;
        for (int i = 0; i < ch.length; i++) {
            int len = left.length(); // Length of word
            left = left.replaceAll(ch[i] + "", "");
            if (len == left.length()) {
                wrong++;
            }
            if (wrong > 6) { // Lose
                System.out.println("You Lost!");
                break;
            }
        }
        switch (wrong) {
            case 6:
                o1 += " o ";
                o2 += "/|\\";
                o3 += "/ \\";
                break;
            case 5:
                o1 += " o ";
                o2 += "/|\\";
                o3 += "/";
                break;
            case 4:
                o1 += " o ";
                o2 += "/|\\";
                break;
            case 3:
                o1 += " o ";
                o2 += "/|";
                break;
            case 2:
                o1 += " o ";
                o2 += "/";
                break;
            case 1:
                o1 += " o ";
                break;
            default:
                break;
        }
        if (wrong <= 6) {
            System.out.println("You Won!");
            System.out.println(o1);
            System.out.println(o2);
            System.out.println(o3);
        }
    }
}
