
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob13 {

    private static int hits = 0;
    private static int misses = 0;
    private static LinkedList cache = new LinkedList();

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob13.txt"));
        String b[] = new String[100];
        String c = "";
        for (int i = 0; i < 5; i++) {
            c += scan.nextLine() + " ";
            b = c.split("\\s+");
            for (int ii = 0; ii < b.length; ii++) {
                getPage(Integer.parseInt(b[ii]));
            }
            System.out.println(toStr());
            hits = 0;
            misses = 0;
            cache.clear();
        }
    }

    public static void getPage(int page) {
        // It's in the cache
        Iterator iter = cache.iterator();
        while (iter.hasNext()) {
            Integer cachedPage = (Integer) iter.next();
            // Move to the front of the list.
            if (cachedPage.equals(page)) {
                hits++;
                iter.remove();
                cache.addFirst(page);
                return;
            }
        }
        // It's not in the cache
        misses++;
        cache.addFirst(page);
        if (cache.size() > 16) {
            cache.removeLast();
        }
    }

    public static String toStr() {
        NumberFormat f = NumberFormat.getInstance();
        f.setMaximumFractionDigits(2);
        f.setMinimumFractionDigits(2);
        f.setMinimumIntegerDigits(1);
        double percent = (double) hits / ((double) misses + (double) hits) * (double) 100;
        return "cache hit rate: " + f.format(percent) + "%";
    }
}
