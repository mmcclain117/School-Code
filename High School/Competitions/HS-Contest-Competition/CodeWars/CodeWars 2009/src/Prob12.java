
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob12.txt"));
        String a = scan.nextLine();
        String fin = "";
        while (!"###".equals(a.trim())) {
            fin += a.toUpperCase() + " ";
            a = scan.nextLine();
        }
        String fina = fin.replaceAll("[^A-Z']+", " ");
        String b[] = fina.split("\\s+");
        Map<String, Integer> hs = new TreeMap();
        for (int i = 0; i < b.length; i++) {
            if (hs.containsKey(b[i])) {
                hs.put(b[i], hs.get(b[i]) + 1);
            } else {
                hs.put(b[i], 1);
            }
        }
        Object c[] = hs.values().toArray();
        Arrays.sort(c);
        int min = (int) (c[c.length - 6]);
        for (int i = 0; i < b.length; i++) {
            if (hs.containsKey(b[i])) {
                if (hs.get(b[i]) < min) {
                    hs.remove(b[i]);
                }
            }
        }
        Set<String> hm = hs.keySet();
        Collection<Integer> hq = hs.values();
        /* Go through and print it out */
        for (int con = 0; con < 5; con++) {
            int max = 0; // Maximum Value
            String nam = ""; // Maximum WOrd
            Iterator it = hm.iterator(); // Words\Keys
            Iterator it2 = hq.iterator(); // Values
            for (int i = 0; i < hs.size(); i++) {
                int tmp = Integer.parseInt(it2.next().toString());
                String tmpW = it.next().toString(); // Temperary Word
                if (tmp > max) {
                    max = tmp;
                    nam = tmpW;
                }
            }
            hm.remove(nam); // Take out max
            /* Print out the astriks */
            for (int i = 0; i < max; i++) {
                System.out.print("*");
            }
            System.out.println(" #" + (con + 1) + ": " + nam + " - " + max);
//            System.out.println(max + " " + nam);
        }
    }
}
