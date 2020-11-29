
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static int q;
    public static int d;
    public static int n;

    public static void main(String[] args) throws Exception {
//        Problem: Quench Your Thirst
//        Points: 5
        Scanner scan = new Scanner(new File("prob06.txt"));
        int co = scan.nextInt(); // Inital number of Cokes
        int sp = scan.nextInt(); // Inital number of Sprites
        int dr = scan.nextInt(); // Inital number of Dr. Pepper
        q = scan.nextInt(); // Inital number of quarters
        d = scan.nextInt(); // Inital number of dimes
        n = scan.nextInt(); // Inital number of nickles
        scan.nextLine();
        double tot = q * .25 + d * .1 + n * .05;
        System.out.println("Number of sodas: " + (co + sp + dr) + " (" + co + " Cokes, " + sp + " Sprites, " + dr + " Dr. Peppers)");
        System.out.printf("Amount of money:  $%.2f (%d Quarters, %d Dimes, %s Nickles)\n", tot, q, d, n);
        System.out.println("Deposited   Soda         Change");
        System.out.println("---------   ----         ------");
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String split[] = line.split("[ ]");
            String type = split[0];
            if ("C".equals(type)) {
                type = "Coke";
                co--;
            } else if ("S".equals(type)) {
                type = "Sprite";
                sp--;
            } else if ("D".equals(type)) {
                type = "Dr. Pepper";
                dr--;
            }
            double inp = add(split) / 100.0; // Money inputed
            double lef = inp - .55; // Change
            String end = getChange(lef);
            System.out.printf("$%.2f%7s%-12s $%.2f %s\n", inp, "", type, lef, end);
        }
        System.out.println("All purchases have been processed");
        System.out.println("Number of sodas: " + (co + sp + dr) + " (" + co + " Cokes, " + sp + " Sprites, " + dr + " Dr. Peppers)");
        tot = q * .25 + d * .1 + n * .05;
        System.out.printf("Amount of money:  $%.2f (%d Quarters, %d Dimes, %s Nickles\n", tot, q, d, n);

    }

    /* Gets the amount of money inputted */
    private static int add(String[] split) {
        int tot = 0;
        for (int i = 1; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);
            if (tmp == 25) {
                q++;
            } else if (tmp == 10) {
                d++;
            } else if (tmp == 5) {
                n++;
            }
            tot += tmp;
        }
        return tot;
    }

    /* Returns a string of what the change should say */
    private static String getChange(double lef) {
        String fin = "";
        if (lef == 0) {
            return fin;
        }
        int qt = 0; // Quarter Temp
        int dt = 0; // Dime Temp
        int nt = 0; // Nickel Temp
        while (lef >= .24) { // Number of quarters
            lef -= .25;
            qt++;
            q--;
        }
        while (lef >= .09) { // Number of Dimes
            lef -= .1;
            dt++;
            d--;
        }
        while (lef >= .04) { // Number of Nickles
            lef -= .05;
            nt++;
            n--;
        }
        if (qt != 0) {
            fin += "(" + qt + " quarter";
            if (dt != 0) {
                fin += ", " + dt + " dime";
            }
            if (nt != 0) {
                fin += ", " + nt + " nickel";
            }
        } else if (dt != 0) {
            fin += "(" + dt + " dime";
            if (nt != 0) {
                fin += ", " + nt + " nickel";
            }
        } else if (nt != 0) {
            fin += "(" + nt + " nickel";
        }
        return fin + ")";
    }
}
