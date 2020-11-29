
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master and Ryan Talbot
 */
public class SomethingCool {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x = tk.getScreenSize().width, y = tk.getScreenSize().height;
//        System.out.println(x + " " + y);
        frame.setSize(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        JPanel panel = new JPanel() {
            Random rand = new Random();

            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.BLACK);
                g.fillRect(rand.nextInt(x + 1) + 10, rand.nextInt(y + 1) + 10, 10, 10);
            }
        };

        panel.setOpaque(true);

        new Thread() {
            public void run() {
                while (true) {
                    panel.repaint();
                }
            }
        }.start();

        frame.add(panel);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }
}
