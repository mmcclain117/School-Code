
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

class BarGraph extends JPanel {

    public Random rnd;

    @Override
    public void paintComponent(Graphics g) {
        Scanner scan = new Scanner(System.in);
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.WHITE);
        out.println("Enter Multiple");
        int multi = scan.nextInt();
        String h[] = {"Grapes", "Cars", "Lambs", "This", "Numbers"};
        int num[] = new int[11];
        int count = 0;
        int iute = 0;
        while (count < 11) {
            if (iute % multi == 0) {
                num[count] = iute;
                count++;
                iute++;
            } else {
                iute++;
            }
        }
        /* OPTIONAL
         Can put in this code underneath to set up Numbers and Set up names
         */
        out.println("Enter in names of products and then number");
        String hh[] = new String[5];
        int numb[] = new int[5];
        String a = scan.next();
        int u = 0;
        while (u < hh.length) {
            hh[u] = a;
            numb[u] = scan.nextInt();
            u++;
            a = scan.next();
        }
        int x = 50;
        int y = 650;
        int WIDTH = 500;
        g.drawLine(75, 650, 675, 650);
        g.drawLine(75, 50, 75, 650);
        g.setColor(Color.red);
        Font font = new Font("Arial", Font.PLAIN, 24);
        g.setFont(font);
        for (int i = 0; i < num.length; i++) {
            g.drawString(num[i] + "", x, y);
            y -= 55;
        }
        g.setColor(Color.cyan);
        Font font1 = new Font("Times New Roman", Font.BOLD, 12);
        g.setFont(font1);
        x = 100;
        y = 675;
        for (int i = 0; i < h.length; i++) {
            g.drawString(hh[i], x, y);
            x += 100;
        }
        // drawing the bars 
        int hight = 100;
        int xsta = 100;
        int width = 50;
        int numbercount = numb.length;
        int counter = 0;
        while (counter < numbercount) {
            hight = (numb[counter] / multi) * 55;
            g.fillRect(xsta, 650 - hight, width, hight);
            counter++;
            xsta += 100;
        }
    }
}

public class BarPro extends JFrame {

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

        frame.pack();
        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(900, 900));
        frame.getContentPane().add(new BarGraph(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
