
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Master Ward
 */
/* RPN  Calculator */
public class Prob12 {

    public static void main(String[] args) throws Exception {
//        Problem: HP Calculator / RPN Calculator
//        Points: 13
        Scanner scan = new Scanner(new File("prob12.txt"));
//        System.out.println(scan.hasNext());
        String s = scan.nextLine();
        Stack<String> num = new Stack(); // Equasion
        while (!(s.equals("END"))) {
            String q[] = s.split("[ ]+"); // Temperary
            for (int i = 0; i < q.length; i++) {
                if (q[i].equals("+")) {
                    double a1 = Double.parseDouble(num.pop());
                    double a2 = Double.parseDouble(num.pop());
                    double tmp = a2 + a1;
                    num.add(tmp + "");
                } else if (q[i].equals("-")) {
                    double a1 = Double.parseDouble(num.pop());
                    double a2 = Double.parseDouble(num.pop());
                    double tmp = a2 - a1;
                    num.add(tmp + "");
                } else if (q[i].equals("*")) {
                    double a1 = Double.parseDouble(num.pop());
                    double a2 = Double.parseDouble(num.pop());
                    double tmp = a2 * a1;
                    num.add(tmp + "");
                } else if (q[i].equals("/")) {
                    double a1 = Double.parseDouble(num.pop());
                    double a2 = Double.parseDouble(num.pop());
                    double tmp = a2 / a1;
                    num.add(tmp + "");
                } else {
                    num.add(q[i]);
                }
//                System.out.println(Arrays.toString(num.toArray()));
            }
            System.out.println(num.pop());
            s = scan.nextLine().trim();
        }
    }
}
