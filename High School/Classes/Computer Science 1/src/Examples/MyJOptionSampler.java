package Examples;

/**
 *
 * @author Master
 * @version 1.2
 */
import javax.swing.*;

public class MyJOptionSampler {

    public static void main(String args[]) {
        System.out.println("JOptionPane dialog boxes can be used to give messages and collect input.");
        System.out.println();

        //Get an input string
        System.out.println("\n>>InputDialog");
        String inputValue = JOptionPane.showInputDialog("What is your name?");
        System.out.println("This is the string you entered:  " + inputValue);

        //Choose yes or no
        System.out.println("\n>>ConfirmDialog");
        int answer = JOptionPane.showConfirmDialog(null, "Do you want to win a Hawaiian vacation?", "Title Goes Here", JOptionPane.YES_NO_OPTION);
        System.out.println("Yes is 0. No is 1.");
        System.out.println("Your selection was:  " + answer);

        //Select from predefined options in a drop-down box
        System.out.println("\n>>InputDialog");
        String[] possibleValues = {"Blue", "Yellow", "Red"};
        String choice = (String) JOptionPane.showInputDialog(null, "Choose a color:", "Input",
                JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
        System.out.println("Your choice was:  " + choice);

        //Give a message to the user
        System.out.println("\n>>MessageDialog");
        ImageIcon icon = new ImageIcon("images/Die_small.png");
        JOptionPane.showMessageDialog(null, "Message statement goes here", "Title Goes Here", JOptionPane.INFORMATION_MESSAGE, icon);
        System.out.println("A message dialog box doesn't have a returned value.");

        //Select from predefined options on buttons
        System.out.println("\n>>OptionDialog");
        String[] options = {"Rocky Road", "Vanilla", "Chocolate", "Lemon Chiffon"};
        int selection = JOptionPane.showOptionDialog(null, "Select your icecream choice:", "Title Goes Here",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
        System.out.println("Your selection was:  " + options[selection]);
    }
}
