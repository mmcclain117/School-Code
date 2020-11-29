
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Weight {

    public static void main(String args[]) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your weight on earth? ");
        double a = input.nextDouble();
        System.out.println(" ");
        System.out.println("1. Voltar");
        System.out.println("2.Krypton");
        System.out.println("3.Fertos");
        System.out.println("4.Servontos");
        System.out.print("Selection");
        int b = input.nextInt();
        System.out.println(" ");
        switch (b) {
            case 1:
                System.out.println("Your weight on Voltar would be " + (a * .091));
                break;
            case 2:
                System.out.println("Your weight on Krypton would be " + (a * .72));
                break;
            case 3:
                System.out.println("Your weight on Fertos would be " + (a * .865));
                break;
            case 4:
                System.out.println("Your weight on Servontos would be " + (a * 4.612));
                break;
            default:
                System.out.println("That is not a planet");
        }
    }
}
