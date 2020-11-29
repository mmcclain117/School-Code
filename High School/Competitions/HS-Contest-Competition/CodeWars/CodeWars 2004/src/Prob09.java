

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Pizza Ordering System
//        Points: 9
        Scanner scan = new Scanner(new File("prob09.txt"));
        String s = scan.nextLine();
        int level = 0; // Where it is
        boolean already = false; // Already made pizza
        while (scan.hasNext()) {
            String eq[] = s.split("\"");
            if (eq.length == 1) { // Is not main
                if (s.contains("item")) {
                    System.out.println("\t\t\t" + getData(s)); // Print original Data
                    while (level == 2) { // Topings
                        s = scan.nextLine();
                        if (s.contains("item")) {
                            System.out.println("\t\t\t" + getData(s)); // Any Extra Data
                        } else {
                            break;
                        }
                    }
                } else if (s.contains("size") || s.contains("crust")) { // Part of pizza
                    System.out.print(getData(s) + ", ");
                } else if (s.contains("type")) { // Last part of pizza
                    System.out.println(getData(s));
                }
            } else {
                if (s.contains("order number")) {
                    System.out.println("Order " + eq[1] + ":");
                } else if (s.contains("pizza number")) {
                    level = 1;
                    if (already) {
                        System.out.println();
                    } else {
                        already = true;
                    }
                    System.out.print("\tPizza " + eq[1] + " - ");
                } else if (s.contains("toppings area")) {
                    level = 2;
                    String amt = ""; // Area to fill 
                    if (s.contains("0")) {
                        amt = "Whole";
                    } else if (s.contains("1")) {
                        amt = "First-Half";
                    } else if (s.contains("2")) {
                        amt = "Second-Half";
                    }
                    System.out.println("\t\tToppings " + amt + ":");
                }
            }
            s = scan.nextLine(); // In case isn't read again
        }
    }

    /* Gets the data inbetween the parameters */
    private static String getData(String s) {
        int startData = s.indexOf("}") + 1; // End of 1st command
        int endData = s.lastIndexOf("{"); // Beginning of 2nd command
        if (startData < 0 || endData < 0 || startData > endData) { // Ignore as just an ending
            return "";
        } else {
            return s.substring(startData, endData);
        }
    }

}
