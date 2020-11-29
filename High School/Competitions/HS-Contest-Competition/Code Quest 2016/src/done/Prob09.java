package done;
import java.io.File;
import java.util.Scanner;
import static java.lang.Math.*;

public class Prob09 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob09.in.txt"));
		int a = scan.nextInt(); // Number of test Cases
		scan.nextLine();
		for (int p = 0; p < a; p++) {
			int z = scan.nextInt(); // Zooom Level
			double la = scan.nextDouble(); // Latitude
			double lo = scan.nextDouble(); // Longitude
			double x = abs(((lo + 180) / 360) * pow(2, z));
			int fx = (int) x; // Final X
			double y1 = tan(la * (PI / 180));
			// double y2 = 1
			double y = abs((1 - (log(tan(la * PI / 180) + 1 / (cos(la * (PI / 180)))) / PI)) * pow(2, z - 1));
			int fy = (int) y; // Final Y
			System.out.println("http://tile.openstreetmap.org/" + z + "/" + fx + "/" + fy);
		}
	}

}
