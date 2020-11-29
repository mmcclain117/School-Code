
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob08 {

    private static ArrayList<Point> ar; // Points
    private static double min = Integer.MAX_VALUE; // Minimum Distance
    public static int setMin[] = null;

    public static void main(String[] args) throws Exception {
//        Problem: Traveling Salesperson
//        Points: 6
        Scanner scan = new Scanner(new File("prob08.txt"));
        ar = new ArrayList();
        ar.add(new Point(0, 0)); // Add Starting Point
        String a = scan.nextLine();
        while (!a.equals("0, 0")) {
            String split[] = a.split("[,]+");
            Point p = new Point(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()));
            ar.add(p);
            a = scan.nextLine();
        }
        ar.add(0, new Point(0, 0)); // Add Starting Point
        /* Print out all the points */
//        for (Point q : ar) {
//            System.out.println(q.x + " " + q.y);
//        }
        ar.add(new Point(0, 0)); // Add Ending Point
        int N = ar.size() - 1;
        int[] sequence = new int[N]; // Combination possibilities array
        for (int i = 0; i < N; i++) {
            sequence[i] = i + 1;
        }
        setMin = new int[N + 2];
        permute(sequence, 0);
        for (int i = 2; i < ar.size() - 1; i++) {
            System.out.println("Client " + (setMin[i] - 1) + " = " + ar.get(setMin[i]).x + ", " + ar.get(setMin[i]).y);
        }
    }

    static void permute(int[] a, int k) {
        if (k == a.length) {
            Calculate(a);
        } else {
            for (int i = k; i < a.length; i++) {
                int temp = a[k];
                a[k] = a[i];
                a[i] = temp;

                permute(a, k + 1);

                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }

    /* Calculates the Paths total distance */
    private static void Calculate(int a[]) {
        double dist = 0; // Distance 
        /* Modify to have 0 at both beginning and end */
        int b[] = new int[a.length + 2];
        /* Copies array a to an array b with starting and ending point */
        for (int i = 0; i < a.length; i++) {
            b[i + 1] = a[i];
        }
        b[0] = 0;
        for (int i = 0; i < b.length - 1; i++) {
            dist += sqrt(ar.get(b[i]), ar.get(b[i + 1]));
        }
        if (dist < min) { // Shorter distance
            if (b[0] == 0 && b[b.length - 1] == 0) { // start and end point are origin.
                /* Copy Array B to SetMin array */
                for (int i = 0; i < b.length; i++) {
                    setMin[i] = b[i];
                }
                min = dist;
            }
        }
    }

    /* Distance formula for two points */
    private static double sqrt(Point a, Point b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }
}
