
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Jacob
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String original = "Today.txt";
        Scanner scan = new Scanner(new File(original + ".txt"));
        String y = "";
        while (scan.hasNext()) {
            String a = scan.nextLine();
            y += a;
        }
        FileWriter fw = new FileWriter(new File(original + " Revise.txt"));
        replace(y);
        fw.write(y);
        fw.flush();
        Scanner in = new Scanner(System.in);
        out.println("DO U want to optimise your preforamance");
        String ans = in.nextLine();
        if (ans.contains("no")) {
            out.println("Thanks and file has been written");
        } else {

        }
    }

    private static void replace(String y) throws Exception {
        y = Period(y);
        Capital(y);
    }

    private static void Capital(String y) throws FileNotFoundException {
        ArrayList<String> ar = new ArrayList<>();
        Scanner name = new Scanner(new File("names.txt"));
        int u = 0;
        String naming = "";
        String names[];
        while (name.hasNext()) {
            naming += name.next() + " ";
        }
//        out.println(Arrays.toString(File.listRoots()));
        names = naming.split("\\s+");
        for (int i = 0; i < names.length; i++) {

        }
    }

    private static String Period(String y) {
        return y.replaceAll("[.]", "[. ]");
    }
}
