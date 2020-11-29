
import java.io.File;
import java.util.Scanner;

public class prob01 {

    public static void main(String[] args)
            throws Exception {
        Scanner scan = new Scanner(new File("prob01.txt"));

        System.out.println("Greetings, O Honorable " + scan.next() + " the Magnificent! "
                + "May I kiss your signet ring?");
    }

}
