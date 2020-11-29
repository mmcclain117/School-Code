
import java.io.File;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author 180869
 */
public class openSource1 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("open.dat"));
        String a = scan.nextLine();
        String b = scan.nextLine();
        HashMap<String, String> hm = new HashMap();
        HashMap<String, String> hm2 = new HashMap();
        while (!(a.equals("1") && b.equals("0"))) {
            while (!(b.equals(b.toUpperCase()))) {
                hm.put(b, a);
                hm2.put(a, b);
                b = scan.nextLine();
            }
            a = b;
            b = scan.nextLine();
        }
        out.println(hm.size() + "\nValues: " + Arrays.toString(hm.values().toArray()) + "\nKeys: " + Arrays.toString(hm.keySet().toArray()));
        out.println(hm2.size() + "\nValues: " + Arrays.toString(hm2.values().toArray()) + "\nKeys: " + Arrays.toString(hm2.keySet().toArray()));
    }
}
