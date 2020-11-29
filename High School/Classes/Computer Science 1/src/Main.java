
import java.io.File;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("input.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        String fil[] = new String[a];
        ArrayList ar = new ArrayList();
        ArrayList as = new ArrayList();
        String sameTwo[] = new String[a / 2];
        int same = 0;
        for (int b = 0; b < a; b++) {
            String name = scan.nextLine();
            Scanner in = new Scanner(new File(name));
            in.useDelimiter("[ ]");
            while (in.hasNext()) {
                out.println(name);
                name += in.next();
            }
            fil[b] = name;
            in.close();
        }
        Arrays.sort(fil);
        int start = 0;
        for (int i = 0; i < fil[i].length() - 2; i++) {
            char ch[] = fil[i].toCharArray();
            for (int n = start; n < fil.length - 1; n++) {
                char ty[] = fil[n].toCharArray();
                for (int t = 0; t < ty.length; t++) {
                    if (t >= 400) {
                        ar.add(fil[i]);
                        as.add(fil[n]);
                        break;
                    }
                    if (ch[t] == ty[t]) {
                        ar.add(fil[i]);
                        as.add(fil[n]);
                    } else {
                        break;
                    }
                }
            }
            start++;
        }
        out.println(ar.size());
        for (int i = 0; i < ar.size(); i++) {
            String at = (String) ar.get(i);
            String ast = (String) as.get(i);
            out.println(at + " " + ast);
        }
    }
}
