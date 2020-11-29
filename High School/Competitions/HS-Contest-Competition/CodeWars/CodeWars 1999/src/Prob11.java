
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    private static ArrayList<String> ar; // People in the room

    public static void main(String[] args) throws Exception {
//        Problem: Mission Possible
//        Points: 6
        Scanner scan = new Scanner(new File("prob11.txt"));
        ar = new ArrayList();
        while (scan.hasNext()) {
            String s = scan.nextLine();
            String split[] = s.split("[,]+"); // List of people
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains("<")) { // Removing someone
                    if (split[i].equals(" <Assignment>")) { // Removing first
                        ar.remove(0);
                    } else { // Removing person
                        String tmp = split[i].replaceAll("[<>]+", "").trim();
                        ar.remove(tmp);
                    }
                } else { // Adding person
                    ar.add(split[i].trim());
                }
            }
        }
        /* Prings out only 10 people in the room */
        for (int i = 0; i < ar.size() && i < 10; i++) {
            if (i + 1 == ar.size() || i == 9) { // Print last one
                System.out.println(ar.get(i) + "");
            } else { // Print other people in the room
                System.out.print(ar.get(i) + ", ");
            }
        }
    }

}
