
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Scanner in = new Scanner(new File("cows.txt"));
        ArrayList<String> dict = new ArrayList(); // List of all the cows
        // Put all of the cows into dictionary (Dict)
        Scanner scan = new Scanner(new File("prob09.txt"));
        String a = scan.nextLine();
        ArrayList<String> ar = new ArrayList<>();
        while (!a.equals("0")) {
            char c[] = a.toCharArray();
            /* Add the initial characters to arraylist */
            char ch[] = getLetter(c[0]); // For when it is empty
            for (int i = 0; i < ch.length; i++) {
                ar.add(ch[i] + "");
            }
            for (int i = 1; i < c.length; i++) {
                ch = getLetter(c[i]);
                ArrayList<String> tmp = new ArrayList();
                for (int o = 0; o < ch.length; o++) { // Cycling through letters
                    for (int p = 0; p < ar.size(); p++) { // ArrayList adding letters
                        tmp.add(ar.get(p) + ch[o]);
                    }
                }
                ar.clear();
                ar.addAll(tmp);
            }
            /* Narrow down to valid names */
//            for
            /* Cut out names that are too short */
            int con = 0;// Counter
            while (con < ar.size()) {
                if (ar.get(con).length() != a.length()) {
                    ar.remove(con);
                } else {
                    con++;
                }
            }

            /* Print out the possible names */
            System.out.print("Possible names for #" + a + " are: ");
            for (int i = 0; i < ar.size(); i++) {
                System.out.println(ar.get(i));
            }
            a = scan.nextLine();
        }
    }

    private static char[] getLetter(char c) {
        char ch[] = new char[3];
        switch (c) {
            case '2':
                ch[0] = 'A';
                ch[1] = 'B';
                ch[2] = 'C';
                break;
            case '3':
                ch[0] = 'D';
                ch[1] = 'E';
                ch[2] = 'F';
                break;
            case '4':
                ch[0] = 'G';
                ch[1] = 'H';
                ch[2] = 'I';
                break;
            case '5':
                ch[0] = 'J';
                ch[1] = 'K';
                ch[2] = 'L';
                break;
            case '6':
                ch[0] = 'M';
                ch[1] = 'N';
                ch[2] = 'O';
                break;
            case '7':
                ch[0] = 'P';
                ch[1] = 'R';
                ch[2] = 'S';
                break;
            case '8':
                ch[0] = 'T';
                ch[1] = 'U';
                ch[2] = 'V';
                break;
            case '9':
                ch[0] = 'W';
                ch[1] = 'X';
                ch[2] = 'Y';
                break;
            default:
                break;
        }
        return ch;
    }
}
