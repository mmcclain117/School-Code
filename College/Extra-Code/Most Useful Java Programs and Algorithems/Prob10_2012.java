
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Key: A - K(13); Spade = 1; Heart = 2; Diamond = 3; Clubs = 4 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: Card Counting
//        Points: 7
        Scanner scan = new Scanner(new File("prob10.txt"));
        int value[] = new int[53];
        int n = scan.nextInt(); // Number of lines
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String split[] = line.split("[ ]+");
            for (int o = 0; o < split.length; o++) {
                int pos = getValue(split[o]); // Position
                value[pos]++;
            }
        }
//        System.out.println(Arrays.toString(value));
        /* Check for missing cards */
        System.out.println("Missing cards:");
        String miss = ""; // Missing cards
        for (int i = 1; i < value.length; i++) {
            if (value[i] == 0) {
                miss += getCard(i) + " ";
//                System.out.print(i + " ");
            }
        }
        System.out.println(miss.trim());

        /* Check for duplicate cards */
        System.out.println("Extra cards:");
        String ext = ""; // Extra Cards
        for (int i = 1; i < value.length; i++) {
            if (value[i] > 1) {
                ext += getCard(i) + " (" + i + ") ";
//                System.out.print(i + " ");
            }
        }
        System.out.println(ext.trim());
    }

    private static int getValue(String string) {
        char number = string.charAt(0);
        char suits = string.charAt(1);
        int numb = 0;
        int suit = 0;
//        System.out.print("THE " + string + " IS EQUAL TO    ");
        switch (number) {
            case 'K': // King
                numb = 13;
                break;
            case 'Q': // Queen
                numb = 12;
                break;
            case 'J': // Jack
                numb = 11;
                break;
            case 'A': // Ace
                numb = 1;
                break;
            case '1': // Ten
                numb = 10;
                suits = string.charAt(2);
                break;
            default: // Number
                numb = (int) (number - '0');
                break;
        }
//        System.out.print("Number: " + numb);
        switch (suits) {
            case 'S': // Spades
                suit = 1;
                break;
            case 'H': // Hearts
                suit = 2;
                break;
            case 'D': // Diamonds
                suit = 3;
                break;
            case 'C': // Clubs
                suit = 4;
                break;
            default: // Not a suit
                break;
        }
//        System.out.println("\tSuit: " + suit);
//        System.out.println("The " + string + " is the " + ((numb - 1) * 4 + suit) + " position");
        return (numb - 1) * 4 + suit;
    }

    /* Return card based on int value */
    private static String getCard(int a) {
        int numb = (a / 4);
        int suit = a % 4;
        if (suit != 0) { // Take care of clubs problem
            numb++;
        }
        String fin = ""; // Final
//        System.out.println("\nThis " + numb + " " + suit + "\n");
        switch (numb) {
            case 13: // King
                fin += "K";
                break;
            case 12: // Queen
                fin += "Q";
                break;
            case 11: // Jack
                fin += "J";
                break;
            case 1: // Ace
                fin += "A";
                break;
            case 10: // Ten
                fin += "10";
                break;
            default: // Number
                fin += numb;
                break;
        }
        switch (suit) {
            case 1: // Spades
                fin += "S";
                break;
            case 2: // Hearts
                fin += "H";
                break;
            case 3: // Diamonds
                fin += "D";
                break;
            case 0: // Clubs
                fin += "C";
                break;
            default: // Not a suit
                break;
        }
        return fin;
    }
}
