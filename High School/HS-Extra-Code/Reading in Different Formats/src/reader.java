
import java.io.*;

/**
 *
 * @author Master Ward
 */
public class reader {

    public reader() throws Exception {

        File file = new File("C:/Users/Digilog/Downloads/Test.mp4");

        FileInputStream fin = new FileInputStream(file);
        byte b[] = new byte[(int) file.length()];
        fin.read(b);

        File nf = new File("D:/K.mp4");
        FileOutputStream fw = new FileOutputStream(nf);
        fw.write(b);
        fw.flush();
        fw.close();

    }

}
