
import java.io.File;
import java.util.Scanner;


/**
 *
 * @author Master
 */
public class StuckRobot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        Scanner scan = new Scanner(new File("stuckrobot.txt"));
        String a = scan.nextLine();
        while(scan.hasNext()) {
            int c = scan.nextInt();
            String b = scan.next();
        }
    }
    
}
