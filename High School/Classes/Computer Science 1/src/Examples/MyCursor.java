package Examples;

/**
 * How to create an image on the screen
 *
 * @author Christine Peterson
 * @version April 2012
 */
import javax.swing.*;
import java.awt.*;

public class MyCursor {

    private JFrame frame;
    private Image cursorImg;
    private Cursor cursor;

    public MyCursor() throws Exception {
        frame = new JFrame("Header Goes Here");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); //width and height
        frame.setVisible(true);

        //draw an image on screen.
//         URL url = this.getClass().getResource("images/cursor.png");
//         cursorImg = Toolkit.getDefaultToolkit().getImage(url);
        cursorImg = new ImageIcon("images/cursor.png").getImage();

        //A Point is the x and y values on the image that is the hotspot
        //The hotspot is the clickable part of the curcor. 
        //The Point is relative to the cursor image
        Point hotspotPoint = new Point(17, 17);

        //create a cursor
        cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, hotspotPoint, "Gun Site");

        frame.setCursor(cursor);  //set the cursor for the frame
    }
}
