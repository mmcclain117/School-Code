/*
import java.awt.event.*;
import javax.swing.*;

private class ButtonDemo extends Board
        implements ActionListener {

    public JButton b1, b2, b3, b4, b5, b6, b7;
    public int set[] = new int[40];

    public ButtonDemo() {
        ImageIcon leftButtonIcon = new ImageIcon("images/right.gif");
        ImageIcon middleButtonIcon = new ImageIcon("images/middle.gif");
        ImageIcon rightButtonIcon = new ImageIcon("images/left.gif");

        b1 = new JButton("Blue", leftButtonIcon);
        // b1.setBounds(x1, y1, x2, y2);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("Blue");
        b1.setEnabled(true);

        b2 = new JButton("Red", middleButtonIcon);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setActionCommand("Red");
        b2.setEnabled(true);

        b3 = new JButton("Yellow", rightButtonIcon);
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("Yellow");
        b3.setEnabled(true);

        b4 = new JButton("Orange", rightButtonIcon);
        b4.setMnemonic(KeyEvent.VK_E);
        b4.setActionCommand("Orange");
        b4.setEnabled(true);

        b5 = new JButton("Green", rightButtonIcon);
        b5.setMnemonic(KeyEvent.VK_E);
        b5.setActionCommand("Green");
        b5.setEnabled(true);

        b6 = new JButton("Magenta", rightButtonIcon);
        b6.setMnemonic(KeyEvent.VK_E);
        b6.setActionCommand("LightBlue");
        b6.setEnabled(true);

        b7 = new JButton("Check", rightButtonIcon);
        b7.setMnemonic(KeyEvent.VK_E);
        b7.setActionCommand("Check");
        b7.setEnabled(true);

        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
    }

    public void actionPerformed(ActionEvent e) {
        if (null != e.getActionCommand()) {
            if (!(position <= 4)) {
                switch (e.getActionCommand()) {
                    case "Blue":
                        set[position] = 1;
                        position++;
                        repaint();
                        System.out.println("RED");
                        break;

                    case "Red":
                        set[position] = 2;
                        position++;
                        repaint();
                        break;
                    case "Orange":
                        set[position] = 3;
                        position++;
                        repaint();
                        break;
                    case "Yellow":
                        set[position] = 4;
                        position++;
                        repaint();
                        break;
                    case "Green":
                        set[position] = 5;
                        position++;
                        repaint();
                        break;
                    case "LightBlue":
                        set[position] = 6;
                        position++;
                        repaint();
                        break;
                    case "Check":

                        break;
                }
            }
        }
    }

}
*/
