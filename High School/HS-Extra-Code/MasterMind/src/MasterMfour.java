
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Master
 */
class MainPanel1 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Scanner scan = new Scanner(System.in);
// Image create 

//        int ImageWidth = JPanel.WIDTH;
//        int ImageHeight = JPanel.HEIGHT;
//        BufferedImage im = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
//        Image image = new ImageIcon("C:\\Users\\Jacob\\Desktop\\Pictures\\1363312985.jpg").getImage();
//        image.getCapabilities(null);
//        g.drawImage(image, 0, 0, this);
//        g.drawString("time", 100, 100);
        String Colors[] = {"Red", "Blue", "Brown", "Orange", "Green", "Yellow"};
        int answer[] = GenCod();
        ArrayList ar = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int u = 0; u < 4; u++) {
                int a = scan.nextInt();
                a = a < 5 ? a : scan.nextInt();
                ar.add(a);
            }
            boolean b = check(ar);
            ar.clear();
        }
    }

    public static boolean check(ArrayList ar) {

        return true;
    }

    public static int[] GenCod() {
        int a[] = new int[4];
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            a[i] = r.nextInt(5) + 1;
        }
        return a;
    }
}

public class MasterMfour {

    public static void main(String[] args) {
        //This is a necessary in order to create the frame window
        javax.swing.SwingUtilities.invokeLater(() -> {
            start();
        });
    }

    public static void start() {

        //Sets up the frame
        JFrame frame = new JFrame("MasterMind");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        //Adds the graphics panel and sets the size
        frame.setSize(new Dimension(900, 900));
        frame.getContentPane().add(new MainPanel1(), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

// Drawing an image
// Image image = new ImageIcon("Path.png").getImage();
// g.drawImage(image , 100 , 25 , this);
