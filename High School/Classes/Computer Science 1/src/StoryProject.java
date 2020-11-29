
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class StoryProject {

    public static void main(String args[]) throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the weather");
        String x = reader.nextLine();
        System.out.println("Favorite car");
        String x1 = reader.nextLine();
        System.out.println("Another person");
        String x2 = reader.nextLine();
        System.out.println("Enter a place");
        String x3 = reader.nextLine();
        System.out.println("Favorite number");
        int x4 = reader.nextInt();
        System.out.println("Number smaller than last");
        int x5 = reader.nextInt();
        if (x4 > x5) {
            System.out.println("Valid input");
        } else {
            System.out.println("invalid response");
        }
        System.out.println("Enter a number between 1 and 2");
        double x6 = reader.nextDouble();
        System.out.print("It was a " + x + " day in the town.");
        System.out.print("In the middle of the town there is a " + x1 + " .");
        System.out.print("going into the car you find there is a box on the passager side with " + x4 + " keys.");
        System.out.print("After going through " + x5 + " keys you get the correct one.");
        System.out.print("You drive away at " + (x6 * x4 * 2) + " Miles per hour");
        System.out.print("When you get to " + x3 + " you run out of gas.");
        System.out.print("Next you push the car to a gas station where " + x2 + " worked at.");
        System.out.print("After you get gas paying " + x2 + " $" + (x6 * x4) + " you leave and drive home");
    }
}
