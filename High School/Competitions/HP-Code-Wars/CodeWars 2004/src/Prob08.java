
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static int match[];

    public static void main(String[] args) throws Exception {
//        Problem: CSI Crime Lab
//        Points: 8
        Scanner scan = new Scanner(new File("prob08.txt"));
        String s = scan.nextLine(); // <Suspects>
        ArrayList<String> names = new ArrayList();
        s = scan.nextLine();
        ArrayList<String> dna = new ArrayList();
        while (!s.equals("<Scene>")) {
            String split[] = s.split("[:]+");
            names.add(split[0].trim());
            dna.add(split[1].trim());
            s = scan.nextLine();
        }
        match = new int[dna.size()]; // Number of matches per person
//        System.out.println(Arrays.toString(dna.toArray()));
        s = scan.nextLine();
        ArrayList<String> evi = new ArrayList();
        while (!s.equals("<END>")) {
            String split[] = s.split("[:]+"); // Spliting the line
            String more[] = split[1].split("[,]+"); // All the evidence
            for (String q : more) {
                evi.add(q.trim());
            }
            s = scan.nextLine();
        }
        /* Compare suspect to evidence */
        for (int i = 0; i < dna.size(); i++) {
            for (int o = 0; o < evi.size(); o++) {
                if (check(dna.get(i), evi.get(o))) {
                    match[i]++;
                }
            }
        }
        /* Gets the Person with Max */
        String suspect = "";
        int max = -1;
        for (int i = 0; i < match.length; i++) {
            if (match[i] > max) {
                suspect = names.get(i);
                max = match[i];
            }
        }
//        System.out.println(Arrays.toString(match));
        System.out.println("The suspect is: " + suspect);
    }

    /* Checks to see if String 1 contains String 2 */
    private static boolean check(String s1, String s2) {
        return s1.contains(s2);
    }
}
