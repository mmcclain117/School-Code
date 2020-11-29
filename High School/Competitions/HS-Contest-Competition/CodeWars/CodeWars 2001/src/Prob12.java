

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob12.txt"));
        int n = scan.nextInt(); // Number of games
        for (int i = 0; i < n; i++) {
            int t = scan.nextInt();// Number of teams
            System.out.println("Number of Teams: " + t);
            int undef = t; // Undefeated
            int olos = 0; // One loss
            int el = 0;// Eliminated
            int r = 0; // Rounds
            int gc = 0; // Game count
            int sgc = 1; // Total Number of games
            while (undef + olos >= 2) {
                System.out.print("Round: " + r + ", " + undef + " undefeated, " + olos);
                System.out.println(" one-loss, " + el + " eliminated, " + gc + " games played");
                if (undef == 1 && olos == 1) {
                    olos = 2;
                    undef = 0;
                    r++;
                    System.out.print("Round: " + r + ", " + undef + " undefeated, " + olos);
                    System.out.println(" one-loss, " + el + " eliminated, " + gc + " games played");
                }
                gc = 0;
                int tmpO = 0; // Temperary One Loss
                int tmpU = 0; // Temperary Undefeated
                tmpU = undef / 2;
                gc += tmpU;
                if (undef % 2 == 1) { // Uneven Undefeated Teams
                    tmpU++;
                }
                tmpO = olos / 2;
                el += olos / 2;
                gc += tmpO;
                if (olos % 2 == 1) { // Uneven One Loss Teams
                    tmpO++;
                }
                tmpO += undef / 2;
                olos = tmpO;
                undef = tmpU;
                r++; // Next Round
                sgc += gc;
            }
            System.out.print("Round: " + r + ", " + undef + " undefeated, " + olos);
            System.out.println(" one-loss, " + el + " eliminated, " + gc + " games played");
            System.out.println("There are " + r + " rounds and a total of " + sgc + " games played.");
            System.out.println();
        }
    }
}
