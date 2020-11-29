
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Master
 */
public class MyMultiBorderGUI {

    private JFrame frame;
    private JButton buttonNorth;
    private JButton buttonSouth;
    private JButton buttonEast;
    private JButton buttonWest;
    private MyPanel4 panel;

    public MyMultiBorderGUI() {
        frame = new JFrame("My Basic GUI");
        buttonNorth = new JButton("Go North");
        buttonSouth = new JButton("Go South");
        buttonEast = new JButton("Go East");
        buttonWest = new JButton("Go West");
        panel = new MyPanel4();

        frame.add(BorderLayout.CENTER, panel);
        frame.add(BorderLayout.NORTH, buttonNorth);
        frame.add(BorderLayout.SOUTH, buttonSouth);
        frame.add(BorderLayout.EAST, buttonEast);
        frame.add(BorderLayout.WEST, buttonWest);
        buttonNorth.addActionListener(new MyNorthActionListener());
        buttonSouth.addActionListener(new MySouthActionListener());
        buttonEast.addActionListener(new MyEastActionListener());
        buttonWest.addActionListener(new MyWestActionListener());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    class MyNorthActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.moveCircle(0, -5);
            panel.repaint();
        }
    }

    class MySouthActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.moveCircle(0, 5);
            panel.repaint();
        }
    }

    class MyEastActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.moveCircle(5, 0);
            panel.repaint();
        }
    }

    class MyWestActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.moveCircle(-5, 0);
            panel.repaint();
        }
    }
}

class MyPanel4 extends JPanel {

    int x = 50;
    int y = 50;

    @Override
    public void paintComponent(Graphics g) {
        Random r = new Random();
        g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        g.fillOval(x, y, 100, 100);
    }

    public void moveCircle(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }
}
