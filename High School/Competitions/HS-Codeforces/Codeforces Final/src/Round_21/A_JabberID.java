package Round_21;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A_JabberID {

    /**
     * Tags: Implementation
     *
     * @param args
     */
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        int at = a.indexOf("@");
        boolean ua = at > 0;
        if (ua) {
            String use = a.substring(0, at); // Username
            int sl = a.indexOf("/", at);
//        out.println(sl);
            boolean resour = sl > 0; // Resources are there
            boolean fin = true;
            String hos = ""; // Hostname
            String res = ""; // Resources
            if (resour) {
                hos = a.substring(at + 1, sl);
//            hos = a.substring(at + 1, sl).replaceAll("[.]+", "");
                res = a.substring(sl + 1);
                if (res.isEmpty()) {
                    fin = false;
                }
            } else {
                hos = a.substring(at + 1);
            }
            if (use.isEmpty()) {
                fin = false;
            } else if (hos.isEmpty()) {
                fin = false;
            }

//        out.println(res);
//        out.println(use);
            if (fin) {
                char ch[] = use.toCharArray();
                for (int i = 0; i < ch.length; i++) { // Check username
                    if (fin) {
                        if (!(Character.isLetterOrDigit(ch[i]) || ch[i] == '_')) {
                            fin = false;
                        }
                    }
                }
            }
            if (fin) {
                char ch[] = hos.toCharArray();
                for (int i = 0; i < ch.length; i++) { // Check hostname
                    if (fin) {
                        if (!(Character.isLetterOrDigit(ch[i]) || ch[i] == '_' || ch[i] == '.')) {
//                    if (!(Character.isLetterOrDigit(ch1[i]) || ch1[i] == '_') || ((ch1[i] + "").equals("\\."))) {
//                        out.println(ch1[i]);
                            fin = false;
                        }
                    }
                }
                if (ch[ch.length - 1] == '.' || hos.contains("..") || ch[0] == '.') {
                    fin = false;
                }
            }
//        out.println(fin);
//            out.println(res);
            if (fin && resour) {
                char ch[] = res.toCharArray();
                for (int i = 0; i < ch.length; i++) { // Check Resources
                    if (fin) {
                        if (!(Character.isLetterOrDigit(ch[i]) || ch[i] == '_')) {
                            fin = false;
                        }
                    }
                }
            }
            String finish = fin ? "YES" : "NO";
            out.println(finish);
        } else {
            out.println("NO");
        }
    }
}
