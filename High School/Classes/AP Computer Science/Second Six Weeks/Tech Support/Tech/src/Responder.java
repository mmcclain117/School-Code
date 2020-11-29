
import java.util.*;

/**
 * The responder class represents a response generator object. It is used to
 * generate an automatic response to an input string.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 0.1 (2011.07.31)
 */
public class Responder {

    private Random randomGenerator;
    private ArrayList<String> responses;
    private HashMap<String, String> ReMap;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder() {
        ReMap = new HashMap<>();
        fillResponseMap();
    }

    /**
     * Generate a response.
     *
     * @param words
     * @return A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> words) {
        for (String word : words) {
            String response = ReMap.get(word);
            if (response != null) {
                return response;
            }
        }
        return pickDefaultResponse();
    }

    public String pickDefaultResponse() {
        return "Can you please explain the problem a but more?";
    }

    private void fillResponseMap() {
        ReMap.put("slow", "I think you need more RAM");
        ReMap.put("network", "You may need to flushdns and assign a new one");
        ReMap.put("expensive", "Get a Job");
        ReMap.put("stupid", "It is not always about the game ,but the player");
    }
}
