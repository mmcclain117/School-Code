package ND;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: Decode This!
//        Points: 6
        Scanner scan = new Scanner(new File("prob10.txt"));
        int a = scan.nextInt();
        while (a != 0) {
            String b = scan.nextLine();
            String fin = "";
            char fins[] = new char[a]; // Empty Ending array
            char ch[] = b.toCharArray();
            int con = 0;
//            After this point there are problems
            for (int i = 0; i < a; i++) {
                char cp = ch[i];
                fin += cp;
                fins[con % a] = cp;
                System.out.println(fin);
                if (Character.isAlphabetic(cp)) {
                    if (Character.isUpperCase(cp)) {
                        con += cp - 'A' + 1;
                    } else {
                        con += cp - 'a' + 1;
                    }
                }
//                con++;
            }
            System.out.println(fin);
            System.out.println(Arrays.toString(fins));
            a = scan.nextInt();
        }
    }

}
