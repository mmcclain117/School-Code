
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class Rand3 extends JFrame {

    public int con = 0;
    public int[][] map;      // array representing map
    public int rows;   // number of rows in array
    public int cols;   // number of columns in array
    public int size = 10;  // size of graphical representation
    public static final int DESERT = 0;
    public static final int WATER = 1;
    public static final int FOREST = 2;
    public static final int ICE = 3;
    public static final int LAVA = 4;
    public static final int ROCK = 5;
    // colors that corresponds to array type:
    public static Color[] colorof = {Color.yellow, Color.blue, Color.green, Color.WHITE, Color.red, Color.black};
    private Graphics display;  // drawing object

    public static void main(String[] args) {
        Rand3 w = new Rand3(200, 200);
//        while (con < 100) {
        w.genmap();
//            con *= 2;
//        }
    } // main

    public Rand3(int r, int c) // takes arguments size of map
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
            Thread.sleep(5);
        } catch (Exception e) {
        } // Synch with system
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = DESERT;
            }
        }
        map[10][10] = WATER;
        map[40][100] = WATER;
        map[100][100] = WATER;
        map[10][40] = WATER;

        map[40][100] = FOREST;
        map[80][100] = FOREST;
        map[40][40] = FOREST;
        map[120][150] = FOREST;

        map[10][120] = LAVA;
        map[120][120] = LAVA;
        map[130][130] = LAVA;
        map[125][125] = LAVA;

        map[120][10] = WATER;
        map[10][100] = WATER;
        map[120][100] = WATER;
        map[10][120] = WATER;
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
            Thread.sleep(5);
        } catch (Exception e) {
        }  // animation delay
    } //drawmap

    /* ******************************************************** */
    public void genmap() // replace code here with your own:
    {
        HashMap<Integer, String> hx = new HashMap<>();
        HashMap<Integer, String> hy = new HashMap<>();
        while (con < 300) {
            int i, j;  // array coords
            double r;  // random number
            double mapsize = rows * cols;
            for (i = 0; i < rows; i++) {
                for (j = 0; j < cols; j++) {
                    r = Math.random() + .01;  // r is a number between 0 and 0.999999...
//                    if (!(map[i][j] == WATER || Math.random() < .52)) {
                    if (i - 1 > 0) {
                        r *= map[i - 1][j] == DESERT ? .9 : map[i - 1][j] == FOREST ? 3.1 : map[i - 1][j] == ICE ? 5.2 : map[i - 1][j] == LAVA ? 7.4 : map[i - 1][j] == ROCK ? 8.4 : 10;
//                            r *= map[i - 1][j] == DESERT ? 1 - (con * .05) : map[i - 1][j] == FOREST ? 1 + (con * .02) : 1.5;
                    } else if (i + 1 < rows) {
                        r *= map[i + 1][j] == DESERT ? .9 : map[i + 1][j] == FOREST ? 3.1 : map[i + 1][j] == ICE ? 5.2 : map[i + 1][j] == LAVA ? 7.4 : map[i + 1][j] == ROCK ? 8.4 : 10;
//                            r *= map[i + 1][j] == DESERT ? 1 - (con * .05) : map[i + 1][j] == FOREST ? 1 + (con * .02) : map[i + 1][j] == ICE ? 1 + (con * .02) : 1.5;
                    } else if (j - 1 > 0) {
                        r *= map[i][j - 1] == DESERT ? .9 : map[i][j - 1] == FOREST ? 3.1 : map[i][j - 1] == ICE ? 5.2 : map[i][j - 1] == LAVA ? 7.4 : map[i][j - 1] == ROCK ? 7.4 : 10;
//                            r *= map[i][j - 1] == DESERT ? 1 - (con * .05) : map[i][j - 1] == FOREST ? 1 + (con * .02) : map[i + 1][j] == ICE ? 1 + (con * .02) : 1.5;
                    } else if (j + 1 < cols) {
                        r *= map[i][j + 1] == DESERT ? .9 : map[i][j + 1] == FOREST ? 3.1 : map[i][j + 1] == ICE ? 5.2 : map[i][j + 1] == LAVA ? 7.4 : map[i][j + 1] == ROCK ? 7.4 : 10;
//                            r *= map[i][j + 1] == DESERT ? 1 - (con * .05) : map[i][j + 1] == FOREST ? 1 + (con * .02) : map[i + 1][j] == ICE ? 1 + (con * .02) : 1.5;
                    }
                    r *= con * .05;
                    if (r < .33) {
                        map[i][j] = DESERT;
                    } else if (r < 2.66) {
                        map[i][j] = FOREST;
                    } else if (r < 4.66) {
                        map[i][j] = ICE;
                    } else if (r < 6.66) {
                        map[i][j] = LAVA;
                    } else if (r < 9.66) {
                        map[i][j] = ROCK;
                    } else {
                        map[i][j] = WATER;
                    }
//                    }
                } // nested for loop
            }

            drawmap();  // displays map on screen
            con += 2;
        }
    } //genmap
}  // randommap
