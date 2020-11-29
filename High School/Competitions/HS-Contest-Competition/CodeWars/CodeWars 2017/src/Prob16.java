
import java.util.*;
import java.io.*;

/**
 *
 * @author Ryan Talbot
 */
public class Prob16 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob16.txt"));

        int n = scan.nextInt();
        ArrayList<String> strings = new ArrayList<>();

        scan.nextLine();

        for (int i = 0; i < n; i++) {
            strings.add(scan.nextLine());
        }

        n = scan.nextInt();

        for (int x = 0; x < n; x++) {
            String string = scan.next();
            ArrayList<String> arr = new ArrayList<>(strings);

            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);

                for (String s : arr) {
                    if (s.contains(c + "")) {
                        arr.remove(s);
                        break;
                    }
                }
            }

            if (strings.size() - string.length() == arr.size()) {
                System.out.println(string + " can be formed.");
            } else {
                System.out.println(string + " CANNOT be formed.");
            }
        }
    }

}
