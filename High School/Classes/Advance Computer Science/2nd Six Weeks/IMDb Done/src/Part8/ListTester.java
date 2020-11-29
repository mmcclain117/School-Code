package Part8;

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
        while (scan.hasNext()) {
            String te = scan.nextLine();
            int date = Integer.parseInt(te.substring(0, 4));
            String title = te.substring(5, 38).trim();
            String actors[] = te.substring(38, 84).trim().split("[,]");
            String dir[] = te.substring(84).trim().split("[,]");
            LinkedList actor = new LinkedList();
            LinkedList direct = new LinkedList();
            for (int ii = 0; ii < actors.length; ii++) {
                actor.add(new Actor(actors[ii]));
            }
            for (int ii = 0; ii < dir.length; ii++) {
                direct.add(new Actor(dir[ii]));
            }
            Movie m = new Movie(date, title, actor, direct);
            Node n = new Node(m);
            movies.add(n);
        }
        int con = 0;
        while (con < movies.size()) {
            out.println(movies.get(con).toString());
            con++;
        }
    }
}
