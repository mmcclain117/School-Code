
import java.io.File;
import java.util.Scanner;


/*
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String args[]) throws Exception {
//        Problem: Serialization
        Scanner scan = new Scanner(new File("prob08.txt"));
        int a = scan.nextInt();
        int b = scan.nextInt();
        while (!(a == 0 && b == 0)) {
            String serial = "";
            int lastNumb = 0;
            for (int i = a; serial.length() + (i + "").length() <= b; i++) {
                lastNumb = serial.length();
                serial += i;
            }
            String result = serial.substring(lastNumb);
            if (result.equals("")) {
                result = "0";
            }
            System.out.println(a + " " + b + " " + result);
            a = scan.nextInt();
            b = scan.nextInt();
        }
    }
}
