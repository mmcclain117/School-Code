
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Kyle Fromm
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob10.txt"));
        int values = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < values; i++) {
            int begining = 0;
            int end = 0;
            String palindrome = "";
            int size = 0;
            String line = scan.nextLine();
            boolean found = false;
            for (int j = 0; j < line.length(); j++) {
                for (int h = line.length(); h > j; h--) {
                    String temp = line.substring(j, h);
                    temp = temp.replaceAll("[^a-zA-Z0-9]", "");
//					 System.out.println(temp);
                    ArrayList<Character> a = new ArrayList<>();
                    for (int d = 0; d < temp.length(); d++) {
                        a.add(temp.charAt(d));
                    }
                    Collections.reverse(a);
                    String s = "";
                    for (int u = 0; u < a.size(); u++) {
                        s += a.get(u);
                    }
                    // System.out.println(s);
                    if (s.equalsIgnoreCase(temp)) {
                        if (s.length() > size) {
                            begining = j;
                            end = h;
                            size = s.length();
                        }
                    }
                }
            }
            if (size == 1) {
                System.out.println("NO PALINDROME");
            } else {
                System.out.println(line.substring(begining, end - 1));
            }
        }
    }
}
