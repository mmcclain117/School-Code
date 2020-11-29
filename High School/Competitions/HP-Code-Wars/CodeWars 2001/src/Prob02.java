
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
//        Problem: Secret Code
//        Points: 2
        Scanner scan = new Scanner(new File("prob02.txt"));
        String line = scan.nextLine();
        while (!line.equals("end")) {
            line = line.replaceAll("Hewlett-Packard Company", "Compaq Computer Corperation");
            char ch[] = line.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                switch (ch[i]) {
                    case 'a':
                        System.out.print("*");
                        break;
                    case 'e':
                        System.out.print("$");
                        break;
                    case 'i':
                        System.out.print("#");
                        break;
                    case 'o':
                        System.out.print("!");
                        break;
                    case 'u':
                        System.out.print("%");
                        break;
                    case 'y':
                        System.out.print("^");
                        break;
                    case 'A':
                        System.out.print("*");
                        break;
                    case 'E':
                        System.out.print("$");
                        break;
                    case 'I':
                        System.out.print("#");
                        break;
                    case 'O':
                        System.out.print("!");
                        break;
                    case 'U':
                        System.out.print("%");
                        break;
                    case 'Y':
                        System.out.print("^");
                        break;
                    default:
                        System.out.print(ch[i]);
                        break;
                }
            }
            System.out.println();
            line = scan.nextLine();
        }
    }
}
