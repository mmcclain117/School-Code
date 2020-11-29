
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    public static char[][] ch;

    public static void main(String[] args) throws Exception {
//        Problem: Mine Layer (Minesweeper)
//        Difficulty: Medium
//        Subject: 2D arrays
        Scanner scan = new Scanner(new File("prob07.txt"));
        ch = new char[15][30];
        for (int y = 0; y < ch.length; y++) {
            ch[y] = scan.nextLine().toCharArray();
        }
        StringBuffer sb = new StringBuffer();

        for (int y = 0; y < ch.length; y++) {
            for (int x = 0; x < ch[0].length; x++) {
                if (ch[y][x] == '*') {
                    sb.append('*');
                } else {
                    String numb = count(y, x);
                    sb.append(numb);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static String count(int y, int x) {
//        char cur = ch[y][x];
        int con = 0;
        try {
            con += ch[y - 1][x - 1] == '*' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {

            con += ch[y - 1][x] == '*' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            con += ch[y - 1][x + 1] == '*' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            con += ch[y][x - 1] == '*' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            con += ch[y][x + 1] == '*' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            con += ch[y + 1][x - 1] == '*' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            con += ch[y + 1][x] == '*' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        try {
            con += ch[y + 1][x + 1] == '*' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        if (con == 0) {
            return ".";
        }
        return con + "";
    }
}
