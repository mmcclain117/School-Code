
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Olympic {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("olympic.txt"));
        double win = 0;
        String winner = null;
        Double score[] = new Double[7];
        double scay = 0.0;
        int a = scan.nextInt();
//        scan.nextLine();
        for (int b = 0; a > b; b++) {
            String name = scan.next();
            for (int xx = 0; xx < 7; xx++) {
                score[xx] = scan.nextDouble();
            }
            shell(score);
            int aa = 1;
            while (aa <= 5) {
                scay += score[aa];
                aa++;
            }
            if (scay > win) {
                winner = name;
                win = scay;
            }
            out.print(name + " ");
            out.printf("%2.2f", scay / 5);
            out.println(" ");
            scay = 0;
        }
        out.println("Winner: " + winner);
        scan.close();
    }

    private static void shell(Double[] score) {
        int increment = score.length / 2;
        while (increment > 0) {
            for (int i = increment; i < score.length; i++) {
                int j = i;
                double temp = score[i];
                while (j >= increment && score[j - increment] > temp) {
                    score[j] = score[j - increment];
                    j = j - increment;
                }
                score[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }
}
