
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class OddorEven {

    public static void main(String args[]) throws Exception {
        FileWriter fw = new FileWriter("Fine.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("5 ");
        bw.write("2 ");
        bw.flush();
        bw.close();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Number");
        int number = input.nextInt();
        System.out.println("the integer " + number);
        if (number % 2 == 0) {
            System.out.println(" is even");
        } else {
            System.out.println(" is odd");
        }
    }
}
