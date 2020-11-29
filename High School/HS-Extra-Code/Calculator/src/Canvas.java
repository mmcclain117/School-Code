
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Master Ward
 */
public class Canvas {

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D g;
    private Color backgroundColor;
    private Image canvasImage;

    public Canvas() {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle("Set The Titile");
        canvas.setPreferredSize(new Dimension(1920, 1080));
        backgroundColor = Color.BLACK;
        frame.pack();
        setVisible(true);

    }

    public void setVisible(boolean visible) {
        if (visible) {
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            g = (Graphics2D) canvasImage.getGraphics();
            /*
             g.setColor(Color.black);
             g.fillRect(0, 0, 2000, 2000);
             This is to make the background black
             */
        }
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void fill(Shape shape) {
        g.fill(shape);
        canvas.repaint();
    }

    public void button() {

    }

    public void fillRect(int xPos, int yPos, int width, int height) {
        g.fillRect(xPos, yPos, width, height);
    }

    public void drawString(String s, int xPos, int yPos) {
        g.drawString(s, xPos, yPos);
    }

    public void setFont(Font d) {
        g.setFont(d);
    }

    public void setColor(Color color) {
        g.setColor(color);
    }

    private class CanvasPane extends JPanel {

        @Override
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}
