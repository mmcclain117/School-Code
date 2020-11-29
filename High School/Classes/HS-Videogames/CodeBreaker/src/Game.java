
// Name: Husna Chaudhary, Thricia Egar, John Shaw
// Period: 4A
// Date: 4/23/2015
// Assignment: Breaking Codes
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MainPanel5 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Image background = new ImageIcon("Breaking Codes Blank.png").getImage();
        g.drawImage(background, 0, 0, GraphicsForGame.panel);
        GraphicsForGame.paintChoices(g);
        GraphicsForGame.showEvaluations(g);
        if (!(GraphicsForGame.game.rightCode())) {
            if (GraphicsForGame.game.gameOver()) {

            }
        }
    }

}

/**
 * ************************************************************
 * The code below is needed to create the Graphics window. You should not modify
 * or delete any of the code.
 * ***********************************************************
 */
class GraphicsForGame extends MainPanel5 implements MouseListener {

    public static JFrame panel = new JFrame("Breaking Codes");
    public static int x = 73;
    public static int w = 48;
    public static int y = 785;
    public static int h = 38;
    public static Rectangle red = new Rectangle(x, y, w, h);
    public static Rectangle orange = new Rectangle(x += 50, y, w, h);
    public static Rectangle yellow = new Rectangle(x += 50, y, w, h);
    public static Rectangle green = new Rectangle(x += 50, y, w, h);
    public static Rectangle lightBlue = new Rectangle(x += 50, y, w, h);
    public static Rectangle blue = new Rectangle(x += 50, y, w, h);
    public static Rectangle purple = new Rectangle(x += 50, y, w, h);
    public static Rectangle hotPink = new Rectangle(x += 50, y, w, h);
    public static Rectangle peach = new Rectangle(x += 50, y, w, h);
    public static Rectangle checkButton = new Rectangle(407, 98, 104, 90);
    public static int sequence[] = new int[5];
    public static int index = 0;
    public static int n = 0;
    public static int trial;
    public static MastermindGame game = new MastermindGame(9, 5, 9);
    public static MouseListener me = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent me) {
            System.out.println("X: " + me.getX() + "    Y: " + me.getY());
            if (red.contains(me.getX(), me.getY())) {
                sequence[index] = 1;
                n = 1;
                index++;
                panel.repaint();
            } else if (orange.contains(me.getX(), me.getY())) {
                sequence[index] = 2;
                n = 2;
                index++;
                panel.repaint();
            } else if (yellow.contains(me.getX(), me.getY())) {
                sequence[index] = 3;
                n = 3;
                index++;
                panel.repaint();
            } else if (green.contains(me.getX(), me.getY())) {
                sequence[index] = 4;
                n = 4;
                index++;
                panel.repaint();
            } else if (lightBlue.contains(me.getX(), me.getY())) {
                sequence[index] = 5;
                n = 5;
                index++;
                panel.repaint();
            } else if (blue.contains(me.getX(), me.getY())) {
                sequence[index] = 6;
                n = 6;
                index++;
                panel.repaint();
            } else if (purple.contains(me.getX(), me.getY())) {
                sequence[index] = 7;
                n = 7;
                index++;
                panel.repaint();
            } else if (hotPink.contains(me.getX(), me.getY())) {
                sequence[index] = 8;
                n = 8;
                index++;
                panel.repaint();
            } else if (peach.contains(me.getX(), me.getY())) {
                sequence[index] = 9;
                n = 9;
                index++;
                panel.repaint();
            } else if (checkButton.contains(me.getX(), me.getY())) {
                if (index == 4) {
                    index = 0;
                    game.enterTry(sequence);
                }
            }
            System.out.println(Arrays.toString(sequence));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    public static void paintChoices(Graphics g) {
        Image background = new ImageIcon("Breaking Codes Blank.png").getImage();
        Color red = new Color(237, 28, 36);
        Color orange = new Color(255, 127, 39);
        Color yellow = new Color(255, 242, 0);
        Color green = new Color(34, 177, 76);
        Color lightBlue = new Color(0, 162, 232);
        Color blue = new Color(63, 72, 204);
        Color purple = new Color(163, 73, 164);
        Color hotPink = new Color(255, 0, 255);
        Color peach = new Color(255, 174, 201);
        g.drawImage(background, 0, 0, panel);
        int k = 0;
        boolean a = true;
        switch (n) {
            case 1:
                g.setColor(red);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
            case 2:
                g.setColor(orange);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
            case 3:
                g.setColor(yellow);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
            case 4:
                g.setColor(green);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
            case 5:
                g.setColor(lightBlue);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
            case 6:
                g.setColor(blue);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
            case 7:
                g.setColor(purple);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
            case 8:
                g.setColor(hotPink);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
            case 9:
                g.setColor(peach);
                g.fillRect(87, GraphicsForGame.yValue(GraphicsForGame.game), 52, 48);
                g.drawImage(background, 0, 0, panel);
        }
    }

    public static void showEvaluations(Graphics g) {
        int black = 0;
        int yellow = 0;
        int white = 0;
        if (game.getTrialNumber() != 0) {
            int eval[][] = game.getHints();
            for (int e : eval[game.getTrialNumber() - 1]) {
                if (e == 1) {
                    black++;
                } else if (e == 2) {
                    yellow++;
                } else {
                    white++;
                }
            }
        }
        int arrayOfY[] = {729, 666, 603, 539, 468, 320, 253, 184};
        int w = 20;
        int h = 18;
        int x = 403;
        for (int s = 0; s < black; s++) {
            g.setColor(Color.BLACK);
            g.fillRect(x, arrayOfY[game.getTrialNumber() - 1], w, h);
            x += w;
        }
        for (int s = 0; s < yellow; s++) {
            g.setColor(Color.YELLOW);
            g.fillRect(x, arrayOfY[game.getTrialNumber() - 1], w, h);
            x += w;
        }
        x = 403;
    }

    public static int yValue(MastermindGame m) {
        switch (m.getTrialNumber()) {
            case 1:
                trial = 723;
                break;
            case 2:
                trial = 658;
                break;
            case 3:
                trial = 595;
                break;
            case 4:
                trial = 530;
                break;
            case 5:
                trial = 458;
                break;
            case 6:
                trial = 382;
                break;
            case 7:
                trial = 312;
                break;
            case 8:
                trial = 245;
                break;
            case 9:
                trial = 176;
                break;
        }
        return trial;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

public class Game {

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
        frame.getContentPane().setLayout(new BorderLayout());
        GraphicsForGame GFG = new GraphicsForGame();
        frame.addMouseListener(GFG);

        //Display the window.
        frame.pack();

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(615, 758));
        frame.getContentPane().add(new MainPanel5(), BorderLayout.CENTER);
        frame.setVisible(true);
        frame.repaint(); // Goes Back to PaintComponents
    }
}
