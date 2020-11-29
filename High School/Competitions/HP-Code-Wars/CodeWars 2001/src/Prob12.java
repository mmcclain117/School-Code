
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: Double Knockout Competition
//        Points: 12
        Scanner scan = new Scanner(new File("prob12.txt"));
        int n = scan.nextInt(); // Number of games
        for (int i = 0; i < n; i++) {
            int t = scan.nextInt();// Number of teams
            System.out.println("Number of Teams: " + t);
            int undefeat = t; // Undefeated
            int oneLoss = 0; // One loss
            int eliminate = 0;// Eliminated
            int round = 0; // Rounds
            int gameCount = 0; // Game count
            int totNumbGames = 1; // Total Number of games
            while (undefeat + oneLoss >= 2) {
                System.out.print("Round: " + round + ", " + undefeat + " undefeated, " + oneLoss);
                System.out.println(" one-loss, " + eliminate + " eliminated, " + gameCount + " games played");
                if (undefeat == 1 && oneLoss == 1) {
                    oneLoss = 2;
                    undefeat = 0;
                    round++;
                    System.out.print("Round: " + round + ", " + undefeat + " undefeated, " + oneLoss);
                    System.out.println(" one-loss, " + eliminate + " eliminated, " + gameCount + " games played");
                }
                gameCount = 0;
                int tmpO = 0; // Temperary One Loss
                int tmpU = 0; // Temperary Undefeated
                tmpU = undefeat / 2;
                gameCount += tmpU;
                if (undefeat % 2 == 1) { // Uneven Undefeated Teams
                    tmpU++;
                }
                tmpO = oneLoss / 2;
                eliminate += oneLoss / 2;
                gameCount += tmpO;
                if (oneLoss % 2 == 1) { // Uneven One Loss Teams
                    tmpO++;
                }
                tmpO += undefeat / 2;
                oneLoss = tmpO;
                undefeat = tmpU;
                round++; // Next Round
                totNumbGames += gameCount;
            }
            System.out.print("Round: " + round + ", " + undefeat + " undefeated, " + oneLoss);
            System.out.println(" one-loss, " + eliminate + " eliminated, " + gameCount + " games played");
            System.out.println("There are " + round + " rounds and a total of " + totNumbGames + " games played.");
            System.out.println();
        }
    }
}
