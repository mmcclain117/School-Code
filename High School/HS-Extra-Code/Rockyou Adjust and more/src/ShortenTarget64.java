
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShortenTarget64 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Stuff.txt"));
        String fin = "";
        ArrayList<Double> ar = new ArrayList();
        while (scan.hasNextLine()) {
            String temp = scan.nextLine();
            if (temp.contains("price")) {
                temp = temp.trim();
                temp = temp.substring(11, temp.length() - 2);
                fin += temp + "\n";
                ar.add(Double.parseDouble(temp));
            }
        }
        Collections.sort(ar);
        for (Double dx : ar) {
            System.out.println(dx);
        }
        FileWriter fw = new FileWriter(new File("Stuff 2.txt"));
        fw.write(fin);
        fw.flush();
        fw.close();
    }

}
