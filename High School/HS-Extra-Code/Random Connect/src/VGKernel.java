
import java.util.*;
// Import the basic graphics classes.
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Master
 */
public class VGKernel extends JPanel {

// This is not a recommended coding practice, just a shortcut.
    public Rectangle screen, bounds; // The screen area and boundary.
    public JFrame frame; // A JFrame to put the graphics into.
    public VGTimerTask vgTask; // The TimerTask that runs the game.
    public VGBall ball; // The game ball.
// Create a constructor method:

    public VGKernel() {
        super();
        screen = new Rectangle(0, 0, 600, 400);
        bounds = new Rectangle(0, 0, 600, 400); // Give some temporary values.
        ball = new VGBall();
        frame = new JFrame("VGKernel");
        vgTask = new VGTimerTask();
    }

    // Create an inner TimerTask class that has access to the
    // members of the VGKernel.
    class VGTimerTask extends TimerTask {

        public void run() {
            ball.move();
            frame.repaint();
        }
    }

    // Create an inner VGBall class that has our game logic in it.
    class VGBall {
        // Accessor methods would be more proper,
        // but for now I just make the needed variables public.

        public int x, y, width, height; // Ball's location and size.
        int xVel, yVel; // The ball's velocity.

        public VGBall() {
            x = 0;
            y = 0;
            width = 20;
            height = 20;
            xVel = width / 4;
            yVel = height / 4;
        }
        // Instance methods for VGBall

        public void move() {
            // Move the ball according to the game rules.
            x += xVel; // Move horizontally.
            y += yVel; // Move vertically.
            // Detect edges and bounce if necessary.
            if (x > (bounds.width - width)) {
                xVel = -xVel; // reverse movement.
                x = bounds.width - width; // Set location to screen edge.
            }
            if (y > (bounds.height - height)) {
                yVel = -yVel; // reverse movement.
                y = bounds.height - height;
            }
            if (x <= 0) {
                xVel = -xVel;
                x = 0;
            }
            if (y <= 0) {
                yVel = -yVel;
                y = 0;
            }
        }
    } // end of class VGBall

// Now the instance methods:
    public void paintComponent(Graphics g) {
        // Get the drawing area bounds for game logic.
        bounds = g.getClipBounds();

        // Clear the drawing area, then draw the ball.
        g.clearRect(screen.x, screen.y, screen.width, screen.height);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
    }

    public static void main(String arg[]) {

        java.util.Timer vgTimer = new java.util.Timer();  // Create a Timer object
        VGKernel panel = new VGKernel();

        panel.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.frame.setSize(panel.screen.width, panel.screen.height);

        panel.frame.setContentPane(panel);
        panel.frame.setVisible(true);

        // Set up a timer to do the vgTask regularly.
        vgTimer.schedule(panel.vgTask, 0, 33);
    }
}
