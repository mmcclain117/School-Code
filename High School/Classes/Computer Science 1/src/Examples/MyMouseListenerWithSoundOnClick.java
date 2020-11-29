package Examples;

/**
 *
 * @author Christine Peterson
 * @version April 2012
 */
import java.applet.AudioClip;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

public class MyMouseListenerWithSoundOnClick implements MouseListener {

    private JFrame frame;
    private AudioClip sound;

    public MyMouseListenerWithSoundOnClick() {
        //These two lines read the sound file and initialize the AudioClip
        URL url = this.getClass().getResource("sounds\\sheep.wav");
        sound = JApplet.newAudioClip(url);

        frame = new JFrame("MyMouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); //width and height
        JLabel label = new JLabel("Click anywhere to hear a sheep.", JLabel.CENTER);
        frame.add(label);
        frame.addMouseListener(this);
        frame.setVisible(true);
    }

    // Once when a mouse button is pressed and released
    public void mouseClicked(MouseEvent e) {
        sound.play();
    }

    // When a button is first pressed
    public void mousePressed(MouseEvent e) {

    }

    // When the button pressed has been released
    public void mouseReleased(MouseEvent e) {

    }
    // Run once when the mouse first enters the area that 
    //  has the listener.  Could be the content pane or 
    //  area

    public void mouseEntered(MouseEvent e) {

    }
    // Run once when the mouse leaves the area with the 
    //  listener

    public void mouseExited(MouseEvent e) {

    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyMouseListenerWithSoundOnClick();
            }
        });
    }
}
