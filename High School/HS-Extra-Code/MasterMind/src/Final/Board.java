package Final;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
public class Board extends JPanel {

    public final int answer[] = new int[4];
    public boolean ShowAnswer;
    public Random rnd = new Random();
    public int position;
    public int ActiveSet[];
    public int guess[];
    public int gray[];
    public int white;
    public int black;

    public Board() {
        int i = 0;
        getAnswer();
        System.out.println("It has passed this point another time");
        System.out.println(Arrays.toString(answer));
    }

    public void getAnswer() {
        for (int i = 0; i < 4; i++) {
            answer[i] = rnd.nextInt(5);
        }
        position = 0;
        int ActiveSet[] = {0, 0, 0, 0};
    }

    public void drawBoard(Graphics g) {
        // Covered Answer Pegs
        int ax = 850;
        int ay = 75;
        int awl = 75;
        for (int i = 0; i < 10 - 1; i++) {
            g.fillOval(ax, ay, awl, awl);
            ax += 100;
        }
        int l = 0;
        g.fillOval(ax, ay, awl, awl);
        // The Pegs
        int numrow = 10;
        int x = 650;
        int y = 175;
        int space = 75;
        int d = 50; // Lenght and Width of the Pegs
        if (l < 10) {
            for (int ii = 0; ii < 4; ii++) {
                switch (answer[ii]) {
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
            l++;
            x = 650;
            y += space;
        }
        // Response Dots
        d = 25;
        int rx = 1050;
        int ry = 175;
        int noblorwh = 4 - (black + white);
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

    public int[] check() {
        int a[] = new int[4];

        return a;
    }
}
