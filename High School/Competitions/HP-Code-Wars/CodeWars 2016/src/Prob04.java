
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Scientific Notation
//        Points: 3
        Scanner scan = new Scanner(new File("prob04.txt"));
        String line = scan.nextLine();
        while (!"0 0".equals(line)) {
            String[] split = line.split(" ");
            double base = Double.parseDouble(split[0]);
            int exp = Integer.parseInt(split[1]);
            double ans = Math.round((base * Math.pow(10, exp)) * 100) / 100.00;
            System.out.println(String.format("%2.2f", ans));
            line = scan.nextLine();
        }
    }
}
