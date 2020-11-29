
/**
 *
 * @author Master
 */
public class ParseI {

    public static void main(String[] args) {
        String x = "23";
        String y = x.substring(0, x.length() - 1);
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a + b);
    }
}
