
import static java.lang.System.out;
import java.util.Scanner;

public class Factors {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.print("Enter a Number: ");
        int num = scan.nextInt();
        while (num != 0) {
            int facamo = 0; // Number of factors
            int ar[] = new int[num];
            int con = 0;
            for (int i = num; i > 0; i--) {
                if (num % i == 0) {
                    ar[con] = i;
                    facamo++;
                    con++;
                }
            }
            out.print("There are " + (facamo - 2) + " factors for the number " + num + ": ");
            for (int i = num - 1; i > 0; i--) {
                if (!(ar[i] == 0 || ar[i] == 1 || ar[i] == num)) {
                    out.print(ar[i] + " ");
                }
            }
            out.print("\nEnter a Number:");
            num = scan.nextInt();
        }

    }
}
