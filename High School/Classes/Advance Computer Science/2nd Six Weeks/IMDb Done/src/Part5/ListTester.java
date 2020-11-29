package Part5;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class ListTester {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("actors.txt"));
        LinkedList all = new LinkedList();
//        for (int i = 0; i < 5; i++) {
        while (scan.hasNext()) {
            all.add(new Actor(scan.nextLine().trim()));
        }
        int con = 0;
        while (con < all.size()) {
            out.println(all.get(con));
            con++;
        }
        out.println(all.get(0));
    }
}
