package Part7;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class ListTester {

    public static void main(String[] args) throws Exception {
        pt4();
    }

    private static void pt1() throws Exception {
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

    public static void pt4() throws Exception {
        LinkedList movies = new LinkedList();
        Scanner scan = new Scanner(new File("movies.txt"));
//        for (int i = 0; i < 5; i++) {
        while (scan.hasNext()) {
            int date = Integer.parseInt(scan.next().trim());
            String te = scan.nextLine();
            String title = te.substring(1, 34).trim();
            String actors[] = te.substring(34, 80).trim().split("[,]");
            String dir[] = te.substring(84).trim().split("[,]");
            LinkedList actor = new LinkedList();
            LinkedList direct = new LinkedList();
            for (int ii = 0; ii < actors.length; ii++) {
                actor.add(new Actor(actors[ii]));
            }
            for (int ii = 0; ii < dir.length; ii++) {
                direct.add(new Node(dir[ii]));
            }
//            Movie x = new Movie(); // Somehow fixed the problem all of a sudde of the following file
            Movie m = new Movie(date, title, actor, direct);
            movies.add((Movie) m);
        }
        int con = 0;
        while (con < movies.size()) {
            out.println(movies.get(con).toString());
            con++;
        }
        out.println(movies.get(0).toString());
    }
}
