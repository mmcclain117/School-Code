
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
public class Rainbow1 {

    public static ArrayList<Coord> gr = new ArrayList();

    public static void main(String[] args) {
//        int x = 3000;
//        int y = 1366;
        for (int x = 0; x < 3000; x++) {
            for (int y = 0; y < 1366; y++) {
                gr.add(new Coord(x, y));
            }
        }
        int i = 0;
//        while (true) {    
        while (i < 100) {
            Runnable r = new Runnable() {
                public void run() {
                    start();
                    run();
                }
            };
        }
        /*
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                start();
            }
        });
         */
    }

    public static void start() {
        int x = 1366;
//        int x = 3000;
//        int y = 1366;
        int y = 768;
        JFrame frame = new JFrame("Rainbow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrayList<Coord> rand = new ArrayList();
        do {
            rand.clear();
            frame.setSize(new Dimension(x, y));
            frame.setBackground(Color.white);
            int randomNum = (int) (sqrt(sqrt((x * y))) * (random()));
//            int randomNum = (int) (sqrt((x * y)) * (random()));
            out.println(randomNum);
            for (int u = 0; u < randomNum; u++) {
                int xx = (int) (random() * gr.size());
                rand.add(gr.get(xx));
            }
//        frame.getContentPane().add(new RPanel(frame, Rainbow1.gr), BorderLayout.CENTER);
            frame.getContentPane().add(new RPanel(frame, rand), BorderLayout.CENTER);
//        Graphics g = frame.getGraphics();

//        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
//        frame.setCursor(blankCursor);
            frame.pack();
//        frame.setUndecorated(true);
            frame.setVisible(true);
//        Runtime.getRuntime().wait(100);
            Graphics g = frame.getGraphics();
//            frame.update(frame.getGraphics());
            frame.update(g);
            frame.setIgnoreRepaint(false);
            frame.paint(g);
        } while (frame.isActive());
    }
}

class RPanel extends JPanel {

    private JFrame Frame;
    private ArrayList<Coord> col;

    RPanel(JFrame frame, ArrayList<Coord> co) {
        Frame = frame;
        col = co;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        lines(col, g);
//        try {
//            /*
//            for (Coord c : col) {
//            Color v = new Color(c.rgb);
//            g.setColor(v);
//            //            Coord y = c;
//            //            out.println(y);
//            g.fillRect(c.xx, c.yy, 1, 1);
//            }
//            */
//            Runtime.getRuntime().wait(100);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(RPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        repaint();
    }

    private void lines(ArrayList<Coord> col, Graphics g) {
        for (int i = 0; i < col.size() - 1; i++) {
            for (int j = 0; j < col.size(); j++) {
                g.drawLine(col.get(i).xx, col.get(i).yy, col.get(j).xx, col.get(j).xx);
            }
        }
    }
}

class Coord {

//    private int xx;
    public int xx;
//    private int yy;
    public int yy;
//    private int rgb;
    public int rgb;

    Coord(int x, int y) {
        xx = x;
        yy = y;
        rgb = getCol();
    }

    private int getCol() {
        return Color.BLACK.getRGB();
        /*
        int r = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        return ((r * 65536) + (g * 256) + b);
         */
    }
}
