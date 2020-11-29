
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author Master
 */
public class One {

    public static void main(String[] args) throws IOException {
//        File file = new File("src/Main.java");
//        PrintWriter pw = new PrintWriter("this.java");
        String st = "C:\\Users\\Master\\Dropbox\\Netbeans Projects\\Filter Java\\Aparts";
        File f = new File(st + "\\BodyVar.java");
        File ff = new File(st + "\\Extracted\\Body.java");
        copyFile(f, ff);
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
    }
}
