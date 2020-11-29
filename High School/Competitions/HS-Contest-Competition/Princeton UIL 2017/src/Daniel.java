
import java.util.*;
import java.io.*;

public class Daniel {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("daniel.dat"));

        while (scan.hasNextLine()) {
            String string = scan.nextLine();

            String[] split = string.split(" ");

            int idx = 0;
            for (int i = 0; i < 6; i++) {
                //if(idx == arr.length) break;
                String s = split[i + idx++ + 1] + " ";
                s.trim();

            }
        }
    }

}
