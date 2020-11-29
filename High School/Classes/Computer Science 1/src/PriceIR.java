
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
class Price extends JPanel {

    public int x;
    public int y;

    @Override
    public void paintComponent(Graphics g) {
        Scanner scan = new Scanner(System.in);
        int sqsx[] = {100, 250, 400, 550};
        int sqsy[] = {100, 400};
        int WL = 100;
        int WLO = 50;
        g.fillRect(sqsx[0], sqsy[0], WL, WL);
        g.fillRect(sqsx[1], sqsy[0], WL, WL);
        g.fillRect(sqsx[2], sqsy[0], WL, WL);
        g.fillRect(sqsx[3], sqsy[0], WL, WL);
        g.fillRect(sqsx[0], sqsy[1], WL, WL);
        g.fillRect(sqsx[1], sqsy[1], WL, WL);
        g.fillRect(sqsx[2], sqsy[1], WL, WL);
        g.fillRect(sqsx[3], sqsy[1], WL, WL);
        // Top Circles 
        g.setColor(Color.blue);
        g.fillOval(sqsx[0] + 25, sqsy[0] + 25, WLO, WLO);
        g.fillOval(sqsx[1] + 25, sqsy[0] + 25, WLO, WLO);
        g.fillOval(sqsx[2] + 25, sqsy[0] + 25, WLO, WLO);
        g.fillOval(sqsx[3] + 25, sqsy[0] + 25, WLO, WLO);
        // Lower Circles
        g.fillOval(sqsx[0] + 25, sqsy[1] + 25, WLO, WLO);
        g.fillOval(sqsx[1] + 25, sqsy[1] + 25, WLO, WLO);
        g.fillOval(sqsx[2] + 25, sqsy[1] + 25, WLO, WLO);
        g.fillOval(sqsx[3] + 25, sqsy[1] + 25, WLO, WLO);
        // Middle Messed Amount Background
        g.setColor(Color.white);
        g.fillRect(sqsx[0], sqsy[0] + 125, WL, WL + WLO);
        g.fillRect(sqsx[1], sqsy[0] + 125, WL, WL + WLO);
        g.fillRect(sqsx[2], sqsy[0] + 125, WL, WL + WLO);
        g.fillRect(sqsx[3], sqsy[0] + 125, WL, WL + WLO);
        // Middle outerlinning
        g.setColor(Color.black);
        g.drawRect(sqsx[0], sqsy[0] + 125, WL, WL + WLO);
        g.drawRect(sqsx[1], sqsy[0] + 125, WL, WL + WLO);
        g.drawRect(sqsx[2], sqsy[0] + 125, WL, WL + WLO);
        g.drawRect(sqsx[3], sqsy[0] + 125, WL, WL + WLO);
        // Lower While Acual amount part background
        g.setColor(Color.white);
        g.fillRect(sqsx[0], sqsy[1] + 125, WL, WL + WLO);
        g.fillRect(sqsx[1], sqsy[1] + 125, WL, WL + WLO);
        g.fillRect(sqsx[2], sqsy[1] + 125, WL, WL + WLO);
        g.fillRect(sqsx[3], sqsy[1] + 125, WL, WL + WLO);
        // Lower Actua Ammount outerlinning
        g.setColor(Color.black);
        g.drawRect(sqsx[0], sqsy[1] + 125, WL, WL + WLO);
        g.drawRect(sqsx[1], sqsy[1] + 125, WL, WL + WLO);
        g.drawRect(sqsx[2], sqsy[1] + 125, WL, WL + WLO);
        g.drawRect(sqsx[3], sqsy[1] + 125, WL, WL + WLO);
        // Circle
        g.setColor(Color.red);
        g.fillOval(700, 150, 200, 200);
        Font fr = new Font("Arial", Font.PLAIN, 36);
        g.setColor(Color.black);
        g.setFont(fr);
        g.drawString("Start", 750, 275);
        // Generating random total        
        int oi[] = new int[4];
        oi = genTot(oi);
        // Generating Random jumbled
        boolean io[] = new boolean[4];
        io = genRan(io);
        // gets the Final number
        int asa[] = genFin(oi, io);
        int typec = 0;
        x = 125;
        Font font = new Font("Times New Roman", Font.BOLD, 56);
        g.setFont(font);
        while (typec < 4) {
            String r = Math.abs(oi[typec]) + "";
            g.drawString(r, x, 325);
            x += 150;
            typec++;
        }
        // Prints out the final
        typec = 0;
        x = 125;
        while (typec < 4) {
            String r = Math.abs(asa[typec]) + "";
            g.drawString(r, x, 625);
            x += 150;
            typec++;
        }
    }

    public int[] genTot(int a[]) {
        Random rnd = new Random();
        for (int b = 0; b < 4; b++) {
            a[b] = rnd.nextInt(9);
        }
        return a;
    }

    public boolean[] genRan(boolean y[]) {
        Random rnd = new Random();
        for (int b = 0; b < y.length; b++) {
            y[b] = rnd.nextBoolean();
        }
        return y;
    }

    public int[] genFin(int a[], boolean b[]) {
        int yu[] = new int[4];
        for (int i = 0; i < a.length; i++) {
            yu[i] = b[i] ? a[i] + 1 : a[i] - 1;
        }
        return yu;
    }
}

public class PriceIR {

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
        frame.setResizable(false);
        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(900, 900));
        frame.getContentPane().add(new Price(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
