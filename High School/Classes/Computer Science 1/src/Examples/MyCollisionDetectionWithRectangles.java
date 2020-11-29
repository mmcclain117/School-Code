package Examples;

/**
 * How to create a JPanel to draw on.
 *
 * @author Christine Peterson
 * @version April 2012
 */
import java.awt.*;
import javax.swing.*;

public class MyCollisionDetectionWithRectangles {

    private JFrame frame;
    private MyPanel panel;
    private Rectangle bullet = new Rectangle(500, 130, 5, 5);
    private Rectangle redBox = new Rectangle(50, 100, 100, 60);
    private boolean boxAlive = true;

    public MyCollisionDetectionWithRectangles() {
        frame = new JFrame("When Two Rectangles Collide");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); //width and height
        frame.setVisible(true);

        //add a panel for drawing
        panel = new MyPanel();
        frame.getContentPane().add(panel);

        MovingBullet bulletThread = new MovingBullet();
        bulletThread.start();
    }

    class MyPanel extends JPanel {

        public void paint(Graphics g) {
            super.paint(g); //allow it to paint as before

            Graphics2D g2D = (Graphics2D) g; //cast as a Graphics2D for more methods.

            //make a dark gray rectangle for the background
            g2D.setColor(Color.DARK_GRAY);
            g2D.fillRect(0, 0, 600, 400);

            //draw a red rectangle
            if (boxAlive) {
                g2D.setColor(Color.red);
                g2D.fill(redBox);
                g2D.setColor(Color.white);
                g2D.fill(bullet);
            } else {
                g2D.setColor(Color.black);
                g2D.fill(redBox);
            }
        }
    }

    //an inner class
    private class MovingBullet extends Thread {

        public void run() {
            while (true) {
                try {
                    frame.repaint(); //refreshes the screen

                    Thread.sleep(30); //delays the code for 75 milliseconds  

                    //move bullet toward red rectangle
                    bullet.x -= 5;

                    //check for collision
                    if (bullet.intersects(redBox)) //or use intersects()
                    {
                        boxAlive = false;
                        frame.repaint();
                        bullet = null;
                        break;
                    }

                } catch (Exception e) {
                    break;
                }
            }
        }

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyCollisionDetectionWithRectangles();
            }
        });
    }
}
