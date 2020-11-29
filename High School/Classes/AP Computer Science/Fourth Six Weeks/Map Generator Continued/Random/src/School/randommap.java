package School;

import java.awt.*;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.*;

public class randommap extends JFrame {

    public int con = 0;
    public int[][] map;      // array representing map
    public int rows;   // number of rows in array
    public int cols;   // number of columns in array
    public int size = 10;  // size of graphical representation
    public static final int DESERT = 0;
    public static final int WATER = 1;
    public static final int FOREST = 2;
    // colors that corresponds to array type:
    public static Color[] colorof = {Color.yellow, Color.blue, Color.green};
    private Graphics display;  // drawing object

    public static void main(String[] args) {
        randommap w = new randommap(70, 100);
//        while (con < 100) {
        w.genmap();
//            con *= 2;
//        }
    } // main

    public randommap(int r, int c) // takes arguments size of map
    {
        rows = r;
        cols = c;
        map = new int[rows][cols];  // creates array
        int XDIM = cols * size;
        int YDIM = rows * size;
        setBounds(0, 0, XDIM, YDIM + size);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = this.getGraphics();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        } // Synch with system
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = DESERT;
            }
        }
        // draw static background as a yellow rectangle
        display.setColor(Color.yellow);
        display.fillRect(0, 0, XDIM, YDIM + 40);
    }  // constructor

    public void drawmap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                display.setColor(colorof[map[i][j]]);
                display.fillRect(j * size, i * size + size, size, size);
            }
        }
        try {
            Thread.sleep(50);
        } catch (Exception e) {
        }  // animation delay
    } //drawmap

    /* ******************************************************** */
    public void genmap() // replace code here with your own:
    {
        HashMap<Integer, String> hx = new HashMap<>();
        HashMap<Integer, String> hy = new HashMap<>();
        while (con < 100) {
            int i, j;  // array coords
            double r;  // random number
            for (i = 0; i < rows; i++) {
                for (j = 0; j < cols; j++) {
                    r = Math.random();  // r is a number between 0 and 0.999999...
                    if (i - 1 > 0) {
                        r *= map[i - 1][j] == DESERT ? 1 - (con * .005) : map[i - 1][j] == FOREST ? 1 + (con * .005) : 1 + (con * .05);
                    } else if (i + 1 < rows) {
                        r *= map[i + 1][j] == DESERT ? 1 - (con * .005) : map[i + 1][j] == FOREST ? 1 + (con * .005) : 1 + (con * .05);
                    }
                    if (j - 1 > 0) {
                        r *= map[i][j - 1] == DESERT ? 1 - (con * .005) : map[i][j - 1] == FOREST ? 1 + (con * .005) : 1 + (con * .05);
                    } else if (j + 1 < cols) {
                        r *= map[i][j + 1] == DESERT ? 1 - (con * .005) : map[i][j + 1] == FOREST ? 1 + (con * .005) : 1 + (con * .05);
                    }

                    if (r < 0.33) {
                        map[i][j] = DESERT;
                    } else if (r < 1) {
                        map[i][j] = FOREST;
                    } else {
                        map[i][j] = WATER;
                    }
                } // nested for loop
            }
            drawmap();  // displays map on screen
            con += 1;
        }
        int i, j;
        double r;
        String d, f, w;
        int d1 = 1, f1 = 1, w1 = 1;
        for (i = 0; i < 7; i++) {
            double ran = (Math.random() * rows);
            for (j = 0; j < cols; j++) {
                r = Math.random();  // r is a number between 0 and 0.999999...
                if (r < 0.2) {
                    if (map[(int) ran][j] == DESERT) {
                        d = "d";
                        d += d1;
                        hx.put(i, d);
                        hy.put(j, d);
                        d1++;
//                        i++;
                    }
                } else if (r < .4) {
                    if (map[(int) ran][j] == FOREST) {
                        f = "f";
                        f += f1;
                        hx.put(i, f);
                        hy.put(j, f);
                        f1++;
//                        i++;
                    }
//                    map[i][j] = FOREST;
                } else if (r < .6) {
                    if (map[(int) ran][j] == WATER) {
                        w = "w";
                        w += w1;
                        hx.put(i, w);
                        hy.put(j, w);
                        w1++;
//                        i++;
                    }
//                    map[i][j] = WATER;
                }
            }
        }
        out.println(Arrays.toString(hx.keySet().toArray()) + " " + Arrays.toString(hx.values().toArray()));
        out.println(Arrays.toString(hy.keySet().toArray()) + " " + Arrays.toString(hy.values().toArray()));
    } //genmap
}  // randommap
