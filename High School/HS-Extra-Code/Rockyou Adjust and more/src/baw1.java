
import java.io.File;
import java.util.Scanner;

public class baw1 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("chall.txt"));
        boolean white = true;
        String ss = "";
        int con = 0;
        while (scan.hasNext()) {
            String st = scan.nextLine();
            con++;
//            String[] st = scan.nextLine().split("cyber");
            int fin = 0;
//            for (int x = 0; x < st.length; x++) {
            char ch[] = (st.trim() + "").toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (!Character.isAlphabetic(ch[i])) {
                    white = !white;
                }
                if (white) {
                    ss += "1";
                    System.out.print("*");
                } else {
                    ss += "0";
                    System.out.print(".");
                }
//                }
                fin += ch.length;
            }
            System.out.print(" " + fin);
            System.out.println();

        }
        System.out.println(ss.length());
        System.out.println(con);
        int p = 0;
        while (p < ss.length()) {
            if (p % 16 == 0) {
                System.out.println();
            }
            System.out.print((ss.charAt(p) == '1' ? "*" : "."));
            p++;
        }
    }
}
