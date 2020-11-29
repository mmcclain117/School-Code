
/**
 *
 * @author Master
 */
public class NewMain {

    public static void main(String[] args) {
//        This is commenting
        System.out.println("Hello World"); // Printing something out
        boolean x = true; // Declaring a boolean
        System.out.println("Boolean can store either true or false");
        System.out.println("Ints Store Whole Numbers from " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        int a = 0; // Making an int variable
//        ; end lines
        System.out.println("Doubles store decimal numbers from " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
        double b = 0.0;
        System.out.println("Char can store a single character");
        char c = 'a';
        System.out.println("Strings can store a length of words that are 255 in length");
        String ch = "";
        for (int i = 0; i < 255; i += 1) {
            ch += (char) i; // casting or changing a variable type to another
        }
        System.out.println(ch);
        System.out.println("Taking apart the for loop");
        System.out.println("for(Declares variable: loops while this statement is true; change the variable");
    }
}
