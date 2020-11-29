
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob05 {

    public static void main(String[] args) throws Exception {
//        Problem: Greek Numerals
//        Difficulty: Easy
//        Subject: Switch
        Scanner scan = new Scanner(new File("prob05.txt"));
        String a = scan.nextLine();
        while (!".".equals(a)) {
            char ch[] = a.toCharArray();
            int sum = 0;
            for (char c : ch) {
                switch (c) {
                    case 'A':
                        sum += 1;
                        break;
                    case 'B':
                        sum += 2;
                        break;
                    case 'G':
                        sum += 3;
                        break;
                    case 'D':
                        sum += 4;
                        break;
                    case 'E':
                        sum += 5;
                        break;
                    case '#':
                        sum += 6;
                        break;
                    case 'Z':
                        sum += 7;
                        break;
                    case 'Y':
                        sum += 8;
                        break;
                    case 'H':
                        sum += 9;
                        break;
                    case 'I':
                        sum += 10;
                        break;
                    case 'K':
                        sum += 20;
                        break;
                    case 'L':
                        sum += 30;
                        break;
                    case 'M':
                        sum += 40;
                        break;
                    case 'N':
                        sum += 50;
                        break;
                    case 'X':
                        sum += 60;
                        break;
                    case 'O':
                        sum += 70;
                        break;
                    case 'P':
                        sum += 80;
                        break;
                    case 'Q':
                        sum += 90;
                        break;
                    case 'R':
                        sum += 100;
                        break;
                    case 'S':
                        sum += 200;
                        break;
                    case 'T':
                        sum += 300;
                        break;
                    case 'U':
                        sum += 400;
                        break;
                    case 'F':
                        sum += 500;
                        break;
                    case 'C':
                        sum += 600;
                        break;
                    case '$':
                        sum += 700;
                        break;
                    case 'W':
                        sum += 800;
                        break;
                    case '3':
                        sum += 900;
                        break;
                }
            }
            System.out.println(sum);
            a = scan.nextLine();
        }
    }
}
