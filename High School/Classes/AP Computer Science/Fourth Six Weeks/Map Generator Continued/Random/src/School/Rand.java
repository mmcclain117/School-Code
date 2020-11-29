package School;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class Rand extends JFrame {

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
        Rand w = new Rand(200, 200);
//        while (con < 100) {
        w.genmap();
//            con *= 2;
//        }
    } // main

    public Rand(int r, int c) // takes arguments size of map
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
            double des = 0;
            double fores = 0;
            double wat = 0;
            for (i = 0; i < rows; i++) {
                for (j = 0; j < cols; j++) {
                    double forestprob = .1;
                    double desprob = 0;
                    double waterprob = .4;
                    r = Math.random() + .01;  // r is a number between 0 and 0.999999...
                    if (!(map[i][j] == WATER)) {
                        if (i - 1 > 0) {
                            desprob = map[i - 1][j] == DESERT ? desprob + .2 : desprob - .2;
                            waterprob = map[i - 1][j] == WATER ? waterprob + .25 : map[i - 1][j] == WATER ? waterprob + .2 : waterprob - .1;
                            forestprob = map[i - 1][j] == FOREST ? forestprob + .25 : map[i - 1][j] == WATER ? waterprob + .1 : waterprob - .2;
                            r *= map[i - 1][j] == DESERT ? 1 - (con * .05) : map[i - 1][j] == FOREST ? 1 + (con * .02) : 1.5;
                        } else if (i + 1 < rows) {
                            desprob = map[i + 1][j] == DESERT ? desprob + .2 : desprob - .2;
                            waterprob = map[i + 1][j] == WATER ? waterprob + .3 : map[i + 1][j] == WATER ? waterprob + .2 : waterprob - .1;
                            forestprob = map[i + 1][j] == FOREST ? forestprob + .25 : map[i + 1][j] == WATER ? waterprob + .15 : waterprob - .2;
                            r *= map[i + 1][j] == DESERT ? 1 - (con * .05) : map[i + 1][j] == FOREST ? 1 + (con * .02) : map[i + 1][j] == ICE ? 1 + (con * .02) : 1.5;
                        } else if (j - 1 > 0) {
                            desprob = map[i][j - 1] == DESERT ? desprob + .1 : desprob - .2;
                            waterprob = map[i][j - 1] == WATER ? waterprob + .25 : map[i][j - 1] == WATER ? waterprob + .2 : waterprob + .1;
                            forestprob = map[i][j - 1] == FOREST ? forestprob + .25 : map[i][j - 1] == WATER ? waterprob + .1 : waterprob - .2;
                            r *= map[i][j - 1] == DESERT ? 1 - (con * .05) : map[i][j - 1] == FOREST ? 1 + (con * .02) : map[i + 1][j] == ICE ? 1 + (con * .02) : 1.5;
                        } else if (j + 1 < cols) {
                            desprob = map[i][j + 1] == DESERT ? desprob + .2 : desprob - .2;
                            waterprob = map[i][j + 1] == WATER ? waterprob + .25 : map[i][j + 1] == WATER ? waterprob + .2 : waterprob - .1;
                            forestprob = map[i][j + 1] == FOREST ? forestprob + .25 : map[i][j + 1] == WATER ? waterprob + .2 : waterprob - .2;
                            r *= map[i][j + 1] == DESERT ? 1 - (con * .05) : map[i][j + 1] == FOREST ? 1 + (con * .02) : map[i + 1][j] == ICE ? 1 + (con * .02) : 1.5;
                        }

                        if (r < 0.01) {
                            map[i][j] = DESERT;
                        } else if (r < 1) {
                            map[i][j] = LAVA;
                        } else if (r < 2.66) {
                            map[i][j] = FOREST;
                        } else if (r < 3.36) {
                            map[i][j] = ROCK;
                        } else if (r < 5.5) {
                            map[i][j] = ICE;
                        } else {
                            map[i][j] = WATER;
                        }
                    }
//                        if (desprob > waterprob && desprob > forestprob) {
//                            map[i][j] = DESERT;
//                        } else if (forestprob > waterprob && forestprob > desprob) {
//                            map[i][j] = FOREST;
//                        } else {
//                            map[i][j] = WATER;
//                        }

//                    if (map[i][j] == DESERT) {
//                        des++;
//                    } else if (map[i][j] == WATER) {
//                        wat++;
//                    } else if (map[i][j] == FOREST) {
//                        fores++;
//                    }
                } // nested for loop
            }/*
             if (des / mapsize > .90) {
             int re = (int) (des - (fores + wat));
             for (int u = 0; u < re; u++) {
             double x = random() * rows;
             double y = random() * cols;
             int xx = (int) x;
             int yy = (int) y;
             double ran = random();
             map[xx][yy] = ran < .7 ? FOREST : WATER;
                    
             }
             con = 0;
             } else if (fores / mapsize > .90) {
             int re = (int) (fores - (des+wat));
             for (int u = 0; u < re; u++) {
             double x = random() * rows;
             double y = random() * cols;
             int xx = (int) x;
             int yy = (int) y;
             double ran = random();
             map[xx][yy] = ran < .7 ? WATER : DESERT;
             }
             con =0;
             } else if (wat / mapsize > .90) {
             int re = (int) (wat - (fores + des));
             for (int u = 0; u < re; u++) {
             double x = random() * rows;
             double y = random() * cols;
             int xx = (int) x;
             int yy = (int) y;
             double ran = random();
             map[xx][yy] = ran < .7 ? FOREST : DESERT;
             }
             con = 0;
             }
             */

            drawmap();  // displays map on screen
            con += 2;
        }
//        int i, j;
//        double r;
//        String d, f, w;
//        int d1 = 1, f1 = 1, w1 = 1;
//        for (i = 0; i < 7; i++) {
//            double ran = (Math.random() * rows);
//            for (j = 0; j < cols; j++) {
//                r = Math.random();  // r is a number between 0 and 0.999999...
//                if (r < 0.2) {
//                    if (map[(int) ran][j] == DESERT) {
//                        d = "d";
//                        d += d1;
//                        hx.put(i, d);
//                        hy.put(j, d);
//                        d1++;
////                        i++;
//                    }
//                } else if (r < .4) {
//                    if (map[(int) ran][j] == FOREST) {
//                        f = "f";
//                        f += f1;
//                        hx.put(i, f);
//                        hy.put(j, f);
//                        f1++;
////                        i++;
//                    }
////                    map[i][j] = FOREST;
//                } else if (r < .6) {
//                    if (map[(int) ran][j] == WATER) {
//                        w = "w";
//                        w += w1;
//                        hx.put(i, w);
//                        hy.put(j, w);
//                        w1++;
////                        i++;
//                    }
////                    map[i][j] = WATER;
//                }
//            }
//        }
//        out.println(Arrays.toString(hx.keySet().toArray()) + " " + Arrays.toString(hx.values().toArray()));
//        out.println(Arrays.toString(hy.keySet().toArray()) + " " + Arrays.toString(hy.values().toArray()));
//        for (int v = 0; v < hx.size(); v++) {
//            
//        }
    } //genmap
}  // randommap
