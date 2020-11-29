
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Compare2Perm {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean compareRun = true;
        boolean bf1 = false; // If file 1 is a file
        boolean bf2 = false; // If file 2 is a file
        String f1 = "", f2 = ""; //File Names
        String fx1 = "", fx2 = ""; // File content
        double pst = 0; // Double percent Straight comparision
        while (compareRun) {
            if (!bf1) {
                out.println("Enter in the first file");
                f1 = "FTest1.txt";
//                f1 = scan.nextLine();
            }
            if (!bf2) {
                out.println("Enter in the Second File");
                f2 = "FTest2.txt";
//                f2 = scan.nextLine();
            }
            File fi1 = new File(f1);
            File fi2 = new File(f2);
            bf1 = fi1.isFile();
            bf2 = fi2.isFile();
            if (bf1 && bf2) {
                Scanner in1 = new Scanner(fi1);
                Scanner in2 = new Scanner(fi2);
                while (in1.hasNext()) {
                    fx1 += in1.nextLine();
                }
                while (in2.hasNext()) {
                    fx2 += in2.nextLine();
                }
                compareRun = false;
            } else {
                if (!bf1) {
                    out.println("File one is invalid");
                }
                if (!bf2) {
                    out.println("File two is invalid");
                }
            }
        }
        StraightCompare(fx1, fx2);
        WordByWord(fx1, fx2);
        DocPerm(fx1, fx2);
    }

    private static void StraightCompare(String fx1, String fx2) { // problem not comparing the first one
        double percent = 0;
        int fl1 = fx1.length(); // Total length of file 1
        int fl2 = fx2.length(); // Total length of file 2
        int small = fl1 > fl2 ? fl2 : fl1; // Smalllest file
        double large = fl1 < fl2 ? fl2 : fl1; // Largest File
        double con = 0;
        String cons = "";
        for (int p = 0; p < small; p++) {
            con += fx1.substring(p, p + 1).equals(fx2.substring(p, p + 1)) ? 1 : 0;
            cons += fx1.substring(p, p + 1).equals(fx2.substring(p, p + 1)) ? fx1.substring(p, p + 1) : "";
        }
//        out.println(cons.length() + " "+ large);
//        out.println(cons.length() / large);
//        out.println((con / large) * 100 + "% Simular");
        out.printf("%.2f", con / large * 100);
        out.println("% Similar");
    }

    private static void WordByWord(String fx1, String fx2) {
        double totmatch = 0;
//        double tot = fx1.length() > fx2.length() ? fx1.length() : fx2.length(); // Decides the longest string
        double tot = 0;
        int fl1 = fx1.length(); // Total length of file 1
        int fl2 = fx2.length(); // Total length of file 2
        String fa1[] = fx1.split("\\s+");
        String fa2[] = fx2.split("\\s+");
        int fal1 = fa1.length; // Amount of words of file 1
        int fal2 = fa2.length; // Amount of words of file 2
        int smallword = fal1 > fal2 ? fal2 : fal1; // Smallest file word count
        double largeword = fal1 < fal2 ? fl2 : fal1; //Largest file word count
        double con = 0;
        for (int p = 0; p < smallword; p++) {
            tot += fa1[p].length() > fa2[p].length() ? fa1[p].length() : fa2[p].length();
            if (fa1[p].equals(fa2[p])) {
                con += 1;
                totmatch += fa1[p].length();
            }
//            con += fx1.substring(p, p + 1).equals(fx2.substring(p, p + 1)) ? 1 : 0;
        }
//        out.println(con + " " + tot + " " + totmatch);
//        out.println(cons.length() + " "+ large);
//        out.println(cons.length() / large);
//        out.println((con / large) * 100 + "% Simular");
        out.printf("%.2f", con / largeword * 100);
        out.println("% Similar Words\n");
        out.printf("%.2f", totmatch / tot * 100);
        out.println("% Similar Charecters\n");
    }

    private static void DocPerm(String fx1, String fx2) {

    }
}
