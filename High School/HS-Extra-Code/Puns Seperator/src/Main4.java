
import java.io.*;
import static java.lang.System.out;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class Main4 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new FileReader("Puns.txt"));
        String tot = "";
        for (int i = 0; i <= 876; i++) {
            tot += scan.nextLine();
        }
        String orig = "C:\\Users\\Jacob\\Dropbox\\Puns Seperator\\Folder"; // The project Folder Path
        String split[] = tot.split("Pun!:");
        String folP = orig;
        Dexist(folP);
        File Folder = new File("Folder");
        Folder.mkdir();
        String myst = orig + "\\Question";
        Dexist(myst);
        File my = new File("Folder\\Question");
        my.mkdir();
        String state = orig + "\\Statement";
        Dexist(state);
        File st = new File("Folder\\Statement");
        st.mkdir();
        try (FileWriter intr = new FileWriter(new File(orig + "\\Intro.txt"))) {
            intr.write(split[0]);
        }
        ArrayList<String> people = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            String u = "Puns!:" + split[i];
//            String u = sp[i];
            String te = split[i];
            int s = te.indexOf("(") - 1;
            int e = te.indexOf(")") - 1;
//            if (s > 0 && e > s && e <= te.length()) {
            if (s > 0 && e > s) {
//                out.println(sp[i] + " " + s + " " + e);
                String name = te.substring(s, e);
                out.println(name);
                people.add(name);
            }
            if (u.contains("?")) {
                String y = orig + "\\Question\\Pun " + i + ".txt";
                write(u, y);
            } else {
                String y = orig + "\\Statement\\Pun " + i + ".txt";
                write(u, y);
            }
        }
//        out.println(Arrays.toString(people.toArray()));
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
//                    ar.remove(0)
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
