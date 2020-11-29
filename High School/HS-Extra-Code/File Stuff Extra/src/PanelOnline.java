
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.*;

public class PanelOnline extends JFrame {

    private JFrame f;
    private JPanel p;
    private JButton b1;
    private JLabel lab;

    public static void main(String[] args) {
        new PanelOnline();
    }

    public PanelOnline() {

        f = new JFrame("Simon Says");
        f.setVisible(true);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBackground(Color.GRAY);

        b1 = new JButton("Click Here to Begin!");

        p.add(b1);
        f.add(p);
        f.setLocationRelativeTo(null);

        f.add(new DrawStuff(), BorderLayout.CENTER);

    }

    public class DrawStuff extends JComponent {

        public void paint(Graphics2D g) {
            g.fillOval(0, 0, 100, 1000);
            Graphics2D g2 = (Graphics2D) g;
            Graphics2D g3 = (Graphics2D) g;
            Graphics2D g4 = (Graphics2D) g;
            Graphics2D g5 = (Graphics2D) g;

            // assume d == 145 && e == 90
            g2.setPaint(Color.GREEN);
            g2.fill(new Arc2D.Double(150, 150, 200, 200, 145, 90, Arc2D.PIE));

            g3.setPaint(Color.BLUE);
            g3.fill(new Arc2D.Double(150, 150, 200, 200, 235, 90, Arc2D.PIE));

            g4.setPaint(Color.RED);
            g4.fill(new Arc2D.Double(150, 150, 200, 200, 325, 90, Arc2D.PIE));

            g5.setPaint(Color.YELLOW);
            g5.fill(new Arc2D.Double(150, 150, 200, 200, 55, 90, Arc2D.PIE));

        }

    }

}
