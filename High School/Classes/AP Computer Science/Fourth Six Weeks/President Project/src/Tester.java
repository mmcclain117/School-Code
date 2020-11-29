
import java.io.File;
import static java.lang.System.out;
import java.util.*;

public class Tester {

    public static void main(String[] args) throws Exception {
        ArrayList<President> pres = new ArrayList<>();
        Scanner scan = new Scanner(new File("US Presidents.csv"));
        scan.nextLine();
        while (scan.hasNext()) {
            String a = scan.nextLine();
            String x[] = a.split("[,]");
            President n = new President(x);
            pres.add(n);
        }
        Collections.shuffle(pres);
        for (President i : pres) {
            out.println(i.toStr());
        }
    }
}
