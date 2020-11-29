
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob13 {

    private static final ArrayList<String> answers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
//        Problem: Non-Repeating Binary
//        Difficulty: Medium
//        Subject: Binary Strings, Finding
//        Points: 10
        Scanner scan = new Scanner(new File("prob13.txt"));
        String numb = scan.nextLine();
        int n = scan.nextInt();
        scan.close();
        findSolution(numb.substring(0, numb.length() - 1), 0, n);
        Collections.reverse(answers);
        for (String answer : answers) {
            System.out.println(answer);
        }
    }

    /* Checks if the Binary is repeating */
    private static boolean isRepeating(String a) {
        try {
            int curNumb = Integer.parseInt(a); // Current Number
            String binary = Integer.toBinaryString(curNumb); // Current Binary String
            for (int i = 0; i < binary.length(); i++) {
                char curChar = binary.charAt(i);
                if ((i % 2) == 0 && '1' != curChar) {
                    return false;
                } else if ((i % 2 == 1) && '0' != curChar) {
                    return false;
                }
            }
        } catch (NumberFormatException e) { // Needed 
            return false;
        }
        return true;
    }

    /* Reccursively find the solution */
    private static boolean findSolution(String numbers, int start, int subString) {
        if (subString == 0) {
            if (start == numbers.length()) { // Can be Done
                return true;
            } else if (start != numbers.length()) { // Can't Be Done
                return false;
            }
        }
        for (int end = start + 1; end <= numbers.length(); end++) {
            String curSubstring = numbers.substring(start, end);
            if (true == isRepeating(curSubstring)) {
                boolean recurrsive = findSolution(numbers, end, subString - 1);
                if (recurrsive) {
                    answers.add(curSubstring);
                    return true;
                }
            }
        }
        return false;
    }
}
