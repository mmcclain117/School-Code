package NeedToTest;

import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.*;

/**
 *
 * @author Master
 */
public class Move2Desk2 {

    /*
     Notes:
     Can't do .zip Files
     Leaves the empty folders
    
     Test:
     If there is already a file there
     If there are no files
    
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        out.println("User Input or File");
        String UoF = scan.nextLine(); // User input or file input
        if (UoF.equalsIgnoreCase("User Input")) {
            User(); // Take in User input
        } else if (UoF.equalsIgnoreCase("File")) {
            out.println("Enter the file name || Path");
            String g = scan.nextLine();
            Computer(g); // Scan from File
        } else {
            out.println("That is not one of the choices");
        }
//        String x = "C:\\Users\\Jacob\\Desktop\\T9\\Marching Band\\";
//        String des = "C:\\Users\\Jacob\\Desktop\\Test Move\\";
    }

    private static void Computer(String g) throws Exception {
        Scanner scan = new Scanner(new File(g));
        String sp = scan.nextLine(); // Source Path
        String dp = scan.nextLine(); // Destination Path
        ArrayList<File> ar = new ArrayList<>();
        ArrayList<File> Fin = new ArrayList<>();
        ArrayList<File> temp = new ArrayList<>();
        ArrayList<File> Mas = new ArrayList<>();
        ar.addAll(Arrays.asList(new File(sp).listFiles()));
        while (!temp.isEmpty()) {
            temp.addAll(Arrays.asList(ar.get(0).listFiles()));
            ar.remove(0);
            for (File f : temp) {
                out.println(f.toString());
                if (f.isFile()) {
                    Fin.add(f);
                    temp.remove(f);
                } else {
                    ar.add(f);
                }
            }
        }
        Mas.addAll(ar);
        Mas.addAll(Fin);
        Mas.addAll(temp);
        moveFile(Mas, dp);
    }

    private static void User() throws IOException {
        Scanner scan = new Scanner(System.in);
        out.println("Enter a file path that you want to do");
        String sp = scan.nextLine(); // Source Path
        out.println("Enter the target path. Not accepted will go to the default desktop");
        String dp = scan.nextLine(); // Destination Path
        File s = new File(sp);
        ArrayList<File> ar = new ArrayList<>();
        ArrayList<File> Fin = new ArrayList();
        ArrayList<File> temp = new ArrayList();
        ArrayList<File> Mas = new ArrayList<>();
        ar.addAll(Arrays.asList(new File(sp).listFiles()));
        while (!temp.isEmpty()) {
            temp.addAll(Arrays.asList(ar.get(0).listFiles()));
            ar.remove(0);
            for (File f : temp) {
                out.println(f.toString());
                if (f.isFile()) {
                    Fin.add(f);
                    temp.remove(f);
                } else {
                    ar.add(f);
                }
            }
        }
        Mas.addAll(ar);
        Mas.addAll(Fin);
        Mas.addAll(temp);
        moveFile(Mas, dp);
    }

    private static void moveFile(ArrayList<File> Mas, String dp) throws IOException {
        for (File sx : Mas) {
            Path source = Paths.get(sx.getAbsolutePath());
            Path destination = Paths.get(dp + sx.getName());
            Files.move(source, destination, REPLACE_EXISTING);
        }
    }
}
