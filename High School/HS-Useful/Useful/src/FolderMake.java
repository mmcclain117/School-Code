
import java.io.*;
import static java.lang.System.out;
import java.nio.file.Path;
import java.util.*;

/**
 *
 * @author Master
 */
public class FolderMake {
    //Change the Fin ot hashmap

    public static ArrayList<String> ar = new ArrayList<>();
    public final static ArrayList<String> fin = new ArrayList<>();
    public static String em = "C:\\Users\\Jacob\\Desktop\\Compare\\Dupli\\Empty";

    public static void main(String[] args) throws IOException {
        String folder = "C:\\Users\\Jacob\\Desktop\\Compare\\Dupli\\R1";
        File f[] = new File(folder).listFiles();
        File F = new File(em);
        F.mkdir();
        for (File f1 : f) {
            find(f1);
        }
        out.println("FIN: is " + fin.size() + Arrays.toString(fin.toArray()));
        Collections.sort(fin);
//        comp();
    }

    private static void find(File s) {
        out.println(Arrays.toString(s.list()));
        String tes[] = s.list();
        File u[] = s.listFiles();
        try {
            for (int y = 0; y < u.length; y++) {
                if (tes[y].contains(".")) {
//                    fin.add(tes[y]);
                    fin.add(u[y].getPath());
                } else {
                    find(u[y]);
                }
            }
        } catch (NullPointerException e) {
//            fin.add("Empty");
        }
    }

    private static ArrayList comp() {
        HashMap<String, Path> hm = new HashMap<>();
        boolean con = true;
        int index = 0;
        while (index + 1 <= fin.size()) {
            String name = fin.get(index);
            while (con) {
                if (name.equals(fin.get(index + 1))) {
                    hm.put(name, null);
                } else {

                }
            }
            index++;
        }
        return null;
    }
}
