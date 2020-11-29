package FloodPic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master Ward
 */
public class Attempt1 {

    // getting your java program to pause properly requires
    // some absurd mumbo-jumbo
    private static void sleep(int msec) {
        try {
            Thread.currentThread().sleep(msec);
        } catch (InterruptedException e) {
        }
    }

//    private static void flood(Picture img, boolean[][] mark,
    private static void flood(Graphics g, BufferedImage img, boolean[][] mark,
            int row, int col, Color srcColor, Color tgtColor) {
        // make sure row and col are inside the image
        if (row < 0) {
            return;
        }
        if (col < 0) {
            return;
        }
//        if (row >= img.height()) {
        if (row >= img.getHeight()) {
            return;
        }
//        if (col >= img.width()) {
        if (col >= img.getWidth()) {
            return;
        }

        // make sure this pixel hasn't been visited yet
        if (mark[row][col]) {
            return;
        }
        int d = srcColor.getRGB();
        // make sure this pixel is the right color to fill
//        if (!img.get(col, row).equals(srcColor)) {
        if (!(img.getRGB(col, row) == d)) {
            return;
        }

        // fill pixel with target color and mark it as visited
        g.setColor(tgtColor);
        g.fillRect(col, row, 1, 1);
//        img.set(col, row, tgtColor);
        mark[row][col] = true;

        // animate
//        img.show();
        sleep(25);

        // recursively fill surrounding pixels
        // (this is equivelant to depth-first search)
        flood(g, img, mark, row - 1, col, srcColor, tgtColor);
        flood(g, img, mark, row + 1, col, srcColor, tgtColor);
        flood(g, img, mark, row, col - 1, srcColor, tgtColor);
        flood(g, img, mark, row, col + 1, srcColor, tgtColor);
    }

    public static void main(String[] args) throws Exception {
        File f = new File("Y&Y.png");
        BasicGraphics.start();
        BufferedImage bi = ImageIO.read(f);
//        Picture img = new Picture(args[0]);
//        boolean[][] mark = new boolean[img.height()][img.width()];
        boolean[][] mark = new boolean[bi.getHeight()][bi.getWidth()];
        Graphics g = bi.getGraphics();
//        img.show();
//        for (int row = 0 ; row < img.height() ; row++) {
        for (int row = 0; row < bi.getHeight(); row++) {
            for (int col = 0; col < bi.getWidth(); col++) {
                flood(g, bi, mark, row, col,
                        Color.BLACK, Color.RED);
            }
        }
    }

}

class randommap extends JFrame {

    public int[][] map;      // array representing map
    public int rows;   // number of rows in array
    public int cols;   // number of columns in array
    public int size = 10;  // size of graphical representation
    public static Color[] colorof = {Color.yellow, Color.blue, Color.green};
    private Graphics display;  // drawing object

    public static void main(String[] args) {
        randommap w = new randommap(500, 500);
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
            Thread.sleep(1);
        } catch (Exception e) {
        } // Sync with system
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
            Thread.sleep(1);
        } catch (Exception e) {
        }  // animation delay
    } //drawmap
}

class MainPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        //YOUR CODE GOES HEREE!!
        //Sample code
        //g.drawOval(100,50,100,200);
        //g.drawRect(300,50,200,200);
    }
}

/**
 * ************************************************************
 * The code below is needed to create the Graphics window. You should not modify
 * or delete any of the code.
 * ***********************************************************
 */
class BasicGraphics extends JFrame {

    public static void main(String[] args) {
        //This is a necessary in order to create the frame window
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                start();
            }
        });
    }

    public static void start() {

        //Sets up the frame
        JFrame frame = new JFrame("Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        //Display the window.
        frame.pack();

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(800, 600));
        frame.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
