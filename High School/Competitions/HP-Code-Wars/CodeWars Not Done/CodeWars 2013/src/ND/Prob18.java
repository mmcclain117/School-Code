package ND;

import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob18 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob18.txt"));
        int n = scan.nextInt(); // Number of rows to Scramble
        int t = scan.nextInt(); // Number of lines
        scan.nextLine();
        String phrase = ""; // Final version of phrase
        for (int i = 0; i < t; i++) {
            phrase += scan.nextLine().toUpperCase().replaceAll("[^A-Z]+", "");
        }
        int q = scan.nextInt(); // Number of words looking for
        for (int i = 0; i < q; i++) {
            String word = scan.next();
            System.out.println(word);
        }
        System.out.println(phrase);
    }

}
