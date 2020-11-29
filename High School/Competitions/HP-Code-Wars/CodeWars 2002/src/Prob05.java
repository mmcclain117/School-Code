
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Unique Word Count
//        Points: 4
        Scanner scan = new Scanner(new File("prob05.txt"));
        HashSet<String> hs = new HashSet(); // Unique Words
        while (scan.hasNext()) {
            String line = scan.nextLine();
            line = line.replaceAll("[,.?!:;]+", " "); // Removes extranious characters
            line = line.toLowerCase(); // Makes sure case isn't a problem
            String words[] = line.split("[ ]+");
            for (String s : words) {
                hs.add(s);
            }
        }
//        System.out.println(Arrays.toString(hs.toArray()));
        System.out.println("There are " + hs.size() + " unique words");
    }
}
