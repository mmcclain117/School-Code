package Attempt1;

import java.io.IOException;

/**
 *
 * @author Jacob
 */
public class UnZipMain {

    public static void main(String[] args) throws IOException {
//        String zipFilePath = "C:\\Users\\Jacob\\Desktop\\Coolmaster Photo.zip";
        String zipFilePath = "C:\\Users\\Jacob\\Dropbox\\WardsWeb emails\\INBOX\\jacob@thewardsweb.com (1).zip";
//        String destDirectory = "C:\\Users\\Jacob\\Desktop\\Test";
        String destDirectory = "C:\\Users\\Jacob\\Dropbox\\WardsWeb emails\\INBOX\\Testing";
        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.unzip(zipFilePath, destDirectory);
//        } catch (IOException ex) {
        } catch (Exception ex) {
//            throw new IOException("This is not working");
//            throws Exception
            ex.printStackTrace();
        }
    }
}
