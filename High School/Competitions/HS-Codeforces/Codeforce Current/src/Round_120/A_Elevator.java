package Round_120;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class A_Elevator {

    /**
     * Tags: Brute Force, Implementation, Math
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("input.txt"));
        FileWriter fw = new FileWriter(new File("output.txt"));
        String a = scan.nextLine();
        int b = scan.nextInt();
        scan.close();
        if (a.equals("front")) {
            if (b == 1) {
//                System.out.println("L");
                fw.write("L");
            } else {
//                System.out.println("R");
                fw.write("R");
            }
        } else if (b == 1) {
            fw.write("R");
//            System.out.println("R");
        } else {
            fw.write("L");
//            System.out.println("L");
        }
        fw.flush();
        fw.close();
    }
}
