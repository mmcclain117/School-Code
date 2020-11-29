
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Master
 */
public class Write {

    public static void main(String[] args) throws Exception {
        int num = 0;
        for (int i = 0; i < 20; i++) {
            Write(i);
        }
    }

    public static void Write(int num) throws Exception {
        String fi = "prob" + num + ".java";
        FileWriter fw = new FileWriter(new File(fi));
        fi = "prob" + fi;
        fw.write("import java.util.Scanner;\n"
                + "import java.io.File;\n"
                + "\n"
                + "public class " + fi + "{\n"
                + "\n"
                + "    public static void main(String[] args) throws Exception {\n"
                + "        Scanner scan = new Scanner(new File(\"" + fi + "\"));\n"
                + "    }\n"
                + "}\n"
                + "");
        fw.flush();
        fw.close();
    }
}
