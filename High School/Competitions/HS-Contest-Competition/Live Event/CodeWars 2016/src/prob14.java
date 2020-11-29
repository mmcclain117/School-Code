
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

public class prob14 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob14-1-in.txt"));
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String encr = scan.nextLine();
            ArrayList<String> s = new ArrayList<>();

            String de = encr.substring(0, 1);
            out.println(de);
        }
        out.println((char) 65);
    }

}
