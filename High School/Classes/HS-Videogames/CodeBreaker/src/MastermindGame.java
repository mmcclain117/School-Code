// Name: Husna Chaudhary, Thricia Egar, John Shaw
// Period: 4A
// Date: 4/23/2015
// Assignment: Breaking Codes

import java.util.Random;

public class MastermindGame {

    private int[][] trials;
    private int[][] hints;
    private int[] correctSequence;

    private int numberOfColours;
    private int numberOfTrials;
    private int colorsInTrial;
    private int trialNumber;

    public final int CORRECT_COLOUR = 1;
    public final int CORRECT_POSITION = 2;

    public MastermindGame(int aNumberOfColours, int aPegsPerRow,
            int aNumberOfGuesses) {

        numberOfColours = aNumberOfColours;
        numberOfTrials = aNumberOfGuesses;
        colorsInTrial = aPegsPerRow;

        trials = new int[numberOfTrials][colorsInTrial];
        hints = new int[numberOfTrials][colorsInTrial];
        correctSequence = new int[colorsInTrial];

        createRandomCorrectSequence();

    }

    private void createRandomCorrectSequence() {
        Random random = new Random();

        for (int i = 0; i < correctSequence.length; i++) {
            correctSequence[i] = random.nextInt(numberOfColours);
        }

    }

    public void enterTry(int[] userGuess) {
        if (trialNumber < numberOfTrials) {
            if (userGuess.length == colorsInTrial) {
                for (int i = 0; i < userGuess.length; i++) {
                    trials[trialNumber][i] = userGuess[i];
                }
            }

            evaluateTry();
            trialNumber++;
        }
    }

    private void evaluateTry() {
        for (int i = 0; i < trials[trialNumber].length; i++) {
            if (trials[trialNumber][i] == correctSequence[i]) {
                addResult(CORRECT_POSITION);
                break;
            } else {
                for (int j = 0; j < trials[trialNumber].length; j++) {
                    if (trials[trialNumber][j] == correctSequence[i]) {
                        addResult(CORRECT_COLOUR);
                        break;
                    }
                }
            }
        }
    }

    private void addResult(int resultToAdd) {
        for (int i = 0; i < hints[1].length; i++) {
            if (hints[trialNumber][i] == 0) {
                hints[trialNumber][i] = resultToAdd;
                break;
            }
        }
    }

    public boolean rightCode() {
        boolean codeCorrect = true;

        for (int i = 0; i < correctSequence.length; i++) {
            if (correctSequence[i] != trials[trialNumber][i]) {
                codeCorrect = false;
            }
        }

        return codeCorrect;
    }

    public boolean gameOver() {
        return (trialNumber == numberOfTrials);
    }

    public int[][] getTries() {
        return trials;
    }

    public int[][] getHints() {
        return hints;
    }

    public int[] getCorrectSequence() {
        return correctSequence;
    }

    public int getTrialNumber() {
        return trialNumber;
    }
}
