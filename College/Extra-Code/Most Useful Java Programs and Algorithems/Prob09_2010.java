
/*
 * Builds a grid containing word multipliers and determines the score
 * Tricks to solve:
 *          1. Java Arrays are zero based, word row and cols are 1 based.
 *          2. Helps to build searchable ArrayList of letter scores.
 *          3. Use NxN array to your advantage.
 */
import java.io.File;
import java.util.*;

/**
 *
 * @author Master Ward and Don Brace
 */
class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: Letter Scramble
//        Points: 7
        Scanner scan = new Scanner(new File("prob09.txt"));
        int i;
        int j;
        ArrayList<letter_value> lv = new ArrayList();
        int gridsize = scan.nextInt();
        String[][] scramble = new String[gridsize][gridsize];
//        Read in the grid
        for (i = 0; i < gridsize; i++) {
            for (j = 0; j < gridsize; j++) {
                String s = scan.next();
                scramble[i][j] = s;
            }
        }
//        Add in the String values
        lv.add(new letter_value("A", 1));
        lv.add(new letter_value("B", 3));
        lv.add(new letter_value("C", 3));
        lv.add(new letter_value("D", 2));
        lv.add(new letter_value("E", 1));
        lv.add(new letter_value("F", 4));
        lv.add(new letter_value("G", 2));
        lv.add(new letter_value("H", 4));
        lv.add(new letter_value("I", 1));
        lv.add(new letter_value("J", 8));
        lv.add(new letter_value("K", 5));
        lv.add(new letter_value("L", 1));
        lv.add(new letter_value("M", 3));
        lv.add(new letter_value("N", 1));
        lv.add(new letter_value("O", 1));
        lv.add(new letter_value("P", 3));
        lv.add(new letter_value("Q", 10));
        lv.add(new letter_value("R", 1));
        lv.add(new letter_value("S", 1));
        lv.add(new letter_value("T", 1));
        lv.add(new letter_value("U", 1));
        lv.add(new letter_value("V", 4));
        lv.add(new letter_value("W", 4));
        lv.add(new letter_value("X", 8));
        lv.add(new letter_value("Y", 4));
        lv.add(new letter_value("Z", 10));
//        Read in the words
        int numWords = scan.nextInt(); // Number of words
        for (i = 0; i < numWords; i++) {
            String word = scan.next();
            int row = scan.nextInt();
            int col = scan.nextInt();
            String orient = scan.next();
            j = CalculateWordScore(scramble, word, lv, row - 1, col - 1, orient);
            System.out.println(word + " " + j);
        }
    }

    /* Find letter in letter value ArrayList */
    static int LetterValue(ArrayList lv, String s) {
        for (int i = 0; i < lv.size(); i++) {
            letter_value l = (letter_value) lv.get(i);
            if (l.letter.equals(s)) {
                return l.value;
            }
        }
        return 0;
    }

    /*
	 * Calculate the word score 
	 *
	 * Start word in row = r, col = c. Follow orientation.
	 * if orientation is H (horiz.) increase row.
	 * if orientation is V (vert.) increase col.
	 * Note: This assumes you have converted row and col to 0-based.
     */
    static int CalculateWordScore(String[][] s, String w, ArrayList lv, int r, int c, String o) {
        int len = 0;
        int score = 0;
        int lscore = 0;
        int word_multiplier = 1;

        while (len < w.length()) {
            String l = w.substring(len, len + 1);
            String g = s[r][c];
            lscore = LetterValue(lv, l);
            if (!g.equals("[]")) {
                int I = Integer.parseInt(g.substring(0, 1));
                if (g.contains("W")) {
                    word_multiplier *= I;
                } else {
                    lscore *= I;
                }
            }
            score += lscore;
            len++;
            if (o.equals("H")) {// Horizontal: increase Column
                ++c;
            } else { // Vertical: Increase row
                ++r;
            }
        }
        return score * word_multiplier;
    }

    /* Print out the grid */
    static void PrintGrid(String[][] s) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                System.out.print(s[i][j] + ' ');
            }
            System.out.println();
        }
    }
}

class letter_value { // Letter scores

    String letter;
    int value;

    letter_value(String s, int v) {
        letter = s;
        value = v;
    }
}
