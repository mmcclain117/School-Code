

import java.util.Scanner;
import java.io.*;

/*
 *
 *@author Master Ward
 */
public class Prob11 {

    public static void main(String args[]) throws Exception {
//        Problem: Picking Teams
//        Points: 7
        Scanner scan = new Scanner(new File("prob11.txt"));
        int n = scan.nextInt();
        for (int k = 0; k < n; k++) {
            int a = scan.nextInt(); // Number of players
            int values[] = new int[a]; // Scores
            String names[] = new String[a]; // Names
            for (int i = 0; i < a; i++) {
                values[i] = scan.nextInt();
                names[i] = scan.nextLine();
            }
            int max = 0;
            int start = -1; // Starting point
            int end = -1; // Ending point
            for (int i = 0; i < a; i++) {
                if (values[i] >= 0) {
                    int tmpMax = 0;
                    int tmpI = i;
                    while (values[tmpI] >= 0) {
                        tmpMax += values[tmpI];
                        tmpI++;
                        if (tmpI == a) { // Going past end of array
                            tmpI--;
                            break;
                        }
                    }
                    if (start == -1) { // No max set and max is zero
                        max = tmpMax;
                        start = i;
                        end = tmpI - 1; // For some reason there is an extra
                    } else if (tmpMax == max) { // Same
                        if (end - start < tmpI - i) { // Check if have more people
                            max = tmpMax;
                            start = i;
                            end = tmpI;
                        }
                    } else if (tmpMax > max) { // If there is another max
                        max = tmpMax;
                        start = i;
                        end = tmpI;
                    }
                    i = tmpI;
                }
            }
            /* Had to use trim to get rid of preciding spaces */
            if (start == -1) { // No one found
                System.out.println("None");
            } else if (start == end) { // only one player
                System.out.println(names[start].trim());
            } else { // More than one player
                System.out.println(names[start].trim() + " to " + names[end].trim());
            }
        }
    }
}
