
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob14 {

    public static void main(String[] args) throws Exception {
//        Problem: Assembler
//        Points: 13
        Scanner scan = new Scanner(new File("prob14.txt"));
        String s = scan.nextLine();
        int value[] = new int[4]; // Values of AX, BX, CX, DX
        while (!(s.equals("HLT"))) {
            String q[] = s.split("[ ]+");// Command, Values
            if (q[0].equals("SHOW")) { // Printing
                if (q[1].equals("AX")) {
                    System.out.println(value[0]);
                } else if (q[1].equals("BX")) {
                    System.out.println(value[1]);
                } else if (q[1].equals("CX")) {
                    System.out.println(value[2]);
                } else if (q[1].equals("DX")) {
                    System.out.println(value[3]);
                }
            } else {
                String tmp[] = q[1].split("[,]+"); // V1,V2
                int ir1 = -1; // Index of value 1
                /* Get Index of Value 1 */
                if (tmp[0].equals("AX")) {
                    ir1 = 0;
                } else if (tmp[0].equals("BX")) {
                    ir1 = 1;
                } else if (tmp[0].equals("CX")) {
                    ir1 = 2;
                } else if (tmp[0].equals("DX")) {
                    ir1 = 3;
                }
                /* Get Index of Value 2 */
                int ir2 = -1; // Index of value 2
                if (tmp[1].equals("AX")) {
                    ir2 = 0;
                } else if (tmp[1].equals("BX")) {
                    ir2 = 1;
                } else if (tmp[1].equals("CX")) {
                    ir2 = 2;
                } else if (tmp[1].equals("DX")) {
                    ir2 = 3;
                }
                boolean as = ir2 != -1; // If it assigns
                if (q[0].equals("MOV")) { // Reassigning
                    if (as) {
                        value[ir1] = value[ir2];
                    } else {
                        value[ir1] = Integer.parseInt(tmp[1]);
                    }
                } else if (q[0].equals("ADD")) { // Adding
                    if (as) {
                        value[ir1] += value[ir2];
                    } else {
                        value[ir1] += Integer.parseInt(tmp[1]);
                    }
                } else if (q[0].equals("SUB")) { // Subtracting
                    if (as) {
                        value[ir1] -= value[ir2];
                    } else {
                        value[ir1] -= Integer.parseInt(tmp[1]);
                    }
                }
            }
            s = scan.nextLine();
        }
    }
}
