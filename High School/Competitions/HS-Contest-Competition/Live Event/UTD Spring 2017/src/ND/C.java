package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class C {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("C.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            int y = scan.nextInt();
            int x = scan.nextInt();
            scan.nextLine();
//            System.out.println(y + " " + x);
            char ch[][] = new char[y][x];
            for (int ii = 0; ii < y; ii++) {
                ch[ii] = scan.nextLine().toCharArray();
            }
            System.out.println(ch[0][0]);
            printMaxSubSquare(ch, 'o');
        }
    }

    public static void printMaxSubSquare(char ch[][], char p) {
        int i, j;
        int S[][] = new int[ch.length][ch[0].length];
        int max_of_s, max_i, max_j;

        /* Construct other entries of S[][]*/
        for (i = 1; i < ch.length; i++) {
            for (j = 1; j < ch[0].length; j++) {
                if (ch[i][j] == p) {
                    S[i][j] = ((min(S[i][j - 1], S[i - 1][j], S[i - 1][j - 1]) + 1));
                } else {
                    S[i][j] = 0;
                }
            }
        }

        /* Find the maximum entry, and indexes of maximum entry 
     in S[][] */
        max_of_s = S[0][0];
        max_i = 0;
        max_j = 0;
        for (i = 0; i < ch.length; i++) {
            for (j = 0; j < ch[0].length; j++) {
                if (max_of_s < S[i][j]) {
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

//        printf("\n Maximum size sub-matrix is: \n");
        for (i = max_i; i > max_i - max_of_s; i--) {
            for (j = max_j; j > max_j - max_of_s; j--) {
//                System.out.printf("%d ", ch[i][j]);
                System.out.println(S[i][j]);
            }
            System.out.println();
//            printf("\n");
        }
    }

    /* UTILITY FUNCTIONS */
 /* Function to get minimum of three values */
    public static int min(int a, int b, int c) {
        int m = a;
        if (m > b) {
            m = b;
        }
        if (m > c) {
            m = c;
        }
        return m;
    }
}
