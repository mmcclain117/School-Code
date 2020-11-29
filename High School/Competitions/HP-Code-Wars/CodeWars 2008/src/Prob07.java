
/**
 * Problem: It is all Greek to Me
 */
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: It's All Greek To Me
//        Points: 6
        Scanner scan = new Scanner(new File("prob07.txt"));
        String line = scan.nextLine();
        String tab[][] = {{"a", "a", "ai", "a", "w", "w", "w"},
        {"y", "ei", "ei", "y", "ou", "ou", "w"},
        {"w", "ou", "oi", "w", "ou", "ou", "w"}};
        while (!"END".equals(line)) {
            int sep = line.indexOf("-");
            char root = line.charAt(sep - 1); // Root
            char suf = line.charAt(sep + 1); // Suffex
            int y = 0;
            int x = 0;
            switch (root) {
                case 'a':
                    y = 0;
                    break;
                case 'e':
                    y = 1;
                    break;
                case 'o':
                    y = 2;
                    break;
                default:
                    break;
            }
            boolean word = true;
            switch (suf) {
                case 'a':
                    x = 0;
                    break;
                case 'e':
                    x = 1;
                    break;
                case 'i':
                    x = 2;
                    break;
                case 'y':
                    x = 3;
                    break;
                case 'w':
                    x = 6;
                    break;
                default:
                    word = false;
                    break;
            }
            if (!word) {
                String ss = suf + "" + line.charAt(sep + 2);
                switch (ss) {
                    case "ou":
                        x = 5;
                        break;
                    default:
                        x = 4;
                        word = true;
                        break;
                }
            }
            System.out.print(line.substring(0, sep - 1) + tab[y][x]);
            if (tab[y][x].length() == 1) {
                System.out.println(line.substring(sep + 2));
            } else {
                System.out.println(line.substring(sep + 3));
            }
            line = scan.nextLine();
        }
    }

}
