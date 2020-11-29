
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
class NumberOfStuff {

    NumberOfStuff(String n, String hn, int num) {
        name = n;
        hadName = hn;
        number = num;
    }
    String name;
    String hadName;
    int number;
}

public class Prob08 {

    public static String numbers[] = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE",
        "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN"
    }; // Numbers based on index

    public static void main(String[] args) throws Exception {
//        Problem: St. Ives
//        Points: 7
        ArrayList<NumberOfStuff> nos = new ArrayList<>(); // Collection of Stuff
        Scanner scan = new Scanner(new File("prob08.txt"));
        String word;
        String lastWord = "";
        String hasWord = "";
        int value;
        while (scan.hasNext()) { // Read Riddle
            word = scan.next();
            if (word.contains("?")) { // Is a question
                String howMany = word.substring(0, word.length() - 1); // Number of something
                System.out.println(getValue(nos, howMany) + " " + howMany);
                break;
            }
            if (word.equals("HAD")) {
                hasWord = lastWord;
            }
            value = getIntValue(word);
            if (value > 0) {
                word = scan.next();
                nos.add(new NumberOfStuff(hasWord, word, value));
            }
            lastWord = word;
        }
    }

    /* Returns int value of String */
    private static int getIntValue(String s) {
        for (int i = 0; i < numbers.length; i++) {
            if (s.equals(numbers[i])) {
                return i;
            }
        }
        return 0;
    }

    /* Get the value of Something (s) */
    private static int getValue(ArrayList<NumberOfStuff> v, String s) { // Backtrack
        int i; // Question word
        NumberOfStuff nos = null;
        for (i = 0; i < v.size(); i++) { // Look for ? word
            nos = v.get(i);
            if (nos.hadName.equals(s)) {
                break;
            }
        }
        int result = nos.number;
        String word = nos.hadName;
        for (int j = i - 1; j >= 0; j--) {
            nos = v.get(j);
            result *= nos.number;
        }
        return result;
    }
}
