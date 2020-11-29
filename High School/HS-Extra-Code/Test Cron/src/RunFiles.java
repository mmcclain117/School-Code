
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Master
 */
public class RunFiles {

    private static void printLines(String name, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(name + " " + line);
        }
    }

    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }

    public static void main(String[] args) {
        try {
//            Object obj = new prob08();
//            ClassLoader cl = obj.getClass().getClassLoader();
//            Class c = cl.loadClass("main");
//            runProcess("cmd /c start cmd.exe");
            String str = "\\Desktop\\Other\\NetBeansProjects\\CodeWars 2017";
            runProcess("cmd /c -classpath " + str + "\\src\\prob08.java");
            runProcess("cmd /c java -c prob08.java");
            runProcess("java prob08");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
