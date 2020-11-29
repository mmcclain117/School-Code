
import java.util.*;

public class MonteCarloTester {

    public static void main(String args[]) {
        MonteCarlo mcObj = new MonteCarlo(5, 3, 2);

        int cirCount = 0;
        int sqrCount = 0;

        for (int xx = 0; xx < 100000; xx++) {
            double x = mcObj.nextRainDrop_x();
            double y = mcObj.nextRainDrop_y();

            if (mcObj.insideCircle(x, y)) {
                cirCount++;
            }

            sqrCount++;
        }

        double side = mcObj.r * 2;
        double pi = (cirCount * (side * side)) / (sqrCount * (mcObj.r * mcObj.r));
        System.out.println(pi);
    }
}
