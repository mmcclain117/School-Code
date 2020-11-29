package Done;

import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class CompareFiles {

    /*
     Things to test and fix
     If there is 3 files that are the same
     How to cut down on time to if i was to be testing 340,000 files
     If there are two of the same folders
     Enter C:\\ as one and see how long it takes
     First thing is to fix all the file paths
     */
    public static void main(String[] args) throws Exception {
//        String y = "C:\\Users\\Jacob\\Desktop\\Final\\Erica Soccer Stuff";
//        String y = "C:\\Users\\Jacob\\Dropbox\\File Stuff\\T9";
//        String y = "T9";
//        String y = "C:\\Windows";
        String y = "C:\\";
        File start = new File(y);
        File st[] = start.listFiles(); // Starting list of files
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
        /*
         out.println("ar");
         printA(ar);
         out.println("temp");
         printA(tempAR);
         out.println("final");
         printA(Final);
         out.println("NS");
         printA(NS);
         */
        System.gc();
        Runtime r = Runtime.getRuntime();
        out.println("Total Memory: " + r.totalMemory());
        out.println("Free Memory: " + r.freeMemory());
        out.println("Max Memory: " + r.maxMemory());
        long used = r.totalMemory() - r.freeMemory();
        out.println("Used Memory: " + used);
        Name(Final);
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

    private static void Name(ArrayList<File> Final) throws IOException {
        try (FileWriter fr = new FileWriter(new File("SameName.txt"))) {
            ArrayList<File> a = Final; // Sorted Final
            int finlen = Final.size();
            Collections.sort(a);
            ArrayList<String> FN = new ArrayList(); // File name
            for (File a1 : a) {
                FN.add(a1.getName());
            }
            for (int i = 0; i < finlen - 1; i++) {
                int con = 0;
                String f1 = FN.get(i);
                for (int j = i + 1; j < finlen - 1; j++) {
                    String f2 = FN.get(j);
                    int set = 0;
                    if (f2.equalsIgnoreCase(f1)) {
                        if (con == 0) {
//                            fr.write(a.get(i) + " ");
                            set++;
                        }
//                        fr.write(a.get(j) + "");
                        fr.write((set + " " + con));
                        con++;
                    } else {
                        break;
                    }
                    System.gc();
                }
            }
            fr.write("\n");
            fr.flush();
        }
    }

    /* 
     Ignore this is what is !N Speed and in accurate
     */
    private static void NameUnsort(ArrayList<File> Final) throws IOException {
        try (FileWriter fr = new FileWriter(new File("SameName.txt"))) {
            int finlen = Final.size();
            for (int i = 0; i < finlen; i++) {
                for (int j = i + 1; j < finlen; j++) {
                    int i1 = Final.get(i).toString().lastIndexOf("\\");
                    String i2 = Final.get(i).toString().substring(i1);
                    int j1 = Final.get(j).toString().lastIndexOf("\\");
                    String j2 = Final.get(j).toString().substring(j1);
                    if (i2.equals(j2)) {
                        File fte = new File(j2); // Folder Temperary Name
                        fr.write(Final.get(i) + "\t" + Final.get(j) + "\n");
                    }
                }
                fr.write("\n");
            }
            fr.flush();
        }
    }

    private static void printA(ArrayList<File> ar) {
        for (File a : ar) {
            out.println(a.getName());
        }
    }

    private static void quickS() {

    }
}