
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Writinglot {

    public static Random rnd = new Random();

    public static void main(String[] args) throws Exception {
        String name = "File";
        for (int i = 0; i < 9780; i++) {
            write(name + i);
            writeString(name + rnd.nextDouble());
        }
    }

    private static void write(String name) throws Exception {
        String path = "C:\\Users\\Jacob\\Desktop\\Testing1\\";
        FileWriter fw = new FileWriter(new File(path + name + ".txt"));
        fw.write(" ");
        fw.flush();
        fw.close();
    }

    private static void writeString(String name) throws Exception {
        String path = "C:\\Users\\Jacob\\Desktop\\Testing1\\Random Number\\";
        FileWriter fw = new FileWriter(new File(path + name + ".txt"));
        String a = rnd.nextInt() + "";
        fw.write(a);
        fw.flush();
        fw.close();
    }
}
