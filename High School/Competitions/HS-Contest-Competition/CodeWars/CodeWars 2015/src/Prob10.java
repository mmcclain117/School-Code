
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: EBDIC
//        Difficulty: Medium
//        Subject: Brute Force, Switch
        Scanner scan = new Scanner(new File("prob10.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String c = scan.nextLine().trim();
            String b[] = c.split("\\s+");
            for (String d : b) {
                if (d.equals("40")) {
                    System.out.print(" ");
                } else if (d.equals("4B")) {
                    System.out.print(".");
                } else if (d.equals("6B")) {
                    System.out.print(",");
                } else if (d.equals("5A")) {
                    System.out.print("!");
                } else {
                    char w = d.charAt(0);
                    int number = 0;
                    number = Integer.parseInt(d.substring(1));
                    switch (w) {
                        case '8':
                            System.out.print((char) (number + 96));
                            break;
                        case '9':
                            System.out.print((char) (number + 105));
                            break;
                        case 'A':
                            System.out.print((char) (number + 113));
                            break;
                        case 'C':
                            System.out.print((char) (number + 64));
                            break;
                        case 'D':
                            System.out.print((char) (number + 73));
                            break;
                        case 'E':
                            System.out.print((char) (number + 81));
                            break;
                        default:
//                            System.out.print("OOPS");
                            break;
                    }
                }
            }
            System.out.println();
        }
    }
}
