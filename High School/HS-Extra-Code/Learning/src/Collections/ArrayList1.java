package Collections;

import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class ArrayList1 {

    public static void main(String[] args) {
        Object c[] = {"Then", "This", "That", "then", "can", "b", "are", "kait", "Late", "This", "Late", "aa", "This"};
        ArrayList arj = new ArrayList();
        Arraylist ar = new Arraylist();
        for (int i = 0; i < c.length; i++) {
            arj.add(c[i]);
            ar.add(c[i]);
        }
        out.println("ADD:      " + ar.toString());
        out.println("Java ADD: " + arj.toString());
        ar.add(ar.size() - 1, "Second to Last");
        arj.add(arj.size() - 1, "Second to Last");
        out.println("ADD Second to Last:     " + ar.toString());
        out.println("Java ADD Second to Last: " + arj.toString());
        ar.add(ar.size(), "Last");
        arj.add(arj.size(), "Last");
        out.println("ADD Last:     " + ar.toString());
        out.println("Java ADD Last: " + arj.toString());
        ar.remove("Then");
        arj.remove("Then");
        ar.remove("aa");
        arj.remove("aa");
        out.println("Remove Object:      " + ar.toString());
        out.println("Java Remove Object: " + arj.toString());
        arj.remove(5);
        ar.remove(5);
        ar.remove(ar.size() - 1);
        arj.remove(arj.size() - 1);
        out.println("Remove Index:      " + ar.toString());
        out.println("Java Remove Index: " + arj.toString());
        out.println("Size:      " + ar.size());
        out.println("Java Size: " + arj.size());
        out.println("Contains:      " + ar.contains("Then"));
        out.println("Java Contains: " + arj.contains("Then"));
        out.println("Contains:      " + ar.contains("then"));
        out.println("Java Contains: " + arj.contains("then"));
        out.println("IndexOf:      " + ar.indexOf("This"));
        out.println("Java IndexOf: " + arj.indexOf("This"));
        out.println("IndexOf:      " + ar.indexOf("this"));
        out.println("Java IndexOf: " + arj.indexOf("this"));
        out.println("LastIndexOf:      " + ar.lastIndexOf("This"));
        out.println("Java LastIndexOf: " + arj.lastIndexOf("This"));
        out.println("LastIndexOf:      " + ar.lastIndexOf("this"));
        out.println("Java LastIndexOf: " + arj.lastIndexOf("this"));
        out.println("Get 1:      " + ar.get(1));
        out.println("Java Get 1: " + arj.get(1));
        ar.set(0, "Not This");
        arj.set(0, "Not This");
        ar.set(ar.size() - 1, "Not Late");
        arj.set(arj.size() - 1, "Not Late");
        out.println("Set First:      " + ar.get(0));
        out.println("Java Set First: " + arj.get(0));
        out.println("Set Last:      " + ar.get(ar.size() - 1));
        out.println("Java Set Last: " + arj.get(arj.size() - 1));
        ar.clear();
        arj.clear();
        out.println("Clear:      " + ar.toString());
        out.println("Java Clear: " + arj.toString());
    }
}
