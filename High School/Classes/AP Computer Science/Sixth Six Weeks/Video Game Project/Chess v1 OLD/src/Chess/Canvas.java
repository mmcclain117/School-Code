
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import static java.lang.System.out;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Piece implements ActionListener {

    public Piece() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        out.println(e.getActionCommand());
    }

}

class MainPanel extends JFrame {

    public MainPanel() {

    }

    @Override
    public void paint(Graphics g) {

    }
}

public class Canvas {

    public static void main(String args[]) {
        start();
    }

    private static void start() {
        JPanel pan = new JPanel();
        JFrame f = new JFrame();
        f.add(pan);
        Piece p = new Piece();
        Dimension d = new Dimension();
        f.setSize(d.getSize());
    }
}
