
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob03 {

    public static void main(String[] args) throws Exception {
//        Problem: Word Scramble
//        Points: 3
        Scanner scan = new Scanner(new File("prob03.txt"));
        while (scan.hasNext()) {
            String line = scan.nextLine();
            char ch[] = line.toCharArray();
            /* Prints in reverse Order */
            for (int i = ch.length - 1; i >= 0; i--) {
                System.out.print(ch[i]);
            }
            System.out.println();
        }
    }

}
