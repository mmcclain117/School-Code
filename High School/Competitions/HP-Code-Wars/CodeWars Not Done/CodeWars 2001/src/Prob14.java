
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob14 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob14.txt"));
//        40 worker hours per employee each week
//        3 hours 1 employee for server
//        1 hour 1 employee laptop copmuter
//        20 lbs of metal for server
//        2 lbs of metal for computer
//        1 lbs of plastic for server
//        3 lbs of plastic for Computer
//        for (int i = 0; i < 12; i++) { // 12 weeks
        for (int i = 0; i < 1; i++) { // 1 week
            String s = scan.nextLine();
            String split[] = s.split("[, ]+");
            int employ = Integer.parseInt(split[0]); // Number of employees
            int met = Integer.parseInt(split[1]); // Pounds of Metal
            int pla = Integer.parseInt(split[1]); // Pounds of Plastic
            int serv = Integer.parseInt(split[1]); // Server Price
            int comp = Integer.parseInt(split[1]); // Computer Price

        }
    }
}
