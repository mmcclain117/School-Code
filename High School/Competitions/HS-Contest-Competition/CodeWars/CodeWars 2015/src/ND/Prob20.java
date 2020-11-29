package ND;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob20 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob20.txt"));
        String inputting = scan.nextLine();
        String tot = inputting;
        while (inputting.contains(")") || inputting.contains("(")) {
            inputting = scan.nextLine();
            tot += inputting;
        }
        System.out.println(tot);
        String tmp = inputting;
        System.out.println(tmp);
        while (tmp.charAt(0) != '.') {
            System.out.println(tmp.replaceAll("[.]", " & "));
            String split[] = tmp.split("[.]+");
            System.out.println(Arrays.toString(split));
            String q = tot.substring(tot.indexOf(split[0]));
            q = q.substring(tot.indexOf(split[1]));
            System.out.println(q);
//            System.out.println(q.split("//s+")[1]);
            tmp = scan.nextLine();
        }
    }
}
