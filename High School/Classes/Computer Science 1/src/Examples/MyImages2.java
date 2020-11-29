package Examples;

/**
 * How to create an image on the screen
 *
 * @author Christine Peterson
 * @version April 2012
 */
import java.awt.*;
import javax.swing.*;

public class MyImages2 {

    private JFrame frame;
    private MyPanel panel;

    public MyImages2() {
        frame = new JFrame("Header Goes Here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); //width and height
        frame.setVisible(true);

        //add a panel for drawing
        panel = new MyPanel();
        frame.getContentPane().add(panel);
    }

}

class MyPanel extends JPanel {

    public void paint(Graphics g) {
        super.paint(g); //allow it to paint as before

        Image img = new ImageIcon("images/pirate.png").getImage();

        //draw an image on screen.
        g.drawImage(img, 100, 100, this);

    }
}
