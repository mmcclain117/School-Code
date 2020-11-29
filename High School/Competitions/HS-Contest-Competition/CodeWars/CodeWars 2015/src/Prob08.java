
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: Counting Cubes
//        Difficulty: Medium
//        Subject: Counting, ArrayList
        Scanner scan = new Scanner(new File("prob08.txt"));
        int a = scan.nextInt();
        int emp = 0;
        int dup = 0;
        int wo = 0;
        ArrayList<Integer> ar = new ArrayList();
        for (int i = 0; i < a; i++) {
            String b = scan.next();
            int c = scan.nextInt();
            ar.add(c);
            if ("NA".equals(b)) {
                emp++;
            }
            if (c == 0) {
                wo++;
            }
        }
        int cons = 0;
        while (!ar.isEmpty()) {
            boolean dupl = true;
            int con = 0;
            int te = ar.remove(0);
            while (con < ar.size()) {
                if (ar.get(con) == te) {
                    if (dupl) {
                        dupl = false;
                        cons++;
                    }
                    ar.remove(con);
                } else {
                    con++;
                }
            }
        }
        System.out.println("Empty Cubes: " + emp);
        System.out.println("Duplicate Cube Assignments: " + cons);
        System.out.println("Employees without Cube: " + wo);
    }

}
