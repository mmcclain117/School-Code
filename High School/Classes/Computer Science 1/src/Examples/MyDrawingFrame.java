package Examples;

/**
 * How to create a JPanel to draw on.
 *
 * @author Christine Peterson
 * @version April 2012
 */
import java.awt.*;
import javax.swing.*;

public class MyDrawingFrame {

    private JFrame frame;
    private MyPanel panel;

    public MyDrawingFrame() {
        frame = new JFrame("Header Goes Here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); //width and height
        frame.setVisible(true);

        //add a panel for drawing
        panel = new MyPanel();
        frame.getContentPane().add(panel);
    }

    class MyPanel extends JPanel {

        public void paint(Graphics g) {
            super.paint(g); //allow it to paint as before

            //make a dark gray rectangle for the background
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 600, 400);

            //draw a red rectangle
            g.setColor(Color.red);
            g.fillRect(50, 100, 100, 60);

        }
    }
}
