
import java.io.File;
import java.util.Scanner;

public class Patricio {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("patricio.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine();
            double x = scan.nextDouble();
            double y = scan.nextDouble();
            double t = scan.nextDouble();
        }
    }

}
