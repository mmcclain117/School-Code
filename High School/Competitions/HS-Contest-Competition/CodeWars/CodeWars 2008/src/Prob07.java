
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
        Scanner scan = new Scanner(new File("prob07.txt"));
        String a = scan.nextLine();
        String tab[][] = {{"a", "a", "ai", "a", "w", "w", "w"},
        {"y", "ei", "ei", "y", "ou", "ou", "w"},
        {"w", "ou", "oi", "w", "ou", "ou", "w"}};
        while (!"END".equals(a)) {
            int sep = a.indexOf("-");
            char r = a.charAt(sep - 1); // Root
            char s = a.charAt(sep + 1); // Suffex
//            System.out.println(r + " " + s);
            int y = 0;
            int x = 0;
            switch (r) {
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
            boolean wor = true;
            switch (s) {
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
                    wor = false;
                    break;
            }
            if (!wor) {
                String ss = s + "" + a.charAt(sep + 2);
//                System.out.println(ss);
                switch (ss) {
                    case "ou":
                        x = 5;
                        break;
//                    case "o":
                    default:
                        x = 4;
                        wor = true;
                        break;
                }
            }
//            System.out.println(y + " " + x);
//            System.out.println(tab[y][x]);
//            System.out.println(tab[y + 1][x + 1]);
            System.out.print(a.substring(0, sep - 1) + tab[y][x]);
//            if (wor) {
            if (tab[y][x].length() == 1) {
                System.out.println(a.substring(sep + 2));
            } else {
                System.out.println(a.substring(sep + 3));
            }
            a = scan.nextLine();
        }
    }

}
