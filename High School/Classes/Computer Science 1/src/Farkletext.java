
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Farkletext {

    public Random rnd = new Random();

    public static void main(String[] args) {
        int numDice = 6;
        Scanner scan = new Scanner(System.in);
        out.println("Enter number of players");
        int playeNum = scan.nextInt();
        out.println("Enter Number playing to");
        int goal = scan.nextInt();
        int playersScore[] = new int[playeNum];
        out.println("Enter players Names");
        String players[] = new String[playeNum];
        for (int i = 0; i < playeNum; i++) {
            players[i] = scan.nextLine();
        }
        int rounScore = 0;
        int leader = 0;
        int playRolling = 0;
        while (leader < goal) {
            if (playRolling > playeNum - 1) {

            } else {
                playersScore[playRolling] = roll(numDice);
            }
        }
    }

    public static int roll(int numDi) {
        int score = 0;
        Random rnd = new Random();
        int[] rollNumb = new int[numDi];
        for (int i = 0; i < numDi; i++) {
            rollNumb[i] = rnd.nextInt(5) + 1;
            rnd.nextGaussian();
            rnd.nextInt();
        }
        Arrays.sort(rollNumb);
        return score;
    }
}
