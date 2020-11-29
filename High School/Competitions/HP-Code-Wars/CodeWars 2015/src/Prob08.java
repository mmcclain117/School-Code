
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: Counting Cubes
//        Points: 5
        Scanner scan = new Scanner(new File("prob08.txt"));
        int a = scan.nextInt(); // Number of Cubicals
        int empty = 0; // Empty Boxes
        int wo = 0; // Not Assigned
        ArrayList<Integer> ar = new ArrayList();
        for (int i = 0; i < a; i++) {
            String b = scan.next();
            int c = scan.nextInt();
            ar.add(c);
            if ("NA".equals(b)) {
                empty++;
            }
            if (c == 0) {
                wo++;
            }
        }
        int cons = 0;
        /* Counts out the number of duplicates */
        while (!ar.isEmpty()) {
            boolean duplicate = true;
            int con = 0;
            int te = ar.remove(0);
            while (con < ar.size()) {
                if (ar.get(con) == te) {
                    if (duplicate) {
                        duplicate = false;
                        cons++;
                    }
                    ar.remove(con);
                } else {
                    con++;
                }
            }
        }
        /* Print out everything */
        System.out.println("Empty Cubes: " + empty);
        System.out.println("Duplicate Cube Assignments: " + cons);
        System.out.println("Employees without Cube: " + wo);
    }
}
