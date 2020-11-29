package Final;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
class MainPanel extends JPanel {

    public void paintComponent(Graphics g) {

    }
}

public class Set {

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
        frame.setResizable(false);
        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(900, 900));
        frame.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
