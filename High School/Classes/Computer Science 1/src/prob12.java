
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class prob12 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob12-1-in.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        int b = a * a;
        double angle = 0;
        double c[] = new double[b + 1];
        int y = 0;
        for (int i = 0; a > i; i++) {
            String ss = scan.nextLine();
            String s[] = ss.split("[ ]+");
            for (; y < b; y++) {
                String yy = s[y % a];
                c[y] = Double.parseDouble(yy);
            }
        }
        double ui = 1.0;
        while (ui < b) {
            int u = 0;
            double ut = c[u];
            ui = c[u + 1];
            double ty = Math.hypot(ut, ui);
            double jo = Math.sin(ty / ty);
            angle = angle < jo ? jo : angle;
            ui++;
        }
        out.println(Math.toDegrees(angle));
    }
}
