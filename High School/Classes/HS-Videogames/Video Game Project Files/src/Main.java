
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 *
 * @author Master Ward
 */
class MainPane extends JFrame {

    public MainPane() {

    }
}

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Da buttons");
        JMenuBar ba = new JMenuBar();
        Rectangle rect = new Rectangle();
        JButton b = new JButton("Red");
        rect.x = 0;
        rect.y = 0;
        rect.height = 100;
        rect.width = 500;
        JButton b2 = new JButton("Orange");
        JButton b3 = new JButton("Blue");
        JButton b4 = new JButton("Yellow");
        JButton b5 = new JButton("Purple");
        JButton b6 = new JButton("Pink");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 100);
        f.setVisible(true);
        b.getBounds(rect);
        b2.getBounds(rect);
        ba.add(b6);
        ba.add(b5);
        ba.add(b4);
        ba.add(b3);
        ba.add(b2);
        ba.add(b);
        f.getJMenuBar();
        f.add(ba);
    }

    public void actionPerformed(ActionEvent e) {

    }

}
