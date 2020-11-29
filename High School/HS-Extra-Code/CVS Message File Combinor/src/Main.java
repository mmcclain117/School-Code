
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Main {

    public static String targetFolder = "C:\\Users\\Master\\Desktop\\MESSAGES";
    static String targetPath = targetFolder + "\\Messages Consolidated";

    public static void main(String[] args) throws Exception {
        File set[] = new File(targetFolder).listFiles();
        out.println(Arrays.toString(set));
        ArrayList<File> x = new ArrayList();
        for (int i = 0; i < set.length - 1; i++) {
            File te = set[i];
            File teA[] = te.listFiles(); // TeArray
            File teLi[] = teA[teA.length - 1].listFiles();
            x.addAll(Arrays.asList(teLi));
        }
        ArrayList<String> finName = new ArrayList();
        for (File temp : x) {
            if (!(finName.contains(temp.getName()))) {
                if (temp.getName().contains(".csv")) {
                    finName.add(temp.getName());
                }
            }
        }
        out.println(Arrays.toString(finName.toArray()));
        out.println(x.size() + "-" + finName.size() + "=" + (x.size() - finName.size()));
        Write(finName, x);
    }

    private static void Write(ArrayList<String> finName, ArrayList<File> x) throws Exception {
        for (String name : finName) {
            FileWriter fw1 = new FileWriter(new File(targetPath + "\\" + name));
            boolean first = true;
            for (File s : x) {
                if (s.getName().equals(name)) {
                    Scanner scan = new Scanner(s);
                    if (first) {
                        first = false;
                        while (scan.hasNext()) {
                            fw1.write(scan.nextLine());
                        }
                    } else {
                        for (int i = 0; i < 5; i++) {
                            scan.nextLine();
                        }
                        while (scan.hasNext()) {
                            fw1.append(scan.nextLine());
                        }
                    }
                }
            }
            fw1.flush();
            fw1.close();
        }
    }
}
