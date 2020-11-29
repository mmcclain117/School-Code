
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Master
 */
class MainPanels extends JPanel {

    public int numslots;
    public int it[];
    public int ActLine; // Columun number
    public int LineScan; // line number
    public int position; // the position
    public Rectangle rect;
    public int rx;
    public int ry;
    public JFrame frame;
    public Gamer place;
    public int sets[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* 1 == Blue 
     2 == Red
     3 == Orange
     4 == Yellow
     5 == Green
     8 == LightBlue
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        int it[] = new int[4]; //Active row guess
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
        if (numrow < 10) {
            for (int ii = 0; ii < 4; ii++) {
                switch (sets[ii]) {
                    case 1:
                        g.setColor(Color.blue);
                        break;
                    case 2:
                        g.setColor(Color.red);
                        break;
                    case 3:
                        g.setColor(Color.orange);
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
            x = 650;
            y += space;
            numrow++;
        }
        // Response Dots
        d = 25;
        int rx = 1050;
        int ry = 175;
        boolean more = true;
        g.setColor(Color.BLACK);
        int asa[] = new int[4];
        for (int i = 0; i < 4; i++) {
            asa[i] = sets[position % 4];
        }
        Peg pe = new Peg();
        int sss[] = pe.black(asa);
        int blackcount = sss[0];
        int whitecount = sss[1];
        int q = 4;
        for (int i = 0; i < numrow; i++) {
            for (int ii = 0; ii < 4; ii++) {
                while (more) {
                    if (blackcount > 0) {
                        g.fillOval(rx, ry, d, d);
                        rx += 85;
                        blackcount--;
                    } else if (whitecount > 0) {
                        g.setColor(Color.white);
                        g.fillOval(rx, ry, d, d);
                        rx += 85;
                        whitecount--;
                    } else if (sss[0] + sss[1] <= q) {
                        g.drawOval(rx, ry, d, d);
                        rx += 85;
                        q++;
                    } else {
                        more = false;
                    }
                }
            }
            rx = 1050;
            ry += space;

        }
    }
}

class ButtonDemo extends MainPanels
        implements ActionListener {

    protected JButton b1, b2, b3, b4, b5, b6, b7, b8;

    public ButtonDemo() {
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

        b3 = new JButton("Orange", rightButtonIcon);
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("Orange");
        b3.setEnabled(true);

        b4 = new JButton("Yellow", rightButtonIcon);
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b4.setMnemonic(KeyEvent.VK_E);
        b4.setActionCommand("Yellow");
        b4.setEnabled(true);

        b5 = new JButton("Green", leftButtonIcon);
        b5.setVerticalTextPosition(AbstractButton.CENTER);
        b5.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b5.setMnemonic(KeyEvent.VK_D);
        b5.setActionCommand("Green");
        b5.setEnabled(true);

        b6 = new JButton("LightBlue", middleButtonIcon);
        b6.setVerticalTextPosition(AbstractButton.BOTTOM);
        b6.setHorizontalTextPosition(AbstractButton.CENTER);
        b6.setMnemonic(KeyEvent.VK_M);
        b6.setActionCommand("LightBlue");
        b6.setEnabled(true);

        b7 = new JButton("Check", middleButtonIcon);
        b7.setVerticalTextPosition(AbstractButton.CENTER);
        b7.setHorizontalTextPosition(AbstractButton.CENTER);
        b7.setMnemonic(KeyEvent.VK_C);
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
                    sets[position] = 1;
                    position++;
                    repaint();
                    break;
                case "Red":
                    sets[position] = 2;
                    position++;
                    repaint();
                    break;
                case "Orange":
                    sets[position] = 3;
                    position++;
                    repaint();
                    break;
                case "Yellow":
                    sets[position] = 4;
                    position++;
                    repaint();
                    break;
                case "Green":
                    sets[position] = 5;
                    position++;
                    repaint();
                    break;
                case "LightBlue":
                    sets[position] = 6;
                    position++;
                    repaint();
                    break;
                case "Check":
                    sets[position] = 7;
                    position = 0;
                    repaint();
                    break;
            }
        }
    }
}

public class This {

    public int answerCode[] = Peg.answer;

    public static void main(String[] args) {
        //This is a necessary in order to create the frame window
        javax.swing.SwingUtilities.invokeLater(() -> {
            start();
        });
    }

    public static void start() {
        //Sets up the frame
        JFrame frame = new JFrame("MASTERMIND");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        ButtonDemo dem = new ButtonDemo();
        dem.setOpaque(true); //content panes must be opaque
        frame.setContentPane(dem);
        //Display the window.
        frame.pack();

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(1200, 1200));
        frame.getContentPane().add(new MainPanels(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
