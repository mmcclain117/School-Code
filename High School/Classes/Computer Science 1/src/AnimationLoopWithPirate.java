
/**
 * How to create an image on the screen
 *
 * @author Christine Peterson
 * @version April 2012
 */
import java.awt.*;
import java.net.*;
import javax.swing.*;

public class AnimationLoopWithPirate {

    private JFrame frame;
    private MyPanel panel;
    private Image imgPirate;
    private int imgX = 100;
    private int imgY = 100;
    private boolean movingRight = true;

    public AnimationLoopWithPirate() {
        frame = new JFrame("Moving Pirate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); //width and height
        frame.setVisible(true);

        //add a panel for drawing
        panel = new MyPanel();
        frame.getContentPane().add(panel);

        //creates and starts the moving pirate
        MyAnimationLoop loop = new MyAnimationLoop();
        loop.start();
    }

    //an inner class
    public class MyAnimationLoop extends Thread {

        public void run() {
            while (true) {
                try {
                    frame.repaint(); //prepaints the screen

                    Thread.sleep(30); //delays the code for 30 milliseconds

                    //updates the position of the image's X coordinate to move right and left
                    if (movingRight) {
                        imgX += 2;
                        if (imgX >= 600 - 200) {
                            movingRight = false;
                        }
                    } else {
                        imgX -= 2;
                        if (imgX <= 100) {
                            movingRight = true;
                        }
                    }

                } catch (Exception e) {
                    break;
                }
            }
        }

    }

    class MyPanel extends JPanel {

        public void paint(Graphics g) {
            //super.paint(g); //allow it to paint as before

            //make a green rectangle for the background
            g.setColor(Color.green);
            g.fillRect(0, 0, 600, 400);

            //draw a blue rectangle for the sky
            g.setColor(Color.cyan);
            g.fillRect(0, 0, 600, 150);

            //draw an image on screen.
            try {
                URL url = this.getClass().getResource("images/pirate.png");
                imgPirate = Toolkit.getDefaultToolkit().getImage(url);
            } catch (Exception e) {
            }

            g.drawImage(imgPirate, imgX, imgY, this);

        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AnimationLoopWithPirate();
            }
        });
    }
}
