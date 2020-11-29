
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class B_ticketToRide {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Ticket.txt"));
        int a1 = scan.nextInt();
        int a2 = scan.nextInt();
        int a3 = scan.nextInt();
        int a4 = scan.nextInt();
        int a5 = scan.nextInt();
        int sum = a1 + a2 + a3 + a4 + a5;
        System.out.println("Bag Weight: " + sum);
        if (sum <= 50) {
            System.out.println("Bag under limit, no up charge");
        } else {
            System.out.println("Bag over weight, pay $50 extra");
        }
    }

}
