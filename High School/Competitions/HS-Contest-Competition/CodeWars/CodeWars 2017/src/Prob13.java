
import java.util.*;
import java.io.*;

/**
 * @author Master Ward
 */
public class Prob13 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("DataSet\\prob13-1-in.txt"));
        String b = "";
        while (scan.hasNext()) {
            b = scan.nextLine();
        }
        char ch[][] = new char[281][281];
        int x = 140;
        int y = 140;
        char p[] = b.toCharArray();
//        System.out.println(b);
        int con = 0;
        int dir = 0;
        if ("URLDurld".contains(p[con] + "")) {
            if (p[con] == 'u' || p[con] == 'U') {
                dir = 2;
            } else if (p[con] == 'd' || p[con] == 'D') {
                dir = 3;
            } else if (p[con] == 'l' || p[con] == 'L') {
                dir = 0;
            } else if (p[con] == 'r' || p[con] == 'R') {
                dir = 1;
            }
        } else {
            dir = 1;
        }
//        System.out.println(Arrays.toString(p));
//	 0 left 1 right 2 up 3 down
        ArrayList<Integer> ax = new ArrayList();
        ArrayList<Integer> ay = new ArrayList();
        while (con < p.length) {
            if (dir == 0) {
                x -= 1;
            } else if (dir == 1) {
                x += 1;
            } else if (dir == 2) {
                y -= 1;
            } else if (dir == 3) {
                y += 1;
            }
//	    System.out.println(x + " " + y);
            ch[y][x] = p[con];
            ay.add(y);
            ax.add(x);
//	    System.out.println(p[con]);
            if (p[con] == 'u' || p[con] == 'U') {
                dir = 2;
            } else if (p[con] == 'd' || p[con] == 'D') {
                dir = 3;
            } else if (p[con] == 'l' || p[con] == 'L') {
                dir = 0;
            } else if (p[con] == 'r' || p[con] == 'R') {
                dir = 1;
            }
//            System.out.println(x + " " + y);
//            System.out.println(ch[y][x] + " "+ dir);
            con++;
        }
        String end = "";
        for (int yy = Collections.min(ay); yy < Collections.max(ay) + 1; yy++) {
            for (int xx = Collections.min(ax); xx < Collections.max(ax) + 1; xx++) {
                end += ch[yy][xx];
                if (Character.isLetterOrDigit(ch[yy][xx]) || ("?!,\'\"".contains(ch[yy][xx] + ""))) {
                    System.out.print(ch[yy][xx]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            end = end.trim();
            end += "\n";
        }
//        for (int i = 0; i < ar.size() / 2; i++) {
//            end += ch[ar.remove(0)][ar.remove(0)];
//        }
//        System.out.println(end.trim());
//        System.out.println(end);
    }

}
