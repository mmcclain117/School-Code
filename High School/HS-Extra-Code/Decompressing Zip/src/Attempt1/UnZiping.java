package Attempt1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Master Ward
 */
public class UnZiping {

    List<String> fileList;
    private static final String INPUT_ZIP_FILE = "C:\\Users\\Jacob\\Desktop\\Coolmaster Photo.zip";
    private static final String OUTPUT_FOLDER = "C:\\Users\\Jacob\\Desktop\\Test";

    public static void main(String[] args) {
        UnZiping unZip = new UnZiping();
        unZip.unZipIt(INPUT_ZIP_FILE, OUTPUT_FOLDER);
    }

    /**
     * Unzip it
     *
     * @param zipFile input zip file
     * @param output zip file output folder
     */
    public void unZipIt(String zipFile, String outputFolder) {

        byte[] buffer = new byte[1024];

        try {

            //create output directory is not exists
            File folder = new File(OUTPUT_FOLDER);
            if (!folder.exists()) {
                folder.mkdir();
            }

            //get the zip file content
            ZipInputStream zis
                    = new ZipInputStream(new FileInputStream(zipFile));
            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();
            out.println(zis.getNextEntry());
            out.println(zis.getNextEntry());
            out.println(zis.getNextEntry());
            out.println(ze.getSize());
            out.println(zis.available());
            while (ze != null) {

                String fileName = ze.getName();
                File newFile = new File(outputFolder + File.separator + fileName);

                System.out.println("file unzip : " + newFile.getAbsoluteFile());

                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();
                if (newFile.isFile()) {
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                    ze = zis.getNextEntry();

                    zis.closeEntry();
                    zis.close();
                } else {
                    break;
                }
            }
            System.out.println("Done");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
