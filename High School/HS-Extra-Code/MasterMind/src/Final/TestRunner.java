package Final;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Master
 */
public class TestRunner {

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
        JFrame frame = new JFrame("MASTERMIND");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        ButtonDemos bd = new ButtonDemos();
        bd.setOpaque(true);
        frame.setContentPane(bd);

        frame.pack();
        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(1200, 1200));
        frame.getContentPane().add(new Board(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
