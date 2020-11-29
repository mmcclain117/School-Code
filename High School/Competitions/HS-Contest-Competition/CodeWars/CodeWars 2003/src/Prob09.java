
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: What's My Score?
//        Points: 10
        Scanner scan = new Scanner(new File("prob09.txt"));
        int gcon = 0; // Game Counter
        String sep = "-------------------------------------------------------------"; // Seperator
        System.out.println(" Game       1    2    3    4    5    6    7    8    9     10");
        System.out.println(sep);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            char ch[] = s.toCharArray();
            String top = "|       |"; // Top Line
            String mid = "|       |----|----|----|----|----|----|----|----|----|------|"; // Middle line
            String bot = "|Game " + gcon + " |"; // Bottom line
            int con = 0; // Counter
            int sum = 0; // Score
            int frame = 0; // Frame counter
            while (con < ch.length - 1) {
//              10th Frame
                if (frame == 9) {
                    if (ch[con] == 'X') {
                        top += " X|";
                        con++;
                        top += ch[con] + "|" + ch[con + 1] + "|";
                    } else if (ch[con + 1] == '/') {
                        top += " " + ch[con] + "|" + ch[con + 1] + "|" + ch[con + 2] + "|";
                    } else {
                        top += " " + ch[con] + "|" + ch[con + 1] + "| |";
                    }
                    break;
                }
                if (ch[con] == 'X') {
                    top += "  |X|";
                } else {
                    top += " " + ch[con] + "|" + ch[con + 1] + "|";
                    con++;
                }
                con++;
                frame++;
            }
            /* Calculate the scores */
            int k = 0; // Counter for scores
            int scores[] = new int[10];
            try {
                for (int i = 0; i < ch.length - 1; i++) {
//                 The 10th Frame
                    if (k == 10) {
                        break;
//                    if (ch[i] == 'X') { // Get a strike
//                        k--;
//                        scores[k] += 10;
//                        i++;
//                        if (ch[i] == 'X') { // 2nd strike
//                            scores[k] += 10;
//                            i++;
//                            if (ch[i] == 'X') { // Three Strikes
//                                scores[k] += 10;
//                            } else { // XX9
//                                scores[k] += ch[i] - '0';
//                            }
//                        } else { // Get a scores
//                            scores[k] += ch[i] - '0';
//                            i++;
//                            if (ch[i] == '/') {
//                                scores[k] += 10;
//                            } else {
//                                scores[k] += ch[i] - '0';
//                            }
//                        }
//                    } else { // Number
//                        scores[k] += ch[i] - '0';
//                        i++;
//                        if (ch[i] == '/') { // Spare
//                            scores[k] = 10;
//                            i++;
//                            if (ch[i] == 'X') {
//                                scores[k] += 10;
//                            } else {
//                                scores[k] += ch[i] - '0';
//                            }
//                        } else { // Done on 2
//                            scores[k] += ch[i] - '0';
//                        }
//                    }
                    }
                    // First Bowl
                    if (ch[i] == 'X') {
                        scores[k] += 10;
                        if (i + 2 < ch.length) { // two more left
                            if (ch[i + 2] == '/') {
                                scores[k] += 10;
                            } else if (ch[i + 1] == 'X') { // Has Strike Next
                                scores[k] += 10;
                                if (ch[i + 2] == 'X') {
                                    scores[k] += 10;
                                } else {
                                    scores[k] += ch[i + 2] - '0';
                                }
                            } else {
                                scores[k] += ch[i + 1] - '0';
                                scores[k] += ch[i + 2] - '0';
                            }
                        } else if (i + 1 < ch.length) { // One left
                            if (ch[i + 1] == 'X') {
                                scores[k] += 10;
                            } else {
                                scores[k] += ch[i + 1] - '0';
                            }
                        }
//                    i++;
                    } else {
                        scores[k] += ch[i] - '0';
                        i++;
                        if (ch[i] == '/') {
                            scores[k] = 10;
                            if (i + 1 < ch.length) {
                                if (ch[i + 1] == 'X') {
                                    scores[k] += 10;
                                } else {
                                    scores[k] += ch[i + 1] - '0';
                                }
                            }
                        } else {
                            scores[k] += ch[i] - '0';
                        }
                    }
                    k++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("That doesn't work");
            }
//            System.out.println(Arrays.toString(scores));

//            System.out.println();
            if (gcon != 0) { // Middle seperator
                System.out.println("|" + sep.substring(2) + "|");
            }
            System.out.println(top);
            System.out.println(mid);
            System.out.print(bot);
            int cumSum = 0;// Cumulative Sum
            for (int i = 0; i < scores.length - 1; i++) {
                cumSum += scores[i];
                System.out.printf("%4s%s", cumSum, "|");
            }
            cumSum += scores[scores.length - 1];
            System.out.printf("%6s%s\n", cumSum, "|");
//            System.out.println(sep);
            gcon++;
        }
        System.out.println(sep);
    }
}
