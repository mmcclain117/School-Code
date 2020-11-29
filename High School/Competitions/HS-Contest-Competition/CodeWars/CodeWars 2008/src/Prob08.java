
import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob08.txt"));
        TreeMap<String, String> tm = new TreeMap();
        scan.nextLine();
        String a = scan.nextLine();
        while (!a.equals("[1337]")) {
            int s = a.indexOf(":"); // Spliting point
            String sta = a.substring(0, s); // Starting word
            String trans = a.substring(s + 1);// Translating word
            tm.put(sta, trans);
            a = scan.nextLine();
        }
        String b = scan.nextLine();
        String fin = "";
        while (!b.equals("[3ND]")) {
            fin = b;
            String ff = "";
            String p[] = fin.split("\\s+");
            for (int i = 0; i < p.length; i++) {
                String string = p[i];
                String te = tm.get(string);
                if (te == null) {
//                    System.out.print(string + " "); // Created Extra Spaces
                    ff += string + " ";
                } else {
//                    System.out.print(te+ " "); // Created Extra Spaces
                    ff += te + " ";
                }
//            System.out.println(tm.get(string));
            }
            System.out.println(ff.trim());
            b = scan.nextLine();
        }
    }
}