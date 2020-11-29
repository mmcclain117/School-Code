

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob15 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob15.txt"));
        int a = scan.nextInt(); // number of input lines
        scan.nextLine();
        ArrayList<String> input = new ArrayList(a);
//        String input[] = new String[a];
        for (int i = 0; i < a; i++) { // Scan in input
            input.add(scan.nextLine());
        }
        int c = scan.nextInt(); // Number of changes
        scan.nextLine();
        for (int i = 0; i < c; i++) {
            String line = scan.nextLine();
            String split[] = line.split("[ ]+");
//            System.out.println(Arrays.toString(split));
            if (split[0].equals("d")) { // Deleting
                if (line.equals("d")) { // No line
                    input.remove(0);
                } else {
                    int numb = Integer.parseInt(split[1]) - 1;
                    if (numb > input.size()) {
                        input.remove(0);
                    } else {
                        input.remove(numb);
                    }
                }
            } else if (split[0].equals("a")) { // Adding (CHECK AGAIN (ADDING AFTER))
                int numb = Integer.parseInt(split[1]);
//                String tmp = input.get(numb);
//                tmp += line.substring(4);
                String tmp = line.substring(4);
//                input.set(numb, tmp);
                input.add(numb, tmp);
            } else { // Editing
                if (split[0].contains("/")) { // Editing all lines
                    String q[] = line.substring(2).split("/");
//                    System.out.println(Arrays.toString(q));
                    for (int p = 0; p < input.size(); p++) {
                        String tmp = input.get(p);
                        tmp = tmp.replaceAll(q[0], q[1]);
                        input.set(p, tmp);
                    }
                } else { // Editing one line
                    int numb = Integer.parseInt(split[0]) - 1;
                    String tmp = input.get(numb);
                    String q[] = line.substring(4).split("/");
//                    System.out.println(Arrays.toString(q));
                    tmp = tmp.replaceAll(q[0], q[1].trim());
                    input.set(numb, tmp);
                }
            }
        }
        /* Print out results */
        for (int i = 0; i < input.size(); i++) {
            System.out.println(input.get(i));
        }
    }
}
