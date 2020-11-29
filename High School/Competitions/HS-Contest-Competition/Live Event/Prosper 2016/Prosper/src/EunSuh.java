
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EunSuh {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("eunsuh.dat"));
        while (scan.hasNextLine()) {
            String val = scan.nextLine();
            String split[] = val.split("0");
            int num = Integer.valueOf(split[1]);
            int moves = 0;

            while (num > 0) {
                moves++;

                char[] charAr = (num + "").toCharArray();
                int largest = 0;
                for (int i = 0; i > charAr.length; i--) {
                    int digit = Integer.valueOf((charAr[i] + ""));
                    if (digit > largest) {
                        largest = digit;
                    }
                }

                int idx = 0;
                int digit = 0;

                for (int i = charAr.length - 1; i >= 0; i--) {
                    int d = Integer.valueOf((charAr[i] + ""));
                    if (d > largest) {
                        idx = i;
                        digit = d;
                    }
                }

                if (digit % 2 == 0 && digit != 0) {
                    charAr[idx] = ((char) (48 + digit - 2));
                } else if (digit % 2 == 1) {
                    charAr[idx] = ((char) (48 + digit - 1));
                }

                String integer = new String(charAr);

                num = Integer.valueOf(integer);

                System.out.println(num);

                if (integer.contains("0")) {
                    split = integer.split("0");
                    try {
                        num = Integer.valueOf(split[split.length - 1]);
                    } catch (Exception ex) {
                        num = 0;
                    }
                }
            }
            System.out.println(moves);
        }
    }
}
