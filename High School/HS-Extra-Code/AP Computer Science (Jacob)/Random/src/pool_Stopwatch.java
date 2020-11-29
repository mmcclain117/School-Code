
/**
 *
 * @author x45clamibot
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;

public class pool_Stopwatch extends JApplet implements ActionListener {

    private JButton suspendB = new JButton("Stop");
    private JButton resumeB = new JButton("Resume");
    private JLabel display = new JLabel("", JLabel.CENTER);
    private StopwatchThread stopWatch;
    private JLabel Score = new JLabel("", JLabel.CENTER);

    public void init() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.setBackground(Color.black);
        display.setFont(new Font("Ariel", Font.BOLD, 240));
        pane.add(display, BorderLayout.CENTER);
        JPanel controlPanel = new JPanel();
        controlPanel.add(suspendB);
        controlPanel.add(resumeB);
        controlPanel.setBackground(Color.lightGray);
        pane.add(controlPanel, BorderLayout.SOUTH);

        suspendB.addActionListener(this);
        resumeB.addActionListener(this);
        stopWatch = new StopwatchThread(display);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == suspendB) {
            stopWatch.suspend();
        } else if (e.getSource() == resumeB) {
            stopWatch.resume();
        }
    }
}

class StopwatchThread implements Runnable {

    private boolean suspended = false;
    private JLabel display;
    int secincrement = 0;
    int minincrement = 0;
    int hrincrement = 0;

    public StopwatchThread(JLabel l) {
        display = l;
        (new Thread(this)).start();
    }

    public void run() {
        while (true) {
            Calendar calendar = Calendar.getInstance();      // get time instance
            int hours = calendar.get(Calendar.HOUR_OF_DAY) - calendar.get((Calendar.HOUR_OF_DAY) - hrincrement);
            int minutes = calendar.get(Calendar.MINUTE) - (calendar.get(Calendar.MINUTE) - minincrement);
            int seconds = calendar.get(Calendar.SECOND) - (calendar.get(Calendar.SECOND) - secincrement);
            display.setText(hours + ":"
                    + ((minutes > 9) ? minutes : "0" + minutes) + ":"
                    + ((seconds > 9) ? seconds : "0" + seconds));

            try {
                Thread.sleep(1000);
                secincrement++;
                if (secincrement > 60) {
                    secincrement = 0;
                    minincrement++;
                }
                if (minincrement > 60) {
                    minincrement = 0;
                    hrincrement++;
                }
                waitIfSuspended();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized void resume() {
        if (suspended) {
            suspended = false;
            notifyAll();
        }
    }

    private synchronized void waitIfSuspended() throws InterruptedException {
        while (suspended) {
            wait();
        }
    }
}
