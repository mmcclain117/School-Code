
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Master Ward
 */
public class SampleKeyListenerDemo extends Canvas {

    JFrame frame;
    int x = 235;
    int y = 235;

    public SampleKeyListenerDemo() {
        frame = new JFrame("KeyListener Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new MyKeyListener());
        frame.add(this);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 20, 20);

    }

    class MyKeyListener implements KeyListener {

        public void keyPressed(KeyEvent e) {
            System.out.println("Key pressed.");
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    x += 5;
                    repaint();
                    break;
                case KeyEvent.VK_LEFT:
                    x -= 5;
                    repaint();
                    break;
                case KeyEvent.VK_DOWN:
                    y += 5;
                    repaint();
                    break;
                case KeyEvent.VK_UP:
                    y -= 5;
                    repaint();
                    break;

            }

        }

        public void keyReleased(KeyEvent e) {
            System.out.println("Key released.");
        }

        public void keyTyped(KeyEvent e) {
            System.out.println("Key typed.");
        }
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SampleKeyListenerDemo();
            }
        });
    }

}
