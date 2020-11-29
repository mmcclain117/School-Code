
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob09.txt"));
        String let = scan.nextLine(); // List of letters
        ArrayList<String> dict = new ArrayList(); // List of words
        /* Read in the dictionary */
        while (scan.hasNext()) {
            String s = scan.nextLine();
            if (s.equals(".")) {
                break;
            } else {
                dict.add(s);
            }
        }
        int con = 0;
        while (con < dict.size()) {
            if (!rem(let, dict.get(con))) {
                dict.remove(con);
            } else {
                con++;
            }
        }
        if (dict.size() == 3) {
            String line = "";
            for (int i = 0; i < dict.size(); i++) {
                line += dict.get(i) + " ";
            }
            System.out.println(line.trim());
        }
//        System.out.println(dict.size());
    }

    /* Removes the letters and see's if all of them are there */
    private static boolean rem(String let, String get) {
        char ch[] = let.toCharArray();
        for (int i = 0; i < get.length(); i++) {
            boolean c = false; // Contians
            for (int o = 0; o < ch.length; o++) {
                if (!c && ch[o] == get.charAt(i)) {
                    c = true;
                    ch[o] = '@'; // Marks differently
                }
            }
            if (!c) { // Doesn't contain the letter
                return false;
            }
        }
        return true;
    }

}
