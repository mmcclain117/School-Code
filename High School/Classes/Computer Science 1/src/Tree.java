
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
class Trees extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        int x[] = {400, 475, 450, 500, 450, 525, 475, 550, 450, 475, 400, 325, 350, 250, 325, 275, 350, 300, 350, 325, 400};
        int y[] = {100, 200, 200, 275, 250, 350, 325, 425, 400, 425, 400, 425, 400, 425, 325, 350, 250, 275, 200, 200, 100};
        g.drawPolygon(x, y, x.length);
    }
}

/**
 * ************************************************************
 * The code below is needed to create the Graphics window. You should not modify
 * or delete any of the code.
 * ***********************************************************
 */
public class Tree {

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
        JFrame frame = new JFrame("Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(800, 600));
        frame.getContentPane().add(new Trees(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
