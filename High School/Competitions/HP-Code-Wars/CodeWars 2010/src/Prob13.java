
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Master Ward and Don Brace
 */

/*
 * This basically involves best-fit solution. You are limited to a 4x4 grid
 * to fit shapes that can be up to 3x3.
 *
 * I decided to use bit patterns. I took the 4x4 grid and choose each row
 * to represent 4 bits. I then used this model to determine how the shape
 * is represented.
 *
 * +-------+-------+-------+-------+
 * | | | | | | | | | | | | | | | | |
 * | Row 1 | Row 2 | Row 3 | Row 4 |
 * +-------+-------+-------+-------+
 *
 * T1 looks like: If left justified
 * +-------+-------+-------+-------+     111  or  ---
 * |1|1|1|0|0|1|0|0|0|0|0|0|0|0|0|0|      1        |
 * | Row 1 | Row 2 | Row 3 | Row 4 |
 * +-------+-------+-------+-------+
 *
 * The above bit pattern is: 0XE400
 *
 * +-+-+-+-+
 * |1|1|1|0|
 * +-+-+-+-+
 * |0|1|0|0|
 * +-+-+-+-+
 * |0|0|0|0|
 * +-+-+-+-+
 * |0|0|0|0|
 * +-+-+-+-+
 *
 * The above shape can only be shifted to the right/left by one square.
 * (In its current position, it can only be shifted right once.)
 * But it can be shifted down 2 more rows. So we need to find the bit patterns
 * for each possible shape position.
 * Eg:
 *          0xE400 - Current displayed position.
 *          0x7200 - Shifted right.
 *          0x0E40 - Shifted down 1x and left justified.
 *          0x0720 - Shifted down 1x and shifted right 1x.
 *          0x00E4 - Shifted down 2x and left justified.
 *          0x0072 - Shifted down 2x and shifted right 1x.
 *
 * Using the above bit patterns I generated all possible patterns for each
 * shape then ran through each pattern and ORed the bits together until I 
 * obtained all F's in the result.
 *
 * The trick is to keep track of the patterns so you know which letter to
 * output for the solution.
 *
 * I used recursion to build the solution list.
 *
 * Note: In the shape table, I right-justified them in the top row.
 */
 /*
 * Class to track and manage the shapes.
 */
class Shapes {

    Shapes(String n, String l, int g) {
        name = n;
        letter = 0;
        pattern = g;
    }

    /* For Debugging Patterns */
    void PrintPattern(String msg, int p) {
        int a = (p >> 12) & 0x0F;
        int b = (p >> 8) & 0x0F;
        int c = (p >> 4) & 0x0F;
        int d = p & 0x0F;
        System.out.println(msg + a + ' ' + b + ' ' + c + ' ' + d);
    }

    /* Shift pattern left. Stop when a 1 bit is detected on the leftmost bit */
    int ShiftLeft(int n) {
        int a = (n >> 12) & 0x0F;
        int b = (n >> 8) & 0x0F;
        int c = (n >> 4) & 0x0F;
        int d = n & 0x0F;
        if ((a & 8) > 0) {
            return 0;
        }
        if ((b & 8) > 0) {
            return 0;
        }
        if ((c & 8) > 0) {
            return 0;
        }
        if ((d & 8) > 0) {
            return 0;
        }
        a = a << 1;
        b = b << 1;
        c = c << 1;
        d = d << 1;
        return (a << 12) | (b << 8) | (c << 4) | d;
    }

    /**
     * Shift the pattern down
     *
     * We can go down until a 1 bit is detected in the last row. The calling
     * function is responsible for storing the pattern and stopping when a 0 is
     * returned
     */
    int ShiftDown(int n) {
        int a, b, c, d;
        int a1, b1, c1, d1;

        a = (n >> 12) & 0x0F;
        b = (n >> 8) & 0x0F;
        c = (n >> 4) & 0x0F;
        d = n & 0x0F;

        /* last row then stop */
        if (d > 0) {
            return 0;
        }

        a1 = 0;
        b1 = a;
        c1 = b;
        d1 = c;
        return (a1 << 12) | (b1 << 8) | (c1 << 4) | d1;
    }

    /* Generate all possible combination of the shape patterns */
    void BuildPatterns() {
        int i;
        int j;
        int k;
        int newpat = pattern;
        patterns = new int[16];
        num_patterns = 0;

        /* Don't forget the first pattern from constructor */
        patterns[num_patterns] = pattern;
        ++num_patterns;

        /* shift the pattern to the left */
        for (i = 0; i < 4; i++) {
            newpat = ShiftLeft(newpat);
            if (newpat == 0) {
                break;
            }
            patterns[num_patterns] = newpat;
            ++num_patterns;
            //PrintPattern("   Lt:", newpat);
        }

        /* Shift pattern down and then to the left */
        k = num_patterns;
        for (i = 0; i < k; i++) {
            newpat = patterns[i];
            for (j = i; j < 4; j++) {
                newpat = ShiftDown(newpat);
                if (newpat == 0) {
                    continue;
                }
                patterns[num_patterns] = newpat;
                ++num_patterns;
                //PrintPattern("   Dn:", newpat);
            }
        }

    }
    /* BuildPatterns */

