
import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Master
 */
class Command {

    public static int con = 0; // Number to put into as
    public static int values[] = new int[100];
    public static int searchValue = (int) (Math.random() * 100);
    public static int low = 0;
    public static int high = 99;
    public static int midpoint = 49;
    public static int lmhsv[] = new int[4]; // low ,middle, high, Search value
    public static ArrayList am = new ArrayList();
    public static ArrayList<Integer> as = y();

    public static void fillarray() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            values[i] = rnd.nextInt(100);
        }
        Arrays.sort(values);
    }

    public static ArrayList y() {
        as = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            as.add(0);
        }
        return as;
    }

    public static void runSearch() throws InterruptedException {
        int count = 0;
        boolean tes = true;
//        while (tes) {
        midpoint = (low + high) / 2;
        if (values[midpoint] == searchValue) {
            tes = false;
            Thread.sleep(100);
        }
        if (high == low || high == midpoint || low == midpoint) {
            tes = false;
            Thread.sleep(100);
        }
        if (searchValue < values[midpoint]) {
            high = midpoint;
            Thread.sleep(100);
//                am.add(low);
//                am.add(midpoint);
//                am.add(high);
        } else if (searchValue > values[midpoint]) {
            low = midpoint;
            Thread.sleep(100);
//                am.add(low);
//                am.add(midpoint);
//                am.add(high);
        }
//            count++;
//            for (int i = low; i < midpoint; i++) {
//                int y = as.get(i) + 1;
//                as.set(i, y);
//            }
//            out.println(Arrays.toString(as.toArray()));
//            con++;
//        }
        lmhsv[0] = low;
        lmhsv[1] = midpoint;
        lmhsv[2] = high;
        lmhsv[3] = searchValue;
    }
}

public class BinarySearch extends JFrame {

    public static void main(String[] args) throws InterruptedException {
        Command.fillarray();
        Command.runSearch();
        //This is a necessary in order to create the frame window
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    start();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BinarySearch.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public static void start() throws InterruptedException {

        //Sets up the frame
        JFrame frame = new JFrame("Graphics");
        BarGraph bg = new BarGraph();
        boolean c = true;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(1200, 1000));
        frame.getContentPane().add(new BarGraph(), BorderLayout.CENTER);

        frame.add(bg);
        frame.getContentPane().add(bg, BorderLayout.CENTER);
        frame.setVisible(true);
//        while (c) {
//            frame.repaint();
//            
//            Thread.sleep(1000);
//        }
    }
}
