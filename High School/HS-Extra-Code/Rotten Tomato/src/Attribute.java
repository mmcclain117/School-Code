
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Attribute {

    public static void main(String[] args) throws Exception {
//        File f = new File("01 A Night To Remember (ANTR).mp3");
        File f = new File("test.txt");
        FileInputStream in = new FileInputStream(f);
//        Properties propse = new Properties();
//        propse.load(in);
//        FileOutputStream fose = new FileOutputStream("test.txt");
//        propse.store(fose, "PGF");
//        fose.close();
        in.close();
        BasicFileAttributes attr = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
//        BasicFileAttributes attrs = Files.setAttribute(f.toPath(), " ", , new LinkOption);

        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
//        Files.setAttribute(null, null, attr, options);
//        LinkOption options = new LinkOption();
        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());
        Properties props = new Properties();
        FileOutputStream fos = new FileOutputStream("t.properties");
//        FileOutputStream fos = new FileOutputStream("test.txt");
        Scanner ins = new Scanner(new File("test.txt"));
        while (ins.hasNext()) {
            String gg = ins.nextLine();
            int t = gg.indexOf(":");
            if (t > 0) {
                props.setProperty(gg.substring(0, t), gg.substring(t + 1));
            }
        }
        props.setProperty("key1", "value1");
        props.store(fos, "Properties Generated File");
        fos.close();
    }
}
