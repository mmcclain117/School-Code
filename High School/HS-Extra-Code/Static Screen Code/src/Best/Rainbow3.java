package Best;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jacob Ward
 */
public class Rainbow3 {

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
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d);
        frame.getContentPane().add(new RainbowPanel3(d.width, d.height), BorderLayout.CENTER);
        BufferedImage cursorImg = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY);

        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}

class RainbowPanel3 extends JPanel {

    private final int MAX_X;
    private final int MAX_Y;

    public RainbowPanel3(int x, int y) {
        MAX_X = x;
        MAX_Y = y;
    }

    @Override
    public void paintComponent(final Graphics graphics) {
        for (int c = 0; c < MAX_Y; c += 1) {
            for (int r = 0; r < MAX_X; r += 1) {
                graphics.setColor(Math.random() >= .5 ? Color.WHITE : Color.black);
                graphics.fillRect(r, c, 1, 1);
            }
        }
        repaint();
    }
}
