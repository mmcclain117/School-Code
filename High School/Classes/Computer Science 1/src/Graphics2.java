
import java.awt.*;
import javax.swing.*;
import java.lang.*;

/**
 *
 * @author Master
 */
class state extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        for (int KL = 0; KL <= 16; KL++) {
            for (int st = 0; st < 20; st++) {
                int x = 10;
                int y = 10;
                int R = (int) (Math.random() * 256);
                int G = (int) (Math.random() * 256);
                int B = (int) (Math.random() * 256);
                Color randomColor = new Color(R, G, B);
                g.setColor(Color.RED);
                g.drawOval(x, y, 10, 10);
                x += 25;
                y += 25;
                g.setColor(randomColor);
            }
        }
    }
}

/**
 *
 * @author Master
 */
public class Graphics2 {

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
        JFrame frame = new JFrame("Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(800, 600));
        frame.getContentPane().add(new state(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
