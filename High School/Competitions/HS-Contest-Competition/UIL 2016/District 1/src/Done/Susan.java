package Done;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class Susan {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("susan.dat"));
//        scan.nextLine();
        while (scan.hasNext()) {
            String a = scan.nextLine();
            int b = a.indexOf("[");
            int c = a.indexOf("]");
//            System.out.println(a.substring(b));
//            System.out.println(a.substring(b + 1, c));
            Regex r = new Regex(a.substring(b + 1, c));
//            Pattern p = new Pattern(a.substring(b + 1, c), 0x0);
            String d[] = a.split(a.substring(b + 1, c));
            String s = a;
//            char ch[] = new char[10];
            boolean con = false;
            if (a.substring(b + 1, c).contains("+")) {
                con = true;
                c--;
            }
            char ch[] = a.substring(b + 1, c).toCharArray();
            for (int i = 0; i < ch.length; i++) {
                s = s.replaceAll(ch[i] + "", "%");
            }
            String sp = "%";
            if (con) {
                sp += "+";
            }
            String[] e = s.split("%");
//            System.out.println(Arrays.toString(e));
//            System.out.println(Arrays.toString(d));
            if (con) {
                c++;
            }
//            System.out.println(Integer.parseInt(a.substring(c + 2)));
            System.out.println(e[Integer.parseInt(a.substring(c + 2))]);
        }
    }

}
