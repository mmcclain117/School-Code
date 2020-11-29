
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
/**
 * Have the complete right code as it works up until the very end. TMP and
 * comment area fixes 2nd half of the problem *
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: Encryption Analyst
//        Points: 8
        Scanner scan = new Scanner(new File("prob08.txt"));
//        String fin = "";
        ArrayList<Integer> message = new ArrayList();
        while (scan.hasNext()) {
            String s = scan.nextLine();
            String split[] = s.split("[, ]+");
            for (int i = 0; i < split.length; i++) {
                message.add(Integer.parseInt(split[i]));
            }
        }
        for (int i = 0; i < 255; i++) { // Going through Keys
            String fin = "";
            int tmp = 0;
            for (int m = 0; m < message.size(); m++) {
//                if ((char)message.get(m).intValue() == ',') { // Helps to work a little
//                    tmp = 1;
//                }
                fin += (char) ((((i + tmp + m) & 0xFF) % 255 + message.get(m)) % 255);
            }
            if (fin.contains("CodeWars4")) {
                System.out.println("Encryption Key = 0x" + Integer.toHexString(i).toUpperCase());
                System.out.println(fin);
            }
        }
//        System.out.println(Arrays.toString(message.toArray()) + " "+ message.size());
    }
}
