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

public class MyImages {

    private JFrame frame;
    private MyPanel2 panel;

    public MyImages() {
        frame = new JFrame("Header Goes Here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); //width and height
        frame.setVisible(true);

        //add a panel for drawing
        panel = new MyPanel2();
        frame.getContentPane().add(panel);
    }

}

class MyPanel2 extends JPanel {

    public void paint(Graphics g) {
        super.paint(g); //allow it to paint as before

        //make a green rectangle for the background
        g.setColor(Color.green);
        g.fillRect(0, 0, 400, 400);

        //draw a blue rectangle for the sky
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 400, 150);

        //The try catch structure handles Exceptions which may be thrown in the try
        Image img = null;
        try {
            URL url = this.getClass().getResource("images/pirate.png");
            img = Toolkit.getDefaultToolkit().getImage(url);
        } catch (Exception e) {
        }

        //draw an image on screen.
        g.drawImage(img, 100, 100, this);

    }

}
