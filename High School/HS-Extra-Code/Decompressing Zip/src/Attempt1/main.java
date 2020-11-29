package Attempt1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Master Ward
 */
public class main {

    public static void main(String[] args) {
        File x = new File("E:\\PAVILLION Backup Extracte\\Make File"); // Starting File Path
        for (int i = 0; i <= 723; i++) {
            String type = ("\\Backup files " + i);
            Path path = Paths.get((x + type));
//            Files.createDirectory(path, fas);
            new File((x + type)).mkdir();
        }
    }
}
