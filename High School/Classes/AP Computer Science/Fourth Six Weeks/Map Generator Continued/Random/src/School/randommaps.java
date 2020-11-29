package School;

import java.awt.*;
import javax.swing.*;

public class randommaps extends JFrame {

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
        randommaps w = new randommaps(70, 100);
        w.genmap();
    } // main

    public randommaps(int r, int c) // takes arguments size of map
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
        int i, j;  // array coords
        double r;  // random number
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                r = Math.random();  // r is a number between 0 and 0.999999...
                if (r < 0.33) {
                    map[i][j] = DESERT;
                } else if (r < 0.66) {
                    map[i][j] = WATER;
                } else {
                    map[i][j] = FOREST;
                }
            } // nested for loop
        }
        drawmap();  // displays map on screen
    } //genmap

}  // randommap
