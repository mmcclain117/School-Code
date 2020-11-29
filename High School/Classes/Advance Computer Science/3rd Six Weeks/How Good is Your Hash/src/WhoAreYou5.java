
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Replace all of the number to compare to line 2 and add if it is to null
 * statement
 *
 * @author Master
 */
public class WhoAreYou5 {

    public static void main(String[] args) throws Exception {
        double a[] = {.1, .5, .8, .9, .99};
        for (int pl = 0; pl < a.length; pl++) {
//            int aa = (int) (50000 * (1 + (1 - a[pl]))); // Size of the table
            int aa = (int) (50000 * (1 + (1 - a[pl]))); // Size of the table
            HashTable hash = new HashTable(aa); // Creating Linkedlist hashtable
            HashTable hash2 = new HashTable(aa);
            HashTable hash3 = new HashTable(aa);
            Quad q = new Quad(aa); // Creating Quadratic 
            Quad q2 = new Quad(aa);
            Quad q3 = new Quad(aa);
            Linear l = new Linear(aa); // Create linear Hashtable
            Linear l2 = new Linear(aa);
            Linear l3 = new Linear(aa);
            Rand r = new Rand(aa); // Creates random hashtable
            Rand r2 = new Rand(aa);
            Rand r3 = new Rand(aa);
            Scanner scan = new Scanner(new File("Large Data Set.txt")); // Large data Scanner
            Scanner succ = new Scanner(new File("Successful Search Records.txt")); // Successful file scanner
            Scanner wrong = new Scanner(new File("Unsuccessful Search Records.txt")); // Unsuccessful File Scanner
            long startBuild, endBuild, unsuc, suc;
            File f = new File("new Folder");
            f.mkdir();
            FileWriter result = new FileWriter(new File(f + "\\Result" + pl + ".txt"));
            ArrayList<String> peeps = new ArrayList();
            ArrayList<String> success = new ArrayList();
            ArrayList<String> unsuccess = new ArrayList();
            while (scan.hasNext()) {
                String xp = scan.nextLine();
                peeps.add(xp);
            }
            scan.close();
            while (succ.hasNext()) {
                String xp = succ.nextLine();
                success.add(xp);
            }
            succ.close();
            while (wrong.hasNext()) {
                String xp = wrong.nextLine();
                unsuccess.add(xp);
            }
            wrong.close();
            /*
             Get the data for the Linear one
             */
//            startBuild = System.currentTimeMillis();
            startBuild = System.nanoTime();
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                l.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            endBuild = System.currentTimeMillis();
            endBuild = System.nanoTime();
            long buildTime = (endBuild - startBuild);
            for (String xp : success) {
                String line[] = xp.split("\t");
                l2.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            suc = System.currentTimeMillis();
            suc = System.nanoTime();
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                l3.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            unsuc = System.currentTimeMillis();
            unsuc = System.nanoTime();
            result.write("Linear:\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n");
            result.write("Build table Time: " + buildTime + "\n\n");
            result.write("Results Added to the table: " + peeps.size() + "\n");
            result.write("Average Insertion time: " + (buildTime / (long) peeps.size()) + "\n"); // Need the other one
            result.write("Number of Collisions: " + l.getC() + "\n");
            result.write("Number of Probes: " + l.getP() + "\n");
            result.write("Number of Collisions Vs Number of insertions:  %\n\n");
            result.write("Successful Table Size: " + success.size() + "\n");
            result.write("Successful insertion time: " + (suc - endBuild) + "\n");
            result.write("Successful Collision Number: " + l2.getC() + "\n");
            result.write("Successful Probe Number: " + l2.getP() + "\n\n");
            result.write("Unsuccessful Table Size: " + unsuccess.size() + "\n");
            result.write("Unsuccessful insertion time: " + (unsuc - suc) + "\n");
            result.write("Unsuccessful Collision Number: " + l3.getC() + "\n");
            result.write("Unsuccessful Probe Number: " + l3.getP() + "\n\n");

            /*
             Get the data for the Quadratic one
             */
//            startBuild = System.currentTimeMillis();
            startBuild = System.nanoTime();
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                q.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            endBuild = System.currentTimeMillis();
            endBuild = System.nanoTime();
            buildTime = (endBuild - startBuild);
            for (String xp : success) {
                String line[] = xp.split("\t");
                q2.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            suc = System.currentTimeMillis();
            suc = System.nanoTime();
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                q3.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            unsuc = System.currentTimeMillis();
            unsuc = System.nanoTime();
            result.write("\nQuadratic:\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n");
            result.write("Build table Time: " + buildTime + "\n\n");
            result.write("Results Added to the table: " + peeps.size() + "\n");
            result.write("Average Insertion time:" + (buildTime / (long) peeps.size()) + "\n");
            result.write("Number of Collisions: " + q.getC() + "\n");
            result.write("Number of Probes: " + q.getP() + "\n");
            result.write("Number of Collisions Vs Number of insertions:  %\n\n");
            result.write("Successful Table Size: " + success.size() + "\n");
            result.write("Successful insertion time: " + (suc - endBuild) + "\n");
            result.write("Successful Collision Number: " + q2.getC() + "\n");
            result.write("Successful Probe Number: " + q2.getP() + "\n\n");
            result.write("Unsuccessful Table Size: " + unsuccess.size() + "\n");
            result.write("Unsuccessful insertion time: " + (unsuc - suc) + "\n");
            result.write("Unsuccessful Collision Number: " + q3.getC() + "\n");
            result.write("Unsuccessful Probe Number: " + q3.getP() + "\n\n");

            /*
             Get the data for the Random Hash
             */
//            startBuild = System.currentTimeMillis();
            startBuild = System.nanoTime();
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                r.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            endBuild = System.currentTimeMillis();
            endBuild = System.nanoTime();
            buildTime = (endBuild - startBuild);
            for (String xp : success) {
                String line[] = xp.split("\t");
                r2.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            suc = System.currentTimeMillis();
            suc = System.nanoTime();
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                r3.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
//            unsuc = System.currentTimeMillis();
            unsuc = System.nanoTime();
            result.write("\nRandom:\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n");
            result.write("Build table time: " + buildTime + "\n\n");
            result.write("Results Added to the table: " + peeps.size() + "\n");
            result.write("Average Insertion time: " + (buildTime / (long) peeps.size()) + "\n");
            result.write("Number of Collisions: " + r.getC() + "\n");
            result.write("Number of Probes: " + r.getP() + "\n");
            result.write("Number of Collisions Vs Number of insertions:  %\n\n");
            result.write("Successful Table Size: " + success.size() + "\n");
            result.write("Successful insertion time: " + (suc - endBuild) + "\n");
            result.write("Successful Collision Number: " + r2.getC() + "\n");
            result.write("Successful Probe Number: " + r2.getP() + "\n\n");
            result.write("Unsuccessful Table Size: " + unsuccess.size() + "\n");
            result.write("Unsuccessful insertion time: " + (unsuc - suc) + "\n");
            result.write("Unsuccessful Collision Number: " + r3.getC() + "\n");
            result.write("Unsuccessful Probe Number: " + r3.getP() + "\n\n");

            /*
             Get the data for the LinkedList Hash
             */
//            startBuild = System.currentTimeMillis();
            startBuild = System.nanoTime();
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                hash.put(line[3], new Person(line[0], line[1], line[2], line[3]));
            }
//            endBuild = System.currentTimeMillis();
            endBuild = System.nanoTime();
            buildTime = (endBuild - startBuild);
            for (String xp : success) {
                String line[] = xp.split("\t");
                hash2.put(line[3], new Person(line[0], line[1], line[2], line[3]));
            }
//            suc = System.currentTimeMillis();
            suc = System.nanoTime();
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                hash3.put(line[3], new Person(line[0], line[1], line[2], line[3]));
            }
//            unsuc = System.currentTimeMillis();
            unsuc = System.nanoTime();
            result.write("\nLinkedList:\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n");
            result.write("Build table time: " + buildTime + "\n\n");
            result.write("Results Added to the table: " + peeps.size() + "\n");
            result.write("Average Insertion time: " + ((buildTime / (long) peeps.size()) * 100) + "\n");
            result.write("Number of Collisions: " + hash.getC() + "\n");
            result.write("Number of Collisions Vs Number of insertions:  %\n\n");
            result.write("Successful Table Size: " + success.size() + "\n");
            result.write("Successful insertion time: " + (suc - endBuild) + "\n");
            result.write("Successful Collision Number: " + hash2.getC() + "\n");
            result.write("Unsuccessful Table Size: " + unsuccess.size() + "\n");
            result.write("Unsuccessful insertion time: " + (unsuc - suc) + "\n");
            result.write("Unsuccessful Collision Number: " + hash3.getC() + "\n");
            result.write("Average List Size:  (number of insertions / (number of insertions -" + hash.getC() + "))\n");
            result.flush();
            result.close();
        }
    }
}
