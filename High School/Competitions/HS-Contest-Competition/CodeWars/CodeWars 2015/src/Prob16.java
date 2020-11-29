
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Master Ward
 */
public class Prob16 {

    public static void main(String[] args) throws Exception {
//        Problem: State Machine Decoder
//        Difficulty: Hard
//        Subject: Graphing, Pathfinding, Replacing
        Scanner scan = new Scanner(new File("prob16.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        String input[] = new String[a];
        for (int i = 0; i < a; i++) {
            input[i] = scan.nextLine();
        }
        HashMap<String, State> states = new HashMap();
        String message = scan.nextLine();
        for (int i = 0; i < input.length; i++) {
            String stateLine = input[i];
            String[] parts = stateLine.split(" ");
            String state = parts[0];
            String trigger = parts[1];
            String nextState = parts[2];
            if (!states.containsKey(state)) {
                State newState = new State(state);
                states.put(state, newState);
            }
            if (!states.containsKey(nextState)) {
                State newState = new State(nextState);
                states.put(nextState, newState);
            }
            State fromState = states.get(state);
            State toState = states.get(nextState);
            fromState.addTransition(trigger, toState);
        }
        StringBuilder decodedMessage = new StringBuilder();
        State currentState = states.get("#");
        for (int index = 0; index < message.length(); index++) {
            String transition = message.substring(index, index + 1);
            currentState = currentState.getNextState(transition);
            decodedMessage.append(currentState.label);
        }
        System.out.println(decodedMessage);
    }
}

class State {

    public String label;
    public Map<String, State> triggers;

    public State(String label) {
        this.label = label;
        triggers = new HashMap<>();
    }

    public void addTransition(String trigger, State nextState) {
        triggers.put(trigger, nextState);
    }

    public State getNextState(String trigger) {
        State nextState = null;
        if (triggers.containsKey(trigger)) {
            nextState = triggers.get(trigger);
        }

        return nextState;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[State: ");
        sb.append(label);
        sb.append(", triggers { ");
        Set<String> triggerKeys = triggers.keySet();
        for (String trigger : triggerKeys) {
            sb.append("(");
            sb.append(trigger);
            sb.append(">");
            State nextState = triggers.get(trigger);
            sb.append(nextState.label);
            sb.append(") ");
        }
        sb.append("}]");
        return sb.toString();
    }
}
