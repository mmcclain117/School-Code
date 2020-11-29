
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class WordLadder {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("input.txt"));
        Scanner sc = new Scanner(new File("dictionary.txt"));
        HashSet<String> dictionary = new HashSet<>();// dictionary
        while (sc.hasNext()) { // adds dictionary words to a HashSet called diction
            dictionary.add(sc.nextLine());
        }
        while (scan.hasNext()) {
            String start = scan.next();
            String end = scan.next();
            boolean finish = false;
            HashSet<String> used = new HashSet(); // Used Words
            used.add(start);
            LinkedList LOS = new LinkedList(); // LinkedList of the stacks 
            LinkedList xx = new LinkedList(); // One for first one to add to the linkedList
            xx.add(start);
            LOS.add(xx);
            while (!finish) {

                if (LOS.size() == 0) {
                    finish = true;
                    out.println("There is no word ladder between " + start + " " + end + "!");
                }
                LinkedList tempTop = (LinkedList) LOS.dequeue(); // Temperary LinkedList
                if ((tempTop.peek()).equals(end)) { // If the last word is the end
                    ArrayList<String> answer = new ArrayList();
                    for (int i = tempTop.size() - 1; i > -1; i--) {
                        answer.add(tempTop.get(i).toString());
                    }
                    out.println(answer);
                    break;
                } else {
//                    Come up with all the words in the dictionary that are one letter apart from the top one of temperary
//                    Create a new LinkedList of it and put it at the end
                }
            }
        }
    }
}
