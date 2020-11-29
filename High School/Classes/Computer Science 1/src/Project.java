
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Project {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Techmania ,where we sell");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|          Computer          |               Ram         |           Memory         |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|all 30% off | all Computers |  0% off  | under $20      |   5% off | over $10      |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|            |               | 10% off  | over $20       | 20% off | over $30       |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|            |               | 15% off  | over $40       | 50% off | over $100      |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.print("Select a Category: ");
        String a = input.nextLine();
        System.out.print("Select a item: ");
        String c = input.nextLine();
        System.out.print("Select a price: $");
        double b = input.nextDouble();
        if (a.equalsIgnoreCase("Computer")) {
            if (c.equalsIgnoreCase("desktops")) {
                b = b - (b * .3);
                System.out.println("Sales price: $" + b);
            } else if (c.equalsIgnoreCase("laptop")) {
                b = b - (b * .2);
                System.out.println("Sales price: $" + b);
            } else {
                System.out.println("That is not in stock");
                System.out.println("Sales price: $" + b + (b * .3));
            }
        }
        if (a.equalsIgnoreCase("Ram")) {
            if (b < 20) {
                System.out.println("Sales price: $" + b);
            } else if (b >= 40) {
                b = b - (b * .4);
                System.out.println("Sales price: $" + b);
            } else {
                b = b - (b * .1);
                System.out.println("Sales price: $" + b);
            }
        }
        if (a.equalsIgnoreCase("Memory")) {
            if (b >= 10) {
                b = b - (b * .05);
                System.out.println("Sales price: $" + b);
            } else if (b >= 30) {
                b = b - (b * .2);
                System.out.println("Sales price: $" + b);
            } else if (b >= 100) {
                b = b - (b * .5);
                System.out.println("Sales price: $" + b);
            } else {
                System.out.println("Sales price: $" + b);
            }
        }
        double asd = (b * .05);
        asd = Math.round(asd);
        System.out.println("Tax: $" + asd);
        double xyz = b + asd;
        System.out.println("Total: $" + xyz);
    }
}
