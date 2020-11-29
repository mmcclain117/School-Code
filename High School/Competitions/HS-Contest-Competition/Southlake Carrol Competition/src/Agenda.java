

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jacob
 */
public class Agenda {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("agenda.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            int s = scan.nextInt();
            String stime = scan.nextLine();
            int hour = Integer.parseInt(stime.substring(1, 3));
            hour += stime.contains("PM") ? 12 : 0;
            int min = Integer.parseInt(stime.substring(4, 6));
//            out.println(hour + " " + min);
            String line;
            do {
                line = scan.nextLine().trim();
                String jo[] = line.split("[,]");
                String yh[] = jo[1].split(" ");
//                out.println(Arrays.toString(yh));
                int amo = Integer.parseInt(yh[1]);
                String job = yh[2];
//                out.println(amo + " " + job);
//                out.println(amo);
                if (job.startsWith("MILE")) {
                    hour += amo / s;
                    amo %= s;
//                    out.println(amo);
                    min += amo == 0 ? 0 : 60 / (s / amo);
                } else if (job.startsWith("MINU")) {
                    min += amo;
                }
//                out.println(hour + " " + min);
            } while (!line.contains("GO HOME"));
//            out.println(hour + " "+ min);
            hour += min >= 60 ? min / 60 : 0;
            min %= 60;
            if (hour > 12) {
                hour -= 12;
                out.print("Joe will arrive home at ");
                if (hour < 10) {
                    out.print("0");
                    out.printf("%1d", hour);
                } else {
                    out.printf("%2d", hour);
                }
                out.print(":");
                if (min < 10) {
                    out.print("0");
                    out.printf("%1d", min);
                } else {
                    out.printf("%2d", min);
                }
                out.println(" PM");
            } else {
                out.print("Joe will arrive home at ");
                if (hour < 10) {
                    out.print("0");
                    out.printf("%1d", hour);
                } else {
                    out.printf("%2d", hour);
                }
                out.print(":");
                if (min < 10) {
                    out.print("0");
                    out.printf("%1d", min);
                } else {
                    out.printf("%2d", min);
                }
                out.println(" PM");
//                out.printf("%2.0f ", (double) min);
                out.println(" AM");
            }
        }
    }

    public static void attemptOne() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("agenda.dat"));
        int n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; n > i; i++) {
            int s = scan.nextInt();
            String li = scan.nextLine();
            String g[] = li.split("[ :]+");
            int hour = Integer.parseInt(g[1]);
            int min = Integer.parseInt(g[2]);
            hour += "AM" == g[3] ? 12 : 0;
            String line = "";
            while (!line.equals("GO HOME")) {
                line = scan.nextLine();
                out.println(line);
                String lival[] = line.split("[,]+");
                String val = lival[1];
                out.println(val);
                line = lival[0];
//                out.println(val);
                out.println(Arrays.toString(lival));
                String val2[] = val.split("[ ]");
                if ("MILES".equalsIgnoreCase(val2[2])) {
                    min += Integer.parseInt(val2[1]);
                } else if (val2[2].endsWith("Minutes")) {
//                    out.println(Arrays.toString(val2));
                    int tem = Integer.parseInt(val2[1]);
                    hour += tem / s;
                    min += 60 / (tem % s);
                } else {
                    out.println("this is failing    " + line);
                }
                out.println(hour + " " + min);
            }
        }
    }
}
