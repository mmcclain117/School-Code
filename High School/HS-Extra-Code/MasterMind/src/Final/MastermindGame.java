package Final;

import java.util.Random;

/**
 *
 * @author Master
 */
public class MastermindGame {

    // Variables
    private int[][] guesses;
    private int[][] evaluations;
    private int[] correctCode;

    private int numberOfColours;
    private int numberOfGuesses;
    private int pegsPerRow;
    private int attemptNumber;

    public final int CORRECT_COLOUR = 1;
    public final int CORRECT_POSITION = 2;

    // Constructor
    public MastermindGame(int aNumberOfColours, int aPegsPerRow,
            int aNumberOfGuesses) {

        numberOfColours = aNumberOfColours;
        numberOfGuesses = aNumberOfGuesses;
        pegsPerRow = aPegsPerRow;

        // Size arrays appropriately
        guesses = new int[numberOfGuesses][pegsPerRow];
        evaluations = new int[numberOfGuesses][pegsPerRow];
        correctCode = new int[pegsPerRow];

        // Generate a random code
        createRandomCode();

    }

    // Generate a random code to solve
    private void createRandomCode() {
        Random random = new Random();

        for (int i = 0; i < correctCode.length; i++) {
            correctCode[i] = random.nextInt(numberOfColours) + 1;
        }

    }

    // Enter a guess at the code
    public void enterGuess(int[] userGuess) {
        if (attemptNumber < numberOfGuesses) {
            if (userGuess.length == pegsPerRow) {
                for (int i = 0; i < userGuess.length; i++) {
                    guesses[attemptNumber][i] = userGuess[i];
                }
            }

            evaluateGuess();
            attemptNumber++;
        }
    }

    // Check the user's guess against the correctCode
    private void evaluateGuess() {
        for (int i = 0; i < guesses[attemptNumber].length; i++) {
            if (guesses[attemptNumber][i] == correctCode[i]) {
                addResult(CORRECT_POSITION);
                break;
            } else {
                for (int j = 0; j < guesses[attemptNumber].length; j++) {
                    if (guesses[attemptNumber][j] == correctCode[i]) {
                        addResult(CORRECT_COLOUR);
                        break;
                    }
                }
            }
        }
    }

    // Add the result of the guess to the first available position
    private void addResult(int resultToAdd) {
        for (int i = 0; i < evaluations[1].length; i++) {
            if (evaluations[attemptNumber][i] == 0) {
                evaluations[attemptNumber][i] = resultToAdd;
                break;
            }
        }
    }

    // Check to see if the code is solved
    public boolean isCodeSolved() {
        boolean codeCorrect = true;

        for (int i = 0; i < correctCode.length; i++) {
            if (correctCode[i] != guesses[attemptNumber][i]) {
                codeCorrect = false;
            }
        }

        return codeCorrect;
    }

    // Check to see if max attempts have been reached
    public boolean isGameOver() {
        return (attemptNumber == numberOfGuesses);
    }

    // Return the guess grid
    public int[][] getGuesses() {
        return guesses;
    }

    // Return the evaluations
    public int[][] getEvaluations() {
        return evaluations;
    }

    //Return correct code
    public int[] getCorrectCode() {
        return correctCode;
    }

    // Return the attempt number 
    public int getAttemptNumber() {
        return attemptNumber;
    }
}
