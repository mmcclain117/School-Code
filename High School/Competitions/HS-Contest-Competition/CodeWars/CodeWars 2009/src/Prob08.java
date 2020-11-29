
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Time : 1 hour Difficulty : very easy
 *
 * @author Master Ward and Michael Scheetz
 *
 */
public class Prob08 {

    public static void main(String[] argss) throws Exception {
//        Problem: Security Door
//        Points: 6
        Scanner scan = new Scanner(new File("prob08.txt"));
        ArrayList<String> input = new ArrayList<>();
        String s = scan.nextLine();
        while (!(s.equals("END 0"))) {
            input.add(s);
            s = scan.nextLine();
        }
        new Prob08(input);
    }

    /**
     * Iterate through the input, handle the commands, and output the state.
     */
    public Prob08(List<String> input) {
        DoorState currentState = new UninitializedState();

        for (String commandString : input) {
            CommandInput command = new CommandInput(commandString);
            DoorState nextState = currentState.handle(command);
            System.out.println(nextState.show());
            currentState = nextState.updateCodes();
        }
    }

    /* Enumerate the possible commands expected from the inputs. */
    private enum Command {
        SYNC, OPEN
    }

    /* A class to encapsulate the input data from a single command. */
    private class CommandInput {

        private Command myCommand; // Command
        private int myCode; // Access code

        /**
         * Construct an object with a command and access code.
         */
        public CommandInput(String commandString) {
            String[] inputStrings = commandString.split(" ");
            myCommand = Command.valueOf(inputStrings[0]);
            myCode = Integer.parseInt(inputStrings[1]);
        }

        /* Return true if this object is the given command */
        public boolean isType(Command sync) {
            return myCommand == sync;
        }

        public Command getCommand() {
            return myCommand;
        }

        public int getCode() {
            return myCode;
        }
    }

    /* Parent class for the state pattern. */
    private interface DoorState {

        /* Handle the next input state */
        public DoorState handle(CommandInput input);

        public String show(); // Output current state

        /**
         * This method is required to return the correct state after the current
         * state has been output.
         */
        public DoorState updateCodes();
    }

    /* Must SYNC to get out of this state */
    private class UninitializedState implements DoorState {

        public DoorState handle(CommandInput input) {
            if (input.isType(Command.SYNC)) {
                return new SyncronizedState(input.getCode());
            } else {
                return new InvalidState(this);
            }
        }

        public DoorState updateCodes() {
            return this;
        }

        public String show() {
            throw new UnsupportedOperationException();
        }
    }

    /* This state prints out "INVALID" and then returns to then previous state. */
    private class InvalidState implements DoorState {

        private DoorState myReturnState;

        public InvalidState(DoorState returnState) {
            myReturnState = returnState;
        }

        public DoorState handle(CommandInput input) {
            throw new UnsupportedOperationException();
        }

        public DoorState updateCodes() {
            return myReturnState;
        }

        public String show() {
            return "INVALID";
        }
    }

    /* This state is re-synchronizes the access codes based on the given code. */
    private class SyncronizedState implements DoorState {

        /* The Code that was issued with this command */
        private int myCode;

        /* Construct this Object with the new code */
        public SyncronizedState(int code) {
            myCode = code;
        }

        public DoorState handle(CommandInput input) {
            throw new UnsupportedOperationException();
        }

        public DoorState updateCodes() {
            return new WaitState(myCode);
        }

        public String show() {
            return "SYNCHRONIZED";
        }
    }

    /**
     * This is the state which most states go to after a command. It handles the
     * valid codes.
     *
     */
    private class WaitState implements DoorState {

        private final int codeCount = 3; // Number of coes in vault

        int[] myValidCodes; // List of valid codes

        /* Contructor used to update the valid codes */
        public WaitState(int code) {
            myValidCodes = new int[codeCount];
            int[] validCodes = createValidCodes(code);
            System.arraycopy(validCodes, 0, myValidCodes, 0, codeCount);
        }

        /* Return an array of valid codes based on given code */
        private int[] createValidCodes(int code) {
            int[] retval = new int[codeCount];
            int oldCode = code;
            for (int i = 0; i < codeCount; i++) {
                int newCode = (17 * oldCode + 91) % 256;
                retval[i] = newCode;
                oldCode = newCode;
            }
            return retval;
        }

        /**
         * Validate that the given code is in the list of valid codes.
         *
         * @param code
         * @return <code>true</code> if the given code is valid.
         */
        private boolean validate(int code) {
            for (int validCode : myValidCodes) {
                if (code == validCode) {
                    return true;
                }
            }
            return false;
        }

        public DoorState handle(CommandInput input) {
            DoorState retval = null;

            int code = input.getCode();
            switch (input.getCommand()) {
                case SYNC:
                    retval = new SyncronizedState(code);
                    break;
                case OPEN:
                    if (validate(code)) {
                        retval = new OpenState(code);
                    } else {
                        retval = new InvalidState(this);
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            return retval;
        }

        public DoorState updateCodes() {
            throw new UnsupportedOperationException();
        }

        public String show() {
            throw new UnsupportedOperationException();
        }
    }

    /* Used to indicate the current state is open */
    private class OpenState implements DoorState {

        private int myCode; // Access Code

        /* Instantiate a new object with the given code. */
        public OpenState(int code) {
            myCode = code;
        }

        public DoorState handle(CommandInput input) {
            throw new UnsupportedOperationException();
        }

        public DoorState updateCodes() {
            return new WaitState(myCode);
        }

        public String show() {
            return "UNLOCK";
        }
    }
}
