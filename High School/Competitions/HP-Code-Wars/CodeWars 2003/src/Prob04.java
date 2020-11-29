
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Corperate Name Changer
//        Points: 4
        Scanner scan = new Scanner(new File("prob04.txt"));
        while (scan.hasNext()) {
            String s = scan.nextLine();
            System.out.println(s.replaceAll("WidgetCo", "SuperMegaCorp"));
        }
    }
}
