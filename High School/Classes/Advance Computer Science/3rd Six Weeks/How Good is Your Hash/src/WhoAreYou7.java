
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

public class WhoAreYou7 {

    public static void main(String[] args) throws Exception {
        double a[] = {.1, .5, .8, .9, .99};
        File f = new File("new Folder");
        f.mkdir();
        FileWriter result = new FileWriter(new File(f + "\\Result.txt"));
        for (int pl = 0; pl < a.length; pl++) {
            int aa = (int) (50000 * (1 + (1 - a[pl]))); // Size of the table
            result.write("Test #" + (pl + 1) + ":\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n\n");
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
            result.write("Linear\n");
            double co = 0;
            startBuild = System.nanoTime();
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                l.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                l.get(line[4]);
            }
            endBuild = System.nanoTime();
            long buildTime = (endBuild - startBuild);
            int probe = l.getP();
            co = (double) l.getC();
            result.write("Big Data Test:\n");
            result.write("Insertion Time: " + buildTime + "\n");
            result.write("Table Size: " + peeps.size() + "\n");
            result.write("Average Insertion time: " + (buildTime / (long) peeps.size()) + "\n"); // Need the other one
            result.write("Collisions Number: " + co + "\n");
            result.write("Probe Number: " + probe + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + (co / (double) peeps.size()) + " %\n\n");
            for (String xp : success) {
                String line[] = xp.split("\t");
                l2.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : success) {
                String line[] = xp.split("\t");
                l2.get(line[4]);
            }
            suc = System.nanoTime();
            result.write("Successful Test:\n");
            result.write("Table Size: " + success.size() + "\n");
            result.write("Insertion Time: " + (suc - endBuild) + "\n");
            result.write("Average Insertion time: " + ((suc - endBuild) / (long) success.size()) + "\n"); // Need the other one
            result.write("Collision Number: " + l2.getC() + "\n");
            result.write("Probe Number: " + (l2.getP() - probe) + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) l2.getC() / (double) success.size()) + " %\n\n");
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                l3.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                l3.get(line[4]);
            }
            unsuc = System.nanoTime();
            result.write("Unsuccessful Test:\n");
            result.write("Table Size: " + unsuccess.size() + "\n");
            result.write("Insertion time: " + (unsuc - suc) + "\n");
            result.write("Average Insertion time: " + ((unsuc - suc) / (long) unsuccess.size()) + "\n"); // Need the other one
            result.write("Collision Number: " + l3.getC() + "\n");
            result.write("Probe Number: " + (l3.getP() - probe) + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) l3.getC() / (double) unsuccess.size()) + " %\n\n\n");

            /*
             Get the data for the Quadratic one
             */
            result.write("Quadratic\n");
            startBuild = System.nanoTime();
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                q.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                q.get(line[4]);
            }
            endBuild = System.nanoTime();
            buildTime = (endBuild - startBuild);
            probe = q.getP();
            result.write("Big Data Test:\n");
            result.write("Insertion Time: " + buildTime + "\n");
            result.write("Table Size: " + peeps.size() + "\n");
            result.write("Average Insertion time: " + (buildTime / (long) peeps.size()) + "\n"); // Need the other one
            result.write("Collisions Number: " + q.getC() + "\n");
            result.write("Probe Number: " + probe + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) q.getC() / (double) peeps.size()) + " %\n\n");
            for (String xp : success) {
                String line[] = xp.split("\t");
                q2.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : success) {
                String line[] = xp.split("\t");
                q2.get(line[4]);
            }
            suc = System.nanoTime();
            result.write("Successful Test:\n");
            result.write("Table Size: " + success.size() + "\n");
            result.write("Insertion Time: " + (suc - endBuild) + "\n");
            result.write("Average Insertion time: " + ((suc - endBuild) / (long) success.size()) + "\n"); // Need the other one
            result.write("Collision Number: " + q2.getC() + "\n");
            result.write("Probe Number: " + (q2.getP() - probe) + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) q2.getC() / (double) success.size()) + " %\n\n"
            );
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                q3.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                q3.get(line[4]);
            }
            unsuc = System.nanoTime();
            result.write("Unsuccessful Test:\n");
            result.write("Table Size: " + unsuccess.size() + "\n");
            result.write("Insertion time: " + (unsuc - suc) + "\n");
            result.write("Average Insertion time: " + ((unsuc - suc) / (long) unsuccess.size()) + "\n"); // Need the other one
            result.write("Collision Number: " + q3.getC() + "\n");
            result.write("Probe Number: " + (q3.getP() - probe) + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) q3.getC() / (double) unsuccess.size()) + " %\n\n\n");
            /*
             Get the data for the Random Hash
             */
            result.write("Random\n");
            startBuild = System.nanoTime();
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                r.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                r.get(line[4]);
            }
            endBuild = System.nanoTime();
            buildTime = (endBuild - startBuild);
            probe = r.getP();
            result.write("Big Data Test:\n");
            result.write("Insertion Time: " + buildTime + "\n");
            result.write("Table Size: " + peeps.size() + "\n");
            result.write("Average Insertion time: " + (buildTime / (long) peeps.size()) + "\n"); // Need the other one
            result.write("Collisions Number: " + r.getC() + "\n");
            result.write("Probe Number: " + probe + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) r.getC() / (double) peeps.size()) + " %\n\n");
            for (String xp : success) {
                String line[] = xp.split("\t");
                r2.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : success) {
                String line[] = xp.split("\t");
                r2.get(line[4]);
            }
            suc = System.nanoTime();
            result.write("Successful Test:\n");
            result.write("Table Size: " + success.size() + "\n");
            result.write("Insertion Time: " + (suc - endBuild) + "\n");
            result.write("Average Insertion time: " + ((suc - endBuild) / (long) success.size()) + "\n"); // Need the other one
            result.write("Collision Number: " + r2.getC() + "\n");
            result.write("Probe Number: " + (r2.getP() - probe) + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) r2.getC() / (double) success.size()) + " %\n\n");
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                r3.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                r3.get(line[4]);
            }
            unsuc = System.nanoTime();
            result.write("Unsuccessful Test:\n");
            result.write("Table Size: " + unsuccess.size() + "\n");
            result.write("Insertion time: " + (unsuc - suc) + "\n");
            result.write("Average Insertion time: " + ((unsuc - suc) / (long) unsuccess.size()) + "\n"); // Need the other one
            result.write("Collision Number: " + r3.getC() + "\n");
            result.write("Probe Number: " + (r3.getP() - probe) + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) r3.getC() / (double) unsuccess.size()) + " %\n\n\n");

            /*
             Get the data for the LinkedList Hash
             */
            result.write("LinkedList\n");
            startBuild = System.nanoTime();
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                hash.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : peeps) {
                String line[] = xp.split("\t");
                hash.get(line[4]);
            }
            endBuild = System.nanoTime();
            double con = 0;
