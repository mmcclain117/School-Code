
import java.io.File;
import java.util.Scanner;

public class prob02 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob02.txt"));
        int y = scan.nextInt();
        while (y != 0) {
            int k = 10000 / y;
            System.out.println(y + " gallons per week will last " + k + " weeks");
            y = scan.nextInt();

        }
    }
}
