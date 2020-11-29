package Examples;

/**
 * How to play a sound
 *
 * @author Christine Peterson
 * @version April 2012
 */
import java.applet.AudioClip;
import java.net.*;
import javax.swing.*;

public class MyLoopingSound {

    private JFrame frame;
    private AudioClip sound;

    public MyLoopingSound() {
        //These two lines read the sound file and initialize the AudioClip
        URL url = this.getClass().getResource("sounds\\jungle.wav");
        sound = JApplet.newAudioClip(url);
        sound.loop();

        frame = new JFrame("Loop a Sound");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); //width and height
        JLabel label = new JLabel("You should hear jungle background sounds looping.", JLabel.CENTER);
        frame.add(label);
        frame.setVisible(true);
    }
}
