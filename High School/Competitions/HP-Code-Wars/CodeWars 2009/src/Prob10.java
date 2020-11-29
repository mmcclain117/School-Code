
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String args[]) throws Exception {
//        Problem: Data in a Huff
//        Points: 6
        Scanner scan = new Scanner(new File("prob10.txt"));
        String x[][] = {
            {" ", "00"},
            {"M", "01000"},
            {".", "010010"},
            {"P", "010011"},
            {"F", "01010"},
            {"G", "010110"},
            {"2", "010111000"},
            {"Q", "010111001"},
            {"!", "01011101000"},
            {"7", "01011101001"},
            {"5", "0101110101"},
            {"0", "010111011"},
            {",", "01011110"},
            {"J", "01011111000"},
            {"?", "0101111100100"},
            {"9", "0101111100101"},
            {"4", "010111110011"},
            {"X", "0101111101"},
            {"K", "010111111"},
            {"I", "0110"},
            {"N", "0111"},
            {"A", "1000"},
            {"O", "1001"},
            {"L", "10100"},
            {"H", "10101"},
            {"C", "10110"},
            {"Y", "101110"},
            {"U", "101111"},
            {"T", "1100"},
            {"D", "11010"},
            {"B", "110110"},
            {"W", "1101110"},
            {"1", "110111100"},
            {"6", "11011110100"},
            {"8", "11011110101"},
            {"Z", "11011110110"},
            {"3", "11011110111"},
            {"V", "11011111"},
            {"R", "11100"},
            {"S", "11101"},
            {"E", "1111"},
            {"0", ""}
        };
        String fin = "";
        while (scan.hasNext()) {
            fin += scan.nextLine();
        }
        char ch[] = fin.toCharArray();
        int bitCount = 0;
        int byteCount = 0;
        String s = "";
//        while (scan.hasNext()) {
        for (int con = 0; con < ch.length; con++) {
            char c = ch[con];
            if (c == '1' || c == '0') {
                bitCount++;
                s += c;
                for (int i = 0; i < x.length; i++) {
                    if (x[i][1].equals(s)) {
                        System.out.print(x[i][0]);
                        byteCount++;
                        s = "";
                        break;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("message bits: " + byteCount * 8);
        System.out.println("compressed bits: " + bitCount);

    }
}
