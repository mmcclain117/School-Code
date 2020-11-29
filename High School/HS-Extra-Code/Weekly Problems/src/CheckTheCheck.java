
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class CheckTheCheck {

    public static void main(String args[]) {
//	Lowercase is black, uppercase is white
        Scanner scan = new Scanner(System.in);
        String ss = scan.nextLine();
        char ch[][] = new char[8][8];
        for (int i = 0; i < 8; i++) {
            ch[i] = ss.toCharArray();
            ss = scan.nextLine();
        }
        ArrayList<Integer> bx = new ArrayList<>(); // Black x spots
        ArrayList<Integer> by = new ArrayList<>(); // black y spots
        ArrayList<Integer> wx = new ArrayList<>(); // White x spots
        ArrayList<Integer> wy = new ArrayList<>(); // White y spots
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                char temp = ch[y][x];
                if (!(temp == '.')) {
                    if (temp > 97) {
                        bx.add(x);
                        by.add(y);
                    } else {
                        wx.add(x);
                        wy.add(y);
                    }
                }
            }
        }
    }
}
