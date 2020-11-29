package Part4;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class NodeTester {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("actors.txt"));
        Actor head = new Actor();
        Actor a1 = new Actor(scan.nextLine().trim());
        Actor a2 = new Actor(scan.nextLine().trim());
        Actor a3 = new Actor(scan.nextLine().trim());
        Actor a4 = new Actor(scan.nextLine().trim());
        Actor a5 = new Actor(scan.nextLine().trim());
        Node n = new Node();
        Node n1 = new Node(a1);
        n1.setNextPtr(n);
        Node n2 = new Node(a2);
        n2.setNextPtr(n1);
        Node n3 = new Node(a3);
        n3.setNextPtr(n2);
        Node n4 = new Node(a4);
        n4.setNextPtr(n3);
        Node n5 = new Node(a5);
        n5.setNextPtr(n4);
        n.setNextPtr(n5);
        Node current = n.getNextPtr();
        while (!(current.get() == null)) {
//            out.println(current.toString());
            out.println((Actor) current.get());
            current = current.getNextPtr();
        }
//        out.println(n.getNextPtr());
        out.println((Actor) n.getNextPtr().get());
    }
}
