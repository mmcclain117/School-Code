
import java.io.File;
import java.util.Scanner;

public class Yash {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("yash.dat"));
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int l = 0; // Log
            for (int i = 0; i < a; i++) { // Figuring out log
                if (Math.pow(2, i) > a) {
                    l = i - 1;
                    break;
                }
            }
            System.out.print("1 " + l + " " + a + " ");
            int nln = (a * l); // O(NlogN)
            if (nln >= 1000) {
                String te = nln + "";
                int pa = te.length();
//                System.out.print(te.substring(0, (pa - 1 %3)) + "," + te.substring(pa - 1));
            }
            int sq = a * a; // O(N^N)
            if (sq >= 1000) {
                String te = sq + "";
                int pa = te.length();

//                System.out.print(te.substring(0, (pa %4) + 1) + "," + te.substring(pa % 3 + 1));
            }
            System.out.println();
        }
    }
}
