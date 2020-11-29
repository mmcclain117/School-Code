
import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class DrawDemo {

    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo() {
        myCanvas = new Canvas("Drawing Demo", 1000, 1000);
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare() {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.yellow);
        square(pen);
    }

    public void drawTriangle() {
        Pen pen = new Pen(500, 200, myCanvas);
        pen.setColor(Color.MAGENTA);
        tri(pen);
    }

    public void drawPentagon() {
        Pen pen = new Pen(700, 500, myCanvas);
        pen.setColor(Color.orange);
        pent(pen);
    }

    private void tri(Pen pen) {
        for (int i = 0; i < 3; i++) {
            pen.move(100);
            pen.turn(120);
        }
    }

    public void drawPolygon(int n) {
        Pen pen = new Pen(900, 100, myCanvas);
        pen.setColor(Color.yellow);
        polygon(pen, n);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel() {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.cyan);
        for (int i = 0; i < 36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen) {
        for (int i = 0; i < 4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    private void pent(Pen pen) {
        for (int i = 0; i < 5; i++) {
            pen.move(60);
            pen.turn(-72);
        }
    }

    public void Spiral() {
        Pen pen = new Pen(400, 400, myCanvas);
        pen.setColor(Color.white);
        for (int i = 0; i < 500; i++) {
            pen.move(1 * i);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble() {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i = 0; i < 100; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear() {
        myCanvas.erase();
    }

    private void polygon(Pen pen, int n) {
        int c = 180 * (n - 2);
        for (int i = 0; i < n; i++) {
            pen.move(50);
            pen.turn(180 - (c / n));
        }
    }
}
