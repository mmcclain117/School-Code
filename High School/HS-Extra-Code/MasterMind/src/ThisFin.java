
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.System.out;
import java.util.Arrays;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
class MainPanelFin extends JPanel {

    public int numslots;
    public int a[] = new int[2];
    public int ActLine; // Columun number
    public int LineScan; // line number
    public int position; // the position
    public Rectangle rect;
    public int rx;
    public int ry;
    public JFrame frame;
    public int set[] = new int[40];
    public int numrowi;
    public Peg pe = new Peg();

    /* 1 == Blue 
     2 == Red
     3 == Orange
     4 == Yellow
     5 == Green
     6 == LightBlue
     */
    @Override
    public void paintComponent(Graphics g) {
        a = pe.black(set);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 2000, 2000);
        // Board
        Color brown = new Color(165, 42, 42);
        g.setColor(brown);
        g.fillRoundRect(600, 50, 800, 900, 50, 65);
        g.setColor(Color.BLACK);
        // Covered Answer Pegs
        int ax = 850;
        int ay = 75;
        int awl = 75;
        numslots = 4;
        for (int i = 0; i < numslots - 1; i++) {
            g.fillOval(ax, ay, awl, awl);
            ax += 100;
        }

        g.fillOval(ax, ay, awl, awl);
        // The Pegs
        int numrow = 10;
        int x = 650;
        int y = 175;
        int space = 75;
        int d = 50; // Lenght and Width of the Pegs
        if (numrowi < 10) {
            for (int ii = 0; ii < 4; ii++) {
                switch (set[ii]) {
                    case 1:
                        g.setColor(Color.blue);
                        break;
                    case 2:
                        g.setColor(Color.red);
                        break;
                    case 3:
                        g.setColor(new Color(255, 140, 0));
                        break;
                    case 4:
                        g.setColor(Color.yellow);
                        break;
                    case 5:
                        g.setColor(Color.green);
                        break;
                    case 6:
                        g.setColor(Color.magenta);
                        break;
                    default:
                        g.setColor(Color.BLACK);
                        break;
                }
                g.fillOval(x, y, d, d);
                x += 100;
            }
            out.println(Arrays.toString(a));
            x = 650;
            y += space;
        }
        // Response Dots
        d = 25;
        int rx = 1050;
        int ry = 175;
        int black = a[0];
        int white = a[1];
        int noblorwh = 4 - (a[0] + a[1]);
        g.setColor(Color.BLACK);
        for (int i = 0; i < numrow; i++) {
            for (int ii = 0; ii < 4; ii++) {
                while ((black + white + noblorwh) < 4) {
                    if (black > 0) {
                        g.setColor(Color.black);
                        g.drawOval(rx, ry, d, d);
                        rx += 85;
                        black--;
                    } else if (white > 0) {
                        g.setColor(Color.WHITE);
                        g.drawOval(rx, ry, d, d);
                        rx += 85;
                        white--;
                    } else if (noblorwh > 0) {
                        g.setColor(Color.gray);
                        g.drawOval(rx, ry, d, d);
                        rx += 85;
                        noblorwh--;
                    }
                }
            }
            rx = 1050;
            ry += space;
        }
    }

}

class ButtonDemos extends MainPanelFin
        implements ActionListener {

    protected JButton b1, b2, b3, b4, b5, b6, b7;

    public ButtonDemos() {
        ImageIcon leftButtonIcon = new ImageIcon("images/right.gif");
        ImageIcon middleButtonIcon = new ImageIcon("images/middle.gif");
        ImageIcon rightButtonIcon = new ImageIcon("images/left.gif");

        b1 = new JButton("Blue", leftButtonIcon);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("Blue");
        b1.setEnabled(true);

        b2 = new JButton("Red", middleButtonIcon);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setEnabled(true);

        b3 = new JButton("Yellow", rightButtonIcon);
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("Yellow");
        b3.setEnabled(true);

        b4 = new JButton("Orange", rightButtonIcon);
        b4.setMnemonic(KeyEvent.VK_E);
        b4.setActionCommand("Orange");
        b4.setEnabled(true);

        b5 = new JButton("Green", rightButtonIcon);
        b5.setMnemonic(KeyEvent.VK_E);
        b5.setActionCommand("Green");
        b5.setEnabled(true);

        b6 = new JButton("Magenta", rightButtonIcon);
        b6.setMnemonic(KeyEvent.VK_E);
        b6.setActionCommand("LightBlue");
        b6.setEnabled(true);

        b7 = new JButton("Check", rightButtonIcon);
        b7.setMnemonic(KeyEvent.VK_E);
        b7.setActionCommand("Check");
        b7.setEnabled(true);

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (null != e.getActionCommand()) {
            switch (e.getActionCommand()) {
                case "Blue":
                    set[position] = 1;
                    position++;
                    repaint();
                    break;
                case "Red":
                    set[position] = 2;
                    position++;
                    repaint();
                    break;
                case "Orange":
                    set[position] = 3;
                    position++;
                    repaint();
                    break;
                case "Yellow":
                    set[position] = 4;
                    position++;
                    repaint();
                    break;
                case "Green":
                    set[position] = 5;
                    position++;
                    repaint();
                    break;
                case "LightBlue":
                    set[position] = 6;
                    position++;
                    repaint();
                    break;
                case "Check":
                    Peg f = new Peg();
                    int a[] = f.black(set);
                    break;
            }
        }
    }
}

public class ThisFin {

    public static int answerCode[] = Peg.answer;

    public static void main(String[] args) {
        //This is a necessary in order to create the frame window
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                start();
            }
        });
    }

    public static void start() {
        //Sets up the frame
        JFrame frame = new JFrame("MASTERMIND");
        out.println(Arrays.toString(answerCode));
        JButton red = new JButton("RED");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        ButtonDemos dem = new ButtonDemos();
        dem.setOpaque(true); //content panes must be opaque
        frame.setContentPane(dem);
        //Display the window.
        frame.pack();

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(1200, 1200));
        frame.getContentPane().add(new MainPanelFin(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
