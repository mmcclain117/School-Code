
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class prob18 {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("prob18.txt"));
        int y = scan.nextInt();
        int x = scan.nextInt();
        int i = 0;
        for (int z = 0; z < x; z++) {
            String a = scan.nextLine();
            Scanner in = new Scanner(a);
            int s[] = new int[x * y];
            int p = 0; //int length
            int pp = 0; // char length
            char ss[] = a.toCharArray();
            if (Character.isDigit(ss[pp])) {
                s[p] = ss[pp];
                ss[pp] = '#';
                p++;
                pp++;
            } else {
                pp++;
            }
            char ch[][] = new char[y][x];
            int yy = 0;
            for (int sa = 0; sa < y; sa++) {
                for (int t = 0; t < x; t++) {
                    ch[sa][t] = ss[yy];
                }
            }
            out.println(Arrays.toString(ch));
            endi(ch, y, x);
        }
    }

    public static char[][] fill(char ch[][], int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int z = 0; z < b; z++) {
                ch[i][z] = '#';
            }
        }
        return ch;
    }

    public static void endi(char ch[][], int a, int b) {
        int y = 0;
        int x = 0;
        while (true) {
            if (x > b) {
                x = 0;
                y++;
            } else if (y > a) {
                y = 0;
                x = 0;
            } else {
                ch[y][x] = '.';
            }
        }
    }

    private static void Write() throws Exception {
        FileWriter fw = new FileWriter("prob18.txt");
        fw.write("5 9\n"
                + "3 3 3 3 2 1 S 8 9\n"
                + "3 1 1 3 3 0 6 8 7\n"
                + "1 2 2 4 3 2 5 9 7\n"
                + "1 2 1 5 4 3 4 4 6\n"
                + "1 1 X 6 4 4 5 5 5");
        fw.flush();
        fw.close();
    }

    private static void Write1() throws Exception {
        FileWriter fw = new FileWriter("prob18.txt");
        fw.write("4 10\n"
                + "5 8 S 8 9 3 4 1 2 1\n"
                + "6 7 7 9 8 3 2 2 4 X\n"
                + "6 4 8 1 3 3 4 2 3 0\n"
                + "5 5 4 4 4 6 5 1 1 1");
        fw.flush();
        fw.close();
    }
}
