package Part1;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class NodeTester {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("actors.txt"));
        Actor head = new Actor();
        Actor a1 = new Actor(scan.nextLine().trim());
        a1.setNextPtr(head);
        Actor a2 = new Actor(scan.nextLine().trim());
        a2.setNextPtr(a1);
        Actor a3 = new Actor(scan.nextLine().trim());
        a3.setNextPtr(a2);
        Actor a4 = new Actor(scan.nextLine().trim());
        a4.setNextPtr(a3);
        Actor a5 = new Actor(scan.nextLine().trim());
        a5.setNextPtr(a4);
        head.setNextPtr(a5);
        Actor current = head.getNextPtr();
        while (current.getName() != null) {
            out.println(current.getName());
            current = current.getNextPtr();
        }
    }
}
