
import java.awt.Color;
import java.awt.Rectangle;
import java.util.*;

/**
 * Class BallDemo - a short demonstration showing animation with the Canvas
 * class.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class BallDemo {

    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo() {
        myCanvas = new Canvas("Ball Demo", 800, 900);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce() {
        int ground = 600;   // position of the ground line
        myCanvas.setVisible(true);
        // draw the ground
        ArrayList<BoxBall> ar = new ArrayList<>();
        myCanvas.drawLine(50, ground, 350, ground);
        Rectangle rect = new Rectangle();
        myCanvas.draw(rect);
        // crate and show the balls
        Scanner scan = new Scanner(System.in);
        int a = 100;
        Random rnd = new Random();
        for (int i = 0; i < a; i++) {
            Color cr = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
            BoxBall ball = new BoxBall((int) (Math.random() * 200 + 100), (int) (Math.random() * 250 + 50), rnd.nextInt(25), cr, ground, myCanvas);
            ar.add(ball);
        }
        for (int i = 0; i < ar.size(); i++) {
            ar.get(i).draw();
        }
        // make them bounce
        boolean right = true;
        boolean finished = false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            for (int i = 0; i < ar.size(); i++) {
                ar.get(i).move();

                // stop once ball has travelled a certain distance on x axis
//            if (ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
//                finished = true;
//            }
                if (ar.get(i).getYPosition() == 0) {
                    finished = true;
                }
            }
        }
    }
}
