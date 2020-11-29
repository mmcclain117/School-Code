
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master Ward
 */
class MainPanel01 extends JPanel {

    public Graphics g;
    int Code[] = new int[4];
    int numberRows = 10;
    boolean GameFin;
    int placedpegs;
    MouseListener Me;
    int mex; // Mouse Event x
    int mey; // Mouse Event yu

    public MainPanel01() {

    }

    public void actionPreformed(ActionEvent e) {

    }

    public void reset() {

    }

    public void MouseListener(MouseListener me) {
        MouseListener m = new MouseListener() {

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
        };
    }

    public void evalguess(int guess[]) {
        int black = 0;
        int white = 0;
        for (int g = 0; g < 4; g++) {
            for (int gg = 0; gg < 4; gg++) {
//                if (guess[g] == Peg.answer[gg]) {
                if (g == gg && guess[g] != 0) {
                    black++;
                } else if (guess[g] != 0) {
                    white++;
//                    }

                    guess[g] = 0;
                }
            }
        }

    }

    public void finishRound(String reason) {

    }

    public void showResponse(int black, int white) {

        int x = 1050; //Whatever the first x equals. Should be equal to each side
        int y = 10;
        for (int i = 0; i < black; i++) {
            g.fillOval(x, y, 25, 25);
            x += 85;
        }

        for (int xx = 0; xx < white; xx++) {
            g.setColor(new Color(250, 250, 250));
            g.fillOval(x, y, 25, 25);
            x += 85;
        }
    }

    public void showSolution() {

    }
}

public class MasterMinds {

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
        JFrame frame = new JFrame("MasterMind");
        ArrayList color = new ArrayList();
        color = setColor(color);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(900, 900));
        frame.getContentPane().add(new MainPanel01(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static ArrayList setColor(ArrayList color) {
        //Order of Red , Green , Yellow , Brown , Blue , LightBlue
        Object Red = new Object();
        Object Blue = new Object();
        Object LightBlue = new Object();
        Object Yellow = new Object();
        Object Green = new Object();
        Object Brown = new Object();
        color.add(Red);
        color.add(Green);
        color.add(Yellow);
        color.add(Brown);
        color.add(Blue);
        color.add(LightBlue);
        return color;
    }
}