    String name;
    int letter;
    int pattern;
    int[] patterns;
    int final_pattern_index;
    int num_patterns;
};


/* Used to help print letters in the Tetras Grid */
class output {

    String letter;
    int value;

    output(int l, int v) {
        value = v;
        letter = l + "";
    }

    output(String l, int v) {
        letter = l;
        value = v;
    }
};

public class Prob13 {

    public static void main(String[] args) throws Exception {
//        Problem: Tetra Square
//        Points: 14
        Scanner scan = new Scanner(new File("prob13.txt"));
        ArrayList<Shapes> shapes = new ArrayList<>();
        ArrayList<String> in_shapes = new ArrayList<>();
        ArrayList<Shapes> tetra_shapes = new ArrayList<>();
        ArrayList<Integer> patterns = new ArrayList<>();
        ArrayList<Shapes> final_shapes = new ArrayList<>();

        BuildShapeList(shapes);
        int numShapes = scan.nextInt(); // Number of shapes

        /* Read in shapes and make a list of them */
        for (int i = 0; i < numShapes; i++) {
            String newShape = scan.next();
            in_shapes.add(newShape);
        }

        BuildShapePatterns(in_shapes, shapes, tetra_shapes); // Generate all combonation for each shape

        /* Find each shape pattern that solves the problem */
        BuildTetraPatterns(tetra_shapes, patterns, final_shapes, 0);

        PrintResultingBoard(tetra_shapes); // Output
    }

