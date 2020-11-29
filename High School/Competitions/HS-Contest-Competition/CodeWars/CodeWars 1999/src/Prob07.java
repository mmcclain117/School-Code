
import java.io.File;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Master Ward
 */
/**
 * Probably needs more on the formating as It should probably include Commas and
 * dollar signs instead of just adding them.
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: Account Balancing
//        Points: 5
        Scanner scan = new Scanner(new File("prob07.txt"));
        /* Needed sorted so Use Tree Instead of Hash */
        TreeMap<String, Double> tm = new TreeMap<>();
        int lineCon = 0; // Track of tranactions
        while (scan.hasNext()) {
            String name = scan.next(); // Name
            String trans = scan.next(); // Transaction
            double val = scan.nextDouble(); // Value of Transaction
            lineCon++;
            if (tm.containsKey(name)) { // Already has account
                if (trans.equals("BALANCE")) {
                    System.err.print("ERROR LINE " + lineCon + ":");
                    System.err.println(name + " CANNOT REASSIGN ACCOUNT BALANCE");
                } else if (trans.equals("DEPOSIT")) {
                    tm.put(name, tm.get(name) + val);// Valid
                } else if (trans.equals("WITHDRAW")) {
                    if (tm.get(name) - val < 0) {
                        System.err.print("ERROR LINE " + lineCon + ":");
                        System.err.print(name + " CANNOT WITHDRAW $" + val);
                        System.err.println(" - BALANCE IS $" + tm.get(name));
                    } else {
                        tm.put(name, tm.get(name) - val); // Valid
                    }
                } else { // For thjings not gotten
                    System.out.println("The Command " + trans + " is not found");
                }
            } else {
                if (trans.equals("WITHDRAW")) {
                    System.err.print("ERROR LINE " + lineCon + ":");
                    System.err.println(name + " DOES NOT HAVE AN ACCOUNT");
                } else if (trans.equals("DEPOSIT")) {
                    System.err.print("ERROR LINE " + lineCon + ":");
                    System.err.println(name + " DOES NOT HAVE AN ACCOUNT");
                } else if (trans.equals("BALANCE")) { // Makes new account
                    tm.put(name, val); // Valid
                }
            }
        }
        System.out.println("--- FINAL BALANCES ---");
        Iterator<String> keyIt = tm.keySet().iterator(); // Key Iterator
        Iterator<Double> valIt = tm.values().iterator(); // Value Iterator
        DecimalFormat myFormat = new DecimalFormat("$###,###.00"); // Money Format
        while (keyIt.hasNext()) {
            System.out.print(keyIt.next() + " ");
//            System.out.printf("$###,###.##\n", it.next());
            System.out.println(myFormat.format(valIt.next()));
        }
    }
}
