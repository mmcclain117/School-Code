package School;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.random;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;

public class map extends JFrame {

    private Graphics display;
//    public ArrayList<Integer> coord;
    public int cordi[][] = new int[2][14];
    public boolean maps[][] = new boolean[500][500];
    public int goal[][] = new int[500][500];
    public int[][] map;      // array representing map
    public int rows;   // number of rows in array
    public int cols;   // number of columns in array
    public int size = 10;  // size of graphical representation
    public static final int DESERT = 0;
    public static final int WATER = 1;
    public static final int FOREST = 2;
    public static Color[] colorof = {Color.yellow, Color.blue, Color.green};

    public static void main(String[] args) {
        map gM = new map(500, 500);
        gM.start(gM);
        int con = 0;
        while (con < 5) {
            gM.genmap();
            gM.drawmap();
        }
//        gM.genreal();
//        gM.genmap();
    }

    public void start(map g) {
        g.genreal();
        g.setbo();
    }

    private void setbo() {
        for (int x = 0; x < 500; x++) {
            for (int i = 0; i < 500; i++) {
                if (!maps[x][i]) {
                    maps[x][i] = random() * 100 > 50;
                }
                if (maps[x][i]) {
                    map[x][i] = goal[x][i];
                }
            }
        }
    }

    public map(int r, int c) {
//        coord = new ArrayList();
        rows = r;
        cols = c;
        map = new int[rows][cols];  // creates array
        int XDIM = cols * size;
        int YDIM = rows * size;
        setBounds(0, 0, XDIM, YDIM + size);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = this.getGraphics();
//        for (int ii = 0 ; ii < 2 ; ii++) {
        for (int i = 0; i < 14; i++) {
            double x = random() * 50 / 4;
            double y = random() * 50 / 4;
            cordi[0][i] = (int) x;
            cordi[1][i] = (int) y;
////           out.println(x + " "+ (int) x);
//             coord.add((int)x);
//            }
        }
    }

    public void drawmap() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                display.setColor(colorof[map[i][j]]);
                display.fillRect(j * size, i * size + size, size, size);
            }
        }
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }  // animation delay
    } //drawmap

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

    public void genreal() {
//        int i, j;
//        double r;
        int con = 0;
        while (con < 7) {
            int xy[] = new int[2];
            ArrayList<Integer> x = new ArrayList<>();
            ArrayList<Integer> y = new ArrayList<>();
            xy = spread(cordi[0][con], cordi[1][con]);
            x.add(xy[0]);
            y.add(xy[1]);
//            out.println(Arrays.toString(x.toArray()));
            out.println(Arrays.toString(y.toArray()));
            out.println(goal[cordi[0][con]][cordi[1][con]]);
            goal[cordi[0][con]][cordi[1][con]] = random() * 10 < 5 ? random() * 100 > 50 ? DESERT : FOREST : WATER;
            con++;
        }
    }

    public int[] spread(int x, int y) {
        double r = random() * 10;
        int ar[] = {x, y};
        if (r < 2) {
            spread(x + 1, y); // right
            ar[0] = x + 1;
            return ar;
        } else if (r < 4) {
            spread(x - 1, y);//left
            ar[0] = x - 1;
            return ar;
        } else if (r < 6) {
            spread(x, y + 1); // up
            ar[1] = y + 1;
            return ar;
        } else if (r < 8) {
            spread(x, y - 1); // down
            ar[1] = y - 1;
            return ar;
        }
        return ar;
    }
}
