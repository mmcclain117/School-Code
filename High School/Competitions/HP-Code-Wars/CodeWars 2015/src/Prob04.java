
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: NetOS App
//        Points: 3
        Scanner scan = new Scanner(new File("prob04.txt"));
        String line = scan.nextLine();
        while (!"0 0".equals(line)) {
            String split[] = line.split("\\s+");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            System.out.println(s * e);
            line = scan.nextLine();
        }
    }
}
