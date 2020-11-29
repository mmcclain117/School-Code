
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Master Ward
 */
public class Main2 {

    public static ArrayList<String> ar = new ArrayList<>();
    public final static ArrayList<String> fin = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String folder = "C:\\Users\\Jacob\\Desktop\\Comparqe\\Dupli\\R1";
        File f[] = new File(folder).listFiles();
        for (int i = 0; i < f.length; i++) {
            find(f[i]);
        }
        out.println("FIN: is " + fin.size() + Arrays.toString(fin.toArray()));
    }

    private static void find(File s) {
        out.println(Arrays.toString(s.list()));
        String tes[] = s.list();
        File u[] = s.listFiles();
//        out.println(Arrays.toString(tes));
        try {
//            for (int y = 0 ; y < s.list().length ; y++) {
            for (int y = 0; y < u.length; y++) {
                if (tes[y].contains(".")) {
                    fin.add(tes[y]);
                } else {
//                    File f2 = new File(tes[y]);
                    find(u[y]);
                }
            }
        } catch (NullPointerException e) {
            fin.add("Empty");
        }
    }
}
