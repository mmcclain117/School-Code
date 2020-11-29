
import java.io.File;
import java.io.FileWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Head_and_Tail {

    public static void main(String[] args) throws Exception {
        Write();
        Scanner scan = new Scanner(new File("I2.txt"));
        int a = scan.nextInt();
        for (int b = 0; b < a; b++) {
            int u = scan.nextInt();
            scan.nextLine();
            String s = scan.nextLine();
            int xu = 0;
            int TTT = 0;
            int TTH = 0;
            int THT = 0;
            int THH = 0;
            int HTT = 0;
            int HTH = 0;
            int HHT = 0;
            int HHH = 0;
            while (xu < 38) {
                switch (s.substring(xu, xu + 3)) {
                    case "TTT":
                        TTT++;
                        xu++;
                        break;
                    case "TTH":
                        TTH++;
                        xu++;
                        break;
                    case "THT":
                        THT++;
                        xu++;
                        break;
                    case "THH":
                        THH++;
                        xu++;
                        break;
                    case "HTT":
                        HTT++;
                        xu++;
                        break;
                    case "HTH":
                        HTH++;
                        xu++;
                        break;
                    case "HHT":
                        HHT++;
                        xu++;
                        break;
                    case "HHH":
                        HHH++;
                        xu++;
                        break;
                }
            }
            out.println(u + " " + TTT + " " + TTH + " " + THT + " " + THH + " " + HTT + " " + HTH + " " + HHT + " " + HHH);
        }
        scan.close();
    }

    public static void Write() throws Exception {
        FileWriter fw = new FileWriter("I2.txt");
        fw.write("4\n"
                + "1\n"
                + "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH\n"
                + "2\n"
                + "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT\n"
                + "3\n"
                + "HHTTTHHTTTHTHHTHHTTHTTTHHHTHTTHTTHTTTHTH\n"
                + "4\n"
                + "HTHTHHHTHHHTHTHHHHTTTHTTTTTHHTTTTHTHHHHT");
        fw.flush();
        fw.close();
    }
}
