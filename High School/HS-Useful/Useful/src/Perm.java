
import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class Perm {

    public ArrayList<String> performPerm(String s) {
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

    public static void main(String[] args) {
        Perm p = new Perm();
        ArrayList<String> arr = p.performPerm("abcde");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
