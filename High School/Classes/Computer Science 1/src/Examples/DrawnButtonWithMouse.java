package Examples;

/**
 * Write a description of class PracticeMouseListener here.
 *
 * @author Master
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawnButtonWithMouse implements MouseListener {

    JFrame frame;
    DBWMPanel panel;
    public Rectangle button = new Rectangle(75, 150, 125, 50);
    Color currColor = Color.BLUE;

    public DrawnButtonWithMouse() {
        frame = new JFrame("Drawn Button");
        panel = new DBWMPanel(this);

        frame.add(BorderLayout.CENTER, panel);
        panel.addMouseListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
        Point point = e.getPoint();

        if (button.contains(point)) {
            if (currColor == Color.BLUE) {
                currColor = Color.RED;
            } else if (currColor == Color.RED) {
                currColor = Color.BLUE;
            }

            panel.repaint();
        }

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}

class DBWMPanel extends JPanel {

    DrawnButtonWithMouse demo;

    public DBWMPanel(DrawnButtonWithMouse demo) {
        this.demo = demo;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(demo.currColor);
        g2D.fill(demo.button);

        g2D.setColor(Color.BLACK);
        g2D.drawString("Use a Rectangle object to draw a button.", 20, 50);
        g2D.drawString("The code tests if the mouse-released point ", 20, 70);
        g2D.drawString("is in the rectangle and, if so, changes the state.", 20, 90);
    }
}
