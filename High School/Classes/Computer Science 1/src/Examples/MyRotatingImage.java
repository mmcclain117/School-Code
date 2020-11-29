package Examples;

/**
 * How to create an image on the screen
 *
 * @author Christine Peterson
 * @version April 2012
 */
import java.awt.*;
import java.net.*;
import javax.swing.*;

public class MyRotatingImage {

    private JFrame frame;
    private MyPanel panel;
    private Image buttonImg;
    private int imgX = 100;
    private int imgY = 100;
    private boolean movingRight = true;

    public MyRotatingImage() {
        frame = new JFrame("Turning Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350); //width and height
        frame.setVisible(true);

        //add a panel for drawing
        panel = new MyPanel();
        frame.getContentPane().add(panel);

        //Image buttonImg = new ImageIcon("images\\button.png").getImage();
        try {
            URL url = this.getClass().getResource("images\\button.png");
            buttonImg = Toolkit.getDefaultToolkit().getImage(url);
        } catch (Exception e) {
        }

        //creates and starts the moving pirate
        MovingImage button = new MovingImage();
        button.start();
    }

    //an inner class
    public class MovingImage extends Thread {

        public void run() {
            while (true) {
                try {
                    frame.repaint(); //refreshes the screen

                    Thread.sleep(30); //delays the code for 30 milliseconds

                } catch (Exception e) {
                    break;
                }
            }
        }

    }

    class MyPanel extends JPanel {

        private double rotation = 0;

        public void paint(Graphics g) {
            //create a varaible typed more specifically as Graphics2D in order to access subclass methods
            Graphics2D g2 = (Graphics2D) g;

            //rotation is in radians. (Use Math.toRadians(Double degrees) to convert if needed)
            rotation += .15;

            //The x and y should be the center of the image
            double rotationAxisX = 100 + new ImageIcon(buttonImg).getIconWidth() / 2;
            double rotationAxisY = 100 + new ImageIcon(buttonImg).getIconHeight() / 2;

            //set the rotation of the Graspics2D object before drawing the image.
            g2.rotate(rotation, rotationAxisX, rotationAxisY);

            g2.drawImage(buttonImg, 100, 100, this);

        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyRotatingImage();
            }
        });
    }
}
