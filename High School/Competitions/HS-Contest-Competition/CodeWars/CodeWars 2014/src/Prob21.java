
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob21 {

    public String inputLines[];
    public Statement ruleStatements[];
    public String names[];
    int namesIndex = 0;

    public String solution[] = new String[6];

    public static void main(String[] args) {
        new Prob21();
    }

    public Prob21() {
        /* Reads in the Input */
        inputLines = new String[6];
        try {
            Scanner scan = new Scanner(new File("prob21.txt"));
            for (int i = 0; i < 6; i++) {
                inputLines[i] = scan.nextLine();
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }

        String curLine; // Current Line
        Statement currentStatement = null;
        String split[]; // Parsing input lines
        ruleStatements = new Statement[6];
        names = new String[5];
        for (int i = 0; i < 6; i++) {
            curLine = inputLines[i];
            split = curLine.split(" ");
            /* Check for statement 2 */
            if (curLine.contains(" OR ")) {
                currentStatement = new Statement(2);
                currentStatement.name = split[0];
                currentStatement.floorX = Integer.parseInt(split[4]);
                currentStatement.floorY = Integer.parseInt(split[6]);
            }
            /* Check for statement 1 */
            if (curLine.contains("NOT ON FLOOR ")) {
                currentStatement = new Statement(1);
                currentStatement.name = split[0];
                currentStatement.floorX = Integer.parseInt(split[4]);
            }
            /* Check for statement 3 */
            if (curLine.contains(" HIGHER")) {
                currentStatement = new Statement(3);
                currentStatement.name = split[0];
                currentStatement.otherName = split[5];
            }
            /* Check for statement 5 */
            if (curLine.contains("NOT ON ADJACENT ")) {
                currentStatement = new Statement(5);
                currentStatement.name = split[0];
                currentStatement.otherName = split[6];
            }
            /* Assume last is statement 4 */
            if (null == currentStatement) {
                currentStatement = new Statement(4);
                currentStatement.name = split[0];
                currentStatement.otherName = split[5];
            }
            addName(currentStatement.name, currentStatement.otherName);
            ruleStatements[i] = currentStatement;
            currentStatement = null;
        }
        createPossibleSolution();
    }

    private void createPossibleSolution() {
        String possibleSolution[] = new String[6];
        for (int first = 1; first <= 5; first++) {
            int floorOne = fillNextOpenFloor(possibleSolution, 1, first, names[0]);
            for (int second = 1; second <= 4; second++) {
                int floorTwo = fillNextOpenFloor(possibleSolution, floorOne, second, names[1]);
                for (int third = 1; third <= 3; third++) {
                    int floorThree = fillNextOpenFloor(possibleSolution, floorTwo, third, names[2]);
                    for (int fourth = 1; fourth <= 2; fourth++) {
                        int floorFour = fillNextOpenFloor(possibleSolution, floorThree, fourth, names[3]);
                        for (int fifth = 1; fifth <= 1; fifth++) {
                            int floorFive = fillNextOpenFloor(possibleSolution, floorFour, fifth, names[4]);
                            if (true == testSolution(possibleSolution)) {
                                printArray(possibleSolution);
                            }
                            possibleSolution[floorFive] = null;
                        }
                        possibleSolution[floorFour] = null;
                    }
                    possibleSolution[floorThree] = null;
                }
                possibleSolution[floorTwo] = null;
            }
            possibleSolution[floorOne] = null;
        }
    }

    private int fillNextOpenFloor(String aPossibleSolution[], int startFloor, int nthEmptySlot, String name) {
        int nextFloor = -1;
        int floor = 0;
        while (nthEmptySlot != 0) {
            nextFloor = (startFloor + floor);
            if (nextFloor > 5) {
                nextFloor = nextFloor % 5;
                if (nextFloor == 0) {
                    nextFloor++;
                }
            }
            if (aPossibleSolution[nextFloor] == null || aPossibleSolution[nextFloor].equals("")) {
                nthEmptySlot--;
            }
            floor++;
        }
        aPossibleSolution[nextFloor] = name;
        return nextFloor;
    }

    private boolean testSolution(String testSolution[]) {
        int statementMatches = 0;
        for (int ruleIndex = 0; ruleIndex < 6; ruleIndex++) {
            if (ruleStatements[ruleIndex].satisfied(testSolution)) {
                statementMatches++;
            }
        }
        if (statementMatches == 6) {
            return true;
        }
        return false;
    }

    private void addName(String name, String otherName) {
        boolean foundName = false;
        boolean foundOtherName = false;
        for (int index = 0; index < namesIndex; index++) {
            if (names[index] != null && names[index].equals(name)) {
                foundName = true;
            }
            if (names[index] != null && names[index].equals(otherName)) {
                foundOtherName = true;
            }
        }
        if (name != null && !foundName) {
            names[namesIndex] = name;
            namesIndex++;
        }
        if (otherName != null && !foundOtherName) {
            names[namesIndex] = otherName;
            namesIndex++;
        }
    }

    /* Print out the flooring layout */
    private void printArray(String ar[]) {
        for (int i = ar.length - 1; i > 0; i--) {
            System.out.println(i + " " + ar[i]);
        }
    }

}

class Statement {

    int type = -1;
    int floorX = -1;
    int floorY = -1;
    String name = null;
    String otherName = null;

    public Statement(int type) {
        this.type = type;
    }

    /* Check if statement is satisfied */
    public boolean satisfied(String[] aSolution) {
        int nameFloor = findFloor(aSolution, name);
        int otherFloor = findFloor(aSolution, otherName);
        switch (type) {
            case 1: {
                if (aSolution[floorX].equals(name)) {
                    return false;
                }
                break;
            }
            case 2: {
                if (aSolution[floorX].equals(name) || aSolution[floorY].equals(name)) {
                    return false;
                }
                break;
            }
            case 3: {
                if (nameFloor < otherFloor) {
                    return false;
                }
                break;
            }
            case 4: {
                if ((nameFloor + 1) != otherFloor && (nameFloor - 1) != otherFloor) {
                    return false;
                }
                break;
            }
            case 5: {
                if ((nameFloor + 1) == otherFloor || (nameFloor - 1) == otherFloor) {
                    return false;
                }
                break;
            }
            default: {
                System.out.println("UNKNOWN Statement Type: " + type);
                break;
            }
        }
        return true;
    }

    private int findFloor(String aSolution[], String name) {
        for (int f = 1; f < aSolution.length; f++) {
            if (aSolution[f].equals(name)) {
                return f;
            }
        }
        return -1;
    }
}
