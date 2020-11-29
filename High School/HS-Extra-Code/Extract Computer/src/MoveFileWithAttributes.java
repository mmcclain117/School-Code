
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Master Ward
 */
public class MoveFileWithAttributes {

    public static void main(String[] args) throws IOException {
//        String so = "C:\\Users\\Master\\Downloads\\AdwCleaner.exe";
//        String des = "C:\\Users\\Master\\Desktop\\";
//        String so = "a\\x.txt";
        String so = "a\\The River.mp3";
//        String des = "B\\a\\x.txt";
        String des = "B\\a\\The River.mp3";
        String s = "src";
        ArrayList<File> ar = new ArrayList();
        ArrayList<File> arFold = new ArrayList();
        ArrayList<File> temp = new ArrayList();
        File x[] = new File(s).listFiles();
        for (int i = 0; i < x.length; i++) {
            temp.add(x[i]);
        }
//        out.println(Arrays.toString(temp.toArray()));
        while (!(temp.isEmpty())) {
            if (temp.get(0).isDirectory()) {
                arFold.add(temp.get(0));
                File y[] = temp.get(0).listFiles();
                if (!(y == null)) {
                    temp.addAll(Arrays.asList(y));
//                    out.println(Arrays.toString(y));
                }
                temp.remove(0);
            } else {
                ar.add(temp.remove(0));
            }
        }
        out.println("Files: " + ar.size());
        out.println("Folders: " + arFold.size());
//        File file = ar.get((int) (Math.random() * ar.size()));
//        Path path = file.toPath();
//        AclFileAttributeView ac = Files.getFileAttributeView(path, AclFileAttributeView.class);
//        FileAttributeView sc = Files.getFileAttributeView(path, FileAttributeView.class);
//        FileStore fs = Files.getFileStore(path);
//        out.println(ac.name());
//        Path path = new File("a\\x.txt").toPath();
        Path path = new File("a\\x.txt").toPath();
        BasicFileAttributes a = Files.readAttributes(path, BasicFileAttributes.class);
        printBFA(a);
        Path sourcePath = new File(so).toPath();
        Path targetPath = new File(des).toPath();
//        Files.walkFileTree(sourcePath, new CopyFileVisitor(targetPath));
        walkPathing(targetPath, sourcePath);
//        File fff = new File("B\\a\\x.txt");
        File fff = new File("B\\a\\The River.mp3");
        fff.delete();
    }

    public static void printBFA(BasicFileAttributes a) {
        out.println("Is Directory: " + a.isDirectory());
        out.println("Creation Time: " + a.creationTime());
        out.println("Last Modification Time: " + a.lastModifiedTime());
        out.println("Last Access Time: " + a.lastAccessTime());
        out.println("Size: " + a.size());
        out.println("Is Symbolic Link: " + a.isSymbolicLink());
        out.println("Is Other: " + a.isOther());
        out.println("String Length: " + a.toString().length());

    }

    public static void walkPathing(final Path targetPath, final Path sourcePath) throws IOException {
        Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
                Files.createDirectories(targetPath.resolve(sourcePath.relativize(dir)));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(final Path file,
                    final BasicFileAttributes attrs) throws IOException {
                Files.copy(file, targetPath.resolve(sourcePath.relativize(file)));
                return FileVisitResult.CONTINUE;
            }
        });
    }
}

class CopyFileVisitor extends SimpleFileVisitor<Path> {

    private final Path targetPath;
    private Path sourcePath = null;

    public CopyFileVisitor(Path targetPath) {
        this.targetPath = targetPath;
    }

    @Override
    public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
        if (sourcePath == null) {
            sourcePath = dir;
        } else {
            Files.createDirectories(targetPath.resolve(sourcePath.relativize(dir)));
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
        Files.copy(file, targetPath.resolve(sourcePath.relativize(file)));
        return FileVisitResult.CONTINUE;
    }
}
