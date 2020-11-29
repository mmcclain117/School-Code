
import java.io.File;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class EdgeForce {

    public static void main(String[] args) throws Exception { // Extra
        Scanner scan = new Scanner(System.in);
        out.println("Enter the force goal");
        int a = scan.nextInt();
        out.println("Enter you level");
        int lev = scan.nextInt();
        out.println("Enter the level researched ");
        Scanner scans = new Scanner(new File("Amount.txt"));
        ArrayList level = new ArrayList();
        LinkedList Name = new LinkedList();
        while (scans.hasNext()) {
            int level1 = scans.nextInt();
            String name1 = scans.next();
            level.add(level1);
            Name.add(name1);
        }
    }
}
