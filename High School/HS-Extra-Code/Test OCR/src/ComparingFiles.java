
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Master Ward
 */
public class ComparingFiles {

    public static void main(String[] args) {
        File in = new File("C:\\Users\\Jacob\\Desktop");
        String d[] = in.list();
        ArrayList<File> ar = new ArrayList();
        ArrayList<String> name = new ArrayList();
        for (int i = 0; i < d.length; i++) {
            File temp = new File(d[i]);
            ar.add(temp);
            String temperary[] = temp.list();
            for (int p = 0; p < temp.list().length - 1; p++) {
                name.add(temperary[p]);
            }
        }
        for (int i = 0; i < ar.size(); i++) {

        }
        out.println(Arrays.toString(d));
    }
}
