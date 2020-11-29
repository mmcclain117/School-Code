
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Dillan Terry
 */
public class TreasurePanel extends JPanel {

    private TreasureGame game;

    public TreasurePanel(TreasureGame game) {
        this.game = game;
    }

    public int x = 100, y = 100;
    public boolean goingRight = true;
    public boolean goingUp = true;

    @Override
    public void paintComponent(Graphics g) {
        if (game.mode == TreasureGame.START) {
            drawStartScreen(g);
        }
        if (game.mode == TreasureGame.STARTOPEN) {
            drawStartScreenOpen(g);
        }
        if (game.mode == TreasureGame.PLAY) {
            drawPlayScreen(g);
        }
        if (game.mode == TreasureGame.PLAYGAME) {
            drawPlayGameScreen(g);
        }
        if (game.mode == TreasureGame.END) {
            drawEndScreen(g);
        }
        if (game.mode == TreasureGame.WIN) {
            drawWinScreen(g);
        }

    }

    private void drawStartScreen(Graphics g) {
        Image image = new ImageIcon("backgroundImage.png").getImage();
        g.drawImage(image, 0, 0, this);

        Image image5 = new ImageIcon("Startbutton.png").getImage();
        g.drawImage(image5, 450, 385, this);
    }

    private void drawStartScreenOpen(Graphics g) {
        Image image2 = new ImageIcon("backgroundImage2.png").getImage();
        g.drawImage(image2, 0, 0, this);
    }

    private void drawPlayScreen(Graphics g) {
        Image image3 = new ImageIcon("gameScreenImage.jpg").getImage();
        g.drawImage(image3, 0, 0, this);

        Image image10 = new ImageIcon("emptyTreasureImage.png").getImage();
        g.drawImage(image10, 200, 250, this);

        Image image11 = new ImageIcon("emptyTreasureImage.png").getImage();
        g.drawImage(image11, 600, 250, this);

        Image image12 = new ImageIcon("fullTreasureImage.png").getImage();
        g.drawImage(image12, 1000, 250, this);

    }

    private void drawPlayGameScreen(Graphics g) {
        Image image3 = new ImageIcon("gameScreenImage.jpg").getImage();
        g.drawImage(image3, 0, 0, this);

        Image image13 = new ImageIcon("closedTreasureImage.png").getImage();
        g.drawImage(image13, 200, 250, this);

        Image image15 = new ImageIcon("closedTreasureImage.png").getImage();
        g.drawImage(image15, 600, 250, this);

        Image image16 = new ImageIcon("closedWithTreasure.png").getImage();
        g.drawImage(image16, 1000, 250, this);

    }

    private void drawEndScreen(Graphics g) {
        Image image4 = new ImageIcon("gameOverImage.png").getImage();
        g.drawImage(image4, 0, 0, this);
    }

    private void drawWinScreen(Graphics g) {
        Image image14 = new ImageIcon("winScreenImage.png").getImage();
        g.drawImage(image14, 0, 0, this);
    }
}
