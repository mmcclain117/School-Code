package Assigned;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class LCDisplay {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        int s = scan.nextInt();
//        int n = scan.nextInt();
        int s = 2;
        int n = 8; // 0 , 1 , 3 , 7
        while (!(s == 0 && n == 0)) {
//            char gr[][] = new char[s + 2][2 * s + 3];
            char gr[][] = new char[s + 4][2 * s + 4];
            String te = n + "";
            char p[] = te.toCharArray();
            int row = 0;
            for (int i = 0; i < p.length; i++) {
                switch (Integer.parseInt(p[i] + "")) {
                    case 0:
                        gr = ones(gr, s);
                        for (int l = 1; l < s + 1; l++) {
                            gr[l + 1][0] = '-'; // Top row
                            gr[l + 1][s * 2 + 2] = '-'; // bottom row
                            gr[0][l] = '|'; //First one 
                            gr[0][l + s] = '|'; // Second row
                        }
                        break;
                    case 1:
                        gr = ones(gr, s);
                        break;
                    case 2:
                        gr = Rows(gr, s);
                        for (int l = 0; l < s + 1; l++) {
                            gr[l][s + 1] = '|'; // End line
                            gr[0][s + l + 1] = '|'; // Front line
                        }
                        break;
                    case 3:
                        gr = ones(gr, s);
                        gr = Rows(gr, s);
                        break;
                    case 4:
                        gr = ones(gr, s);
                        for (int l = 0; l < s + 1; l++) {
                            gr[l][s + 1] = '-'; // Middle Row
                            gr[0][l] = '|'; // 1st drop
                        }
                        break;
                    case 5:
                        gr = Rows(gr, s);
                        for (int l = 0; l < s + 1; l++) {
                            gr[l][0] = '|';
                            gr[s + l][s + 1] = '|';
                        }
                        break;
                    case 6:
                        gr = Rows(gr, s);
                        for (int l = 0; l < s + 1; l++) {
                            gr[0][l] = '|'; // First one
                            gr[0][s + 1] = '|'; // Second Bottom
                            gr[s + 2][s + 1] = '|'; // Last One
                        }
                        break;
                    case 7:
                        gr = ones(gr, s);
                        for (int l = 0; l < s; l++) {
                            gr[l][0] = '-'; // First row
                        }
                        break;
                    case 8:
                        gr = ones(gr, s);
                        gr = Rows(gr, s);
                        for (int l = 1; l < s + 1; l++) {
                            gr[0][l] = '|'; // First of line
                            gr[0][s + l + 1] = '|'; // Bottom of line
                        }
                        break;
                    case 9:
                        gr = ones(gr, s);
                        for (int l = 0; l < s + 1; l++) {
                            gr[0][l] = '-'; // First row
                            gr[s][l] = '-'; // Second Row
                        }
                        break;
                    default:
                        out.println("it is broken");
                        out.println(Integer.parseInt(p[i] + ""));
                        break;
                }
            }
            for (int i = 0; i < gr[0].length - 1; i++) {
                for (int o = 0; o < gr.length - 1; o++) {
//                    if(gr[o][i] == null) {
//                }else {
                    out.print(gr[o][i]);
                    out.println(gr[o][i]);
                    out.print(gr[o][i] + "");
//                }
                }
                out.println();
            }
            s = scan.nextInt();
            n = scan.nextInt();
        }
    }

    public static char[][] Rows(char x[][], int s) {
        for (int i = 1; i < s + 1; i++) {
            x[i][0] = '-';
            x[i][s + 1] = '-';
            x[i][s * 2 + 2] = '-';
        }
        return x;
    }

    public static char[][] ones(char x[][], int s) {
        for (int i = 1; i < s + 1; i++) {
            x[s + 1][i] = '|';
            x[s + 1][s + i + 1] = '|';
        }
        return x;
    }
}
