package HTML_Making;

import java.io.*;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class WindowsUtils {

    private WindowsUtils() {
    }

// see note
    private static final String WINDOWS_DESKTOP = "Desktop";

    /**
     * the current user desktop path
     *
     * @return the current user desktop path
     */
    public static String getWindowsCurrentUserDesktopPath() {
        return System.getenv("userprofile") + "/" + WINDOWS_DESKTOP;
    }

    /**
     * Create an Internet shortcut on User's Desktop no icon specified
     *
     * @param name name of the shortcut
     * @param target URL
     *
     * @throws IOException
     */
    public static void createInternetShortcutOnDesktop(String name, String target)
            throws IOException {
        String path = getWindowsCurrentUserDesktopPath() + "/" + name + ".URL";
        out.println(path);
        createInternetShortcut(name, path, target, "");
    }

    /**
     * Create an Internet shortcut on User's Desktop, icon specified
     *
     * @param name name of the shortcut
     *
     * @param target URL
     * @param icon URL (ex. http://www.server.com/favicon.ico)
     * @throws IOException
     */
    public static void createInternetShortcutOnDesktop(String name, String target, String icon)
            throws IOException {
        String path = getWindowsCurrentUserDesktopPath() + "/" + name + ".URL";
        out.println(path);
        createInternetShortcut(name, path, target, icon);
    }

    /**
     * Create an Internet shortcut
     *
     * @param name name of the shortcut
     * @param where location of the shortcut
     * @param target URL
     *
     * @param icon URL (ex. http://www.server.com/favicon.ico)
     * @throws IOException
     */
    public static void createInternetShortcut(String name, String where, String target, String icon)
            throws IOException {
        FileWriter fw = new FileWriter(where);
        fw.write("[InternetShortcut]\n");
        fw.write("URL=" + target + "\n");
        if (!icon.equals("")) {
            fw.write("IconFile=" + icon + "\n");
        }
        fw.flush();
        fw.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        WindowsUtils.createInternetShortcutOnDesktop("GOOGLE", "http://www.google.com/");
    }
}
