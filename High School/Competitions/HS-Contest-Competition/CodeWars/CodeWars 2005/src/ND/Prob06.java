package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    /* Have no clue what the hell I am doing */
    public static void main(String[] args) throws Exception {
//        Problem: L-Systems Part 1/String Rewriting
//        Points: 7
        Scanner scan = new Scanner(new File("prob06.txt"));
        String s = scan.nextLine();
        int n = Integer.parseInt(s.substring(s.indexOf("=") + 1)); // Number of cases
        s = scan.nextLine();
        String w = s.substring(s.indexOf("=") + 1); // Equasion
        ArrayList<String> var = new ArrayList<>();
        ArrayList<String> val = new ArrayList<>();
        while (scan.hasNext()) {
            String tmp = scan.nextLine();
            String vr = tmp.substring(0, tmp.indexOf("=")); // Variable
            String vl = tmp.substring(tmp.indexOf("=") + 1); // Value
//            System.out.println(vr + " " + vl);
            var.add(vr);
            val.add(vl);
        }
        boolean add = false; // Add the addition sign
        int con = 0; // Counter for var
        for (int i = 0; i < n; i++) {
            String tmp = w;
            con %= var.size(); // No out of bounds
//            for (int o = 0; o < var.size(); o++) {
//                System.out.println("Part " + i + ": o = " + o + " " + var.get(o));
            if (tmp.contains(var.get(con))) {
                int tmpInd = w.indexOf(var.get(con));
                System.out.println(tmpInd);
                if (!add) { // For when it is the first Substitution
                    add = true;
                    tmp = val.get(con) + "+";
                }
                while (tmpInd < w.length() - 1 && tmpInd >= 0) {
                    tmp += val.get(con) + "+";
//                    tmp = tmp.replaceAll(var.get(o), val.get(o));
//                    System.out.println(tmp);
//                    tmpInd++;
                    int che = tmpInd;
                    tmpInd = (w.substring(tmpInd + 1)).indexOf(var.get(con));
                    if (che > tmpInd) {
                        break;
                    }
//                    System.out.println(tmp + " " + tmpInd + " " + var.get(con));
//                    System.out.println(w.substring(tmpInd));
                }
//                    w = w.replaceAll(var.get(o), val.get(o));
//                    w = w.replaceAll(var.get(o), "");
//                }
            } else { // Isn't found
                i--;
            }
            con++;
            w = tmp;
        }
        System.out.println(w.substring(0));
    }
}
