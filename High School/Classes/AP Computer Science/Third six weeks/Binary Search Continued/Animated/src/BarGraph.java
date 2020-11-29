
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

class BarGraph extends JPanel {

    public Random rnd;
    public int click = 0;
    public ArrayList<Integer> ar = Command.am;

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 2000, 2000);
        g.setColor(Color.white);
        g.drawRect(100, 100, 900, 800);
        int[] values = Command.values;
        int[] val = Command.lmhsv;
        int low = val[0];
        int mid = Command.midpoint;
        int high = val[2];
        int searchValue = val[3];
        g.setColor(Color.gray);
//        for (int i = 0; i < values.length; i++) {
//            int o = i;
//            g.fillRect(o * 9 + 100, 900 - values[o] * 5, 5, values[o] * 5);
//        }
        for (int p = 0; p < ar.size() / 3; p++) {
            int cur = p * 3;
            int low1 = (int) ar.get(cur);
            int high1 = (int) ar.get(cur + 1);
            int mid1 = (int) ar.get(cur + 2);
            g.setColor(Color.yellow);
            g.fillRect(low1 * 9 + 100, 900 - values[low1] * 5, 5, values[low1] * 5);
            g.setColor(Color.white);
            g.fillRect(high1 * 9 + 100, 900 - values[high1] * 5, 5, values[high1] * 5);
            g.setColor(Color.CYAN);
            g.fillRect(mid1 * 9 + 100, 900 - values[mid1] * 5, 5, values[mid1] * 5);
        }
//        for (int i = 0; i < values.length; i++) {
//            int o = i;
//            if (o == low) {
//                g.setColor(Color.yellow);
//            } else if (o == high) {
//                g.setColor(Color.CYAN);
//            } else if (o == mid) {
//                g.setColor(Color.WHITE);
//            }
//            g.fillRect(o * 9 + 100, 900 - values[o] * 5, 5, values[o] * 5);
//        }
        Font arial = new Font("Arial", Font.BOLD, 36);
        Font def = new Font("Times New Roman", Font.PLAIN, 25);
        g.setFont(def);
        g.setColor(Color.CYAN);
        g.drawString("High                   " + values[high] + "   index " + high, 150, 200);
        g.setColor(Color.yellow);
        g.drawString("Low                   " + values[low] + "   index " + low, 150, 250);
        g.setColor(Color.gray);
        g.drawString("Searching For   " + searchValue, 150, 300);
        g.setColor(Color.WHITE);
        g.drawString("Midpoint           " + values[mid] + "    ", 150, 350);
        g.setFont(arial);
        g.setColor(Color.red);
        g.drawString("Binary Search", 450, 50);

    }

    public void graph(Graphics g) {
        int values[] = Command.values;
        for (int i = 0; i < values.length; i++) {
            int o = i;
            g.fillRect(o * 9 + 100, 900 - values[o] * 5, 5, values[o] * 5);
        }
    }
}
