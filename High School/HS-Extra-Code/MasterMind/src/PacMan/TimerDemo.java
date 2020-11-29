package PacMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.out;
import javax.swing.Timer;

/**
 *
 * @author Master
 */
public class TimerDemo implements ActionListener {

    public static void main(String args[]) {
        int delay = 0;
        ActionListener ae = (ActionEvent ae1) -> {
            long y = System.currentTimeMillis();
        };
        Timer time = new Timer(delay, ae);
        time.start();
        time.setActionCommand("y");
        int start1 = time.getDelay();
        time.addActionListener(ae);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String y = "y";
        }
        long end = System.currentTimeMillis();
        int end1 = time.getDelay();
        long ElapsedTime = end - start;
        long t = (long) Math.log(1000);
        int et = start1 - end1;
        out.println(end + " - " + start + " = " + ElapsedTime);
        out.println(end1 + " - " + start1 + " = " + et);
        out.println(t);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        out.print("1 + 1 = 11");
    }
}
