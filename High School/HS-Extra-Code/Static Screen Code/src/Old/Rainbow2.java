package Old;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Master Ward
 */
public class Rainbow2 {

    public static ArrayList<Coord> gr = new ArrayList();

    public static void main(String[] args) {
//        int x = 3000;
//        int y = 1366;
        for (int x = 0; x < 3000; x++) {
            for (int y = 0; y < 1366; y++) {
                gr.add(new Coord(x, y));
            }
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                start();
            }
        });
    }

    public static void start() {
//        int x = 1366;
        int x = 3000;
        int y = 1366;
//        int y = 768;
        JFrame frame = new JFrame("Rainbow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(new Dimension(x, y));
        frame.getContentPane().add(new RPanel(frame, Rainbow2.gr), BorderLayout.CENTER);
        Graphics g = frame.getGraphics();

//        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
//        frame.setCursor(blankCursor);
        frame.pack();
//        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}

class RPanel extends JPanel {

    private final JFrame Frame;
    private ArrayList<Coord> col;

    RPanel(JFrame frame, ArrayList<Coord> co) {
        Frame = frame;
        col = co;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (Coord c : col) {
            Coord y = c;
            out.println(y);
            g.fillRect(10, 10, 10, 10);
        }
    }
}

class Coord {

    private int xx;
    private int yy;
    private int rgb;

    Coord(int x, int y) {
        xx = x;
        yy = y;
        rgb = getCol();
    }

    private int getCol() {
        int r = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        return ((r * 65536) + (g * 256) + b);
    }
}
