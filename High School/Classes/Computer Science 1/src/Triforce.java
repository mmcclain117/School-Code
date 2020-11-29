
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.Math.random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
class Tri extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        int x = 100;
        int y = 50;
        for (int i = 0; i <= 10; i++) {
            for (int ii = 0; ii <= 10; ii++) {
                g.setColor(Color.blue);
                fillTriforce(g, x, y);
                x += 125;
                y += 0;
            }
            x = 0;
            y += 100;
        }
    }

    private Color randomColor() {
        int r = (int) (random() * 256);
        int G = (int) (random() * 256);
        int b = (int) (random() * 256);
        return new Color(r, G, b);
    }

    private void fillTriforce(Graphics g, int x, int y) {
        int xPoints[] = {x + 0, x + 25, x + 0, x + 25, x - 50, x + 0, x - 100};
        int yPoints[] = {y + 0, y + 100, y + 100, y + 50, y + 50, y + 100, y + 100};
        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }
}

/**
 * ************************************************************
 * The code below is needed to create the Graphics window. You should not modify
 * or delete any of the code.
 * ***********************************************************
 */
public class Triforce {

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
        frame.getContentPane().add(new Tri(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
