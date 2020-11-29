
import java.io.File;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class Prob17 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob17.txt"));
        Map<String, ArrayList<Crate>> docks = new HashMap<>();
        ArrayList<ArrayList<Crate>> sentTrains = new ArrayList<>();
        ArrayList<Crate> queue = new ArrayList<>();
        docks.put("A", new ArrayList<>());
        docks.put("B", new ArrayList<>());
        docks.put("C", new ArrayList<>());
        String line = scan.nextLine();
        while (!line.equals("DONE")) {
            String cmd = line.substring(0, 4); // Command
            String split[] = line.split(" ");
            if (cmd.equals("RECV")) { // Add new Crate
                Crate c = new Crate(split[1], Integer.parseInt(split[2]));
                queue.add(c);
            } else if (cmd.equals("LOAD")) { // Loads onto docks
                Crate c = queue.remove(0);
                String dock = split[1]; // Letter at the end
                docks.get(dock).add(c);
            } else if (cmd.equals("XFER")) { // Transfers
                String a = split[1];
                String b = split[2];
                ArrayList<Crate> t = docks.get(a);
                Crate ac = t.get(t.size() - 1);
                docks.get(a).remove(t.size() - 1);
                docks.get(b).add(ac);
            } else if (cmd.equals("SEND")) { // Sends out train
                String d = split[1];
                sentTrains.add(docks.get(d));
                docks.put(d, new ArrayList<>());
            }
            line = scan.nextLine();
        }
        for (ArrayList<Crate> crates : sentTrains) {
            int index = sentTrains.indexOf(crates);
            System.out.println("VACTRAIN " + (index + 1));
            Collections.reverse(crates);
            for (int i = 0; i < crates.size(); i++) {
                Crate tmp = crates.get(i);
                System.out.println(tmp.name + " " + tmp.size);
            }
        }
    }

    public static class Crate {

        public String name;
        public int size;

        public Crate(String n, int s) {
            name = n;
            size = s;
        }
    }
}
