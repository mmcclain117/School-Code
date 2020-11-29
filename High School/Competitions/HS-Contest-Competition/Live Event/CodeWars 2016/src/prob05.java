
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

public class prob05 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob05.txt"));
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            String f = scan.nextLine().substring(1);
//	    out.println(f);
            ArrayList<String> ar = new ArrayList<>();
            for (int ii = 0; ii < f.length(); ii++) {
                ar.add(f.substring(ii, ii + 1));
            }
            ar.remove(0);
//	    out.println(f.length()  / x);
            for (int ii = 1; ii < (f.length() / x) + 1; ii++) {

                ar.remove((ii * x) - ii);
            }
            for (int ii = 0; ii < ar.size(); ii++) {
                out.print(ar.get(ii));
            }
            out.println(" " + ar.size());
        }
    }
}
