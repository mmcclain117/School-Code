
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Main7 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean run = true;// Used if you want to have it repeat if you dont input a valid anwser
        File st[] = findStart(scan); // Starting list of files
        ArrayList<File> ar = new ArrayList<>();
        ArrayList<File> tempAR = new ArrayList<>();
        ArrayList<File> Final = new ArrayList<>();
        ArrayList<File> NS = new ArrayList<>(); // Not sure
        ar.addAll(Arrays.asList(st));
        /*
         Finds all of the possible files in the folder and puts them in final
         */
        while (!ar.isEmpty()) {
            for (int i = 0; i < ar.size(); i++) {
                if (ar.get(i).isFile()) {
                    Final.add(ar.get(i));
                } else if (FileNameTest(ar.get(i))) {
                    NS.add(ar.get(i));
                } else {
                    tempAR.add(ar.get(i));
                }
                ar.remove(i);
            }
            while (!tempAR.isEmpty()) {
                File g[] = tempAR.get(0).listFiles();
                ar.addAll(Arrays.asList(g));
                tempAR.remove(0);
            }
        }
        try (FileWriter fw = new FileWriter(new File("FinalPaths.txt"))) {
            for (File f : Final) {
                fw.write(f.getAbsolutePath() + "\n");
            }
            fw.flush();
        }
        System.gc();
        Choose(Final);
        FileMethodTest(new File("FinalPaths.txt"));

    }

    /*
     Test to see if it is eqaul to full
     */
    private static boolean Test(String y) {
        return y.equalsIgnoreCase("full");
    }

    /*
     * Can run all the extra return methods on a file with x that is a string on of the file
     */
    private static void FileMethodTest(File f) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new File(f.getPath()));
        String x = "";
        while (scan.hasNext()) {
            x += scan.nextLine();
        }
    }

    /*
     *The start up and user interface of the computer file or folder to start with
     */
    private static File[] findStart(Scanner scan) {
        out.println("Enter in the folder || file");
        out.println("Enter full if you want to fully scan computer");
//        String y = scan.nextLine();
        String y = "C:\\Users\\Jacob\\Desktop\\Final";
//        String y = "C:\\Users\\Jacob\\Desktop\\Final\\Pool";
//        String y = "C:\\Users\\Jacob\\Desktop\\Final\\Erica Soccer Stuff";
//        String y = "full";
        if (Test(y)) {
            return File.listRoots();
        } else {
            return new File(y).listFiles();
        }
    }

    /*
     Alternate way to check if a file is a file and not a directory
     */
    private static boolean FileNameTest(File get) throws IOException {
        File gp[] = get.listFiles();
        if (gp == null) {
            return true;
        } else {
            for (File gp1 : gp) {
                if (gp1 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     User input for the file choosing of ways to compare the new final files and 
     reading in each one individually
     */
    private static void Choose(String finpath) throws Exception {
        Scanner FN = new Scanner(new File(finpath)); // File scanner
    }

    /* 
     User input for the file choosing of ways to compare the new final files
     */
    private static void Choose(ArrayList<File> Final) throws IOException {
        Scanner input = new Scanner(System.in);
        out.println("What do you want to do next");
        out.println("do you want to Compare File");
//        String a = input.nextLine();
        String a = "yes";
        if (YesNo(a)) {
            out.println("Do you want to compare by name, bits, or size");
//            String comp = input.nextLine();
            String comp = "name";
            if (comp.equalsIgnoreCase("name")) {
                try (FileWriter fr = new FileWriter(new File("SameName.txt"))) {
//                    out.println(Arrays.toString(Final.toArray()));
                    int finlen = Final.size();
                    for (int i = 0; i < finlen; i++) {
                        for (int j = i + 1; j < finlen; j++) {
                            int i1 = Final.get(i).toString().lastIndexOf("\\");
                            String i2 = Final.get(i).toString().substring(i1);
                            int j1 = Final.get(j).toString().lastIndexOf("\\");
                            String j2 = Final.get(j).toString().substring(j1);
                            if (i2.equals(j2)) {
                                File fte = new File(j2); // Folder Temperary Name
                                fr.write(Final.get(i) + " " + Final.get(j) + "\n");
                            }
                        }
                        fr.write("\n");
                    }
                    fr.flush();
                }
            } else if (comp.equalsIgnoreCase("bits")) {
                out.println("That is going to take some formating problmes right now");
            } else if (comp.equalsIgnoreCase("size")) {
                try (FileWriter fr = new FileWriter(new File("SameSize.txt"))) {
                    int finlen = Final.size();
                    out.println(finlen);
                    for (int i = 0; i < finlen; i++) {
                        for (int j = 0; j < finlen - i; j++) {
                            if (Final.get(i).getTotalSpace() == Final.get(j).getTotalSpace()) {
                                fr.write(Final.get(i) + " " + Final.get(j));
                            }
                        }
                    }
                    fr.flush();
                }
            } else {
                out.println("That does not work and no comparision done");
            }
        } else {
            out.println("I have nothing else at this point to do");
        }
    }

    /*
     Checks in to see that it is a yes in any form
     */
    private static boolean YesNo(String a) {
        return a.equalsIgnoreCase("Yes") || a.equalsIgnoreCase("Y") || a.equalsIgnoreCase("True");
    }
}
