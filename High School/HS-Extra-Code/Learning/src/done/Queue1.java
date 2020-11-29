package done;

import static java.lang.System.out;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author Master
 */
public class Queue1 {

    public static void main(String[] args) {
        String set[] = {"First", "Second", "A", "B", "C", "D", "E", "Binary", "ten"};
        queue q = new queue();
        out.println("Starting:     " + q.toString());
        out.println("Ans Starting: []");
        q.offer(set[0]);
        q.offer(set[1]);
        out.println("First:     " + q.peek());
        out.println("Ans First: First");
        out.println("String add 2:     " + q.toString());
        out.println("Ans String add 2: [First, Second]");
        q.poll();
        out.println("Removed 1:     " + q.toString());
        out.println("Ans Removed 1: [Second]");
        for (int i = 0; i < set.length; i++) {
            q.offer(set[i]);
        }
        out.println("Offering all:     " + q.toString());
        out.println("Ans Offering all: [Second, First, Second, A, B, C, D, E, Binary, ten]");
        for (int i = 0; i < 3; i++) {
            q.poll();
        }
        out.println("Remove 3:     " + q.toString());
        out.println("Ans Remove 3: [A, B, C, D, E, Binary, ten]");
    }
}
