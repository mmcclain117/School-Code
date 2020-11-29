
import java.io.*;

/**
 *
 * @author Master Ward
 */
public class convert {

    public static void main(String[] args) throws Exception {

        //create file object
        File file = new File("B:/music/Billa.mp4");

        try {
            //create FileInputStream object
            FileInputStream fin = new FileInputStream(file);

            byte fileContent[] = new byte[(int) file.length()];
            fin.read(fileContent);

            //create string from byte array
            String strFileContent = new String(fileContent);

            System.out.println("File content : ");
            System.out.println(strFileContent);

            File dest = new File("B://music//a.mp4");
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest));
            bw.write(strFileContent + "\n");
            bw.flush();

        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the file " + ioe);
        }
    }
}
