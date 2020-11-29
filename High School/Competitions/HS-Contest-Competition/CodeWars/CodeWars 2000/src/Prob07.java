
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob07.txt"));
        String line = "";
        while (scan.hasNext()) {
            line = scan.nextLine();
            String split[] = line.split("\\s+");
            String fin = ""; // Final line
            for (int i = 0; i < split.length; i++) {
                String tmp;
                if (isVowel(split[i], 0)) {
                    /* If ends in punctuation */
                    boolean ends = !Character.isAlphabetic(split[i].charAt(split[i].length() - 1));
                    if (ends) {
//                        tmp = split[i].substring(1, split[i].length() - 1);
                        tmp = split[i].substring(0, split[i].length() - 1) + "pay" + split[i].charAt(split[i].length() - 1);
//                        tmp += split[i].substring(0, 1) + "pay" + split[i].charAt(split[i].length() - 1);
                    } else {
                        tmp = split[i].substring(0) + "pay";
                    }
                    if (isCap(split[i], 0)) {
//                        System.out.println(split[i]);
                        tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase();
                    }
                    fin += tmp + " ";
                } else {
                    int con = 0;
                    while (true) {
                        if (!isVowel(split[i], con)) {
//                            tmp += split[i].charAt(con);
                            con++;
                        } else {
                            break;
                        }
                    }
                    /* If ends in punctuation */
                    boolean ends = !Character.isAlphabetic(split[i].charAt(split[i].length() - 1));
                    if (ends) {
                        tmp = split[i].substring(con, split[i].length() - 1);
                        tmp += split[i].substring(0, con) + "ay" + split[i].charAt(split[i].length() - 1);
                    } else {
                        tmp = split[i].substring(con) + split[i].substring(0, con) + "ay";
                    }
                    if (isCap(split[i], 0)) {
//                    System.out.println(split[i]);
                        tmp = tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase();
                    }
                    fin += tmp + " ";
                }
            }
//            line = scan.nextLine();
            System.out.println(fin);
        }
    }

    /* Check if word starts with vowel */
    private static boolean isVowel(String line, int a) {
        char check = line.toLowerCase().charAt(a); // Check at index a
        return check == 'a' || check == 'e' || check == 'i' || check == 'o' || check == 'u' || check == 'y' || check == 'w';
    }

    /* Check if word starts with Capital Letter */
    private static boolean isCap(String line, int a) {
        return Character.isUpperCase(line.charAt(a));
    }
}
