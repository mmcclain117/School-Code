
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob06.txt"));
        String result = "";
        String value1 = scan.next(); // First Value
        int numb1 = RomanToNumber(value1); // First Value
        String operator = scan.next(); // Operator
        String value2 = scan.next(); // Second Value
        int numb2 = RomanToNumber(value2); // Second Value
        switch (operator.charAt(0)) {
            case '+':
                result = numberToRoman(numb1 + numb2);
                break;
            case '-':
                result = numberToRoman(numb1 - numb2);
                break;
            case '*':
                result = numberToRoman(numb1 * numb2);
                break;
            case '/':
                result = numberToRoman(numb1 / numb2);
                break;
        }
        System.out.println("The result is: " + result);
    }

    /* Convert Roman Numeral to Number */
    private static int RomanToNumber(String roman) {
        int number = 0;  // Arabic numeral equivalent of the part of the string that has been converted so far.
        int con = 0; // String index
        while (con < roman.length()) {
            char letter = roman.charAt(con);
            int curNumb = letterToNumber(letter); // Current Number
            con++;
            if (con == roman.length()) { //Reaches the end
                number += curNumb;
            } else { // Checks for nextNumber being bigger
                int nextNumb = letterToNumber(roman.charAt(con)); // Preceding Letter
                if (nextNumb > curNumb) { // Combines Letters and moves on
                    number += (nextNumb - curNumb);
                    con++;
                } else { // Add value of cur letter to number
                    number += curNumb;
                }
            }
        }
        return number;
    }

    /* Convert Number to Roman Numeral */
    private static String numberToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"};
        String roman = "";
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman += letters[i];
                num -= values[i];
            }
        }
        return roman;
    }

    /* Finds integer value for letter */
    private static int letterToNumber(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
