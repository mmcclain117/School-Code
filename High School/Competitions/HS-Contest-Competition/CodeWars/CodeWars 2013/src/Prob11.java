
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
//        Problem: Room For An Arguement
//        Points: 5
        Scanner scan = new Scanner(new File("prob11.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine();
            String split[] = b.split("[ ]+");
//            System.out.println(Arrays.toString(split));
            for (int o = 0; o < split.length; o++) {
                if (split[o].equals("is")) {
//                    System.out.println("Made it here with " + split[o + 1] + " next");
                    if (split[o + 1].contains("not")) { // Removes Not
                        System.out.print("is");
                        o++;
                        if (o + 1 == split.length) { // Taking care of periods
                            System.out.print(".");
                        } else {
                            System.out.print(" ");
                        }
                    } else { // Adds Not
                        System.out.print("is not ");
                    }
                } else {
                    System.out.print(split[o] + " ");
                }
            }
            System.out.println();
        }
    }
}
