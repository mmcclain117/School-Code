
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob17 {

    public static void main(String[] args) throws Exception {
//        Problem: Airport Geography
//        Points: 15
        Scanner in = new Scanner(new File("airport.dat"));
        while (in.hasNext()) {
            String an = cut(in.nextLine()); // Airport Name
            String iata = cut(in.nextLine()); // IATA
            String loc = cut(in.nextLine()); // Location (City, State, Country)
            String lat = cut(in.nextLine()); // Latitude
            String lon = cut(in.nextLine()); // Longitude
            String rad = cut(in.nextLine()); // Radius
        }
//        Don't have all the code so will create as much as I do have
//        Missing the Airport.Dat file which is crutial
//        Equasions
//        Miles = 50.23 * Degrees Longitude
//        Miles = 60.07 * Degrees Latitude
        Scanner scan = new Scanner(new File("prob17.txt"));
        while (scan.hasNext()) {
            String s = scan.nextLine(); // Scan codes
            String split[] = s.split("[ ]+");
            String iad = split[0]; // IATA Departure
            String iaa = split[1]; // IATA Arrival
            String dti = split[2]; // Departure Time
            String sp = split[3]; // Average Speed
        }
//        Using a created map based on the Airport.dat file we can determine a path
//        Output is Departure Airport
//        Location of airport
//        Laditude and longitude
//        Crossing, Departing, or arriving
//        Bonus points for enter or exit instead of cross
    }

    /* Used to delimeter the input based on ":" icon */
    private static String cut(String s) {
        return s.substring(s.indexOf(":"));
    }
}
