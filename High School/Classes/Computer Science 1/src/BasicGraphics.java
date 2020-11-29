

/* package whatever; // don't place package name! */
// Name: Jacob Ward
// Period: 4A
// Date: 12 /16 /2014
// Assignment: This one
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Master
 */
class MainPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Font myFont = new Font("Arial", Font.BOLD, 36);
        g.setFont(myFont);
        g.fillOval(50, 50, 200, 200);
        g.drawRect(300, 50, 200, 200);
        g.drawLine(400, 250, 400, 125);
        g.drawRect(300, 300, 200, 200);
        g.drawRect(350, 350, 200, 200);
        g.drawLine(300, 300, 350, 350);
        g.drawLine(300, 500, 350, 550);
        g.drawLine(500, 500, 550, 550);
        g.drawString("Your Name ", 125, 300);
        g.drawOval(25, 400, 250, 250);
        g.drawOval(50, 400, 200, 250);
        g.drawOval(100, 400, 100, 250);
        g.drawOval(25, 450, 250, 125);
        g.drawLine(500, 300, 550, 350);
    }
}

/**
 * ************************************************************
 * The code below is needed to create the Graphics window. You should not modify
 * or delete any of the code.
 * ***********************************************************
 */
public class BasicGraphics {

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
        frame.setSize(new Dimension(900, 900));
        frame.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
