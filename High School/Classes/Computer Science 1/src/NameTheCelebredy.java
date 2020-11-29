
/**
 *
 * @author Master
 */
public class NameTheCelebredy {

    public static void main(String args[]) {
        String s1 = "Allan Alda";
        String s2 = "John Wayne";
        String s3 = "Gregory Peck";
        int s1length = s1.length();
        int s2length = s2.length();
        int s3length = s3.length();
        String subs1 = s1.substring(2, s1length - 3);
        String subs2 = s2.substring(2, s2length - 3);
        String subs3 = s3.substring(2, s3length - 3);
        System.out.println(s1 + " >>> " + subs1);
        System.out.println(s2 + " >>> " + subs2);
        System.out.println(s3 + " >>> " + subs3);
    }
}
