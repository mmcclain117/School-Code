package Pacman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Master
 */
public class Pacman_word extends JPanel implements ActionListener {

    public Graphics g;
    public Image pac;
    public Image Blinky; // Red     Shadows
    public Image Inky; // Light Blue      Bashful / Shy
    public Image Pinky;// Pink      Speedy
    public Image Clyde;// Orange    Slow

    public Pacman_word() {
        paintPac(g);
        paintGhost(g);

    }

    @Override
    public void paintComponent(Graphics g) {

    }

    public void paintPac(Graphics g) {
        pac = new ImageIcon("pacman.png").getImage();
    }

    public void paintGhost(Graphics g) {
        Blinky = new ImageIcon("Blinky.png").getImage();
        Inky = new ImageIcon("Inky.png").getImage();
        Pinky = new ImageIcon("Pinky.png").getImage();
        Clyde = new ImageIcon("Clyde.png").getImage();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
