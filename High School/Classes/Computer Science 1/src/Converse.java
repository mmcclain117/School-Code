
/**
 *
 * @author Master
 */
public class Converse {

    public static void main(String args[]) throws Exception {
        String t = "	";
        System.out.println("Decimal" + t + "Binary" + t + "Octal" + t + "Hex" + t + "Charecter");
        for (int j = 65; j <= 90; j++) {
            System.out.print(j + t + t);
            System.out.print(Integer.toBinaryString(j));
            System.out.print(t);
            System.out.print(Integer.toOctalString(j));
            System.out.print(t + t);
            System.out.print(Integer.toHexString(j));
            System.out.print(t);
            System.out.print((char) j + t);
            System.out.println(" ");
        }
    }
}
