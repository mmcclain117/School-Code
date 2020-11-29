
import java.util.*;

/**
 * InputReader reads typed text input from the standard text terminal. The text
 * typed by a user is returned.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 0.1 (2011.07.31)
 */
public class InputReader {

    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal), and return
     * it as a String.
     *
     * @return A String typed by the user.
     */
    public HashSet<String> getInput() {
        System.out.print("> ");         // print prompt
        String inputLine = reader.nextLine().trim().toLowerCase();
        String[] wordArray = inputLine.split(" ");
        HashSet<String> words = new HashSet<>();
        words.addAll(Arrays.asList(wordArray));
        return words;
    }
}