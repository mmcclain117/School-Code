
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Main {

    /**
     * Assuming that there are no packages
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
//        String filename = "NetbeanTest";
        Scanner scna = new Scanner(System.in);
//            String a = scna.nextLine();
        String projectName = "NetBeansTest";
        String oldPath = "C:\\Users\\Master\\Dropbox\\BlueJ to Netbeans\\Blue J\\Blocks";
        String ProPath = "C:\\Users\\Master\\Dropbox\\BlueJ to Netbeans\\" + projectName;
        File f1 = new File(ProPath + "\\nbproject\\private"); // Private Nbproject Folder
        f1.mkdirs();
        File f2 = new File(ProPath + "\\src"); // Source Code Folder
        f2.mkdir();
        File f3 = new File(ProPath + "\\build.xml");
        FileWriter fw1 = new FileWriter(f3);
        fw1.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<!-- You may freely edit this file. See commented blocks below for -->\n"
                + "<!-- some examples of how to customize the build. -->\n"
                + "<!-- (If you delete it and reopen the project it will be recreated.) -->\n"
                + "<!-- By default, only the Clean and Build commands use this build script. -->\n"
                + "<!-- Commands such as Run, Debug, and Test only use this build script if -->\n"
                + "<!-- the Compile on Save feature is turned off for the project. -->\n"
                + "<!-- You can turn off the Compile on Save (or Deploy on Save) setting -->\n"
                + "<!-- in the project's Project Properties dialog box.-->\n"
                + "<project name=\"" + projectName + "\" default=\"default\" basedir=\".\">\n"
                + "    <description>Builds, tests, and runs the project " + projectName + ".</description>\n"
                + "    <import file=\"nbproject/build-impl.xml\"/>\n"
                + "    <!--\n"
                + "\n"
                + "    There exist several targets which are by default empty and which can be \n"
                + "    used for execution of your tasks. These targets are usually executed \n"
                + "    before and after some main targets. They are: \n"
                + "\n"
                + "      -pre-init:                 called before initialization of project properties\n"
                + "      -post-init:                called after initialization of project properties\n"
                + "      -pre-compile:              called before javac compilation\n"
                + "      -post-compile:             called after javac compilation\n"
                + "      -pre-compile-single:       called before javac compilation of single file\n"
                + "      -post-compile-single:      called after javac compilation of single file\n"
                + "      -pre-compile-test:         called before javac compilation of JUnit tests\n"
                + "      -post-compile-test:        called after javac compilation of JUnit tests\n"
                + "      -pre-compile-test-single:  called before javac compilation of single JUnit test\n"
                + "      -post-compile-test-single: called after javac compilation of single JUunit test\n"
                + "      -pre-jar:                  called before JAR building\n"
                + "      -post-jar:                 called after JAR building\n"
                + "      -post-clean:               called after cleaning build products\n"
                + "\n"
                + "    (Targets beginning with '-' are not intended to be called on their own.)\n"
                + "\n"
                + "    Example of inserting an obfuscator after compilation could look like this:\n"
                + "\n"
                + "        <target name=\"-post-compile\">\n"
                + "            <obfuscate>\n"
                + "                <fileset dir=\"${build.classes.dir}\"/>\n"
                + "            </obfuscate>\n"
                + "        </target>\n"
                + "\n"
                + "    For list of available properties check the imported \n"
                + "    nbproject/build-impl.xml file. \n"
                + "\n"
                + "\n"
                + "    Another way to customize the build is by overriding existing main targets.\n"
                + "    The targets of interest are: \n"
                + "\n"
                + "      -init-macrodef-javac:     defines macro for javac compilation\n"
                + "      -init-macrodef-junit:     defines macro for junit execution\n"
                + "      -init-macrodef-debug:     defines macro for class debugging\n"
                + "      -init-macrodef-java:      defines macro for class execution\n"
                + "      -do-jar:                  JAR building\n"
                + "      run:                      execution of project \n"
                + "      -javadoc-build:           Javadoc generation\n"
                + "      test-report:              JUnit report generation\n"
                + "\n"
                + "    An example of overriding the target for project execution could look like this:\n"
                + "\n"
                + "        <target name=\"run\" depends=\"" + projectName + "-impl.jar\">\n"
                + "            <exec dir=\"bin\" executable=\"launcher.exe\">\n"
                + "                <arg file=\"${dist.jar}\"/>\n"
                + "            </exec>\n"
                + "        </target>\n"
                + "\n"
                + "    Notice that the overridden target depends on the jar target and not only on \n"
                + "    the compile target as the regular run target does. Again, for a list of available \n"
                + "    properties which you can use, check the target you are overriding in the\n"
                + "    nbproject/build-impl.xml file. \n"
                + "\n"
                + "    -->\n"
                + "</project>");
        fw1.flush();
        fw1.close();
        System.runFinalization();
        File f4 = new File(ProPath + "\\manifest.mf");
        FileWriter fw2 = new FileWriter(f4);
        fw2.write("Manifest-Version: 1.0\n"
                + "X-COMMENT: Main-Class will be added automatically by build\n"
                + "");
        fw2.flush();
        File f7 = new File(oldPath);
        out.println(Arrays.toString(f7.listFiles()));
        File p[] = f7.listFiles();
        out.println(Arrays.toString(p));
        for (int i = 0; i < p.length; i++) {
            File px = p[i];
            String yy = px.getName();
            Scanner scan = new Scanner(px);
            String y = "";
            while (scan.hasNext()) {
                y += scan.nextLine() + "\n";
            }
            if (yy.contains(".java")) { // Java File goes into the SRC folder
                File npx = new File(f2.getPath() + "\\" + p[i].getName());
                FileWriter fw3 = new FileWriter(npx);
                fw3.write(y);
                fw3.flush();
            } else if (yy.contains(".txt") || yy.contains(".dat")) {
                File npx = new File(ProPath + "\\" + p[i].getName());
                FileWriter fw3 = new FileWriter(npx);
                fw3.write(y);
                fw3.flush();
            }
        }
        Runtime.getRuntime().exec("shutdown /r");
    }
}
