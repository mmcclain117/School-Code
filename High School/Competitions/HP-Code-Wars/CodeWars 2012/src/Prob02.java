
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Ringworld
//        Points: 3
        Scanner scan = new Scanner(new File("prob02.txt"));
        long r = scan.nextLong();
        long w = scan.nextLong();
        double c = 2 * Math.PI * r * w;
        System.out.println((int) (c / 196935000) + " EARTHS");
    }

}
