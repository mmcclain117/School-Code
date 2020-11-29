
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Time : 6-8 hours Difficulty : Hard
 *
 * @author Master Ward & Michael Scheetz
 *
 */
public class Prob20 {

    public static void main(String[] args) throws Exception {
//        Problem: Three Letter Crossword
//        Points: 21
        Scanner scan = new Scanner(new File("prob20.txt"));
        List<String> input = new ArrayList();
        while (scan.hasNext()) {
            input.add(scan.nextLine());
        }
        Prob20 problem = new Prob20(input);
        problem.solve();

    }

    private WordDatabase myDb; // Collection of words to put into crossword puzzle
    private CrossWordTable myTable; // Crossword Puzzle

    /**
     * Construct the problem from the given input.
     *
     * @param input
     * @throws Exception
     */
    public Prob20(List<String> input) throws Exception {
        parseInput(input);
    }

    /**
     * Solve the problem.
     *
     */
    private void solve() {
        reduceSearchSpace();
        CrossWordTable table = search(myTable, myDb.getWords());
        System.out.println(table.solutionOutput());
    }

    /**
     * A recursive search until the first solution is found.
     *
     * @param table The current solution state.
     * @param availableWords The current state of words to place.
     * @return A table containing the solution.
     */
    public CrossWordTable search(CrossWordTable table, List<String> availableWords) {
        // recursively
        //   pick a node
        //   select a word for that node (check for fit)
        //   add word to selected word list
        //   call this method again(state)

        if (availableWords.isEmpty()) {
            return table;
        }

        CrossWord crossWord = table.getCrossWordWithFewestChoices();
        for (String word : crossWord.myPossibleWords) {
            if (availableWords.contains(word)) {
                boolean itFits = crossWord.doesFit(word);
                if (itFits) {
                    List<Boolean> assignedChars = crossWord.setWord(word);
                    availableWords.remove(word);
                    table.assign(crossWord);
                    CrossWordTable retval = search(table, availableWords);
                    if (retval != null) {
                        return retval;
                    } else {
                        table.unassign(crossWord);
                        availableWords.add(word);
                        crossWord.unsetWord(assignedChars);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Parse the input into a problem description.
     *
     * @param input A list of input lines.
     * @throws Exception
     */
    private void parseInput(List<String> input) throws Exception {
        List<String> threeLetterWords = extractWords(input);
        myDb = new WordDatabase(threeLetterWords);
        char[][] table = extractTable(input);
        myTable = new CrossWordTable(table, threeLetterWords.size());
    }

    /**
     * Extract the words used in the puzzle from the input data. Allows words to
     * be listed on multiple lines.
     *
     * @param input A list of input lines.
     * @return
     */
    private List<String> extractWords(List<String> inputRecords) {
        final int wordCountIndex = 0;
        String wordCountString = inputRecords.get(wordCountIndex);
        int wordCount = Integer.parseInt(wordCountString);

        int wordIndex = 1;
        List<String> retval = new ArrayList<>();
        while (wordCount > retval.size()) {
            String wordString = inputRecords.get(wordIndex);
            String[] wordArray = wordString.split(" ");
            retval.addAll(Arrays.asList(wordArray));
            wordIndex++;
        }

        return retval;
    }

    /**
     * Extract the crossword table from the input data. Searches the input
     * records until a line is found which establishes the dimensions of the
     * table.
     *
     * @param string
     * @return
     */
    private char[][] extractTable(List<String> inputRecords) {
        int tableSizeIndex = 2;
        int cSize = 0;
        int rSize = 0;

        boolean foundTableSize = false;
        while (!foundTableSize) {
            String tableSizeString = inputRecords.get(tableSizeIndex);
            String[] crTableSizeString = tableSizeString.split(" ");

            try {
                cSize = Integer.parseInt(crTableSizeString[0]);
                rSize = Integer.parseInt(crTableSizeString[1]);
                foundTableSize = true;
            } catch (NumberFormatException e) {
                // not right, try next line.
                tableSizeIndex++;
            }
        }
        char[][] retval = new char[rSize][cSize];

        final int tableStartIndex = tableSizeIndex + 1;
        for (int rIdx = 0; rIdx < rSize; rIdx++) {
            String tableRow = inputRecords.get(rIdx + tableStartIndex);
            String[] tableChar = tableRow.split(" ");
            for (int cIdx = 0; cIdx < tableChar.length; cIdx++) {
                String cellStr = tableChar[cIdx];
                retval[rIdx][cIdx] = cellStr.charAt(0);
            }
        }
        return retval;
    }

    /**
     * Eliminate words from the table search space which we know will not fit.
     * We know some boxes require letters that exist in a specific location of
     * two words. For example: one down and one across require that two words
     * start with the same letter.
     */
    public void reduceSearchSpace() {
        for (CrossWordBox square : myTable.getBoxes()) {
            square.findPossibleLettersByCount(myDb);
        }
        boolean isOptimal = true;
        do {
            isOptimal = true;
            for (CrossWord word : myTable.getCrossWords()) {
                word.findPossibleWordsFromLetters(myDb);
                boolean updated = word.filterPossibleLettersByPossibleWords();
                if (updated) {
                    isOptimal = false;
                }
            }
        } while (!isOptimal);
    }

    /**
     * Show the parsed data for debugging.
     */
    public String toString() {
        return myDb + "\n" + myTable;
    }

    /**
     * Encapsulate words that can be placed into the crossword puzzle.
     */
    private class WordDatabase {

        /**
         * The complete list of words that can be placed.
         */
        List<String> myWords = new ArrayList<String>();
        /**
         * A map of all letters from the words and how many times they appear
         * for each position.
         */
        Map<Character, PositionCount> myLetterCounter = new HashMap<Character, PositionCount>();

        /**
         * Instantiate the word database with a list of words that will be used.
         */
        public WordDatabase(List<String> words) {
            for (String caseWord : words) {
                String word = caseWord.toUpperCase();
                myWords.add(word);
                countLetters(word);
            }
        }

        /**
         * Instantiate the word database with a list of words that will be used.
         */
        public WordDatabase(String[] words) {
            this(Arrays.asList(words));
        }

        /**
         * Count each time a letter appears in a particular position in a word.
         * This is used to optimize the search space.
         */
        private void countLetters(String word) {
            char[] letters = word.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                char letter = letters[i];
                addCounter(letter, i);
            }
        }

        /**
         * Increment the counter for the given letter and index of that letter.
         */
        private void addCounter(char letter, int index) {
            PositionCount counter = retrieveCounter(letter);
            counter.add(index);
        }

        /**
         * Get the counter for the given letter.
         */
        private PositionCount retrieveCounter(char caseLetter) {
            char letter = Character.toUpperCase(caseLetter);
            PositionCount counter = myLetterCounter.get(letter);
            if (counter == null) { // Don't have a counter. So we Make our own
                // Don't have a counter yet, instantiate a new one.
                counter = new PositionCount();
                myLetterCounter.put(letter, counter);
            }

            return counter;
        }

        /**
         * Return the number of times the given letter has appeared at the given
         * index.
         */
        public int getCount(char letter, int index) {
            PositionCount counter = retrieveCounter(letter);
            return counter.get(index);
        }

        /**
         * Return a list of letters which satisfy the given position counter,
         * e.g. the letter must occur at least the number of times for each
         * position that it is required in.
         */
        public List<Character> findLetterMatches(PositionCount squareCounter) {
            List<Character> retval = new ArrayList<>();
            for (Character letter : myLetterCounter.keySet()) {
                PositionCount wordCounter = myLetterCounter.get(letter);
                if (wordCounter.fitsIn(squareCounter)) {
                    retval.add(letter);
                }
            }

            return retval;
        }

        /**
         * Get all of the words from this database. Needing this method
         * typically means that I have some functionality in the wrong place.
         */
        public List<String> getWords() {
            return new ArrayList<>(myWords);
        }

        /**
         * Return a string showing the db contents. Used for debugging.
         */
        public String toString() {
            return myLetterCounter.toString();
        }
    }

    /**
     * A class which keeps track of the number of occurances and the position of
     * occurance.
     */
    private class PositionCount {

        /**
         * The size of words we are keeping track of.
         */
        public static final int WORDSIZE = 3;
        /**
         * The collection of counters for each position.
         */
        private List<Integer> myCount = new ArrayList<>();

        /**
         * Default constructor uses the default word size.
         */
        public PositionCount() {
            this(WORDSIZE);
        }

        /**
         * A constructor which can take a size other than the default.
         */
        public PositionCount(int size) {
            for (int i = 0; i < size; i++) {
                myCount.add(0);
            }
        }

        /**
         * Return <code>true</code> if this counter is greater than the given
         * counter. To "fit", this counter (the one for the letter) must have
         * each index value be greater or equal to the given counter index (from
         * the box). The counters also need to be the same size.
         */
        public boolean fitsIn(PositionCount squareCounter) {
            if (this.size() != squareCounter.size()) {
                return false;
            }
            for (int i = 0; i < size(); i++) {
                if (squareCounter.get(i) > get(i)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * The number of counters in this object, e.g. the number of letters in
         * a word.
         */
        public int size() {
            return myCount.size();
        }

        /**
         * Increment the counter for the given index.
         */
        public void add(int index) {
            int count = myCount.get(index);
            count++;
            myCount.set(index, count);
        }

        /**
         * Return the count for the given index.
         */
        public int get(int index) {
            return myCount.get(index);
        }

        /**
         * Return debug information about this object.
         */
        public String toString() {
            return myCount.toString();
        }
    }

    /**
     * Encapsulate information about the cross table and its search space.
     *
     */
    private class CrossWordTable {

//        Progress
        private final CrossWordBox[][] myTable; // Table represented as a 2d array of boxes
        private final List<CrossWordBox> myBoxes = new ArrayList<>(); // List of boxes
        private final List<CrossWord> myCrossWords = new ArrayList<>(); // List of word boxes
//        Solutions
        private final List<CrossWord> myCompletedCrossWords = new ArrayList<>(); // List of filled in word boxes
        private final List<CrossWord> myIncompleteCrossWords = new ArrayList<>(); // List of word boxes still empty

        /**
         * Constructor takes an initial array of characters representing open
         * boxes and closed boxes. The given table is analyzed and converted
         * into objects used to optimize and solve the puzzle.
         *
         * @param wordCount The number of words expected to find when we analyze
         * the table.
         */
        public CrossWordTable(char[][] charTable, int wordCount) {
            int rSize = charTable.length;
            int cSize = charTable[0].length;
            myTable = new CrossWordBox[rSize][cSize];
            for (int r = 0; r < rSize; r++) {
                for (int c = 0; c < cSize; c++) {
                    char cell = charTable[r][c];
                    myTable[r][c] = new CrossWordBox(cell);
                    if (myTable[r][c].isOpen()) {
                        myBoxes.add(myTable[r][c]);
                    }
                }
            }
            findWordsAcross();
            findWordsDown();
            for (CrossWord word : myCrossWords) {
                word.calculatePositionCounters();
            }

            myIncompleteCrossWords.addAll(myCrossWords);
        }

        /**
         * Traverse the table horizontally looking for continuous open boxes
         * which indicate a word.
         */
        private void findWordsAcross() {
            int rSize = myTable.length;
            int cSize = myTable[0].length;
            for (int r = 0; r < rSize; r++) {
                CrossWord word = new CrossWord();
                for (int c = 0; c < cSize; c++) {
                    CrossWordBox square = myTable[r][c];
                    if (square.isOpen()) {
                        word.add(square);
                    } else {
                        addNewCrossWord(word);
                        word = new CrossWord();
                    }
                }
                addNewCrossWord(word);
            }
        }

        /**
         * Traverse the table vertically looking for continuous open boxes which
         * indicate a word.
         */
        private void findWordsDown() {
            int rSize = myTable.length;
            int cSize = myTable[0].length;
            for (int c = 0; c < cSize; c++) {
                CrossWord word = new CrossWord();
                for (int r = 0; r < rSize; r++) {
                    CrossWordBox square = myTable[r][c];
                    if (square.isOpen()) {
                        word.add(square);
                    } else {
                        addNewCrossWord(word);
                        word = new CrossWord();
                    }
                }
                addNewCrossWord(word);
            }
        }

        /**
         * Add new found word
         */
        private void addNewCrossWord(CrossWord word) {
            if (word.size() > 1) {
                myCrossWords.add(word);
            }
        }

        /**
         * Return a string representation of this object suitable to print.
         */
        public String solutionOutput() {
            StringBuilder builder = new StringBuilder();
            for (CrossWordBox[] row : myTable) {
                for (CrossWordBox cell : row) {
                    builder.append(cell.solutionOutput()).append(" ");
                }
                builder.append("\n");
            }

            return builder.toString();
        }

        /**
         * A string representation for debugging.
         */
        public String toString() {
            String builder = "";
            for (CrossWordBox[] row : myTable) {
                for (CrossWordBox cell : row) {
                    builder += cell;
                }
                builder += "\n";
            }
            builder += "\n";
            for (CrossWord word : myCrossWords) {
                builder += word + "\n";
            }
            return builder;
        }

        /**
         * Return a collection of all the open boxes in the table.
         */
        public List<CrossWordBox> getBoxes() {
            return new ArrayList<>(myBoxes);
        }

        /**
         * Return a list of all the open box words.
         */
        public List<CrossWord> getCrossWords() {
            return new ArrayList<>(myCrossWords);
        }

        /**
         * Return a list of the currently incomplete words.
         */
        public List<CrossWord> getIncompleteIncompleteWords() {
            return new ArrayList<>(myIncompleteCrossWords);
        }

        /**
         * Return a single incomplete word.
         *
         * @return
         */
        public CrossWord getAnyIncompleteCrossWord() {
            List<CrossWord> retval = new ArrayList<>(getIncompleteIncompleteWords());
            return retval.get(0);
        }

        /**
         * Return the incomplete cross word which has the fewest choices of
         * possible words remaining to choose.
         *
         * @return
         */
        public CrossWord getCrossWordWithFewestChoices() {
            List<CrossWord> retval = new ArrayList<>(getIncompleteIncompleteWords());
            Collections.sort(retval, new CompareCrossWordBySearchSpace());
            return retval.get(0);
        }

        /**
         * Update the current state by moving the given word from the unfinished
         * list to the finished list.
         *
         * @param crossWord
         */
        public void assign(CrossWord crossWord) {
            myCompletedCrossWords.add(crossWord);
            myIncompleteCrossWords.remove(crossWord);
        }

        /**
         * Update the current state by moving the given word from the finished
         * state back to unfinished.
         */
        public void unassign(CrossWord crossWord) {
            myCompletedCrossWords.remove(crossWord);
            myIncompleteCrossWords.add(crossWord);
        }
    }

    /**
     * A comparator of CrossWords to sort by remaining possible words.
     *
     */
    private class CompareCrossWordBySearchSpace implements Comparator<CrossWord> {

        public int compare(CrossWord o1, CrossWord o2) {
            Integer count1 = o1.myPossibleWords.size();
            Integer count2 = o2.myPossibleWords.size();
            if (count1 != count2) {
                return count1.compareTo(count2);
            }
            return 1;
        }
    }

    /**
     * Encapsulate data for a single box in the table.
     */
    private class CrossWordBox {

        char myCurrentChar; // Current charecter in the box
        /**
         * All of the possible characters that will fit in this box. Used to
         * optimize the search.
         */
        List<Character> myPossibleChars = new ArrayList<>();
        /**
         * A counter used to hold the number of occurances and their position in
         * a word.
         */
        PositionCount myCounter = new PositionCount();

        /**
         * Construct an object with the current character.
         *
         * @param currentChar
         */
        public CrossWordBox(char currentChar) {
            myCurrentChar = currentChar;
        }

        /**
         * Set the possible characters to the given list.
         *
         * @param currentPossibleChars
         */
        public void setPossibleChars(List<Character> possibleChars) {
            myPossibleChars.clear();
            myPossibleChars.addAll(possibleChars);
        }

        /**
         * Return the number of possible characters.
         *
         * @return
         */
        public int possibleCharSize() {
            return myPossibleChars.size();
        }

        /**
         * Use a string builder to add the next character to the given builders.
         * The number of builders will multiply by the number of possible
         * letters.
         *
         * @param builder
         * @return
         */
        public List<StringBuilder> buildLettersIntoListOfStrings(List<StringBuilder> builders) {
            List<StringBuilder> retval = new ArrayList<>();
            if (builders.isEmpty()) {
                for (Character ch : myPossibleChars) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(ch);
                    retval.add(builder);
                }
            } else {
                for (StringBuilder oldBuilder : builders) {
                    for (Character ch : myPossibleChars) {
                        StringBuilder newBuilder = new StringBuilder(oldBuilder);
                        newBuilder.append(ch);
                        retval.add(newBuilder);
                    }
                }
            }
            return retval;
        }

        /**
         * Return all of the possible letters for this box.
         *
         * @return
         */
        public List<Character> getPossibleLetters() {
            return new ArrayList<>(myPossibleChars);
        }

        /**
         * return true if this is not a closed box, represented by the '#'
         * character.
         *
         * @return
         */
        public boolean isOpen() {
            return myCurrentChar != '#';
        }

        /**
         * increment the counter for this box position.
         *
         * @param index
         */
        public void addCount(int index) {
            myCounter.add(index);
        }

        /**
         * Return a string of this object suitable for solution output.
         *
         * @return
         */
        public String solutionOutput() {
            return Character.toString(myCurrentChar);
        }

        /**
         * Return a string for debugging.
         */
        public String toString() {
            return Character.toString(myCurrentChar) + myCounter;
        }

        /**
         * Search for the possible letters in the database.
         *
         * @param db
         */
        public void findPossibleLettersByCount(WordDatabase db) {
            List<Character> letters = db.findLetterMatches(myCounter);
            myPossibleChars.addAll(letters);
        }

        /**
         * Set the current character for this box.
         *
         * @param wordChar
         */
        public void setCurrentChar(char wordChar) {
            myCurrentChar = wordChar;
        }
    }

    /**
     * Encapsulate a list of boxes as a word in the cross word table.
     */
    private class CrossWord {

        /**
         * The list of boxes representing a word.
         */
        List<CrossWordBox> myWord = new ArrayList<>();
        /**
         * A list of strings which could fit into this object.
         */
        List<String> myPossibleWords = new ArrayList<>();

        public void add(CrossWordBox square) { // Add box to word
            myWord.add(square);
        }

        public int size() { // Returns length of word
            return myWord.size();
        }

        /**
         * Iterate across the boxes of this word and increment the counters for
         * its position.
         */
        public void calculatePositionCounters() {
            for (int i = 0; i < myWord.size(); i++) {
                CrossWordBox square = myWord.get(i);
                square.addCount(i);
            }
        }

        @Override
        public String toString() { // For Debugging
            String fin = "";
            for (CrossWordBox letter : myWord) {
                fin += letter;
            }
            return fin;
        }

        /**
         * Merge all of the letters from these boxes into strings and only keep
         * strings that are found in the db.
         *
         * Requires that the possible letters have already been found.
         *
         * @param myDb
         */
        public void findPossibleWordsFromLetters(WordDatabase db) {
            List<StringBuilder> mergedLetterStrings = new ArrayList<>();
            for (CrossWordBox square : myWord) {
                mergedLetterStrings = square.buildLettersIntoListOfStrings(mergedLetterStrings);
            }
            List<String> possibleWords = new ArrayList<>();
            for (StringBuilder mergedString : mergedLetterStrings) {
                String word = mergedString.toString();
                possibleWords.add(word);
            }
            possibleWords.retainAll(db.getWords());
            myPossibleWords = possibleWords;
        }

        /**
         * Remove any possible letters if they don't exist in the possible words
         * that we found.
         *
         * @return true if it updated.
         */
        public boolean filterPossibleLettersByPossibleWords() {
            for (int i = 0; i < myWord.size(); i++) {
                List<Character> updatePosChar = new ArrayList<>(); // Update possible Chars
                for (String word : myPossibleWords) {
                    char ch = word.charAt(i);
                    updatePosChar.add(ch);
                }

                CrossWordBox square = myWord.get(i);
                List<Character> currentPossibleChars = square.getPossibleLetters();
                currentPossibleChars.retainAll(updatePosChar);
                List<Character> origPossibleChars = square.getPossibleLetters();
                if (origPossibleChars.size() != currentPossibleChars.size()) {
                    square.setPossibleChars(currentPossibleChars);
                    return true;
                }
            }
            return false;
        }

        /**
         * Return <code>true</code> if the given string fits in this word.
         */
        public boolean doesFit(String word) {
            char[] ch = word.toCharArray();
            for (int i = 0; i < myWord.size(); i++) {
                CrossWordBox square = myWord.get(i);
                char squareChar = square.myCurrentChar;
                char wordChar = ch[i];
                if (squareChar != '-' && squareChar != wordChar) {
                    return false;
                }
            }
            return true;
        }

        /**
         * Put the give string into all of the word boxes. Caller is expected to
         * know if it fits or not.
         */
        public List<Boolean> setWord(String word) {
            List<Boolean> retval = new ArrayList<Boolean>();
            char[] ch = word.toCharArray();
            for (int i = 0; i < myWord.size(); i++) {
                boolean added = false;
                CrossWordBox square = myWord.get(i);
                if (square.myCurrentChar == '-') {
                    char c = ch[i];
                    square.setCurrentChar(c);
                    added = true;
                }
                retval.add(added);
            }
            return retval;
        }

        /**
         * Reset the characters if they were previously assigned.
         */
        public void unsetWord(List<Boolean> assignedChars) {
            for (int i = 0; i < assignedChars.size(); i++) {
                boolean unset = assignedChars.get(i);
                if (unset) {
                    CrossWordBox square = myWord.get(i);
                    square.setCurrentChar('-');
                }
            }
        }
    }
}
