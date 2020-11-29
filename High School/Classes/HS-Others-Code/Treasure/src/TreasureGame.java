
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Dillan Terry
 */
public class TreasureGame implements MouseListener {

    private TreasurePanel panel;
    private JFrame frame;
    public Image backgroundImage;
    public Image backgroundImage2;
    public Image startButtonImage;
    public Image emptyTreasureImage;
    public Image emptyTreasureImage2;
    public Image closedTreasureImage;
    public Image closedTreasureImage2;
    public Image closedWithTreasure;
    public Image fullTreasureImage;
    public Image fullTreasureImage2;
    public Image fullWithTreasure;
    public Image gameOverImage;
    public Image gameScreenImage;
    public Image rulesImage;
    public Image rulesButtonImage;
    public Image winScreenImage;
    int c = 0;

    public int frameCount = -1;

    public int x = 100, y = 100;
    public boolean chest1, chest2, chest3 = false;

    public static final int START = 0;
    public static final int STARTOPEN = 1;
    public static final int PLAY = 2;
    public static final int PLAYGAME = 3;
    public static final int END = 4;
    public static final int WIN = 5;

    public int mode = START;

    public TreasureGame() {
        loadImages();

        frame = new JFrame("Treasure Start");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d); // Sets the screen to full screen on any computer
        panel = new TreasurePanel(this);
        panel.addMouseListener(this);
        frame.add(panel);
        frame.setVisible(true);

        MyThread thread = new MyThread();
        thread.start();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        switch (mode) {
            case TreasureGame.START:
                if (new Rectangle(300, 300, 1650, 950).contains(me.getPoint())) {
                    mode = STARTOPEN;
                    frameCount = 50;
                }
                break;
            case TreasureGame.STARTOPEN:
                break;
            case TreasureGame.PLAY:
                if (new Rectangle(0, 0, 1000, 1000).contains(me.getPoint())) {
                    mode = PLAYGAME;

                }
                break;
            case TreasureGame.PLAYGAME:
                Random r = new Random();
                Rectangle p = new Rectangle();
                p.contains(me.getPoint());
                p = new Rectangle(200, 250, 311, 254);
                p = new Rectangle(600, 250, 311, 254);
                p = new Rectangle(1000, 250, 311, 254);
                chest1 = false;
                chest2 = false;
                chest3 = false;
                int gamble = (int) (Math.random() * 3 + 1);
                switch (gamble) {
                    case 1:
                        chest1 = true;
                        mode = WIN;
                        if (gamble != 1) {
                            chest2 = false;
                            chest3 = false;
                            mode = END;
                        }
                        break;
                    case 2:
                        chest2 = true;
                        mode = WIN;
                        if (gamble != 2) {
                            chest1 = false;
                            chest3 = false;
                            mode = END;
                        }
                        break;
                    case 3:
                        chest1 = true;
                        mode = WIN;
                        if (gamble != 3) {
                            chest1 = false;
                            chest2 = false;
                            mode = END;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case TreasureGame.END:
                if (new Rectangle(582, 384, 212, 170).contains(me.getPoint())) {
                    mode = PLAY;
                    frameCount = 50;
                }
                if (new Rectangle(866, 388, 212, 170).contains(me.getPoint())) {
                    mode = START;

                }
                break;
            case TreasureGame.WIN:
                if (new Rectangle(442, 473, 212, 170).contains(me.getPoint())) {
                    mode = PLAYGAME;
                    frameCount = 50;
                }
                if (new Rectangle(905, 464, 212, 170).contains(me.getPoint())) {
                    mode = START;

                }
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    private void loadImages() {
        backgroundImage = new ImageIcon("backgroundImage.png").getImage();
        backgroundImage2 = new ImageIcon("backgroundImage2.png").getImage();

        gameScreenImage = new ImageIcon("gameScreenImage.jpg").getImage();

        startButtonImage = new ImageIcon("Startbutton.png").getImage();

        emptyTreasureImage = new ImageIcon("emptyTreasureImage.png").getImage();
        emptyTreasureImage2 = new ImageIcon("emptyTreasureImage2.png").getImage();

        fullTreasureImage = new ImageIcon("fullTreasureImage.png").getImage();

        gameOverImage = new ImageIcon("gameOverImage.png").getImage();

        rulesImage = new ImageIcon("rulesImage.png").getImage();
        rulesButtonImage = new ImageIcon("rulesbuttonImage.png").getImage();

        closedTreasureImage = new ImageIcon("closedTreasureImage.png").getImage();
        closedTreasureImage2 = new ImageIcon("closedTreasureImage2.png").getImage();
        closedWithTreasure = new ImageIcon("closedWithTreasure.png").getImage();
        winScreenImage = new ImageIcon("winScreenImage.png").getImage();
    }

    private void update() {
        if (frameCount > 0) {
            frameCount--;

        } else if (frameCount == 0) {
            mode = PLAY;
            frameCount--;
        } else if (frameCount < 0) {

        }

    }

    class MyThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    frame.repaint();//paint

                    Thread.sleep(30);//wait

                    update();

                } catch (Exception e) {
                }
            }
        }
    }

    public static void main(String args[]) {
        TreasureGame tg = new TreasureGame();
    }

}
