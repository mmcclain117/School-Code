
/**
 *
 * @author Master
 */
public class NameCelebr { // Chapter 5 Mine

    public static void main(String[] args) {
        String s1 = "Allan Alda";
        String s2 = "John Wayne";
        String s3 = "Jacob Ward";
        int a1 = s1.length();
        int a2 = s2.length();
        int a3 = s3.length();
        System.out.println(s1 + ">>>" + s1.substring(2, a1 - 3));
        System.out.println(s2 + ">>>" + s2.substring(2, a2 - 3));
        System.out.println(s3 + ">>>" + s3.substring(2, a3 - 3));
    }
}
