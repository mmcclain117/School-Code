package Attempt1;

/**
 *
 * @author Jacob
 */
public class Jhard {

    public static void main(String[] args) {
        String zipFilePath = "G:\\PAVILLION\\Backup Set 2016-06-08 184331\\Backup Files 2016-06-08 184331\\Backup files 11.zip";
        String destDirectory = "G:\\PAVILLION Backup Extracte\\Backup files 11";
        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.unzip(zipFilePath, destDirectory);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }

}
