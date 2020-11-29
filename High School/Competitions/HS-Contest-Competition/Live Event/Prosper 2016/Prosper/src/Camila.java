
import java.io.File;
import java.util.Scanner;

public class Camila {

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("camila.dat"));
        while (scan.hasNext()) {
            String name = scan.next();
            String name2 = "";
            name2 = name2 + name.substring(0, 1);
            int i = 1;
            while (i != name.length() && name2.length() != 4) {
                if (name.substring(i, i + 1).equalsIgnoreCase("B") || name.substring(i, i + 1).equalsIgnoreCase("B") || name.substring(i, i + 1).equalsIgnoreCase("F") || name.substring(i, i + 1).equalsIgnoreCase("P") || name.substring(i, i + 1).equalsIgnoreCase("V") && !(name.substring(i - 1, i).equalsIgnoreCase("B") || name.substring(i - 1, i).equalsIgnoreCase("f") || name.substring(i - 1, i).equalsIgnoreCase("p") || name.substring(i - 1, i).equalsIgnoreCase("v"))) {
                    name2 += "1";
                } else if (name.substring(i, i + 1).equalsIgnoreCase("C") || name.substring(i, i + 1).equalsIgnoreCase("G") || name.substring(i, i + 1).equalsIgnoreCase("J") || name.substring(i, i + 1).equalsIgnoreCase("K") || name.substring(i, i + 1).equalsIgnoreCase("Q") || name.substring(i, i + 1).equalsIgnoreCase("S") || name.substring(i, i + 1).equalsIgnoreCase("X") || name.substring(i, i + 1).equalsIgnoreCase("Z") && !(name.substring(i - 1, i).equalsIgnoreCase("C") || name.substring(i - 1, i).equalsIgnoreCase("G") || name.substring(i - 1, i).equalsIgnoreCase("J") || name.substring(i - 1, i).equalsIgnoreCase("K") || name.substring(i - 1, i).equalsIgnoreCase("Q") || name.substring(i - 1, i).equalsIgnoreCase("S") || name.substring(i - 1, i).equalsIgnoreCase("X") || name.substring(i - 1, i).equalsIgnoreCase("Z"))) {
                    name2 += "2";
                } else if (name.substring(i, i + 1).equalsIgnoreCase("D") || name.substring(i, i + 1).equalsIgnoreCase("T") && !(name.substring(i - 1, i).equalsIgnoreCase("D") || name.substring(i - 1, i).equalsIgnoreCase("T"))) {
                    name2 += "3";
                } else if (name.substring(i, i + 1).equalsIgnoreCase("L") && !(name.substring(i - 1, i).equalsIgnoreCase("L"))) {
                    if (!(name.substring(i - 1, i).equalsIgnoreCase("L"))) {
                        name2 += "4";
                    }
                } else if (name.substring(i, i + 1).equalsIgnoreCase("M") || name.substring(i, i + 1).equalsIgnoreCase("N") && !(name.substring(i - 1, i).equalsIgnoreCase("M") || name.substring(i - 1, i).equalsIgnoreCase("N"))) {
                    name2 += "5";
                } else if (name.substring(i, i + 1).equalsIgnoreCase("R") && !(name.substring(i - 1, i).equalsIgnoreCase("R"))) {
                    name2 += "6";
                }
                i++;

            }
            if (!(name2.length() == 4)) {
                name2 += "0";
            }
            System.out.println(name2);
        }
    }
}
