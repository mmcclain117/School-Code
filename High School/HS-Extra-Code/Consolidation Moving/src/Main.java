
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Master Ward
 */
public class Main {

    public static ArrayList<File> list = new ArrayList();

    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Master\\Desktop\\MESSAGES";
        File oldFold = new File(folderPath);
        File newFold = new File(folderPath + "\\TestFolder");
        File dup = new File(newFold.getAbsolutePath() + "\\Duplicate");
        File test = new File(folderPath + "\\test File");
        File staa[] = {(new File("C:\\Users\\Master\\Desktop\\MESSAGES\\_Messages Consolidated")), (new File("C:\\Users\\Master\\Desktop\\MESSAGES\\_Attachments Consolidated"))};
        newFold.mkdirs();
        dup.mkdirs();
        test.mkdir();
        File st[] = oldFold.listFiles();
        reccursiveFind(st);
//        out.println(list.size());
        ArrayList<String> y = new ArrayList();
        for (File a : list) {
            y.add(a.getName());
        }
        out.println(list.get(0));
        out.println(y.get(0));
//        String newT = folderPath + "\\" + list.get(0).getName();
        String newT = folderPath + "\\TestFolder\\" + list.get(0).getName();
//        File temp = new File(newFold.getName() + "\\" + y.get(0));
//        File temp = new File((newFold.getName() +"\\" + y.get(0)));
        File temp = new File(newT);
        list.get(0).renameTo(temp);
        move(list, (folderPath + "\\TestFolder\\"));
        list.clear();
//        reccursiveFind(st);
        reccursiveFind(staa);
        int i = 0;
        while (i < 5) {
            list.clear();
            reccursiveFind(staa);
            new File(folderPath + "\\TestFolder\\Duplicate " + i + "\\").mkdirs();
            move(list, (folderPath + "\\TestFolder\\Duplicate " + i + "\\"));
            i++;
        }
    }

    private static void reccursiveFind(File[] st) {
        for (File a : st) {
            if (a.isDirectory()) {
                reccursiveFind(a.listFiles());
            } else {
                list.add(a);
            }
        }
    }

    private static void move(ArrayList<File> list, String folderPath) {
//        String folderPath = folderPath + "\\TestFolder\\";
        for (File a : list) {
            String newFoldPath = folderPath + a.getName();
            a.renameTo((new File(newFoldPath)));
//            break;
        }
    }
}
