
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class A {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("a.txt"));
        String a = scan.nextLine();
        int con = 1;
        while (!a.equals("End of games")) {
            int joe = 0;
            int jane = 0;
            int joW = 0; // Joe Wins
            while (!a.equals("End of game")) {
                a = a.replaceAll(":", " ");
                String b[] = a.split("\\s+");
//                System.out.println(Arrays.toString(b));
                if (b[0].equals("Joe")) {
                    for (int i = 1; i < b.length; i++) {
                        joe += Integer.parseInt(b[i]);
                    }
                } else {
                    for (int i = 1; i < b.length; i++) {
                        jane += Integer.parseInt(b[i]);
                    }
                }
                if (joe >= 301) {
                    joW = 1;
                    break;
                } else if (jane >= 301) {
                    joW = 2;
                    break;
                }
                a = scan.nextLine();
            }
//            System.out.println(joe + " " + jane);
            System.out.print("Game " + con + ": ");
            if (joW == 0) {
                System.out.println("Game ended too soon. No one has won.");
            } else {
                while (!a.equals("End of game")) { // Goes till the end of the game
                    a = scan.nextLine();
                }
                if (joW == 1) {
                    System.out.println("Joe has won.");
                } else if (joW == 2) {
                    System.out.println("Jane has won.");
                }
            }
            con++;
            a = scan.nextLine();
        }
    }
}
