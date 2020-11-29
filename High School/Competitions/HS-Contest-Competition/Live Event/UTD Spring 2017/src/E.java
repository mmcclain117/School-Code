
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Master
 */
public class E {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("E.txt"));
        boolean first = true;
        int con = 1;
        while (scan.hasNext()) {
            if (!first) {
                scan.nextLine();
            } else {
                first = false;
            }
            String a = scan.nextLine(); // The Set of letters
            TreeSet<Character> ts = new TreeSet();
            for (int i = 0; i < a.length(); i++) {
                ts.add(a.charAt(i));
            }
            char ch[][] = new char[9][9];
//            ch[0] = a.toCharArray();
            for (int i = 0; i < 9; i++) {
                ch[i] = scan.nextLine().toCharArray();
            }
//            System.out.println(Arrays.toString(ch[8]));
            boolean check = check(ts, ch);
//            System.out.println(check);
            System.out.println("Grid " + con++ + ": " + (check ? "This is a valid Sudoku solution." : "This is not a valid Sudoku solution."));
//            scan.nextLine();
//            System.out.println(scan.nextLine());
        }
    }

    private static boolean check(TreeSet<Character> ts, char[][] ch) {
        String b = "";
        for (int i = 0; i < ts.size(); i++) {
            b += ts.pollFirst();
        }
        boolean bo = checkBox(b, ch);
        boolean upDown = checkVer(b, ch);
        boolean leri = checkHor(b, ch);
        return upDown && leri && bo;
    }

    private static boolean checkVer(String b, char[][] ch) {
        for (int i = 0; i < 9; i++) {
            TreeSet<Character> c = new TreeSet(); // Current Tree
            for (int p = 0; p < 9; p++) {
                c.add(ch[p][i]);
            }
            String a = "";
            for (int ix = 0; ix < c.size(); ix++) {
                a += c.pollFirst();
            }
//            if (!(Arrays.toString(c.toArray())).equals((Arrays.toString(ts.toArray())))) {
            if (!b.equals(a)) {
//                System.out.println(Arrays.toString(c.toArray()) + " " + Arrays.toString(ts.toArray()) + " " + i);
//                System.out.println(i + " V " + b + " " + a);
                return false;
            }
        }
        return true;
    }

    private static boolean checkHor(String b, char[][] ch) {
        for (int i = 0; i < 9; i++) {
            TreeSet<Character> c = new TreeSet(); // Current Tree
            for (int p = 0; p < 9; p++) {
                c.add(ch[i][p]);
            }
            String a = "";
            for (int ix = 0; ix < c.size(); ix++) {
                a += c.pollFirst();
            }
//            if (!(Arrays.toString(c.toArray())).equals((Arrays.toString(ts.toArray())))) {
            if (!b.equals(a)) {
//                System.out.println(Arrays.toString(c.toArray()) + " " + Arrays.toString(ts.toArray()) + " " + i);
//                System.out.println(i + " H " + " " + b + " " + a);
                return false;
            }
        }
        return true;
    }

    private static boolean checkBox(String b, char[][] ch) {
        for (int i = 0; i < 3; i++) {
            for (int ii = 0; ii < 3; ii++) {
                TreeSet<Character> c = new TreeSet(); // Current Tree
                for (int p = 0; p < 3; p++) {
                    for (int ix = 0; ix < 3; ix++) {
                        c.add(ch[i * 3 + p][ii * 3 + ix]);
//                        c.add(ch[i * 3 + p + 1][ii * 3 + ix + 1]);
//                        c.add(ch[i * 3 + p + 2][ii * 3 + ix + 2]);
                    }
                }
                String a = "";
                for (int ix = 0; ix < c.size(); ix++) {
                    a += c.pollFirst();
                }
//                System.out.println(a);
//            System.out.println(b);
//            if (!(Arrays.toString(c.toArray())).equals((Arrays.toString(ts.toArray())))) {
                if (!b.equals(a)) {
//                System.out.println(Arrays.toString(c.toArray()) + " " + Arrays.toString(ts.toArray()) + " " + i);
//                    System.out.println(i + " " + b + " " + a);
                    return false;
                }
            }
        }
        return true;
    }
}
