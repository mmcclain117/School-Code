package ND;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/* Not right at all */
public class Prob10 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob10.txt"));
        String str = scan.nextLine();
        String[] strs = str.split("[-+*=]");
        String ops[] = str.split("[0-9a-z]+");
        int nums[] = new int[strs.length - 1];
        System.out.println(Arrays.toString(strs));
        for (int i = 0; i < strs.length - 1; i++) { // The last String is in a different format
            nums[i] = convert(strs[i].trim());
        }
        String sentence[] = new String[nums.length + ops.length];
        String simpleSentence[] = new String[sentence.length];
        int con = 0;
        int j = 0;
        int k = 0;
        while (con < nums.length) {
            sentence[k] = nums[con] + "";
            k++;
            if (j < ops.length) {
                sentence[k] = ops[j];
            }
            con++;
            j++;
            k++;
        }
        con = 0;
        j = 0;
        boolean tMultiplying = false;
        int product = 1;
        System.out.println(Arrays.toString(sentence));
        while (con < sentence.length) {
            if (sentence[con] == null) {
                break;
            }
            if (sentence[con].length() > 0) { // For empty spots
                if (Character.isDigit(sentence[con].charAt(0))) {
                    if (!tMultiplying) {
                        simpleSentence[j] = sentence[con];
                        j++;
                    } else {
                        product *= Integer.parseInt(sentence[con]);
                    }
                } else {
                    if ("*".equals(sentence[con])) {
                        if (!tMultiplying) {
                            product *= Integer.parseInt(sentence[con - 1]);
                        }
                        tMultiplying = true;
                    } else {
                        if (product > 1) {
                            simpleSentence[--j] = product + "";
                            j++;
                            product = 1;
                        }
                        tMultiplying = false;
                        simpleSentence[j] = sentence[con];
                        j++;
                    }
                }
            }
            con++;
        }
        if (product > 1) // We still have to store a running multiplication
        {
            simpleSentence[--j] = product + "";
        }

        // Now just walk the simple sentence doing addition and subtraction
        boolean tAdd = true;
        Integer result = 0;
        for (con = 0; con < simpleSentence.length; con++) {
            if (simpleSentence[con] == null) {
                break;
            }
            if (sentence[con].length() > 0) { // For empty spots
                if (Character.isDigit(sentence[con].charAt(0))) {
                    if (Character.isDigit(simpleSentence[con].charAt(0))) { // Another precaution
                        if (tAdd) {
                            result += Integer.parseInt(simpleSentence[con]);
                        } else {
                            result -= Integer.parseInt(simpleSentence[con]);
                        }
                    }
                } else {
                    tAdd = !"-".equals(simpleSentence[con]);
                }
            }
        }

        // Recall that the final entry in strs is the output base in format ^base
        int Base = Integer.parseInt(strs[strs.length - 1].split("\\^")[1]);
        String Result = ConvertToBase(result, Base);
        System.out.println(result + "^" + Base);

    }

    private static int letterToNumber(char c) {
        int eq = (int) c; // Int equivolent for C
        if (eq >= 48 && eq <= 57) { // It is a number
            return eq - 48;
        } else if (eq >= 97 && eq <= 122) { // Lowercase Letter
            return eq - 87; // a = 10
        } else if (eq >= 65 && eq <= 90) {// Uppercase Letter
            return eq - 65; // Not valid letter
        } else {
            return -1; // Not valid
        }
    }

    private static char numberToLetter(int c) {
        if (c < 10) {
            return (char) (c + 48);
        } else if (c < 36) {
            return (char) (c + 87);
        } else {
            return '0'; // Not valid
        }
    }

    private static String invert(String s) {
        String t = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            t += s.charAt(i);
        }
        return t;
    }

    private static Integer convert(String s) {
        // Numbers come in the format number^base, so split the String
        String strs[] = s.replaceAll("\\^", "#").split("[#]+");
//        System.out.println(s.replaceAll("\\^", "#"));
//        System.out.println(Arrays.toString(strs));
        String number = strs[0];
        int numb = 0;
        int base = Integer.parseInt(strs[1]);
//         Convert base 10 right to left
        int exponent = 0;
        int place;
        for (int i = number.length() - 1; i >= 0; i--) {
            place = letterToNumber(number.charAt(i));
            for (int j = 0; j < exponent; j++) {
                place *= base;
            }
            exponent++;
            numb += place;
        }

        return numb;
    }

    /* Need to figure out what this does */
    private static String ConvertToBase(int numb, int base) {
        boolean neg = false; // Negative number
        String result;
        if (numb < 0) { // Negative Number
            numb *= -1;
            neg = true;
        }
        int PlaceValue = numb % base;
        int WorkingValue = numb / base;
        String invertedValue = numberToLetter(PlaceValue) + "";
        while (WorkingValue > 0) {
            PlaceValue = WorkingValue % base;
            WorkingValue /= base;
            invertedValue += numberToLetter(PlaceValue);
        }
        result = invert(invertedValue);
        if (neg) {
            result = "-" + result;
        }
        return result;
    }
}
