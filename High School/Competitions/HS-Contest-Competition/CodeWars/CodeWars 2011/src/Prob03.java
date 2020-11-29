
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob03.txt"));
        String s = scan.nextLine();
        while (scan.hasNext()) {
            s += " " + scan.nextLine();
        }
        s = s.replaceAll("[#]", "");
        int space = 0; // Counter for number of words
        int sum = 0; // Number of characters
        int index = 0;// Index of starting set
        String split[] = s.split("[ ]+");
        boolean first = true; // If first word
        for (int i = 0; i < split.length; i++) {
            space += 1; // Adding another word
            sum += split[i].length();
            if ((sum + space) > 30) {
                sum -= split[i].length();
                space--; // Removing a word
                if (first) { // If first word
                    space--; // No space at end of the line
                    first = false;
                }
                int lef = (30 - sum) / space; // Number per space
                int mor = (30 - sum) % space; // Number extra spaces
                for (; index < i - 1; index++) {
                    System.out.print(split[index]);
                    for (int q = 0; q < lef; q++) {
                        System.out.print(".");
                    }
                    if (mor > 0) {
                        System.out.print(".");
                        mor--;
                    }
                }
                System.out.println(split[i - 1]);
//                Reset the values
                space = 0;
                sum = split[i].length();
                index = i;
            }
        }
        /* Print out the last line */
        for (; index < split.length; index++) {
            System.out.println(split[index]);
        }

    }
}
