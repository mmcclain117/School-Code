
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: Morse Code Palidrome
//        Points: 6
        Scanner scan = new Scanner(new File("prob12.txt"));
        String a = scan.nextLine();
        while (!".".equals(a.trim())) {
            char ch[] = a.toCharArray();
            String fin = "";
            HashMap<String, String> hm = make();
            for (char c : ch) {
                fin += hm.get(c + "");
            }
            System.out.println(a + " is " + (isPal(fin) ? "" : "*not* ") + "a MCP");
            a = scan.nextLine();
        }
    }

    private static HashMap make() {
        HashMap<String, String> hm = new HashMap();
        hm.put("A", "*-");
        hm.put("B", "-***");
        hm.put("C", "-*-*");
        hm.put("D", "-**");
        hm.put("E", "*");
        hm.put("F", "**-*");
        hm.put("G", "--*");
        hm.put("H", "****");
        hm.put("I", "**");
        hm.put("J", "*---");
        hm.put("K", "-*-");
        hm.put("L", "*-**");
        hm.put("M", "--");
        hm.put("N", "-*");
        hm.put("O", "---");
        hm.put("P", "*--*");
        hm.put("Q", "--*-");
        hm.put("R", "*-*");
        hm.put("S", "***");
        hm.put("T", "-");
        hm.put("U", "**-");
        hm.put("V", "***-");
        hm.put("W", "*--");
        hm.put("X", "-**-");
        hm.put("Y", "-*--");
        hm.put("Z", "--**");
        return hm;
    }

    private static boolean isPal(String fin) {
        ArrayList<Character> c = new ArrayList();
        char ch[] = fin.toCharArray();
        for (char y : ch) {
            c.add(y);
        }
        String te = c.toString();
        Collections.reverse(c);
        return c.toString().equals(te);
    }

}