    /*
	 * Prints the 4x4 grid using some simple tricks about bit patterns
	 *
	 * The list of patterns comes out in inputed shape order.
	 * If you printout the hex values for each 4 bits the answer is
	 * down the column, not across the row.
	 * 
	 * Looks like:
	 * Shape 'A' solution pattern = 1100
	 * Shape 'B' solution pattern = 04c8
	 * Shape 'C' solution pattern = 0006
	 * Shape 'D' solution pattern = 0231
	 * Shape 'E' solution pattern = e800
	 *                              ^  ^
	 *                              |  |
	 *                              |  +--> Bottom row of 4x4 grid
	 *                              +--> Top row of 4x4 grid
	 *
	 * Need to emit highest hex value first.
	 *
	 * Answer is:
	 *           EEEA    0XE001 (0xE = 1110)
	 *           EBDA    0x8421 (0x8 = 1000)
	 *           BBDD    0xC011 (0xC = 1100)
	 *           BCCD    0x8601 (0x6 = 0110)
     */
    static void PrintResultingBoard(ArrayList<Shapes> v) {
        int a, b, c, d;
        /* Need to hold each nibble in the pattern */
        int n;
        /* First shape is 'A' (from problem desc.) */

        output[][] tet_out = new output[4][16];

        int letter = 'A';
        for (int i = 0; i < v.size(); i++) {

            Shapes s = v.get(i);
            n = s.patterns[s.final_pattern_index];

            /* Decompile the pattern to put into a 4x4 grid */
            a = (n >> 12) & 0x0F;
            b = (n >> 8) & 0x0F;
            c = (n >> 4) & 0x0F;
            d = n & 0x0F;

            /* Creates a sparse Array */
            tet_out[0][a] = new output(letter, a);
            tet_out[1][b] = new output(letter, b);
            tet_out[2][c] = new output(letter, c);
            tet_out[3][d] = new output(letter, d);
            ++letter;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 15; j > -1; j--) {
                PrintCharacter(tet_out[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * This function looks at each shapes bit pattern and emits the shapes
     * associated letter if a 1 bit is found.
     *
     * 0x0E = 1100. So two of the shape's letters are emitted.
     */
    static void PrintCharacter(output o) {
        if (o == null || o.value == 0) {
            return;
        }
        for (int i = 0; i < 16; i++) {
            if (((o.value >> i) & 0x1) > 0) {
                int k = Integer.parseInt(o.letter);
                System.out.printf("%s", (char) k);
            }
        }
    }

    /* Return shape if found */
    static Shapes FindShape(ArrayList<Shapes> s, String name) {
        //System.out.println("Looking for:" + name);
        for (int i = 0; i < s.size(); i++) {
            Shapes sh = s.get(i);
            if (sh.name.equals(name)) {
                return sh;
            }
        }
        return null;
    }

    /**
     * Go through the list of patterns and OR the bits together. At the end, all
     * F's result in a solution. You can even use XOR.
     *
     * Overlap does not really matter as there will be 0's in other positions.
     */
    static int OR_square(ArrayList<Integer> v) {
        int a, b, c, d;
        int n;
        int tot_a = 0;
        int tot_b = 0;
        int tot_c = 0;
        int tot_d = 0;

        for (int i = 0; i < v.size(); i++) {
            n = v.get(i);
            a = (n >> 12) & 0x0F;
            b = (n >> 8) & 0x0F;
            c = (n >> 4) & 0x0F;
            d = n & 0x0F;
            /**
             * Can use OR because we are completely filling the grid. If
             * overlap, the grid will not be filled.
             */
            tot_a |= a;
            tot_b |= b;
            tot_c |= c;
            tot_d |= d;
        }
        return (tot_a << 12) | (tot_b << 8) | (tot_c << 4) | tot_d;
    }

    /**
     * This function looks for the patterns that results in 0xFFFF for the 4x4
     * grid.
     *
     * It uses a brute force approach to find the resulting pattern Stops on the
     * first successful pattern found.
     */
    static int BuildTetraPatterns(ArrayList<Shapes> vs, ArrayList<Integer> patt,
            ArrayList<Shapes> final_shapes, int index) {
        int pat = 0;
        int found = 0;
        Shapes s;

        /**
         * This will not happen but with recursion you need some checks just to
         * be sure you stop.
         *
         * Left over from debug phase. :<
         */
        if (index > vs.size()) {
            return 0;
        }

        /**
         * We are at the last shape in the input list. patt is the list of
         * patterns from each shape that we used along the way.
         *
         * OR in each pattern to see if we get all F's
         */
        if (index == vs.size()) {
            pat = OR_square(patt);
            if (pat == 0xffff) {
                return 1;// Found solution
            }
            return 0; // Keep going
        }

        /* Get the shape from the list of inputed shapes. */
        s = vs.get(index);

        /**
         * Brute Force approach, find correct combination of patterns that make
         * all rows contain F's. Look at all possible shape patterns and OR them
         * together until we get all F's.
         */
        for (int i = 0; i < s.num_patterns; i++) {
            patt.add(s.patterns[i]);

            /* Recursively call but use the next shape in the list. */
            found = BuildTetraPatterns(vs, patt, final_shapes, index + 1);
            /**
             * If we find all F's in the pattern we have solved the problem. Use
             * the system stack to set the index of the shape's pattern.
             */
            if (found > 0) {
                s.final_pattern_index = i;
                return 1;
            }
            patt.remove(index); // Remove failure
        }
        return 0;
    }

    /**
     * The shapes to be fitted come from the input stream. We need to lookup the
     * shape from the shape list and then generate all combination of possible
     * patterns. Really great that there are no rotations to handle!
     *
     * I could have generated all possible patterns in the shape list itself but
     * figured that just doing the ones to be used would be faster.
     */
    static void BuildShapePatterns(ArrayList<String> input,
            ArrayList<Shapes> s, ArrayList<Shapes> v) {
        Shapes shape;
        int letter = 'A';
        int i;

        /**
         * Convert input to bit patterns, set letter The letter starts with a
         * and increases.
         */
        for (i = 0; i < input.size(); i++) {
            shape = FindShape(s, input.get(i));
            shape.letter = letter;
            shape.BuildPatterns();
            v.add(shape);
            ++letter;
        }
    }

    /* Builds a static list of known game shapes */
    static void BuildShapeList(ArrayList<Shapes> v) {
        /*
 		 * A = 10, B = 11, C = 12, D = 13, E = 14, F = 15
 		 *
 		 * Example J1:
 		 * +-+-+-+-+
 		 * |0|0|0|1|
 		 * +-+-+-+-+
 		 * |0|0|0|1|
 		 * +-+-+-+-+
 		 * |0|0|1|1|
 		 * +-+-+-+-+
 		 * |0|0|0|0|
 		 * +-+-+-+-+
         */
//         Each Hex digit represents 4 squares 
        v.add(new Shapes("J1", " ", 0x1130));
        v.add(new Shapes("J2", " ", 0x4700));
        v.add(new Shapes("J3", " ", 0x3220));
        v.add(new Shapes("J4", " ", 0x7100));
        v.add(new Shapes("T1", " ", 0x7200));
        v.add(new Shapes("T2", " ", 0x1310));
        v.add(new Shapes("T3", " ", 0x2700));
        v.add(new Shapes("T4", " ", 0x2320));
        v.add(new Shapes("I1", " ", 0x1100));
        v.add(new Shapes("I2", " ", 0x3000));
        v.add(new Shapes("L1", " ", 0x2230));
        v.add(new Shapes("L2", " ", 0x7400));
        v.add(new Shapes("L3", " ", 0x3110));
        v.add(new Shapes("L4", " ", 0x1700));
        v.add(new Shapes("Z1", " ", 0x6300));
        v.add(new Shapes("Z2", " ", 0x1320));
        v.add(new Shapes("S1", " ", 0x3600));
        v.add(new Shapes("S2", " ", 0x2310));
    }
};
