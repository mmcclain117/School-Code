
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
public class WhoAreYou3 {

    public static void main(String[] args) throws Exception {
        double a[] = {.1, .5, .8, .9, .99};
        for (int pl = 0; pl < a.length; pl++) {
            int aa = (int) (50000 * (1 + (1 - a[pl]))); // Size of the table
            HashTable hash = new HashTable(aa); // Creating Linkedlist hashtable
            Quad q = new Quad(aa); // Creating Quadratic 
            Linear l = new Linear(aa); // Create linear Hashtable
            Rand r = new Rand(aa); // Creates random hashtable
//        Scanner scan = new Scanner(new File("sampleperson.txt")); // Sample Scanner
            Scanner scan = new Scanner(new File("Large Data Set.txt")); // Large data Scanner
            Scanner succ = new Scanner(new File("Successful Search Records.txt")); // Successful file scanner
            Scanner wrong = new Scanner(new File("Unsuccessful Search Records.txt")); // Unsuccessful File Scanner
            long startBuild = 1;
            long endBuild = 0; // Build table end
            long suc = 0;
            long unsuc = 0;
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
            startBuild = System.currentTimeMillis();
//            out.println(peeps.get(0));
            for (String xp : peeps) {
                String line[] = xp.split("\t"); // Scans the people in
//                out.println(Arrays.toString(line));
                l.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4])); // Puts in linear Hashtable
            }
            endBuild = System.currentTimeMillis();
            int sucRes = 0; // Successful successful results
            int sucRes3 = 0; // Not found
            int sucRes2 = 0; // Unsuccessful successful results
            for (String xp : success) {
                String line[] = xp.split("\t");
                Person tem = l.get(line[4]);
//                out.println(line[2]);
                if (tem == null) {
                    sucRes3++;
                } else {
//                    out.println(sucRes);
                    if (tem.getNumber().equals(line[1])) {
                        sucRes++;
                    } else {
                        sucRes2++;
                    }
                }
            }
            int unsucRes = 0; // Successful Unsuccessful results
            int unsucRes2 = 0;  // unsuccessful results
            int unsucRes3 = 0; // Unsuccessful not found file
            suc = System.currentTimeMillis();
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                Person tem = l.get(line[3]);
                if (tem == null) {
                    unsucRes3++;
                } else {
                    if (tem.getNumber().equals(line[1])) {
                        unsucRes++;
                    } else {
                        unsucRes2++;
                    }
                }
            }
            unsuc = System.currentTimeMillis();
            result.write("Linear:\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n");
            result.write("Build table Size: " + (endBuild - startBuild) + "\n");
            result.write("Results Added to the table: \n"); // Have no clue
            result.write("Average Insertion time: \n"); // Need the other one
            result.write("Number of Collisions: " + l.getC() + "\n");
            result.write("Number of Collisions Vs Number of insertions:  %\n"); // Need the number of insertions
            result.write("Sucessful insertion time: " + (suc = endBuild) + "\n");
            result.write("Successful Successful insertion count: " + sucRes + "\n");
            result.write("Successful unSuccessful insertion count: " + sucRes2 + "\n");
            result.write("Successful not found count: " + sucRes3 + "\n");
            result.write("Unsuccessful insertion time: " + (unsuc - suc) + "\n");
            result.write("Unsucessful successful search count: " + unsucRes + "\n");
            result.write("Unsucessful Unsuccessful search count: " + unsucRes2 + "\n");
            result.write("Unsuccesful not there search count: " + unsucRes3 + "\n");
            /*
             Get the data for the Quadratic one
             */
            startBuild = System.currentTimeMillis();
            for (String xp : peeps) {
                String line[] = xp.split("\t"); // Scans the people in
                q.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4])); // Puts in linkedList Hashtable
            }
            endBuild = System.currentTimeMillis();
            sucRes = 0; // Successful results
            sucRes2 = 0; // Unsuccessful successful results
            sucRes3 = 0;
            for (String xp : success) {
                String line[] = xp.split("\t");
                Person tem = q.get(line[3]);
                if (tem == null) {
                    sucRes3++;
                } else {
//                    out.println(line[1] + " " + tem.getNumber());
                    if (tem.getNumber().equals(line[1])) {
                        sucRes++;
                    } else {
                        sucRes2++;
                    }
                }
            }
            unsucRes = 0; // Successful Unsuccessful results
            unsucRes2 = 0;  // unsuccessful results
            unsucRes3 = 0;
            suc = System.currentTimeMillis();
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                Person tem = q.get(line[3]);
                if (tem == null) {
                    unsucRes3++;
                } else {
//                    out.println(tem.getNumber() + " " + line[2]);
                    if (tem.getNumber().equals(line[1])) {
                        unsucRes++;
                    } else {
                        unsucRes2++;
                    }
                }
            }
            unsuc = System.currentTimeMillis();
            result.write("\nQuadratic :\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n");
            result.write("Build table Size: " + (endBuild - startBuild) + "\n");
            result.write("Results Added to the table: \n"); // Have no clue
            result.write("Average Insertion time: \n"); // Need the other one
            result.write("Number of Collisions: " + q.getC() + "\n");
            result.write("Number of Collisions Vs Number of insertions:  %\n"); // Need the number of insertions
            result.write("Sucessful insertion time: " + (suc = endBuild) + "\n");
            result.write("Successful Successful insertion count: " + sucRes + "\n");
            result.write("Successful unSuccessful insertion count: " + sucRes2 + "\n");
            result.write("Successful not found count: " + sucRes3 + "\n");
            result.write("Unsuccessful insertion time: " + (unsuc - suc) + "\n");
            result.write("Unsucessful successful search count: " + unsucRes + "\n");
            result.write("Unsucessful Unsuccessful search count: " + unsucRes2 + "\n");
            result.write("Unsuccesful not there search count: " + unsucRes3 + "\n");
            /*
             Get the data for the Random Hash
             */
            startBuild = System.currentTimeMillis();
            for (String xp : peeps) {
                String line[] = xp.split("\t"); // Scans the people in
                r.put(line[4], new Person(line[0] + line[1], line[2], line[3], line[4])); // Puts in linkedList Hashtable
            }
            endBuild = System.currentTimeMillis();
            sucRes = 0; // Successful results
            sucRes2 = 0; // Unsuccessful successful results
            sucRes3 = 0;
            for (String xp : success) {
                String line[] = xp.split("\t");
                Person tem = r.get(line[3]);
//                out.println(r.get(line[3]));
                if (tem == null) {
                    sucRes3++;
                } else {
                    if (tem.getNumber().equals(line[1])) {
                        sucRes++;
                    } else {
                        sucRes2++;
                    }
                }
            }
            unsucRes = 0; // Successful Unsuccessful results
            unsucRes2 = 0;  // unsuccessful results
            unsucRes3 = 0;
            suc = System.currentTimeMillis();
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                Person tem = r.get(line[3]);
//                out.println(tem);
                if (tem == null) {
                    unsucRes3++;
                } else {
//                    out.println(unsucRes2);
                    if (tem.getNumber().equals(line[2])) {
                        unsucRes++;
                    } else {
                        unsucRes2++;
                    }
                }
            }
            unsuc = System.currentTimeMillis();
            result.write("\nRandom :\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n");
            result.write("Build table Size: " + (endBuild - startBuild) + "\n");
            result.write("Results Added to the table: \n"); // Have no clue
            result.write("Average Insertion time: \n"); // Need the other one
            result.write("Number of Collisions: " + r.getC() + "\n");
            result.write("Number of Collisions Vs Number of insertions:  %\n"); // Need the number of insertions
            result.write("Sucessful insertion time: " + (suc = endBuild) + "\n");
            result.write("Successful Successful insertion count: " + sucRes + "\n");
            result.write("Successful unSuccessful insertion count: " + sucRes2 + "\n");
            result.write("Successful not found count: " + sucRes3 + "\n");
            result.write("Unsuccessful insertion time: " + (unsuc - suc) + "\n");
            result.write("Unsucessful successful search count: " + unsucRes + "\n");
            result.write("Unsucessful Unsuccessful search count: " + unsucRes2 + "\n");
            result.write("Unsuccesful not there search count: " + unsucRes3 + "\n");
            /*
             Get the data for the LinkedList Hash
             */
            startBuild = System.currentTimeMillis();
            for (String xp : peeps) {
                String line[] = xp.split("\t"); // Scans the people in
                hash.put(line[3], new Person(line[0], line[1], line[2], line[3])); // Puts in linkedList Hashtable
            }
            endBuild = System.currentTimeMillis();
            sucRes = 0; // Successful results
            sucRes2 = 0; // Unsuccessful successful results
            for (String xp : success) {
                String line[] = xp.split("\t");
                Person tem = hash.get(line[3]);
                if (tem.getNumber().equals(line[2])) {
                    sucRes++;
                } else {
                    sucRes2++;
                }
            }
            unsucRes = 0; // Successful Unsuccessful results
            unsucRes2 = 0;  // unsuccessful results
            suc = System.currentTimeMillis();
            for (String xp : unsuccess) {
                String line[] = xp.split("\t");
                Person tem = hash.get(line[3]);
                if (tem.getNumber().equals(line[1])) {
                    unsucRes++;
                } else {
                    unsucRes2++;
                }
            }
            unsuc = System.currentTimeMillis();
            result.write("\nLinkedList:\n");
            result.write("Table size: " + aa + "\n");
            result.write("Load Factor I think: " + a[pl] + "\n");
            result.write("Build table Size: " + (endBuild - startBuild) + "\n");
            result.write("Results Added to the table: \n"); // Have no clue
            result.write("Average Insertion time: \n"); // Need the other one
            result.write("Number of Collisions: " + hash.getC() + "\n");
            result.write("Number of Collisions Vs Number of insertions:  %\n"); // Need the number of insertions
            result.write("Sucessful insertion time: " + (suc = endBuild) + "\n");
            result.write("Successful Successful insertion count: " + sucRes + "\n");
            result.write("Successful unSuccessful insertion count: " + sucRes2 + "\n");
            result.write("Successful not found count: " + sucRes3 + "\n");
            result.write("Unsuccessful insertion time: " + (unsuc - suc) + "\n");
            result.write("Unsucessful successful search count: " + unsucRes + "\n");
            result.write("Unsucessful Unsuccessful search count: " + unsucRes2 + "\n");
            result.write("Unsuccesful not there search count: " + unsucRes3 + "\n");
            result.write("Average List Size:  (number of insertions / (number of insertions -" + hash.getC() + "))\n"); // Only for open hashes
            result.flush();
            result.close();
        }
    }
}
