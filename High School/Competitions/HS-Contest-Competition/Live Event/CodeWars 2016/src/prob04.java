
import java.io.File;
import java.util.Scanner;

public class prob04 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob04.txt"));
        String y = scan.nextLine();
        while (!y.equals("0 0")) {
            String yu[] = y.split("\\s+");
            double i = Double.parseDouble(yu[0]);
            int k = Integer.parseInt(yu[1]);
            double j = i * Math.pow(10, k);
            System.out.printf("%.2f%n", j);
            y = scan.nextLine();
        }
    }
}
