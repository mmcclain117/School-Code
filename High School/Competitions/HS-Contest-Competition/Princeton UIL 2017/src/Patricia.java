
import java.util.*;
import java.io.*;

public class Patricia {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("patricia.dat"));

        int times = scan.nextInt();
        scan.nextLine();

        for (int t = 0; t < times; t++) {
            String s = scan.nextLine();
            System.out.println(s);
            String[] split = s.split(" ");

            System.out.println(Arrays.toString(split));

            if (split.length == 4) {
                int rolls = Integer.valueOf(split[0]);
                int amtRed = Integer.valueOf(split[1]),
                        amtGreen = Integer.valueOf(split[2]);

                switch (scan.next()) {
                    case "R":
                        System.out.println(amtRed + "/" + (amtRed + amtGreen));
                        break;
                    case "G":
                        System.out.println(amtGreen + "/" + (amtRed + amtGreen));
                }
            } else {
                int rolls = Integer.valueOf(split[0]);
                int amtRed = Integer.valueOf(split[1]),
                        amtGreen = Integer.valueOf(split[2]);
                String replace = scan.next();

                int prob = 0;

                switch (scan.next()) {
                    case "R":
                        prob += amtRed;
                        if (replace.equalsIgnoreCase("N")) {
                            amtRed--;
                        }
                    case "G":
                        prob += amtGreen;
                        if (replace.equalsIgnoreCase("N")) {
                            amtGreen--;
                        }
                }

                switch (scan.next()) {
                    case "R":
                        prob += amtRed;
                        System.out.println(prob + "/" + (replace.equalsIgnoreCase("N")
                                ? 90 : 100));
                    case "G":
                        prob += amtGreen;
                        System.out.println(prob + "/" + (replace.equalsIgnoreCase("N")
                                ? 90 : 100));
                }
            }
        }
    }

}
