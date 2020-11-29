
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
public class CombineSame {

    public static String targetFolder = "C:\\Users\\Master\\Desktop\\MESSAGES";
    static String targetPath = targetFolder + "\\Messages Consolidated";

    public static void main(String[] args) throws Exception {
//        File set[] = new File[(new File(targetFolder)).listFiles().length];
        File set[] = new File(targetFolder).listFiles();
        out.println(Arrays.toString(set));
        ArrayList<File> x = new ArrayList();
        for (int i = 0; i < set.length - 1; i++) {
            File te = set[i];
            File teA[] = te.listFiles(); // TeArray
            File teLi[] = teA[teA.length - 1].listFiles();
            x.addAll(Arrays.asList(teLi));
//            out.println(Arrays.toString(x.toArray()));
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
////        Scanner scan1 = new Scanner(new File("C:\\Users\\Master\\Desktop\\MESSAGES\\Messages 1\\Text\\Aaron  Putnam.csv"));
////        scan1.nextLine();
////        Scanner scan3 = new Scanner(new File("C:\\Users\\Master\\Desktop\\MESSAGES\\Messages 3\\Text\\Aaron  Putnam.csv"));
////        scan3.nextLine();
//        ArrayList<String[]> scl1 = new ArrayList();
//        ArrayList<String[]> scl3 = new ArrayList();
//        /**
//         * Put each line of scan1 into a String array seperated by colums Then
//         * into scl1
//         */
//        while (scan1.hasNext()) {
//            String te = scan1.nextLine();
//            scl1.add(te.split("[,]"));
//        }
//        scan1.close();
//        /**
//         * Put each line of scan3 into a String array Seperated by collums Put
//         * into scl3
//         */
//        while (scan3.hasNext()) {
//            String te = scan3.nextLine();
//            scl3.add(te.split("[,]"));
//        }
//        scan3.close();
//        out.println(Arrays.toString(scl3.remove(0)));
//        out.println(Arrays.toString(scl3.remove(1)));
//        out.println(Arrays.toString(scl3.remove(0)));
//        out.println(Arrays.toString(scl3.remove(0)));
//        out.println(Arrays.toString(scl3.remove(0)));
//
//        FileWriter fw1 = new FileWriter("C:\\Users\\Master\\Desktop\\Test Aaron.csv");
//        for (String a[] : scl1) {
//            for (String y : a) {
//                fw1.write(y + ",");
//            }
//            fw1.write("\n");
//        }
//        for (String a[] : scl3) {
//            for (String y : a) {
//                fw1.write(y + ",");
//            }
//            fw1.write("\n");
//        }
//        fw1.flush();
//        fw1.close();  
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
