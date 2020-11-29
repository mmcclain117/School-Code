package Examples;

/**
 * @(#)MouseShooter.java
 *
 *
 * @author Christine Peterson
 * @version 1.00 2012/5/1
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MouseShooter implements Runnable {

    JFrame frame;
    GamePanel gamePanel;
    Rectangle target = new Rectangle(100, 100, 50, 50);
    Color rectColor = Color.red;
    Random rand = new Random();
    int velocityX = 1;
    JLabel scoreLabel;
    int score = 0;

    public static void main(String args[]) {
        Thread game = new Thread(new MouseShooter());
        game.start();

    }

    public void run() {
        frame = new JFrame("Shooter Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        gamePanel = new GamePanel();
        gamePanel.addMouseListener(new MyMouseListener());
        frame.add(gamePanel);

        scoreLabel = new JLabel("Score: 0");
        frame.add(scoreLabel, BorderLayout.SOUTH);

        frame.setVisible(true);

        Thread mt = new Thread(new MovingTarget());
        mt.start();
    }

    private class GamePanel extends JPanel {

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(rectColor);
            g2d.fill(target);
        }
    }

    private class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {
        }

        @Override
        public void mouseReleased(MouseEvent event) {
        }

        public void mousePressed(MouseEvent event) {
            System.out.println("Mouse clicked");
            if (target.contains(event.getX(), event.getY())) {
                target.x = 100;
                target.y = 100;
                rectColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                score++;
                scoreLabel.setText("Score: " + score);
                frame.repaint();
            }
        }

        public void mouseEntered(MouseEvent event) {
        }

        public void mouseExited(MouseEvent event) {
        }
    }

    private class MovingTarget implements Runnable {

        public void run() {
            while (true) {
                try {
                    if (target.x > 500) {
                        velocityX = -3;
                    } else if (target.x < 100) {
                        velocityX = 3;
                    }

                    target.x += velocityX;

                    Thread.sleep(30);
                    frame.repaint();

                } catch (Exception e) {
                    break;
                }
            }
        }
    }

}
