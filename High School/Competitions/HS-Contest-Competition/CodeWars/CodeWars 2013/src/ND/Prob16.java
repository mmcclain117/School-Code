package ND;

import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob16 {

    public static void main(String[] args) throws Exception {
//        Problem: Family Tree
//        Points: 11
        Scanner scan = new Scanner(new File("prob16.txt"));
        /* Scan in all the information */
        int n = scan.nextInt(); // Number of Parent-Child
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            String par = s.substring(0, s.indexOf(":") - 1); // Parent
            String chi = s.substring(s.indexOf(":") + 2); // Children
            System.out.println(par);
            System.out.println(chi);
        }
        int e = scan.nextInt(); // Next Expressions
        for (int i = 0; i < e; i++) {
            String s = scan.nextLine();
            String split[] = s.split("[ ]+");
        }
    }
}
