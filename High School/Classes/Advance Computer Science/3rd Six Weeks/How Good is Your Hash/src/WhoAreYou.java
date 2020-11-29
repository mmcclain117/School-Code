
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WhoAreYou {

    public static void main(String[] args) throws Exception {
        double a[] = {.1, .5, .8, .9, .99};
        for (int pl = 0; pl < a.length; pl++) {
            int aa = (int) (50000 * (1 + (1 - a[pl]))); // Size of the table
            int collision = 1;
            HashTable hash = new HashTable(); // Creating Linkedlist hashtable
            Quad q = new Quad(aa); // Creating Quadratic 
            Linear l = new Linear(aa); // Create linear Hashtable
            Rand r = new Rand(aa); // Creates random hashtable
//        Scanner scan = new Scanner(new File("sampleperson.txt")); // Sample Scanner
            Scanner scan = new Scanner(new File("Large Data Set.txt")); // Large data Scanner
            Scanner succ = new Scanner(new File("Successful Search Records.txt")); // Successful file scanner
            Scanner wrong = new Scanner(new File("Unsuccessful Search Records.txt")); // Unsuccessful File Scanner
//            Scanner s = new Scanner(System.in);
            long startBuild = 1;
            long endBuild = 0; // Build table end
            long suc = 0;
            long unsuc = 0;
            int insertion = 0;
            ArrayList<String> peeps = new ArrayList();
            ArrayList<String> success = new ArrayList();
            ArrayList<String> unsuccess = new ArrayList();
            startBuild = System.currentTimeMillis();
            while (scan.hasNext()) {
                String xp = scan.nextLine();
                peeps.add(xp);
                String line[] = xp.split("\t"); // Scans the people in
                hash.put(line[3], new Person(line[0], line[1], line[2], line[3])); // Puts in linkedList Hashtable
                q.put(line[3], new Person(line[0], line[1], line[2], line[3])); // puts in quadratic hashtable
                l.put(line[3], new Person(line[0], line[1], line[2], line[3])); // puts in linear hashtable
                r.put(line[3], new Person(line[0], line[1], line[2], line[3])); // Puts in Random hashtable 
            }
            scan.close();
            endBuild = System.currentTimeMillis();
            while (succ.hasNext()) {
                String xp = succ.nextLine();
                success.add(xp);
                String line[] = xp.split("\t");
                hash.get(line[3]);
                q.get(line[3]);
                l.get(line[3]);
                r.get(line[3]);
            }
            suc = System.currentTimeMillis();
            succ.close();
            while (wrong.hasNext()) {
                String xp = wrong.nextLine();
                unsuccess.add(xp);
                String line[] = xp.split("\t");
                hash.get(line[3]);
                q.get(line[3]);
                l.get(line[3]);
                r.get(line[3]);
            }
            wrong.close();
            unsuc = System.currentTimeMillis();
            /**
             * Need to Edit all output
             *
             */
            File f = new File("new Folder");
            f.mkdir();
            FileWriter result = new FileWriter(new File(f + "\\Result" + pl + ".txt"));
            result.write("Linear:\n");
            result.write("Size of the Table: " + aa + "\n");
            result.write("Unsuccessful search time: " + (unsuc - suc) + "\n");
            result.write("Successful search time: " + (suc - endBuild) + "\n");
            result.write("Build table time: " + (endBuild - startBuild) + "\n");

            result.flush();
            result.close();
        }
    }
}
