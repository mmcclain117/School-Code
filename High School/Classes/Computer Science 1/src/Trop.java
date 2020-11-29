
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Trop {

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter(new File("Troops Count"));
        fw.write("925 416 Sentinel\n"
                + "0 3652 Sentinel Squad\n"
                + "1630 3688 Berserker\n"
                + "70 32560 Berserker Platoon\n"
                + "1095 3496 Decimator\n"
                + "19 30669 Decimator Platoon\n"
                + "715 10 Devastator\n"
                + "100 377 Devastator Platoon\n"
                + "50 202 Disruptor\n"
                + "500 5708 Disruptor Platoon\n"
                + "695 484 Shrine Platoon\n"
                + "1220 1214 Titan Platoon\n"
                + "1375 660 Specter Platoon\n"
                + "920 281 Hornet Platoon\n"
                + "965 391 Pyro Platoon\n"
                + "30 130 Bomba Squad\n"
                + "400 383 Bomba Platoon\n"
                + "185 183 Raider Platoon\n"
                + "515 215 Rhino Platoon\n"
                + "200 11931 Incineraptor\n"
                + "110 104698 Incineraptor Platoon\n"
                + "15 16155 Battlecruiser Squad");
        fw.flush();
        fw.close();
        Scanner scan = new Scanner(new File("Troops Count"));
        int sum = 3000000;
        ArrayList count = new ArrayList();
        ArrayList force = new ArrayList();
        LinkedList Name = new LinkedList();
        LinkedList amount = new LinkedList();
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            String c = scan.nextLine();
            int d = a * b;
            count.add(a);
            force.add(b);
            Name.add(c);
            amount.add(d);
            Collections.sort(amount);
            sum += d;
            out.println(a + "\t" + b + "\t" + c + "\t" + d);
        }
        out.println(Arrays.toString(amount.toArray()));
        out.println("\n" + sum);
    }
}
