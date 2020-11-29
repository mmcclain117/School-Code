
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.Math.random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
class States extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        int x;
        int y;
        x = 50;
        y = 50;
        int a = 100;
        g.fillOval(x, y, a, a);
    }

    public void randomColor() {
        int r = (int) (random() * 256);
        int G = (int) (random() * 256);
        int b = (int) (random() * 256);
    }
}

public class State {

    public static void main(String[] args) {
        //This is a necessary in order to create the frame window
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                start();
            }
        });
    }

    public static void start() {

        //Sets up the frame
        JFrame frame = new JFrame("State");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(800, 600));
        frame.getContentPane().add(new States(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
