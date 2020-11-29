package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Not finished */
public class Prob06 {

    /* Have no clue how to do this */
    public static void main(String[] args) throws Exception {
//        Problem: Checking the Sum
//        Points: 5
        Scanner scan = new Scanner(new File("prob06.txt"));
        String grid[][] = new String[16][16];
        for (int i = 0; i < 16; i++) {
            String s = scan.nextLine();
            grid[i] = s.split("[ ]+");
        }
        long sum = 0;
        for (int x = 0; x < 16; x++) {
//            for (int y = 0; y < 4; y++) {
            for (int y = 0; y < 16; y++) {
                sum += Long.parseLong(grid[x][y], 16);
            }
        }
        sum = 0;
        /* Print out the array */
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 16; y++) {
                System.out.print(grid[x][y] + " ");
                sum += Long.parseLong(grid[x][y], 16);
            }
            String tmp = Long.toHexString(sum);
            System.out.println(sum + " " + tmp.substring(tmp.length() - 2));
            sum = Long.parseLong(tmp.substring(tmp.length() - 2), 16);
        }

        /* Testing Test part (Unsigned part is not neccessary)*/
        long qs = Long.parseUnsignedLong("9E", 16);
        qs += Long.parseUnsignedLong("A6", 16);
        qs += Long.parseUnsignedLong("58", 16);
        qs += Long.parseUnsignedLong("80", 16);
        System.out.println(Long.toHexString(qs));

        /* Back to regular Code */
        String unsign = Long.toUnsignedString(sum);
        System.out.println(unsign);
//        System.out.println("UNSIGNED: " + unsign.substring(unsign.length() - 8));
        System.out.println(Long.toHexString(Long.parseLong(twosCompliment(Long.toBinaryString(sum).substring(Long.toBinaryString(sum).length() - 8)))));
        System.out.println("Unsigned sum: " + Long.toHexString(sum));
    }

    public static String twosCompliment(String bin) {
        String twos = "", ones = "";

        for (int i = 0; i < bin.length(); i++) {
            ones += flip(bin.charAt(i));
        }
        int number0 = Integer.parseInt(ones, 2);
        StringBuilder builder = new StringBuilder(ones);
        boolean b = false;
        for (int i = ones.length() - 1; i > 0; i--) {
            if (ones.charAt(i) == '1') {
                builder.setCharAt(i, '0');
            } else {
                builder.setCharAt(i, '1');
                b = true;
                break;
            }
        }
        if (!b) {
            builder.append("1", 0, 7);
        }

        twos = builder.toString();

        return twos;
    }

// Returns '0' for '1' and '1' for '0'
    public static char flip(char c) {
        return (c == '0') ? '1' : '0';
    }
}
