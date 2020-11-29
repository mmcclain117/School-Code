
import java.io.FileWriter;

/**
 *
 * @author Master
 */
public class Palindromes {

    public static void main(String[] args) throws Exception {
        Write();
        Palindrome_Tester tester = new Palindrome_Tester();
        System.out.println("radar is a palindrome? "
                + tester.ptest("sradars"));
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("palindrome.dat");
        fw.write("3\n"
                + "Madam, I’m Adam.\n"
                + "1234.4321\n"
                + "Mississippi Burning");
        fw.flush();
        fw.close();

    }  // class Palindromes
}

class Palindrome_Tester {

    //===========================================================
    //  Uses recursion to perform the palindrome test.
    //===========================================================
    public boolean ptest(String str) {

        boolean result = false;

        if (str.length() <= 1) {
            result = true;
        } else {
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                result = ptest(str.substring(1, str.length() - 1));
            }
        }
        return result;
    }  // method ptest

}  // class Palindrome_Tester
