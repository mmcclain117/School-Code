
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master Ward
 */
class Bax extends JPanel {

    public int numslots;
    public ArrayList allPegs;
    public ArrayList ActLine;
    public ArrayList LineScan;

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        allPegs = new ArrayList();
        g.fillRect(0, 0, 2000, 2000);
        // Board
        Color brown = new Color(165, 42, 42);
        g.setColor(brown);
        g.fillRoundRect(600, 50, 800, 900, 50, 65);
        g.setColor(Color.BLACK);
        // Covered Answer Pegs
        int ax = 850;
        int ay = 75;
        int awl = 75;
        numslots = 4;
        for (int i = 0; i < numslots - 1; i++) {
            g.fillOval(ax, ay, awl, awl);
            ax += 100;
        }
        g.fillOval(ax, ay, awl, awl);
        // The Pegs
        int numrow = 10;
        int x = 650;
        int y = 175;
        int space = 75;
        int d = 50; // Lenght and Width of the Pegs
        for (int i = 0; i < numrow; i++) {
            for (int ii = 0; ii < 4; ii++) {
                g.fillOval(x, y, d, d);
                x += 100;
            }
            x = 650;
            y += space;
        }
        // Response Dots
        d = 25;
        int rx = 1050;
        int ry = 175;
        for (int i = 0; i < numrow; i++) {
            for (int ii = 0; ii < 4; ii++) {
                g.drawOval(rx, ry, d, d);
                rx += 85;
            }
            rx = 1050;
            ry += space;
        }
    }
}

public class BasicBoard {

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
        JButton red = new JButton("RED");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        //Display the window.
        frame.pack();

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(1200, 1200));
        frame.getContentPane().add(new Bax(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
