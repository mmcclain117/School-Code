
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

public class RPNCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String aa[] = a.split("\\s+");
        ArrayStack as = new ArrayStack();
        int sum = 1;
//        out.println(Arrays.toString(as.toStringA()));
        for (int i = 0; i < aa.length; i++) {
            if (aa[i].equalsIgnoreCase("+")) {
                sum += as.pop();
            } else if (aa[i].equalsIgnoreCase("-")) {
                sum -= as.pop();
            } else if (aa[i].equalsIgnoreCase("/")) {
                sum /= as.pop();
            } else if (aa[i].equalsIgnoreCase("*")) {
                sum *= as.pop();
            } else if (aa[i].equalsIgnoreCase("%")) {
                sum %= as.pop();
            } else {
                as.push(Double.parseDouble(aa[i]));
            }
        }
        out.println(sum);
        out.println(Arrays.toString(as.toStringA()));
    }

}
