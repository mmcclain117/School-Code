
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob04.txt"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            char ch[] = a.toCharArray();
            boolean len = a.length() >= 8;
            boolean uplo = false; // Uppercase && Lowercase
            int uplos = 0; // Up and Low Count
            boolean nusy = false; // Number || Symbol
            for (char c : ch) {
                if (Character.isDigit(c) || !Character.isLetterOrDigit(c)) {
                    nusy = true;
                }
                if (Character.isLetter(c) && !uplo) {
                    if (uplos == 1) {
                        if (Character.isUpperCase(c)) {
                            uplo = true;
                        }
                    } else if (uplos == 2) {
                        if (Character.isLowerCase(c)) {
                            uplo = true;
                        }
                    } else {
                        if (Character.isLowerCase(c)) {
                            uplos = 1;
                        } else if (Character.isUpperCase(c)) {
                            uplos = 2;
                        }
                    }
                }
            }
            int strength = 0;
            strength += len ? 1 : 0;
            strength += uplo ? 1 : 0;
            strength += nusy ? 1 : 0;
            String fin = strength == 0 ? "WEAK" : strength == 1 ? "ACCEPTABLE" : strength == 2 ? "GOOD" : "STRONG";
            System.out.println(fin);

        }
    }

}
