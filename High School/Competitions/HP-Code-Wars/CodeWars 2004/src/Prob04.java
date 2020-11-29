
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob04 {

    public static void main(String[] args) throws Exception {
//        Problem: Time of Day
//        Points: 3
        Scanner scan = new Scanner(new File("prob04.txt"));
        int st = scan.nextInt(); // Start time
        int et = scan.nextInt(); // End time
        int lt = et - st; // Elapse Time

        /* Start Time */
        int sh = st / 3600; // Start Hour
        st %= 3600;
        int sm = st / 60; // Start Minute
        st %= 60;
        int ss = st; // Start Second
        String sap = "AM"; // Start AM/PM
        if (sh == 0) { // Midnight
            sh = 12;
        } else if (sh > 12) { // Afternoon
            sap = "PM";
            sh -= 12;
        } else if (sh == 12) { // It is noon
            sap = "PM";
        }
        System.out.printf("%2d:%2d:%2d %s\n", sh, sm, ss, sap);

        /* End time */
        int eh = et / 3600; // End Hour
        et %= 3600;
        int em = et / 60; // End Minute
        et %= 60;
        int es = et; // End Second
        String eap = ""; // End AM/PM
        if (eh == 0) { // Midnight
            eh = 12;
        } else if (eh > 12) { // Afternoon
            eap = "PM";
            eh -= 12;
        } else if (eh == 12) { // It is noon
            eap = "PM";
        }
        System.out.printf("%2d:%2d:%2d %s\n", eh, em, es, eap);

        /* Elapse Time  (Military Time) */
        int lh = lt / 3600; // Elapse Hour
        lt %= 3600;
        int lm = lt / 60; // Elapse Minute
        lt %= 60;
        int ls = lt; // Elapse Second
        System.out.printf("%2d:%2d:%2d\n", lh, lm, ls);

    }
}
