
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Alexey {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Alexey.dat"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b[] = a.split("\\s+");
            if (b.length == 2) { // Not
                String c = Integer.toBinaryString(Integer.parseInt(b[1]));
                String fin = "";
                for (int i = 0; i < c.length(); i++) {
                    if (c.charAt(i) == '1') {
                        fin += "0";
                    } else {
                        fin += "1";
                    }
                }
                System.out.println(Integer.parseInt(fin, 2));
            } else if (b[0].equals("LS")) { // Left Shift
                int d1 = Integer.parseInt(b[1]); // Shift 
                int d2 = Integer.parseInt(b[2]); // Number
                System.out.println(d2 << d1);
            } else if (b[0].equals("RS")) { // Right Shift
                int d1 = Integer.parseInt(b[1]); // Shift 
                int d2 = Integer.parseInt(b[2]); // Number
                System.out.println(d2 >> d1);
            } else if (b[0].equals("LC")) { // Left Circle
                int d1 = Integer.parseInt(b[1]); // Shift 
                int d2 = Integer.parseInt(b[2]); // Number
                String binary = Integer.toBinaryString(d2);
//				String end = binary.substring(binary.length() - d1 - 1, binary.length()) + binary.substring(0, d1) ;
//				System.out.println("LC: "+end);
                System.out.println(Integer.parseInt(binary.substring(binary.length() - d1 - 1, binary.length()) + binary.substring(0, d1), 2));
            } else if (b[0].equals("RC")) { // Right Circle
                int d1 = Integer.parseInt(b[1]); // Shift 
                int d2 = Integer.parseInt(b[2]); // Number
                String binary = Integer.toBinaryString(d2);
                System.out.println(Integer.parseInt(binary.substring(d1 + 1, binary.length()) + binary.substring(0, d1 + 1), 2));
            } else if (b[0].equals("A")) { // And
                int d1 = Integer.parseInt(b[1]); // Number 
                int d2 = Integer.parseInt(b[2]); // Number
                System.out.println(d1 & d2);
            } else if (b[0].equals("O")) { // Or
                int d1 = Integer.parseInt(b[1]); // Number 
                int d2 = Integer.parseInt(b[2]); // Number
                System.out.println(d1 | d2);
            } else if (b[0].equals("X")) { // Xor
                int d1 = Integer.parseInt(b[1]); // Number 
                int d2 = Integer.parseInt(b[2]); // Number
                System.out.println(d1 ^ d2);
            }
        }
    }
}
