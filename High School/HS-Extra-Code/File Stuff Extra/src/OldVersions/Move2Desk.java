package OldVersions;

import java.io.File;
import static java.lang.System.out;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.*;

/**
 *
 * @author Master
 */
public class Move2Desk {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        out.println("Enter a file path that you want to do");
//        String x = scan.nextLine();
        String x = "C:\\Users\\Jacob\\Desktop\\T9\\Marching Band\\";
        String des = "C:\\Users\\Jacob\\Desktop\\Test Move\\";
        File s = new File(x);
        ArrayList<File> ar = new ArrayList<>();
        ArrayList<File> Fin = new ArrayList();
        ArrayList<File> temp = new ArrayList();
        ArrayList<File> Mas = new ArrayList<>();
        File te[] = s.listFiles();
        for (int i = 0; i < te.length; i++) {
            ar.add(te[i]);
        }
//        while (!ar.isEmpty() && !temp.isEmpty()) {
        while (!temp.isEmpty()) {
            File v[] = ar.get(0).listFiles();
            for (File y : v) {
                temp.add(y);
            }
            ar.remove(0);
            for (File f : temp) {
                out.println(f.toString());
                if (f.isFile()) {
                    Fin.add(f);
                    temp.remove(f);
                } else {
                    ar.add(f);
                }
            }
        }
        Mas.addAll(ar);
        Mas.addAll(Fin);
        Mas.addAll(temp);
//        for (int i = 0 ; i < Mas.size() ; i++) {
        for (File sx : Mas) {
//            out.println(sx.getAbsolutePath());
//            out.println(sx.getName());
//            Scanner in = new Scanner(new File(sx.getAbsolutePath()));
//            String source = sx.getAbsolutePath();
            Path source = Paths.get(sx.getAbsolutePath());
            File sou = new File(sx.getAbsolutePath());
//            File destination = new File(des + sx.getName());
            Path destination = Paths.get(des + sx.getName());
//            CopyOption options = java.nio.file.CopyOption;
//            Files.move(sou, destination, REPLACE_EXISTING);
            Files.move(source, destination, REPLACE_EXISTING);
//            Files.move(sx.getAbsolutePath(), null, options);
        }
    }
}
