package Done;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Tomas {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("tomas.dat"));
        scan.nextLine();
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int se[] = new int[a];
            Arrays.fill(se, 1);
            if (a <= 3) {
                System.out.println("1");
            } else {
                for (int i = 3; i < se.length; i++) {
                    se[i] = se[i - 1] + se[i - 2] + se[i - 3];
                }
            }
            System.out.println(se[se.length - 1]);
        }
    }
}
