
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master
 */
public class Greek {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob07.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int b = 0; b < a; b++) {
            String li = scan.nextLine();
            char ch[] = li.toCharArray();
            if (Character.isDigit(ch[0])) {
                dig(ch);
            } else {
                int score = 0;
                let(ch, score);
            }
        }
    }

    public static void dig(char n[]) {

    }

    public static void let(char n[], int count) {
        int a = n.length;
        int s = 0;
        for (int b = 0; a < b; b++) {
            switch (n[b]) {
                case 'P':
                    switch (n[b + 1]) {
                        case 'M':
                            count += 50000;
                            break;
                        case 'C':
                            count += 5000;
                            break;
                        case 'H':
                            count += 500;
                            break;
                        case 'D':
                            count += 50;
                            break;
                        case 'I':
                            count += 6;
                            break;
                    }
                    break;
                case 'M':
                    count += 10000;
                    break;
                case 'C':
                    count += 1000;
                    break;
                case 'H':
                    count += 100;
                    break;
                case 'D':
                    count += 10;
                    break;
                case 'I':
                    count += 1;
                    break;
            }
        }
        s = count;
        out.println(count);
        count = 0;
    }
}
