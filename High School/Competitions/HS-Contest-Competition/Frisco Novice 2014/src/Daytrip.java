
import java.util.*;
import java.io.*;

/**
 *
 * @author Master
 */
public class Daytrip {

    public static void main(String args[]) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("Tripper.txt"));
        int days = scan.nextInt();
        int price = 0;
        int num;
        for (int i = 1; i <= days; i++) {
            num = scan.nextInt();
            for (int x = 1; x <= num; x++) {
                price = price + scan.nextInt();
            }
        }
        int pound = price / 100;
        int pence = price % 100;
        if (pound < 35) {
            System.out.println("BUY SINGLE-USE TICKETS");
            int saving1 = 35 - pound;
            if (pence > 0) {
                saving1 = saving1 - 1;
            }
            int saving2 = 100 - pence;
            System.out.println("Expected savings: " + saving1 + " Pounds, " + saving2 + " Pence");
        } else if (pound > 35) {
            System.out.println("BUY THE TRAVELCARD");
            int saving1 = pound - 35;
            int saving2 = pence;
            System.out.println("Expected savings: " + saving1 + " Pounds, " + saving2 + " Pence");
        }
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("Tripper.txt");
        fw.write("5\n"
                + "6 500 250 400 250 220 500\n"
                + "3 250 250 250\n"
                + "1 550\n"
                + "3 100 100 100\n"
                + "2 250 175 ");
        fw.flush();
        fw.close();
    }
}
