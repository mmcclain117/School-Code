
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: Domino Rally
//        Points: 14
        Scanner scan = new Scanner(new File("prob12.txt"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            ArrayList<Domino> ar = new ArrayList();
            while (!"0 F".equals(a)) {
                String b[] = a.split("\\s");
                ar.add(new Domino(Integer.parseInt(b[0]), b[1]));
                a = scan.nextLine();
            }
            boolean more = true;
            while (more) {
                int con = 0;
                while (con < ar.size() - 1) {
                    if (ar.get(con).getBack() == ar.get(con + 1).getFor()) {
                        ar.remove(con);
                        ar.remove(con);
                        con = 0;
//                        con++;
                    } else {
                        con++;
                    }
                }
                more = false;
            }
            if (ar.isEmpty()) {
                System.out.println("DATASET CLEARED");
            } else {
                for (int i = 0; i < ar.size(); i++) {
                    System.out.print(ar.get(i).getDom() + " ");
                }
                System.out.println("");
            }
        }
    }
}

class Domino {

    private int dom; // Domino Number
    private boolean d; // Directino; True = forwards

    public Domino(int a, String b) {
        dom = a;
        d = "F".equals(b);
    }

    public int getFor() {
        return d ? gf() : gb();
    }

    public int getBack() {
        return !d ? gf() : gb();
    }

    private int gf() { // Forword Number
        if (dom <= 7) {
            return 0;
        } else if (dom <= 13) {
            return 1;
        } else if (dom <= 18) {
            return 2;
        } else if (dom <= 22) {
            return 3;
        } else if (dom <= 25) {
            return 4;
        } else if (dom <= 27) {
            return 5;
        } else {
            return 6;
        }
    }

    private int gb() { // Backwards Nunmber
        int a[] = {0, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6, 3, 4, 5, 6, 4, 5, 6, 5, 6, 6};
        return a[dom - 1];
    }

    public int getDom() {
        return dom;
    }
}
