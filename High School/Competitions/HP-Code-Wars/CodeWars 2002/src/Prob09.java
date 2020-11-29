
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Movie Time Popcorn
//        Points: 7
        Scanner scan = new Scanner(new File("prob09.txt"));
        setUp();
        while (scan.hasNext()) {
            String s = scan.nextLine();
            String split[] = s.split("[,]");
            String name = split[0];// Name of farm
            double numb = Double.parseDouble(split[1]); // Number of acres
            int pint = Integer.parseInt(split[2].trim()); // Pints
            String amount = ""; // Number of stars
            double mount = (pint / 250) / (numb);
            for (int i = 0; i < mount; i++) {
                amount += "*";
            }
            for (int i = (int) mount; i < 20; i++) {
                amount += " ";
            }
            if (amount.charAt(20) == '*') {
                amount = amount.substring(0, 19) + "#" + amount.substring(21);
            } else {
                amount = amount.substring(0, 19) + "|" + amount.substring(21);
            }
//            System.out.println(mount);
            System.out.printf("%-30s%s\n", name, amount);
        }

    }

    /* Setup of the printout */
    private static void setUp() {
        System.out.printf("%20sPop Co-Op%15s\n", "", "");
        System.out.printf("%-30s%s\n", "Farm Name", "Production in");
        System.out.printf("%30s%s\n", "", "Thousands of");
        System.out.printf("%30s%s\n", "", "Pint Jars per Acre");
        System.out.printf("%30s%s\n", "", "   1   2   3   4   5   6");
        System.out.printf("%30s%s\n", "", "---|---|---|---|---|---|");

    }
}
