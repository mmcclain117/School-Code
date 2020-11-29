
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob06 {

    public static final int A = 2; // A side
    public static final int B = 1; // B Side
    public static final int C = 0; // C Side
    public static final int SQR_B = 3;
    public static final int SQR_A = 4;

    public static void main(String[] args) throws Exception {
//        Problem: Heronian Rectangles
//        Points: 5
        Scanner scan = new Scanner(new File("prob06.txt"));
        long p = scan.nextLong(); // Perimeter
        long a = scan.nextLong(); // Area

        List<Long> sides = new ArrayList(); // Longest Sides
        for (long side = p; side <= a; ++side) {
            sides.add(side);
        }

        for (Long longestSide : sides) {
            List<long[]> triangles = toTriangles(longestSide);
            List<long[]> heronianTriangles = toHeronianTriangles(triangles);

            List<long[]> heronianPairs = toHeronianPairs(heronianTriangles);
            for (long[] pair : heronianPairs) {
                System.out.printf("(%d, %d, %d) (%d, %d)\n", pair[C], pair[B], pair[A], pair[SQR_B], pair[SQR_A]);
            }
        }
    }

    /* Calculate area of Triangle */
    public static final long area(long a, long b, long c) {
        long sNumerator = a + b + c;
        if ((sNumerator % 2) != 0) { // Area is Invalid
            return -1;
        }
        long s = sNumerator / 2;
        long square = s * (s - a) * (s - b) * (s - c);
        double area = Math.sqrt(square);
        if (Math.floor(area) == area) {
            return (long) area;
        }
        return -1; // Invalid Area
    }

    /* Return triangles with given longestSide (ls) length */
    public static final List<long[]> toTriangles(long ls) {
        List<long[]> triangles = new ArrayList<long[]>();
        long b = ls - 1;
        long c = b;
        while ((b + c) > ls) {
            while ((b + c) > ls) {
                long[] triangle = new long[3];
                triangle[C] = c;
                triangle[B] = b;
                triangle[A] = ls;
                triangles.add(triangle);
                c--;
            }
            b--;
            c = b;
        }
        return triangles;
    }

    /* Trims down list of triangles to Heronian Triangles only */
    public static final List<long[]> toHeronianTriangles(List<long[]> triangles) {
        List<long[]> heronians = new ArrayList<long[]>();
        for (long[] triangle : triangles) {
            long c = triangle[C];
            long b = triangle[B];
            long a = triangle[A];
            long area = area(a, b, c);
            if (area != -1) {
                long perimeter = a + b + c;
                long[] heronian = new long[5];
                heronian[C] = c;
                heronian[B] = b;
                heronian[A] = a;
                heronian[3] = area;
                heronian[4] = perimeter;
                heronians.add(heronian);
            }
        }
        return heronians;
    }

    /**
     * Returns the heronian triangle and associated rectangle for the given
     * triangle. The rectangle will have the same area and perimeter as the
     * triangle.
     */
    public static final List<long[]> toHeronianPairs(List<long[]> heronianTriangles) {
        List<long[]> pairs = new ArrayList<long[]>();
        for (long[] triangle : heronianTriangles) {
            long longSide = triangle[A];
            long area = triangle[3];
            long perimeter = triangle[4];
            while ((area / longSide) < longSide) {
                if ((area % longSide) == 0) {
                    long shortSide = area / longSide;
                    if ((2 * (longSide + shortSide)) == perimeter) {
                        long[] pair = new long[5];
                        pair[C] = triangle[C];
                        pair[B] = triangle[B];
                        pair[A] = triangle[A];
                        pair[SQR_B] = shortSide;
                        pair[SQR_A] = longSide;
                        pairs.add(pair);
                    }
                }
                --longSide;
            }
        }
        return pairs;
    }
}
