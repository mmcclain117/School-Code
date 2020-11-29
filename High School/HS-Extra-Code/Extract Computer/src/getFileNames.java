
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Master Ward
 */
public class getFileNames {

    public static void main(String[] args) {
        String s = "C:\\";
        ArrayList<File> ar = new ArrayList();
        ArrayList<File> arFold = new ArrayList();
        ArrayList<File> temp = new ArrayList();
        File x[] = new File(s).listFiles();
        for (int i = 0; i < x.length; i++) {
            temp.add(x[i]);
        }
        out.println(Arrays.toString(temp.toArray()));
        while (!(temp.isEmpty())) {
//            out.println(temp.get(0));
            if (temp.get(0).isDirectory()) {
//                if (temp.get(0).isFile()) {
                arFold.add(temp.get(0));
//                } else {
                File y[] = temp.get(0).listFiles();
//                out.println(Arrays.toString(y));
//                out.println("".equals(Arrays.toString(y)));
//                out.println(y == null);
//                out.println(y.equals(null));
//                if (!(Arrays.toString(y) == null)) {
                if (!(y == null)) {
                    temp.addAll(Arrays.asList(y));
                }
//            }
                temp.remove(0);
            } else {
//                out.println(temp.get(0));
                ar.add(temp.remove(0));
            }
        }
        out.println("Files: " + ar.size());
        out.println("Folders: " + arFold.size());
    }
}