//            double sum = 0;
            for (int i = 0; i < hash.arr.length; i++) {
                try {
                    int u = hash.arr[i].size();
                    if (u != 0) {
                        con++;
//                        sum += u;
                    }
                } catch (NullPointerException e) {
                }
            }
//            out.println(con + " "+ sum);
//            out.println();
            buildTime = (endBuild - startBuild);
//            probe = hash.getP();
            result.write("Big Data Test:\n");
            result.write("Insertion Time: " + buildTime + "\n");
            result.write("Table Size: " + peeps.size() + "\n");
            result.write("Average Insertion time: " + (buildTime / (long) peeps.size()) + "\n"); // Need the other one
            result.write("Collisions Number: " + hash.getC() + "\n");
            result.write("Probe Number: " + probe + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) unsuccess.size() / (double) (unsuccess.size() - hash.getC())) + " %\n\n");
//            result.write("Average List Length: " + (sum / con) + "\n");
            result.write("Average List Length: " + ((double) peeps.size() / con) + "\n");
            for (String xp : success) {
                String line[] = xp.split("\t");
                hash2.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : success) {
                String line[] = xp.split("\t");
                hash2.get(line[4]);
            }
            suc = System.nanoTime();
            result.write("Successful Test:\n");
            result.write("Table Size: " + success.size() + "\n");
            result.write("Insertion Time: " + (suc - endBuild) + "\n");
            result.write("Collision Number: " + hash2.getC() + "\n");
//            result.write("Probe Number: " + (hash2.getP() - probe) + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) unsuccess.size() / (double) (unsuccess.size() - hash2.getC())) + " %\n\n");
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                hash3.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4]));
            }
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                hash3.get(line[4]);
            }
            unsuc = System.nanoTime();
            result.write("Unsuccessful Test:\n");
            result.write("Table Size: " + unsuccess.size() + "\n");
            result.write("Insertion time: " + (unsuc - suc) + "\n");
            result.write("Collision Number: " + hash3.getC() + "\n");
//            result.write("Probe Number: " + (hash3.getP() - probe) + "\n");
            result.write("Number of Collisions Vs Number of insertions: " + ((double) unsuccess.size() / (double) (unsuccess.size() - hash3.getC())) + " %\n\n\n");
        }
        result.flush();
        result.close();
    }
}
