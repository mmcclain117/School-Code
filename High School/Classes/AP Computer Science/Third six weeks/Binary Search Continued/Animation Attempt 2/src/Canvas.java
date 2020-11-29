
import java.awt.*;
import javax.swing.*;

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
        frame.setTitle("Binary Search Animated");
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
            g.setColor(Color.black);
            g.fillRect(0, 0, 2000, 2000);
        }
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void fill(Shape shape) {
        g.fill(shape);
        canvas.repaint();
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

    public void High(int i, int i2, int i3, int i4) throws Exception {
        Thread.sleep(5);
        g.setColor(Color.RED);
        g.fillRect(i + 1, 100, 1, 550);
        g.setColor(Color.BLACK);
        g.fillRect(i + 2, 100, i2, 600);
        g.setColor(Color.RED);
        g.drawString("High", i, 675);
        canvas.repaint();
    }

    public void Mid(int i) throws Exception {
        Thread.sleep(5);
        g.fillRect(i, 100, 1, 550);
        g.drawString("Mid", i, 675);
        canvas.repaint();
    }

    public void Low(int i, int i2, int i3, int i4) throws Exception {
        Thread.sleep(5);
        g.setColor(Color.RED);
        g.fillRect(i, 100 + i2, 1, 550 - i2);
        g.setColor(Color.BLACK);
        g.fillRect(0, 100, i, 675);
        g.fillRect(i, 660, 30, 20);
        g.setColor(Color.RED);
        g.drawString("Low", i, 675);
        canvas.repaint();
    }

    private class CanvasPane extends JPanel {

        @Override
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}
