
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob15 {

    public static void main(String[] args) throws Exception {
//        Problem: Queueing Theory
//        Points: 9
        Scanner scan = new Scanner(new File("prob15.txt"));
        int d = scan.nextInt(); // Length of String
        int n = scan.nextInt(); // Number of requests
        scan.nextLine();
        String que[] = new String[n]; // Queue Strings
        String queN[] = new String[n]; // Queue Numbers
        char ch[] = new char[d]; // Queue
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            String split[] = s.split("[ ]+");
            String qLine = split[0]; // Queue Line
            queN[i] = qLine;
            que[i] = split[1] + " " + split[2];
            /* Replacing the words */
//            int sI = Integer.parseInt(split[1]); // Start Index
//            String word = split[2]; // The word
//            char tmp[] = word.toCharArray();
//            for (int p = 0; p < word.length(); p++) {
//                ch[sI + p] = tmp[p];
//            }
        }
        String x = scan.nextLine(); // The Queue Orders
        String splitting[] = x.split("[ ]+");
        for (int i = 0; i < splitting.length; i++) { // Goes through the last line of queues
            String tmp = splitting[i];
            for (int o = 0; o < queN.length; o++) { // Traverses the queue Numbers
                if (tmp.equals(queN[o])) { // Same queue
                    queN[o] = ""; // Erase it
                    String split[] = que[o].split("[ ]+");
                    int sI = Integer.parseInt(split[0]); // Start Index
                    String word = split[1]; // The word
                    char tmper[] = word.toCharArray(); // Temperary Array
                    for (int p = 0; p < word.length(); p++) {
                        ch[sI + p] = tmper[p];
                    }
//                    System.out.println(Arrays.toString(ch));
                    break;
                }
            }
        }
        for (int i = 0; i < ch.length; i++) {
            if (Character.isAlphabetic(ch[i])) {
                System.out.print(ch[i]);
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
//        System.out.println(Arrays.toString(ch));
    }
}
