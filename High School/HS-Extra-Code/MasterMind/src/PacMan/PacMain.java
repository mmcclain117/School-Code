package PacMan;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
public class PacMain {

    private int x = 100;
    private int y = 100;
    private Rectangle rect;
    private MyPanel panel;
    private Area border;
    public static JFrame frame;
    private static Rectangle rectang1;
    private static Rectangle rectang2;
    private Rectangle pacsdir = new Rectangle(500, 130, 5, 5);

    public static void main(String args[]) {
        new PacMain();
    }

    public PacMain() {
        JFrame frame = new JFrame();
        rect = new Rectangle(x, y, 50, 50);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyKeyDispatcher());
        panel = new MyPanel();
        MovingPac pacthread = new MovingPac();
        pacthread.start();
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    private class MovingPac extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    frame.repaint();
                    Thread.sleep(30);
                    pacsdir.x -= 1;
                    if (pacsdir.intersects(rectang1)) {
                        frame.repaint();
                        break;
                    }
                } catch (Exception e) {
                    break;
                }
            }
        }
    }

    public class MyKeyDispatcher implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                System.out.println(e.getKeyCode());
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) //Left
            {
                rect.x += 5;
                panel.repaint();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) //Right
            {
                rect.x -= 5;
                panel.repaint();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) //Up
            {
                rect.y -= 5;
                panel.repaint();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) //Down
            {
                rect.y += 5;
                panel.repaint();
            }
            return false;
        }
    }

    private class MyPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.setColor(Color.black);
            g2D.fillRect(0, 0, panel.getWidth(), panel.getHeight());
            g2D.setColor(Color.red);
            g2D.fill(rect);
        }
    }

    public static void createVoid() {
        Area border = new Area();
        rectang1.setRect(0, 0, 800, 800);
        rectang2.setRect(10, 10, 780, 780);
        Area t = new Area(rectang1);
        Area tt = new Area(rectang2);
        border.add(t);
        border.subtract(tt);
    }
}
