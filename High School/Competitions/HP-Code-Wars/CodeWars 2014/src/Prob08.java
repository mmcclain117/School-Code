
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: N-Ultimate
//        Points: 6
        Scanner scan = new Scanner(new File("prob08.txt"));
        String line = scan.nextLine();
        while (!"0 $".equals(line)) {
            String split[] = line.split("\\s+");
            int c = Integer.parseInt(split[0]);
            System.out.println(split[split.length - c - 1]);
            line = scan.nextLine();
        }
    }
}
