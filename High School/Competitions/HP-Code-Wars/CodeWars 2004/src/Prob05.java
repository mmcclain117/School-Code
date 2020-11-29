
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Check Please?
//        Points: 5
        Scanner scan = new Scanner(new File("prob05.txt"));
        String s = scan.nextLine(); // Ordering
        double sum = 0;
        while (!(s.equals("END"))) {
            switch (s) {
                case "COFFEE":
                    sum += .5;
                    break;
                case "SODA":
                    sum += 1;
                    break;
                case "MILKSHAKE":
                    sum += 2.13;
                    break;
                case "PANCAKES":
                    sum += 3.25;
                    break;
                case "WAFFLES":
                    sum += 3.92;
                    break;
                case "HAMBURGERS":
                    sum += 4.01;
                    break;
                case "PASTA":
                    sum += 4.44;
                    break;
                case "HOTDOG":
                    sum += 2.98;
                    break;
                case "CHIPS":
                    sum += .65;
                    break;
                case "FRIES":
                    sum += .99;
                    break;
            }
            s = scan.nextLine();
        }
        System.out.printf("Your total is $%.2f\n", sum);
    }
}
