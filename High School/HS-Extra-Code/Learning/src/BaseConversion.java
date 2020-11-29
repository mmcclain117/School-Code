
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class BaseConversion {

    public static void main(String[] args) {
        int i = 192;
        String qq = "192";
        out.println(DectoBin(qq));
        String a = Integer.toBinaryString(i);
        String b = Integer.toHexString(i);
        String c = Integer.toOctalString(i);
        String d = Integer.toString(11000000);
        out.println(i);
        out.println(a);
        out.println(b);
        out.println(c);
        out.println(d);
    }

    public static String DectoBin(String a) {
        Integer i = Integer.parseInt(a);
        String fin = "";
        if (i == 1) {
            return "1";
        } else {
            int top = 2;
            int con = 1;
            while (top < i) {
                top *= 2;
                con++;
            }
            out.println(top);
            top /= 2;
            while (con > 0) {
                if (i >= top) {
                    fin += "1";
                    i -= top;
                } else {
                    fin += "0";
                }
                top /= 2;
                con--;
            }
        }
        return fin;
    }

}
