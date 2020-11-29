
import java.io.File;
import java.util.Scanner;

public class prob03 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob03.txt"));

        int amt = scan.nextInt();
        while (amt-- > 0) {
            String obj = scan.next();
            if (hasDoubleLetters(obj)) {
                System.out.println("likes " + obj);
            } else {
                System.out.println("hates " + obj);
            }
        }
    }

    public static boolean hasDoubleLetters(String s) {
        char oldChar = '0';
        for (char c : s.toCharArray()) {
            if (oldChar == c) {
                return true;
            }
            oldChar = c;
        }
        return false;
    }
}
