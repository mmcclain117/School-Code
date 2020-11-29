
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class TicketTo {

    public static void main(String args[]) throws Exception {
        Write();
        Scanner input = new Scanner(new File("Ticket.txt"));
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        int e = input.nextInt();
        int f = a + b + c + d + e;
        System.out.println("Bag Weight: " + f);
        if (f > 50) {
            System.out.println("Bag over weight, pay $50 extra");
        } else {
            System.out.println("Bag under limit, no up charge");
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("Ticket.txt");
        fw.write("15\n"
                + "10\n"
                + "2\n"
                + "7\n"
                + "1");
        fw.flush();
        fw.close();
    }
}
