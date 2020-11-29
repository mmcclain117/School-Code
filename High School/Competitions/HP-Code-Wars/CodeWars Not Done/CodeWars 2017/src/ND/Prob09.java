package ND;

import java.util.*;
import java.io.*;

/**
 * @author Master Ward
 */
public class Prob09 {

    /* Get rid of underneath and extra one */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob09.txt"));
        char[][] arr = new char[12][60];
        for (char[] c : arr) {
            Arrays.fill(c, ' ');
        }
        Stack<String> stack = new Stack<>();
        while (scan.hasNextLine()) {
            stack.add(scan.nextLine());
        }

        while (!stack.isEmpty()) {
            scan = new Scanner(stack.pop());
            int x = scan.nextInt(), size = scan.nextInt();

            int start = x - (size - 1), end = x + size;

            for (int y = 11; y >= 0; y--) {
                if (start > 0) {
                    arr[y][start++] = '/';
                }
                if (end > size) {
                    arr[y][end--] = '\\';
                }

                for (int i = start + 1; i < end; i++) {
                    if (i > 0 && i < size) {
                        arr[y][i] = ' ';
                    }
                }

                if (start >= end) {
                    break;
                }
            }
        }

        for (char[] c : arr) {
            String s = new String(c);
            if (s.trim().length() == 0) {
                continue;
            }

            System.out.println(s);
        }

        String s = new String(arr[11]);

        for (int i = 0; i < s.lastIndexOf("\\") / 10 + 1; i++) {
            System.out.print("1234567890");
        }
        System.out.println();
    }

}
