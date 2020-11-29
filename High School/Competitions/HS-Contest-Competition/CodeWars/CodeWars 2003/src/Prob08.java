
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
//        Problem: MP3 Organizer
//        Points: 8
        Scanner scan = new Scanner(new File("prob08.txt"));
        String t = scan.nextLine();
        String br = t.substring(t.indexOf("=") + 1); // Bitrate
        int speed = getSpeed(br);
        System.out.println("MP3 CD #1");
        System.out.println("------------------------");
        double tot = 0; // Total Size
        int cdNumb = 2; // CD number
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String split[] = line.split("[,]+");
            String artist = split[0];
            String album = split[1];
            String len = split[2]; // Album Length
            String form = split[3]; // Format
            int length = conTime(len.trim());
            double size = 0; // new File Size
            int nSpeed = getSpeed(form.trim()); // New FOrmat Speed
            size = nSpeed;
            size *= length; // Long song is
            if (nSpeed > speed) { // Convert only bigger
                size *= (double) speed / (double) nSpeed; // Converting
            }
            size /= 8000; // TO MB
            System.out.print(artist + "," + album + "," + len + ", ");
//            System.out.println("\n" + size + "");
            tot += size;
            size = Math.ceil(size);
            System.out.println((int) size + "MB");
            if (tot > 650) { // Has to go to Next CD
                System.out.println();
                System.out.println("Total: " + (int) tot + "MB");
                if (scan.hasNext()) {
                    System.out.println("MP3 CD #" + cdNumb);
                    System.out.println("------------------------");
                }
                cdNumb++;
                tot = 0;
            }
        }
        if (tot != 0) {
            tot = Math.ceil(tot);
            System.out.println();
            System.out.println("Total: " + (int) tot + "MB");
        }
    }

    /* Converts the length to seconds */
    private static int conTime(String len) {
        int min = Integer.parseInt(len.substring(0, len.indexOf(":")));
        int sec = Integer.parseInt(len.substring(len.indexOf(":") + 1));
        return (min * 60) + sec;
    }

    /* Gets the speed of Form */
    private static int getSpeed(String form) {
        if (form.contains("MP3")) { // If MP3 Parse it
            return Integer.parseInt(form.substring(4));
        } else if (form.equals("FLAC")) {
            return 700;
        } else if (form.equals("CD")) {
            return 1411;
        } else { // Just a number
            return Integer.parseInt(form);
        }
    }
}
