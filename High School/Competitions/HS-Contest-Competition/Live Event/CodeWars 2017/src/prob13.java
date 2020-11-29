
import java.util.*;
import java.io.*;

public class prob13 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob13-1-in.txt"));
        String b = "";
        while (scan.hasNext()) {
            b = scan.nextLine();
        }
        char ch[][] = new char[281][281];
        int x = 140;
        int y = 140;
        char p[] = b.toCharArray();
        int con = 0;
        int dir = 0;
        System.out.println(Arrays.toString(p));
//	 0 left 1 right 2 up 3 down
        while (con < p.length - 1) {
            if (dir == 0) {
                x += 1;
            } else if (dir == 1) {
                x -= 1;
            } else if (dir == 2) {
                y += 1;
            } else if (dir == 3) {
                y -= 1;
            }
//	    System.out.println(x + " " + y);
            ch[y][x] = p[con];
//            System.out.println(ch[y][x]);
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
            con++;
        }
        String end = "";
        boolean emp = true;
        for (int yy = 0; yy < ch.length; yy++) {
            String temp = "";
            for (int xx = 0; xx < ch[0].length; xx++) {
                temp += ch[yy][xx];
                end += ch[yy][xx];
                if (!emp) {
                    System.out.println(ch[yy][xx] + "");
                }
            }
            if (!"".equals(temp.trim()) && emp) {
                System.out.println(temp);
                end += "\n";
                emp = false;
            }
        }
        System.out.println(end.trim());
    }

}
