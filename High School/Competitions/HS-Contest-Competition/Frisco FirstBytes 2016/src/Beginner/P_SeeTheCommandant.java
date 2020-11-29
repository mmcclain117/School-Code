package Beginner;

import java.util.Scanner;

/**
 *
 * @author Master
 */
public class P_SeeTheCommandant {

    public static void main(String args) {
        Scanner scan = new Scanner(System.in);
        int a1 = scan.nextInt();
        int a2 = scan.nextInt();
        int a3 = scan.nextInt();
        int a4 = scan.nextInt();
        int a5 = scan.nextInt();
        int sum = a1 + a2 + a3 + a4 + a5;
        if (sum >= 100) {
            System.out.println("You passed! " + sum + " points");
        } else {
            System.out.println("See the Commandant! " + sum + " points");
        }
    }
}
