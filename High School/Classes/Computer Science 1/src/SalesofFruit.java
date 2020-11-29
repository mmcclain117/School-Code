
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
class MainPanel2 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Font myfont = new Font("Arial ", Font.PLAIN, 14);
        Font myFont = new Font("Impact", Font.BOLD, 48);
        g.setFont(myFont);
        g.drawString("Sales of Fruit ", 250, 100);
        g.setFont(myfont);
        g.drawString("Celery", 800, 400);
        g.drawString("Apple", 800, 425);
        g.drawString("Lamborghini", 800, 450);
        g.drawString("People", 800, 475);
        g.drawString("Banananas ", 790, 500);
        g.drawString("Other", 800, 525);
        g.setColor(Color.GREEN);
        g.fillRect(790, 390, 10, 10);
        g.fillArc(200, 200, 400, 400, 330, 30);
        g.setColor(new Color(40, 140, 140));
        g.fillArc(200, 200, 400, 400, 0, 90);
        g.fillRect(790, 415, 10, 10);
        g.setColor(Color.PINK);
        g.fillArc(200, 200, 400, 400, 300, 60);
        g.fillRect(790, 440, 10, 10);
        g.setColor(Color.RED);
        g.fillRect(790, 466, 10, 10);
        g.fillArc(200, 200, 400, 400, 90, 45);
        g.setColor(Color.YELLOW);
        g.fillArc(200, 200, 400, 400, 135, 100);
        g.fillRect(790, 490, 10, 10);
        g.setColor(Color.BLACK);
        g.fillArc(200, 200, 400, 400, 235, 65);
        g.fillRect(790, 515, 10, 10);
        Font myFonT = new Font("Serif", Font.ITALIC, 20);
        g.setFont(myFonT);
        g.drawString("9%", 325, 250);
        g.drawString("18%", 425, 250);
        g.drawString("20%", 275, 400);
        g.setColor(Color.YELLOW);
        g.drawString("13%", 360, 500);
        g.drawString("12%", 500, 500);
    }
}

public class SalesofFruit {

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
        frame.setSize(new Dimension(900, 900));
        frame.getContentPane().add(new MainPanel2(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
