
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
//        Problem: English Math
//        Points: 11
        Scanner scan = new Scanner(new File("prob11.txt"));
        String numbers[] = {"zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteenth", "fifteenth",
            "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twenty"};
        while (scan.hasNext()) {
            String fin = ""; // Equasion in normal
            String line = scan.nextLine();
            String split[] = line.split("[ ]+");
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("times")) {
                    fin += " * ";
                } else if (split[i].equals("divided-by")) {
                    fin += " / ";
                } else if (split[i].equals("plus")) {
                    fin += " + ";
                } else if (split[i].equals("minus")) {
                    fin += " - ";
                } else { // It is a number
                    for (int o = 0; o < numbers.length; o++) {
                        if (split[i].equals(numbers[o])) {
                            fin += o;
                            break;
                        }
                    }
                }
            }
            int answer = calculator(fin);
//            System.out.println("Equasion is " + fin);
            System.out.println(numbers[answer]);
        }
    }

    /* Calculates the equasion */
    private static int calculator(String fin) {
        String e[] = fin.split("[ ]+");// Spliting it up
        ArrayList<String> eq = new ArrayList<>();
        /* Adds e into equasion */
        for (int i = 0; i < e.length; i++) {
            eq.add(e[i]);
        }
//        System.out.println(Arrays.toString(eq.toArray()));
        while (eq.size() > 1) {

            /* Checking for Multiplication */
            for (int i = 1; i < eq.size(); i++) {
                if (eq.get(i).equals("*")) { // Multiplication
                    int a = Integer.parseInt(eq.remove(i - 1));
                    int b = Integer.parseInt(eq.remove(i));
                    eq.set(i - 1, (a * b) + ""); // Set operator equal to new number
//                    System.out.println(Arrays.toString(eq.toArray()));
                    i--;
                }
            }

            /* Checking for Division */
            for (int i = 1; i < eq.size(); i++) {
                if (eq.get(i).equals("/")) { // Division
                    int a = Integer.parseInt(eq.remove(i - 1));
                    int b = Integer.parseInt(eq.remove(i));
                    eq.set(i - 1, (a / b) + ""); // Set operator equal to new number
//                    System.out.println(Arrays.toString(eq.toArray()));
                    i--;
                }
            }

            /* Checking for Addition */
            for (int i = 1; i < eq.size(); i++) {
                if (eq.get(i).equals("+")) { // Addition
                    int a = Integer.parseInt(eq.remove(i - 1));
                    int b = Integer.parseInt(eq.remove(i));
                    eq.set(i - 1, (a + b) + ""); // Set operator equal to new number
//                    System.out.println(Arrays.toString(eq.toArray()));
                    i--;
                }
            }

            /* Checking for Subtraction */
            for (int i = 1; i < eq.size(); i++) {
                if (eq.get(i).equals("-")) { // Subtraction
                    int a = Integer.parseInt(eq.remove(i - 1));
                    int b = Integer.parseInt(eq.remove(i));
                    eq.set(i - 1, (a - b) + ""); // Set operator equal to new number
//                    System.out.println(Arrays.toString(eq.toArray()));
                    i--;
                }
            }
        }
        return Integer.parseInt(eq.get(0));
    }
}
