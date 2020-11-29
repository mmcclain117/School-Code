
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class TimeTot {

    public static void main(String[] args) throws Exception { // Pool time Cal
        Scanner min = new Scanner(new File("Min.txt"));
        Scanner sec = new Scanner(new File("Sec.txt"));
        FileWriter fw = new FileWriter(new File("tot.txt"));
        for (int i = 0; i < 110; i++) {
            int total = (min.nextInt() * 60) + sec.nextInt();
            fw.write(total + "\n");
        }
        fw.flush();
        fw.close();
        sec.close();
        min.close();
    }
}
