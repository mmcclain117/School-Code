
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class SeperateWrite {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new FileReader("Puns.txt"));
        String tot = "";
        while (scan.hasNext()) {
            tot += scan.nextLine();
        }
        String split[] = tot.split("Pun!:");
        String folP = "C:\\Users\\Jacob\\Dropbox\\Puns Seperator\\Folder";
        Dexist(folP);
        File Folder = new File("Folder");
        Folder.mkdir();
        String myst = "C:\\Users\\Jacob\\Dropbox\\Puns Septerator\\Folder\\Question";
        Dexist(myst);
        File my = new File("Folder\\Question");
        my.mkdir();
        String state = "C:\\Users\\Jacob\\Dropbox\\Puns Seperator\\Folder\\Statement";
        Dexist(state);
        File st = new File("Folder\\Statement");
        st.mkdir();
        try (FileWriter intr = new FileWriter(new File("C:\\Users\\Jacob\\Dropbox\\Puns Seperator\\Folder\\Intro.txt"))) {
            intr.write(split[0]);
        }
        for (int i = 0; i < split.length; i++) {
            String u = "Puns!:" + split[i];
            if (u.contains("?")) {
                String y = "C:\\Users\\Jacob\\Dropbox\\Puns Seperator\\Folder\\Question\\Pun " + i + ".txt";
                write(u, y);
            } else {
                String y = "C:\\Users\\Jacob\\Dropbox\\Puns Seperator\\Folder\\Statement\\Pun " + i + ".txt";
                write(u, y);
            }
        }
    }

    private static void write(String sp, String path) throws Exception {
        FileWriter x = new FileWriter(new File(path));
        x.write(sp);
        x.flush();
        x.close();
    }

    private static void Dexist(String path) throws IOException {
        Path f = Paths.get(path);
        File o = f.toFile();
        if (o.exists()) {
            File p[] = f.toFile().listFiles();
            ArrayList<File> ar = new ArrayList();
            ArrayList<File> fin = new ArrayList<>();
            ArrayList<File> fold = new ArrayList();
            ar.addAll(Arrays.asList(p));
            while (!ar.isEmpty()) {
                if (ar.get(0).isDirectory()) {
                    ar.addAll(Arrays.asList(ar.get(0).listFiles()));
                    fold.add(ar.get(0));
                } else {
                    fin.add(ar.get(0));
                }
                ar.remove(0);
            }
            for (File y : fin) {
                Files.deleteIfExists(y.toPath());
            }
            for (File r : fold) {
                Files.deleteIfExists(r.toPath());
            }
            Files.delete(Paths.get(path));
        }
    }
}
