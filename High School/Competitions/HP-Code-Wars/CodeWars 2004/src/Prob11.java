
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 *
 * 1 MISSING OR 1 WRONG LETTER
 */
public class Prob11 {

    private static String items[] = {"COFFEE", "SODA", "MILKSHAKE", "PANCAKES", "WAFFLES", "HAMBURGERS", "PASTA", "HOTDOG", "CHIPS", "FRIES"}; // Item names

    public static void main(String[] args) throws Exception {
//        Problem: Check Please? (Advance)
//        Points: 9
        Scanner scan = new Scanner(new File("prob11.txt"));
        String s = scan.nextLine(); // Ordering
        double sum = 0;
        while (!(s.equals("END"))) {
            switch (sim(s)) {
                case "COFFEE":
                    sum += .5;
                    break;
                case "SODA":
                    sum += 1;
                    break;
                case "MILKSHAKE":
                    sum += 2.13;
                    break;
                case "PANCAKES":
                    sum += 3.25;
                    break;
                case "WAFFLES":
                    sum += 3.92;
                    break;
                case "HAMBURGERS":
                    sum += 4.01;
                    break;
                case "PASTA":
                    sum += 4.44;
                    break;
                case "HOTDOG":
                    sum += 2.98;
                    break;
                case "CHIPS":
                    sum += .65;
                    break;
                case "FRIES":
                    sum += .99;
                    break;
                default:
                    System.out.println(s + " Has not been found ");
                    break;
            }
            s = scan.nextLine();
        }
        System.out.printf("Your total is $%.2f\n", sum);
    }

    /* Matches up with item list and returns the closest version */
    private static String sim(String s) {
        int len = s.length(); // Length of word
        for (int i = 0; i < items.length; i++) {
            if (len == items[i].length()) { // Changed a letter
//                System.out.println(s + " is really close to " + items[i]);
                int con = 0; // number of right
                if (similar(s, items[i]) + 1 == len) {
                    return items[i];
                }
            } else if (len + 1 == items[i].length()) { // Removed a letter
//                System.out.println(s + " is close to " + items[i]);
                if (similar(s, items[i]) == len) {
                    return items[i];
                }
            }
        }
        return s;
    }

    /* Return the number of similar letters */
    private static int similar(String s1, String s2) {
        if (s1.length() != s2.length()) { // Different size words
            if (s1.length() > s2.length()) { // S1 is bigger
                s2 += " ";
            } else { // S2 is bigger
                s1 += " ";
            }
        }
        char ch1[] = s1.toCharArray();
        Arrays.sort(ch1);
        char ch2[] = s2.toCharArray();
        Arrays.sort(ch2);
//        System.out.println(Arrays.toString(ch1));
//        System.out.println(Arrays.toString(ch2));
        int con = 0;
        for (int i = 0; i < ch1.length; i++) {
            con += ch1[i] == ch2[i] ? 1 : 0;
        }
        return con;
    }
}
