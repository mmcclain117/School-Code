package Examples;

/**
 * How to use a JFrame
 *
 * @author Christine Peterson
 * @version April 2012
 */
import javax.swing.JFrame;

public class MyFrame {

    private final JFrame frame;

    public MyFrame() {
        frame = new JFrame("Header Goes Here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); //width and height
        frame.setVisible(true);
    }

}
