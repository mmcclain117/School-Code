
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob08.txt"));
        while (scan.hasNext()) {
            Set<String> setA = new LinkedHashSet<>();
            Set<String> setB = new LinkedHashSet<>();
            Set<String> setC = new LinkedHashSet<>();    //our new set
            String line1[] = scan.nextLine().split("[,]+"); // Scan in line 1
            String line2[] = scan.nextLine().split("[,]+"); // Scan in line 2
            setA.addAll(Arrays.asList(line1)); // Populate setA
            setB.addAll(Arrays.asList(line2)); // Populate setB
            String operation = scan.nextLine();

            if (operation.equalsIgnoreCase("Union")) {
                setC = setUnion(setA, setB);
            } else if (operation.equalsIgnoreCase("Intersection")) {
                setC = setIntersection(setA, setB);
            } else if (operation.equalsIgnoreCase("Complement")) {
                setC = setComplement(setA, setB);
            }
            if (setC.isEmpty()) {
                System.out.println("Null");
            } else {
                Iterator it = setC.iterator();
                System.out.print(it.next().toString());
                while (it.hasNext()) {
                    System.out.print("," + it.next().toString());
                }
                System.out.println();
            }
        }
        scan.close();
    }

    /* Returns setA and setB combined */
    private static Set setUnion(Set setA, Set setB) {
        Set<String> setC = new LinkedHashSet<>();
        setC.addAll(setA);
        setC.addAll(setB);
        return setC;
    }

    /* Returns values both in setA and setB */
    private static Set setIntersection(Set setA, Set setB) {
        Set<String> setC = new LinkedHashSet<>();
        Object cur; // SetA iterating value
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            cur = it.next();
            if (setB.contains(cur)) {
                setC.add(cur.toString());
            }
        }
        return setC;
    }

    /* Adds setB values that are Not in setA */
    private static Set setComplement(Set setA, Set setB) {
        Set<String> setC = new LinkedHashSet<>();
        Object cur; // setB iterating Value
        Iterator it = setB.iterator();
        while (it.hasNext()) {
            cur = it.next();
            if (!setA.contains(cur)) {
                setC.add(cur.toString());
            }
        }
        return setC;
    }
}
