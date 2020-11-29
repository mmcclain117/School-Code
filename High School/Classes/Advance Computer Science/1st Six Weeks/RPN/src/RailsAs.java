
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

public class RailsAs {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("rails.txt"));
        while (scan.hasNext()) {
            ArrayStack as = new ArrayStack();
            ArrayStack copyas = new ArrayStack();
            String a = scan.nextLine();
            String y[] = a.split("\\s+");
            for (String u : y) {
                as.push(Double.parseDouble(u));
                copyas.push(Double.parseDouble(u));
            }
//            out.println(Arrays.toString(as.toStringA()));
//            out.println(a);
            if (as.size() == 1) {
            } else {
                boolean inc = false, dec = false;
                inc = increasing(as);
                dec = decreasing(copyas);
                out.println(inc || dec ? "Yes" : "No");
            }
        }
    }

    private static boolean increasing(ArrayStack as) {
        double temp = as.pop();
        while (!(as.size() == 0)) {
            double pop = as.pop();
            if (!(temp > pop)) {
                return false;
            } else {
                temp = pop;
            }
        }
        return true;
    }

    private static boolean decreasing(ArrayStack as) {
//        out.println(Arrays.toString(as.toStringA()));
        double temp = as.pop();
        while (!(as.size() == 0)) {
            double pop = as.pop();
            if (!(temp < pop)) {
                return false;
            } else {
                temp = pop;
            }
        }
        return true;
    }

}
