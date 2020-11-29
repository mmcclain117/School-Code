package Part2;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class ListTester {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("actors.txt"));
        ActorLinkedList all = new ActorLinkedList();
        for (int i = 0; i < 5; i++) {
            String a = scan.nextLine().trim();
            Actor act = new Actor(a);
            all.add(act);
        }
        int con = 0;
        while (con < all.size()) {
            out.println(all.get(con));
            con++;
        }
        out.println(all.get(0).getName());
    }
}
