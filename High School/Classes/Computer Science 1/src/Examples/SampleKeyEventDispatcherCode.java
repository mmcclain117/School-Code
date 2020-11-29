package Examples;

/**
 *
 * @author Master
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SampleKeyEventDispatcherCode {

    private int x = 100;
    private int y = 100;
    private Rectangle rect;
    private MyPanel panel;

    public static void main(String args[]) {
        new SampleKeyEventDispatcherCode();
    }

    public SampleKeyEventDispatcherCode() {
        JFrame frame = new JFrame();
        rect = new Rectangle(x, y, 50, 50);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyKeyDispatcher());
        panel = new MyPanel();
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public class MyKeyDispatcher implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                System.out.println(e.getKeyCode());
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) //Left == 37
            {
                rect.x += 5;
                panel.repaint();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) //Right == 39
            {
                rect.x -= 5;
                panel.repaint();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) //Up == 38
            {
                rect.y -= 5;
                panel.repaint();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) //Down == 40
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
            g2D.setColor(Color.white);
            g2D.fillRect(0, 0, panel.getWidth(), panel.getHeight());
            g2D.setColor(Color.green);
            g2D.fill(rect);
        }
    }
}
