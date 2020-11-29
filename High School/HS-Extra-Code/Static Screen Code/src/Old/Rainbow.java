package Old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jacob Ward
 */
public class Rainbow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                start();
            }
        });
    }

    public static void start() {
        JFrame frame = new JFrame("Rainbow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(new Dimension(1366, 768));
        frame.getContentPane().add(new RainbowPanel(1366, 768, frame), BorderLayout.CENTER);
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        frame.setCursor(blankCursor);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}

class RainbowPanel extends JPanel {

    private final int MAX_X;
    private final int MAX_Y;
    private final JFrame FRAME;

    public RainbowPanel(int x, int y, JFrame frame) {
        MAX_X = x;
        MAX_Y = y;
        FRAME = frame;

        TimerTask task = new TimerTask() {

            public void run() {
                FRAME.repaint();
            }
        };

        new Timer().schedule(task, 1, 1);
    }

    public void paintComponent(final Graphics graphics) {
        final Random random = new Random();

        for (int c = 0; c < MAX_Y; c += 1) {
            for (int r = 0; r < MAX_X; r += 1) {
                graphics.setColor(new Color(random.nextInt(255), random.nextInt(255),
                        random.nextInt(255)));
                graphics.fillRect(r, c, 1, 1);
            }
        }
    }

}
