
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Trial {

    public int a[][] = {{0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0}};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        KeyListen kl = new KeyListen();
        kl.actionPerformed(null);
    }
}

class KeyListen extends Trial implements ActionListener {

    public KeyListen() {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
