package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob11.txt"));
        String s = scan.nextLine();
        while (!s.equals("END")) {

            s = scan.nextLine();
        }
    }
}