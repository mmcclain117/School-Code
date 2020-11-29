
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Neelam {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Neelam.dat"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            System.out.println(a);
            String l1 = "";
            String l2 = "";
            String fin = "";
            for (int i = 0; i < a.length(); i++) {
                int cur = Integer.parseInt(a.charAt(i) + "");
                if (cur >= 5) {
                    fin += cur - 5;
                    l1 += "|";
                    l2 += "o";
                } else {
                    fin += cur;
                    l1 += "o";
                    l2 += "|";
                }
            }
            System.out.println(l1);
            System.out.println(l2);
            for (int i = 0; i < a.length(); i++) { // Seperator
                System.out.print("=");
            }
            System.out.println();
//			Bottom Lines
            String b1 = "";
            String b2 = "";
            String b3 = "";
            String b4 = "";
            String b5 = "";
            for (int i = 0; i < fin.length(); i++) {
                int cur = Integer.parseInt(fin.charAt(i) + "");
                if (cur == 0) {
                    b1 += "|";
                    b2 += "o";
                    b3 += "o";
                    b4 += "o";
                    b5 += "o";
                } else if (cur == 1) {
                    b1 += "o";
                    b2 += "|";
                    b3 += "o";
                    b4 += "o";
                    b5 += "o";
                } else if (cur == 2) {
                    b1 += "o";
                    b2 += "o";
                    b3 += "|";
                    b4 += "o";
                    b5 += "o";
                } else if (cur == 3) {
                    b1 += "o";
                    b2 += "o";
                    b3 += "o";
                    b4 += "|";
                    b5 += "o";
                } else if (cur == 4) {
                    b1 += "o";
                    b2 += "o";
                    b3 += "o";
                    b4 += "o";
                    b5 += "|";
                }
            }
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);
            System.out.println(b4);
            System.out.println(b5);
            System.out.println();
        }
    }
}
