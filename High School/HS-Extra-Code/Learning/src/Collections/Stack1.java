package Collections;

import static java.lang.System.out;
import java.util.Stack;

/**
 *
 * @author Master
 */
public class Stack1 {

    public static void main(String[] args) {
        Object se[] = {"Top", "Now Top", "Middle", "First", "Second", "Ten", "Third", "Last", "In", "First", "Out", "LIFO"};
        Stack sj = new Stack();
        stack s = new stack();
        for (int i = 0; i < se.length; i++) {
            sj.push(se[i]);
            s.push(se[i]);
        }
        out.println("Pushed:      " + s.toString());
        out.println("Java Pushed: " + sj.toString());
        out.println("Peek:      " + s.peek());
        out.println("Java Peek: " + sj.peek());
        s.pop();
        sj.pop();
        s.pop();
        sj.pop();
        out.println("Popped 2:      " + s.toString());
        out.println("Java Popped 2: " + sj.toString());
        out.println("Peek:      " + s.peek());
        out.println("Java Peek: " + sj.peek());
        out.println("Search First:      " + s.search("First"));
        out.println("Java Search First: " + sj.search("First"));
        out.println("Search Second:      " + s.search("Second"));
        out.println("Java Search Second: " + sj.search("Second"));
        out.println("Empty:      " + s.empty());
        out.println("Java Empty: " + sj.empty());
    }
}
