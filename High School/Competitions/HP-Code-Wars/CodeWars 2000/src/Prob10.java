
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Don't really care about the format */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: Undo Arithmetic
//        Points: 11
        Scanner scan = new Scanner(new File("prob10.txt"));
        ArrayList<Double> tasks = new ArrayList();
        double f = scan.nextDouble(); // Adds first value
        tasks.add(f);
        scan.nextLine();
        System.out.println(f + "\t\t" + f);
        while (scan.hasNext()) {
            String s = scan.nextLine().trim();
            if (s.equals("UNDO")) {
                tasks.remove(tasks.size() - 1);
            } else {
                String split[] = s.split("[ ]");
                if (split.length == 1) {
                    tasks.add(Double.parseDouble(split[0]));
                } else {
                    String oper = split[0]; // Operator
                    double val = Double.parseDouble(split[1]);
                    double lasVal = tasks.get(tasks.size() - 1);
                    /* Do the operation */
                    switch (oper) {
                        case "*":
                            lasVal *= val;
                            break;
                        case "-":
                            lasVal -= val;
                            break;
                        case "+":
                            lasVal += val;
                            break;
                        case "/":
                            lasVal /= val;
                            break;
                    }
                    tasks.add(lasVal);
                }
            }
            System.out.printf("%8s\t%10.7f\n", s, tasks.get(tasks.size() - 1));
        }
    }
}
