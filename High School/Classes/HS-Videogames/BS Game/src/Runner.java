
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master Ward
 */
class BSPanel extends JPanel {

    public boolean playing = true;
    public ArrayList Players = new ArrayList();

    @Override
    public void paintComponent(Graphics g1) {
        Scanner scan = new Scanner(System.in);
        int playerNumber = scan.nextInt();
        out.println(playerNumber);
        ArrayList ar = new ArrayList();
        for (int i = 0; i < playerNumber; i++) {
            switch (playerNumber) {
                case 10:
                    ArrayList p10 = new ArrayList();
                    ar.add(p10);
                    break;
                case 9:
                    ArrayList p9 = new ArrayList();
                    ar.add(p9);
                    break;
                case 8:
                    ArrayList p8 = new ArrayList();
                    ar.add(p8);
                    break;
                case 7:
                    ArrayList p7 = new ArrayList();
                    ar.add(p7);
                    break;
            }
            out.println(playerNumber + " " + i);
        }
        ArrayList p1 = new ArrayList();
        ArrayList p2 = new ArrayList();
        ArrayList p3 = new ArrayList();
        ar.add(p1);
        ar.add(p2);
        while (playing) {
            playing = false;
        }
    }
}

public class Runner {

    public static int a;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println("Enter Number of Players\nThere will Be from 2 - 10 players");
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
        frame.pack();

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(900, 900));
        frame.getContentPane().add(new BSPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
