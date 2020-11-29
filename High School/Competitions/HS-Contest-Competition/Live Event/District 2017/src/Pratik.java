
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Pratik {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Pratik.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine();
            String c = scan.nextLine();
            String li[] = b.replaceAll(":", " ").split("\\s+");
            int h = Integer.parseInt(li[0]); // Hour
            int m = Integer.parseInt(li[1]); // Minute
            if (li[2].contains("p")) {
                h += 12;
            }
            switch (c) {
                case "Aunt Tapasi":
                    h += 5;
                    m += 30;
                    break;
                case "Grandpa Aadi":
                    h += 5;
                    m += 45;
                    break;
                case "Second Cousin Bongi":
                    h += 2;
                    break;
                case "Cousin Gulasyl":
                    h += 5;
                    break;
                case "Uncle Ardem":
                    h += 2;
                    break;
                case "Mom":
                    h += 12; // Going around
                    h += 6; // Current
                    break;
                default:
                    System.out.println(c + " not on the list");
                    break;
            }
            h += 6;
            if (m >= 60) { // Hour wrap around
                m -= 60;
                h++;
            }
            if (h >= 24) { // Day wrap around
                h -= 24;
            }
            char ch[][] = make(h, m);
            for (int y = 0; y < ch.length; y++) {
                for (int x = 0; x < ch[0].length; x++) {
                    System.out.print((ch[y][x] == '#' || ch[y][x] == '.' ? ch[y][x] : ' ') + "");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static char[][] make(int h, int m) {
        char ch[][] = new char[5][27];
        String fin = "";
        if (h < 10) {
            fin += "0";
        }
        fin += h;
        if (m < 10) {
            fin += "0";
        }
        fin += m;
        int set = 0;
        for (int i = 0; i < fin.length(); i++) {
            if (i == 2) {
                ch[1][set] = '.';
                ch[3][set] = '.';
                set += 3;
            }
            int c = Integer.parseInt(fin.charAt(i) + "");
            if (c != 1 && c != 4) { // Top Row
                for (int ii = 0; ii < 5; ii++) {
                    ch[0][set + ii] = '#';
                }
            }
            if (c != 1 && c != 2 && c != 3 && c != 7) { // Left top 3
                for (int ii = 0; ii < 3; ii++) {
                    ch[ii][set] = '#';
                }
            }
            if (c != 5 && c != 6) { // Right top 3
                for (int ii = 0; ii < 3; ii++) {
                    ch[ii][set + 4] = '#';
                }
            }
            if (c != 1 && c != 7 && c != 0) { // Middle
                for (int ii = 0; ii < 5; ii++) {
                    ch[2][set + ii] = '#';
                }
            }
            if (c == 2 || c == 6 || c == 8 || c == 0) { // Left bottom 3
                for (int ii = 0; ii < 3; ii++) {
                    ch[ii + 2][set] = '#';
                }
            }
            if (c != 2) { // Right Bottom 3
                for (int ii = 0; ii < 3; ii++) {
                    ch[ii + 2][set + 4] = '#';
                }
            }
            if (c != 1 && c != 4 && c != 7) { // Bottom
                for (int ii = 0; ii < 5; ii++) {
                    ch[4][set + ii] = '#';
                }
            }
            set += 6;
        }
        return ch;
    }
}
