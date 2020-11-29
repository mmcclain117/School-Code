
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Master
 */
public class WriteTest {

    public static void main(String[] args) throws Exception {
//        FileWriter fw = new FileWriter(new File("ts.txt"));
//        String a = "This is one of the files lines";
//        fw.write(a + "\r and this is the next Line\rHopefully this will woirk");
//        fw.flush();
//        fw.append("\r\r\rthis is one of the lines");
//        fw.flush();
//        fw.close();
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File("YourFile.txt")), "UTF-8");
        writer.write("This is one of the lines\rAnd another one of the lines\nUsing the next here");
        writer.write("another one of the lines\r\nhopefully this works\r and not this one ");
//        writer.flush();
        writer.close();
    }
}
