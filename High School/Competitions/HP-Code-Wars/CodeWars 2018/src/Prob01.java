
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob01 {

    public static void main(String[] args) throws Exception {
//        Problem: Introductions
//        Points: 1
        Scanner scan = new Scanner(new File("prob01.txt"));
        System.out.println("Salutations, " + scan.nextLine() + "! We are the Crashing Airplanes from LoserVille HS!");
    }

}
