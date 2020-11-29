
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Anagram
//        Points: 4
        Scanner scan = new Scanner(new File("prob04.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String s = scan.nextLine();
            String split[] = s.split("[\"]");
            String s1 = split[1].trim(); // String 1
            String s2 = split[3].trim(); // String 2
            String str = anagram(s1, s2) ? "" : " NOT";
            System.out.println("\"" + s1 + "\" is" + str + " an anagram of \"" + s2 + "\"");
        }
    }

    private static boolean anagram(String s1, String s2) {
        char ch1[] = s1.toLowerCase().replaceAll("[^a-z]+", "").toCharArray();
        Arrays.sort(ch1);
        char ch2[] = s2.toLowerCase().replaceAll("[^a-z]+", "").toCharArray();
        Arrays.sort(ch2);
        return Arrays.toString(ch1).equals(Arrays.toString(ch2));
    }
}
