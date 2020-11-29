
import java.io.File;

/**
 *
 * @author Master Ward
 */
public class MoveFile {

    public static void main(String[] args) {
        File f = new File("x.txt");
        f.renameTo(new File("src/" + f.getName()));
    }
}
