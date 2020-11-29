
import java.awt.*;
import javax.swing.*;

class MainPanel extends JPanel {

    @Override
    public void paintComponent(java.awt.Graphics g) {

    }
}

/**
 * ************************************************************
 * The code below is needed to create the Graphics window. You should not modify
 * or delete any of the code.
 * ***********************************************************
 */
public class Graphics {

    public static void main(String[] args) {
        //This is a necessary in order to create the frame window
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                start();
            }
        });
    }

    public static void start() {

        //Sets up the frame
        JFrame frame = new JFrame("Spinner Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(800, 600));
        frame.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
        frame.setVisible(true);

    }
}
