
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob14 {

    public static void main(String[] args) throws Exception {
//        Problem: Arithmetic Expression Evaluation
//        Points: 11
        Scanner scan = new Scanner(new File("prob14.txt"));
        while (scan.hasNext()) {
            String s = scan.nextLine().trim(); // Equasion
            if (countPar(s)) {
                s = space(s);
                ArrayList<String> ar = sep(s);
                solvePar(ar);
                String fin = "";
                for (String q : ar) {
                    if (!q.equals("")) { // Used to remove when there is a null in front
                        fin += q + "#";
                    }
//                    System.out.print(q + " ");
                }
                /* Solve the rest */
//                System.out.println(fin);
                System.out.printf("%f", Double.parseDouble(Solve(fin)));
//                System.out.println("ANSWER: " + Solve(fin));
                System.out.println();
            }
        }
    }

    /* Counts the parenthases and if there are missing\extra */
    private static boolean countPar(String s) {
        String q = s.replaceAll("[^()]+", "");
        int f = 0; // Forwards
        int b = 0; // Backwards
        char ch[] = q.toCharArray(); // Array of parenthases
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') { // Forwards
                f++;
            } else if (ch[i] == ')') { // Backwards
                if (f < b) { // Unexpected
                    System.out.println("error: unexpected )");
                    return false;
                }
                b++;
            }
        }
        if (f == b) {
            return true;
        } else if (f < b) {
            System.out.println("error: unexpected )");
            return false;
        } else if (f > b) {
            System.out.println("error: unmatched (");
            return false;
        } else {
            System.out.println("Something went wrong and i dont know what");
            return false;
        }

    }

    /* Solves parenthasise by reccursive function DOESNT WORK*/
    private static boolean solvePar(ArrayList<String> a) {
        while (true) {
            int lasClo = -1; // Last Closed
            int lasOpe = -1; // Last Open
            for (int i = a.size() - 1; i > 0; i--) { // Finds the last Parenthases
                if (a.get(i).trim().equals(")")) {
                    lasClo = i;
                } else if (a.get(i).equals("(")) {
                    lasOpe = i;
                    break;
                }
            }
            if (lasClo == -1 || lasOpe == -1) { // No more parenthases
                return false;
            }
            String sol = ""; // Equasion to be solved
            int mount = lasClo - lasOpe; // Number to remove
            a.remove(lasOpe); // Removes first Parenthases
            for (int i = 0; i < mount - 1; i++) {
                sol += a.remove(lasOpe) + "#"; // Removes same spot
            }
            a.set(lasOpe, Solve(sol)); // Add back the solution
        }
    }

    /* Add spaces to equasion that are all together */
    private static String space(String s) {
        s = s.replaceAll("[*]", " * ");// Multiplication
        s = s.replaceAll("[/]", " / ");// Division
        s = s.replaceAll("[+]", " + ");// Addition
        s = s.replaceAll("[-]", " - "); // Subtraction
        s = s.replaceAll("[(]", " ( "); // Open Parenthases
        s = s.replaceAll("[)]", " ) "); // Closed Parenthases
        return s;
    }

    /* Seperate the whole equasion into an inline RPN format ArrayList */
    private static ArrayList<String> sep(String s) {
        String split[] = s.split("[ ]+");
        ArrayList<String> ar = new ArrayList();
        int i; // Where start reading
        String oper = "*/+-()"; // Operators
        /* Adding the first one ot arrayList */
        if (split[0].equals("-")) {
            ar.add(split[0].trim() + split[1].trim()); // Add First Negative Number
            i = 2;
        } else {
            ar.add(split[0].trim()); // First Number
            i = 1;
        }
        for (; i < split.length; i++) {
            boolean good = true; // Need to add
            /* Next part takes care of negatives */
            if (oper.contains(split[i - 1])) { // First character is a operator
                if (split[i].equals("-")) { // If negative number is following
                    if (!oper.contains(split[i + 1])) { // Next is number
                        i++;
                        ar.add("-" + split[i].trim());
                        good = false;
                    }
                }
            }
            if (good) { // If haven't been added
                ar.add(split[i].trim());
            }
        }
        return ar;
    }

    private static String Solve(String sol) {
        String split[] = sol.split("[#]"); // Equasion
//        System.out.println(Arrays.toString(split));
        ArrayList<String> tmp = new ArrayList();
        tmp.addAll(Arrays.asList(split));
        int con = 0;
        /* Multiplication and Division */
        while (con < tmp.size()) {
            if (tmp.get(con).equals("*")) { // Multiplication
                double v1 = Double.parseDouble(tmp.remove(con - 1));
                double v2 = Double.parseDouble(tmp.remove(con));
                String v3 = (v1 * v2) + "";
                tmp.set(con - 1, v3);
            } else if (tmp.get(con).equals("/")) { // Division
                double v1 = Double.parseDouble(tmp.remove(con - 1));
                double v2 = Double.parseDouble(tmp.remove(con));
                String v3 = (v1 / v2) + "";
                tmp.set(con - 1, v3);
            } else {
                con++;
            }
        }
        con = 0;
        /* Addition and Subtraction */
        while (con < tmp.size()) {
            if (tmp.get(con).equals("+")) { // Addition
                double v1 = Double.parseDouble(tmp.remove(con - 1));
                double v2 = Double.parseDouble(tmp.remove(con));
                String v3 = (v1 + v2) + "";
                tmp.set(con - 1, v3);
            } else if (tmp.get(con).equals("-")) { // Subtraction
                double v1 = Double.parseDouble(tmp.remove(con - 1));
                double v2 = Double.parseDouble(tmp.remove(con));
                String v3 = (v1 - v2) + "";
                tmp.set(con - 1, v3);
            } else {
                con++;
            }
        }
        return tmp.get(0);
    }
}
