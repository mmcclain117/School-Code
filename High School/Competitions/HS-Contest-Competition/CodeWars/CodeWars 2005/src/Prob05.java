
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Text Me
//        Points: 5
        Scanner scan = new Scanner(new File("prob05.txt"));
        String s = scan.nextLine();
        String split[] = s.split("[ ]+");
        String codes[] = {"0", "@.?1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS7", "TUV8", "WXYZ9", "\n", " "};
        for (int i = 0; i < split.length; i++) {
            char ch[] = split[i].trim().toCharArray();
            int con = 1; // Counter
            int ind = getIndex(ch[0]); // Index at
            int las = 0; // Number of times pressed
            while (con < ch.length) { // Goes through current section
                int tmp = getIndex(ch[con]);
                if (tmp == ind) { // If press same button
                    las++;
                } else {
                    las %= codes[ind].length(); // To fix numbers over
                    System.out.print(codes[ind].charAt(las));
                    las = 0;
                    ind = getIndex(ch[con]);
                }
                con++; // Always moving one over
            }
            las %= codes[ind].length();
            System.out.print(codes[ind].charAt(las));
        }
    }

    /* Returns the index of character */
    private static int getIndex(char c) {
        int ind = 0;
        if (Character.isDigit(c)) {
            ind = c - '0';
        } else if (c == '*') {
            ind = 10;
        } else if (c == '#') {
            ind = 11;
        } else {
            ind = c - '0';
            System.out.println("IND: " + ind);
        }
        return ind;
    }
}
