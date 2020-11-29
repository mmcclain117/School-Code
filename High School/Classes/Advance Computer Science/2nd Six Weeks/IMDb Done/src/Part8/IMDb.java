package Part8;

import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

public class IMDb {

    public static void main(String[] args) throws Exception {
        LinkedList actors = getActor();
        LinkedList movie = getMovies();
        for (int i = 0; i < actors.size(); i++) {
            Actor mast = new Actor(actors.get(i).toString());
            boolean work = false;
            for (int ii = 0; ii < movie.size(); ii++) {
                Node ok = (Node) movie.get(ii);
                Movie ml = ((Movie) ok.get());
                LinkedList ll = ml.getActors();
                for (int iii = 0; iii < ll.size(); iii++) {
                    Actor act = new Actor(ll.get(iii).toString());
                    if (act.getName().contains(mast.getName())) {
                        if (!work) {
                            out.println(mast.getName());
                            work = true;
                        }
//                        out.println(ml.getDate() + " " +ml.getTitle());
                        out.println(ml);
                    }
                }
            }
            if (work) {
                out.println();
            }
        }
    }

    private static LinkedList getActor() throws Exception {
        Scanner scan = new Scanner(new File("actors.txt"));
        LinkedList all = new LinkedList();
        while (scan.hasNext()) {
            all.add(new Actor(scan.nextLine().trim()));
        }
        return all;
    }

    private static LinkedList getMovies() throws Exception {
        LinkedList movies = new LinkedList();
        Scanner scan = new Scanner(new File("movies.txt"));
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
                direct.add(new Actor(dir[ii]));
            }
//            Movie x = new Movie(); // Somehow fixed the problem all of a sudde of the following file
            Movie m = new Movie(date, title, actor, direct);
            movies.add(m);
        }
        return movies;
    }
}
