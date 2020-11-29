
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
class Geometry extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        int yP[] = {150, 150, 315, 500, 500, 315};
        int xP[] = {300, 515, 600, 500, 300, 190};
        int xP2[] = {350, 450, 505, 450, 350, 295};
        int yP2[] = {225, 225, 325, 405, 405, 325};
        int xP3[] = {xP[0], xP[2], xP[5], xP[1], xP[3], xP[5], xP[2], xP[4], xP[0], xP[3], xP[4], xP[1]};
        int yP3[] = {yP[0], yP[2], yP[5], yP[1], yP[3], yP[5], yP[2], yP[4], yP[0], yP[3], yP[4], yP[1]};
        int xP4[] = {xP2[0], xP2[2], xP2[5], xP2[1], xP2[3], xP2[5], xP2[2], xP2[4], xP2[0], xP2[3], xP2[4], xP2[1]};
        int yP4[] = {yP2[0], yP2[2], yP2[5], yP2[1], yP2[3], yP2[5], yP2[2], yP2[4], yP2[0], yP2[3], yP2[4], yP2[1]};
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 800);
//            Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
//             float strokeThickness = 5.0f;
//              float miterLimit = 10f;
//              float[] dashPattern = { 10f };
//              float dashPhase = 5f;
//              BasicStroke stroke = new BasicStroke(strokeThickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
//               miterLimit, dashPattern, dashPhase);
//            g2d.setStroke(stroke);
        g.drawOval(350, 265, 100, 100); //Center Circle
        //Outer Ring
        g.drawOval(450, 265, 100, 100);
        g.drawOval(400, 350, 100, 100);
        g.drawOval(400, 180, 100, 100);
        g.drawOval(300, 350, 100, 100);
        g.drawOval(300, 180, 100, 100);
        g.drawOval(250, 265, 100, 100);
        //Outside Rings
        g.drawOval(550, 265, 100, 100);
        g.drawOval(255, 440, 100, 100);
        g.drawOval(445, 440, 100, 100);
        g.drawOval(150, 265, 100, 100);
        g.drawOval(245, 97, 100, 100);
        g.drawOval(460, 100, 100, 100);
        g.setColor(Color.green);
        g.drawPolygon(xP3, yP3, xP3.length);
        g.setColor(Color.CYAN);

        //Outer Polygon
        g.drawPolygon(xP, yP, xP.length);
        g.drawPolygon(xP2, yP2, xP2.length);
        g.setColor(Color.magenta);
        g.drawPolygon(xP4, yP4, xP4.length);
        g.setColor(Color.RED);
        g.drawString("asv", 10, 100);

    }

    public Color randomColor(int r, int G, int b) {
        r = (int) (random() * 256);
        G = (int) (random() * 256);
        b = (int) (random() * 256);
        return new Color(r, G, b);
    }

}

/**
 * ************************************************************
 * The code below is needed to create the Graphics window. You should not modify
 * or delete any of the code.
 * ***********************************************************
 */
public class SacredGeo {

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
        JFrame frame = new JFrame("Sacred Geometry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(1000, 800));
        frame.getContentPane().add(new Geometry(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
