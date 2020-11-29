package ND;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* First one is wrong  NEEDS tO BE FIXED */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Musical Intervals
        Scanner scan = new Scanner(new File("prob09.txt"));
        String a = scan.nextLine();
        String b[] = a.split("[+-]");
        String c[] = a.split("[^+-]+");
        String d[] = {"F", "F#", "G", "G#", "A", "A#", "B", "B2", "C", "C#", "D", "D#", "E", "E2", "F", "F#", "G", "G#", "A", "A#", "B", "B2"};
        int point = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i].equals(b[0])) {
                point = i;
                break;
            }
        }
        point += d.length * b.length;
        for (int i = 0; i < b.length; i++) {
            if ("-".equals(c[i])) {
                point -= Integer.parseInt(b[i]);
            } else if ("+".equals(c[i])) {
                point += Integer.parseInt(b[i]);
            }
            if (i < b.length - 1) {
                System.out.print(d[point % d.length] + " ");
            } else {
                System.out.print(d[point % d.length]);
            }
//            System.out.println(b[i]+ " "+c[i]);
        }
        System.out.println();
//        for (int i = 0; i < c.length; i++) {
//            System.out.println(c[i]);
//        }
    }

}
