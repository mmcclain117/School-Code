// MasterMind.java

import java.awt.*;
import java.util.*;
import ch.aplu.jgamegrid.*;

public class MasterMind extends GameGrid implements GGMouseListener {

    int[] secretCode = new int[4];
    int currentRow;
    boolean roundFinished;
    ActiveRowMarker marker;
    private int placedPegs = 0;

    public MasterMind() {
        super(7, 10, 60, null, "sprites/MastermindBG4.png", false);
        this.addMouseListener(this, GGMouse.lPress | GGMouse.rPress);
        this.setTitle("MasterMind");
        getBg().setPaintColor(Color.red);
        reset();
        show();
    }

    public boolean mouseEvent(GGMouse mouse) {
        if (roundFinished) {
            reset();
            return true;
        }

        Location loc = toLocation(mouse.getX(), mouse.getY());

        if (placedPegs == 4 && loc.x == 1 && loc.y == currentRow) { // click on evalButton -> evaluate
            int[] guess = new int[4];
            for (int i = 0; i < 4; i++) {
                guess[i] = getOneActorAt(new Location(2 + i, currentRow)).getIdVisible();
            }
            evaluateGuess(guess);
        }

        if (loc.y == currentRow && loc.x > 1 && loc.x < 6) {
            if (getOneActorAt(loc) == null) {
                this.addActor(new Peg(), loc);
                placedPegs++;
                if (placedPegs == 4) { // show evaluate button
                    addActor(new EvaluateButton(), new Location(1, currentRow));
                }
            } else if (mouse.getEvent() == GGMouse.lPress) {
                getOneActorAt(loc).showNextSprite(); //if leftclick -> next color
            } else {
                getOneActorAt(loc).showPreviousSprite(); //if rightClick -> previous color
            }
        }
        refresh();
        return true;
    }

    public void reset() {
        removeAllActors();
        getBg().clear();
        currentRow = this.nbVertCells - 2;
        roundFinished = false;
        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = (int) (Math.random() * Peg.AmountOfColors);
        }
        marker = new ActiveRowMarker();
        addActor(marker, new Location(1, currentRow));
        refresh();
    }

    private void evaluateGuess(int[] guess) {
        int blackPegs = 0, whitePegs = 0;
        for (int i = 0; i < 4; i++) {
            if (guess[i] == secretCode[i]) {
                blackPegs++;
            }
        }
        ArrayList<Integer> alreadyProcessed = new ArrayList<Integer>();
        for (int color : secretCode) {
            for (int j = 0; j < 4; j++) {
                if (color == guess[j] && !alreadyProcessed.contains(j)) {
                    alreadyProcessed.add(j);
                    whitePegs++;
                    break;
                }
            }
        }
        whitePegs -= blackPegs;
        showTips(whitePegs, blackPegs);

        if (blackPegs == 4) // got right combination
        {
            finishRound("Correct!");
        } else {
            currentRow--; //go to next column for next try
        }
        if (currentRow == 1) //no more guesses left
        {
            finishRound("Pattern not found!");
        }

        marker.setLocation(new Location(1, currentRow));
        placedPegs = 0;
        removeActors(EvaluateButton.class);
    }

    private void finishRound(String reason) {
        getBg().setFont(new Font("verdana", Font.PLAIN, 18));
        getBg().drawText(reason, new Point(10, 32));
        getBg().setFont(new Font("verdana", Font.PLAIN, 18));
        getBg().drawText("Click to play again", new Point(10, 590));
        removeActor(marker);
        showSolution();
        roundFinished = true;
    }

    private void showTips(int whitePegs, int blackPegs) {
        for (int i = 0; i < 4; i++) {
            if (blackPegs > 0) {
                EvalPeg ep = new EvalPeg(0);
                addActor(ep, new Location(1, currentRow));
                ep.turn(90 * i);
                blackPegs--;
            } else if (whitePegs > 0) {
                EvalPeg ep = new EvalPeg(1);
                addActor(ep, new Location(1, currentRow));
                ep.turn(90 * i);
                whitePegs--;
            }
        }
    }

    private void showSolution() {
        int x = 2;
        for (int spriteNr : secretCode) {
            Peg peg = new Peg();
            peg.show(spriteNr);
            addActor(peg, new Location(x, 1));
            x++;
        }
    }

    private String printArray(int[] a) {
        String result = "";
        for (int b : a) {
            result += b + ", ";
        }
        return result;
    }

    public static void main(String[] args) {
        new MasterMind();
    }
}
