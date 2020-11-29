
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Ralph {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Ralph.dat"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            ArrayList<String> arr = performPerm(a);
            int max = -1;
            for (String b : arr) {
                int cur = Integer.parseInt(b);
                if (cur <= 32767) {
                    if (cur > max) {
                        max = cur;
                    }
                }
            }
            if (max == -1) {
                System.out.println("EXCEEDS MAX VALUE");
            } else {
                System.out.println(max);
            }
        }
    }

    public static ArrayList<String> performPerm(String s) {
        ArrayList<String> AL = new ArrayList<>();
        if (s == null) {
            return null;
        } else if (s.length() == 0) {
            AL.add("");
            return AL;
        } else {
            for (int i = 0; i < s.length(); i++) {
                ArrayList<String> remain = performPerm(s.substring(0, i) + s.substring(i + 1));
                for (int j = 0; j < remain.size(); j++) {
                    AL.add(s.charAt(i) + remain.get(j));
                }
            }
            return AL;
        }
    }
}
