
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master Ward
 */
class MainPanels extends JPanel {

    public static final int numberrow = 10;
    public static Peg p = new Peg();
    public static Checker Check = new Checker();
    public static int answerCode[] = p.createAnswer();
    public static int[] answers = answerCode;

    public final int numslots = 4;
    public static int[] it = new int[20];

    public static int position; // the position
    public static int rx;
    public int ry;
    public static int bwpos;

    public static final ArrayList blwh = p.s();
    public static ArrayList set = p.s();
    public static int a[] = new int[2];
    public static int numrow = 10;
    public static int tryy = 0;
    public static int ice = 0;
    public static int s = 0;
    public static int cre = 1;
    public static int[] bla = new int[10];
    public static int[] whi = new int[10];
    public static boolean on = false;
    public static int lol = -1;
    public static int[] h = new int[10];
    public static int[] b = new int[10];
    public boolean show = false;
    public static int felina = 10;

    /* 1 == Blue 
     2 == Red
     3 == Orange
     4 == Yellow
     5 == Green
     6 == LightBlue
     */
    public void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 2000, 2000); // BackGround
        // Board
        Color brown = new Color(165, 42, 42);
        g.setColor(brown);
        g.fillRoundRect(600, 50, 800, 900, 50, 65); // board
        g.setColor(Color.BLACK);
        // Covered Answer Pegs
        int ax = 850;
        int ay = 75;
        int awl = 75;

        for (int i = 0; i < numslots; i++) {
            if (show == false) {
                g.drawOval(ax, ay, awl, awl);
                ax += 100;
            } else {
                switch (answerCode[i]) {
                    case 1:
                        g.setColor(Color.blue);
                        g.fillOval(ax, ay, awl, awl);
                        ax += 100;
                        break;
                    case 2:
                        g.setColor(Color.red);
                        g.fillOval(ax, ay, awl, awl);
                        ax += 100;
                        break;
                    case 3:
                        g.setColor(new Color(255, 140, 0));
                        g.fillOval(ax, ay, awl, awl);
                        ax += 100;
                        break;
                    case 4:
                        g.setColor(Color.yellow);
                        g.fillOval(ax, ay, awl, awl);
                        ax += 100;
                        break;
                    case 5:
                        g.setColor(Color.green);
                        g.fillOval(ax, ay, awl, awl);
                        ax += 100;
                        break;
                    case 6:
                        g.setColor(Color.magenta);
                        g.fillOval(ax, ay, awl, awl);
                        ax += 100;
                        break;
                    default:
                        g.setColor(Color.BLACK);
                        g.drawOval(ax, ay, awl, awl);
                        ax += 100;
                        break;
                }
            }
        }
        int numrowlef = 10;
        int d = 50; // Lenght and Width of the Pegs
        while (numrowlef > 0) {
            // The Pegs
            int x = 650;
            int space = 75;
            int y = 175 + ((10 - numrowlef) * space);
            ry = y;

            d = 50;
            for (int ii = 0; ii < 4; ii++) {
                switch ((int) set.get(ii + ((10 - numrowlef) * 4))) {
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
            d = 25;

            int[] checks = new int[4];
            int f = 0;

            for (int gg = 0; gg < 10; gg++) {
                int rx = x;

                if (on == true) {

                    bla[lol] = it[ice];
                    whi[lol] = it[ice + 1];
                    int yx = (bla[lol]);
                    int yy = whi[lol];
                    h[lol] = yx;
                    b[lol] = yy;
                    ice += 2;
                    on = false;
                }

                int wb = 4 - bla[tryy] - whi[tryy];

                while (bla[tryy] > 0) {
                    g.setColor(Color.BLACK);
                    g.fillOval(rx, ry, d, d);
                    rx += 85;
                    bla[tryy]--;
                }
                while (whi[tryy] > 0) {
                    g.setColor(Color.white);
                    g.fillOval(rx, ry, d, d);
                    rx += 85;
                    whi[tryy]--;
                }
                while (wb > 0) {
                    g.setColor(Color.black);
                    g.drawOval(rx, ry, d, d);
                    rx += 85;
                    wb--;
                }
                //bla[tryy]=h;
                //whi[tryy]=b;
                tryy++;
                ry += space;
            }
            tryy = 0;
            // There is something Wrong

            x = 650;
            rx = x + 400;
            y += space;
            //ry = y + 100;
            numrowlef--;

        }
        numrowlef = 10;
        bwpos = 0;
        // Response Dots
        for (int u = 0; u < 10; u++) {

            bla[u] = h[u];
            whi[u] = b[u];

        }
    }

}

class ButtonDemo extends MainPanels
        implements ActionListener {

    int attempts;

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
        b4.setMnemonic(KeyEvent.VK_E);
        b4.setActionCommand("Yellow");
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

        b8 = new JButton("Delete", rightButtonIcon);
        b8.setMnemonic(KeyEvent.VK_E);
        b8.setActionCommand("Delete");
        b8.setEnabled(true);

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!show) {
            if (null != e.getActionCommand() && position < 40) {
                switch (e.getActionCommand()) {
                    case "Blue":
                        set.set(position, 1);
                        position++;
                        repaint();
                        break;
                    case "Red":
                        set.set(position, 2);
                        position++;
                        repaint();
                        break;
                    case "Orange":
                        set.set(position, 3);
                        position++;
                        repaint();
                        break;
                    case "Yellow":
                        set.set(position, 4);
                        position++;
                        repaint();
                        break;
                    case "Green":
                        set.set(position, 5);
                        position++;
                        repaint();
                        break;
                    case "LightBlue":
                        set.set(position, 6);
                        position++;
                        repaint();
                        break;
                    case "Delete":
                        if (position > 0) {
                            set.set(position - 1, 0);
                            position--;
                        }
                        repaint();
                        break;
                    case "Check":
                        //answerCode=answers;
                        System.out.println(Arrays.toString(answerCode));
                        int z = cre * 4 - 4;
                        lol++;
                        ArrayList aaa = new ArrayList();
                        aaa.add(set.get(z));
                        z++;
                        aaa.add(set.get(z));
                        z++;
                        aaa.add(set.get(z));
                        z++;
                        aaa.add(set.get(z));
                        if (aaa.indexOf(0) == -1) {
                            Check.check(answerCode, aaa);
                            if (it[s] == 4) {
                                show = true;
                            }
                            s += 2;
                            on = true;
                            felina--;
                            System.out.println(felina);
                            if (felina == 1) {
                                show = true;
                            }
                        }
                        repaint();
                        cre++;
                        break;
                    case "default":
                        break;
                }
            }
        }
    }
}

public class This {

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
        JFrame frame = new JFrame("MASTERMIND");
        JButton red = new JButton("RED");
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        frame.setSize(xSize, ySize);
        frame.show();
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
