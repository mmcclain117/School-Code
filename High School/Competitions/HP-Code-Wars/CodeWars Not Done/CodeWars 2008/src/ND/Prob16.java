package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob16 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob16.txt"));
        String a = scan.nextLine();
        while (!a.contains("END")) {
            int b = a.indexOf("=");
            String c = a.substring(b);

            a = scan.nextLine();
        }
    }

}
