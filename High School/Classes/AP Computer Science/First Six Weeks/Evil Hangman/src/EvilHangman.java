
import java.io.File;
import static java.lang.System.out;
import java.util.*;

public class EvilHangman {

    private boolean debug;
    private Scanner in;
    private List<String> wordList;
    private int wordLength;
    private int remainingGuesses;
    private String solution;
    private String guessedLetters;

    public EvilHangman(String fileName, boolean debug) throws Exception {
        in = new Scanner(System.in);
        inputWords(fileName);
    }

    public void playGame() {
        while (solution.contains("-") && remainingGuesses > 0) {
            System.out.println(this.toString());
            String letter = inputLetter();
            guessedLetters = guessedLetters + letter;
            List<Partition> partitions = new ArrayList();
            partitions = getPartitionList(letter);
            removeSmallerPartitions(partitions);
            wordList = getWordsFromOptimalPartition(partitions);
            String u = solution;
            substitute(wordList.get(1), letter);
            if (u.equals(solution)) {
                remainingGuesses--;
            }
        }
        if (remainingGuesses == 0) {
            out.println("You Lose");
        } else {
            out.println("You Win");
        }
        out.println("You Lose \nThe word was " + wordList.get((int) (Math.random() * wordList.size())));
    }

    @Override
    public String toString() {
        return "Remaining guesses: " + remainingGuesses + "\n" + "Guesses letters: " + guessedLetters + "\n" + "Solution: " + solution;
    }

    private void inputWords(String fileName) throws Exception {
        wordList = new ArrayList();
        Scanner Scan = new Scanner(new File(fileName));
        int b = 0;
        Scan.nextLine();
        while (Scan.hasNext()) {
            wordList.add(Scan.nextLine());
        }
        System.out.print("Word length? ");
        wordLength = in.nextInt();
        System.out.print("Total Guesses? ");
        remainingGuesses = in.nextInt();
        guessedLetters = "";
        solution = "";
        for (int i = 0; i < wordLength; i++) {
            solution += "-";
        }
        while (b < wordList.size()) {
            String word = wordList.get(b);
            if (!(wordLength == word.length())) {
                wordList.remove(b);
            } else {
                b++;
            }
        }
    }

    private String inputLetter() {
        System.out.print("Next letter? ");
        String letter = in.next().toUpperCase();
        boolean u = true;
        while (u) {
            if (Character.isAlphabetic(letter.charAt(0))) {
                u = false;
            } else {
                System.out.print("Invalid!?");
                letter = in.next().toUpperCase();
            }
        }
        return letter.substring(0, 1);
    }

    private String getPattern(String word, String letter) {
        String s = solution; // This May be Wrong
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i++) == letter) {
                s.substring(i, i++).replace("-", letter);
            }
        }
        return s;
    }

    private List<Partition> getPartitionList(String letter) {
        List<Partition> nums = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            String thesii = getPattern(wordList.get(i), letter);
            // Come back to later
        }
        return nums;
    }

    private void removeSmallerPartitions(List<Partition> partitions) {
        int max = 0;
        for (int i = partitions.size() - 1; i >= 0; i--) {
            if (partitions.get(i).getWords().size() > max) {
                max = partitions.get(i).getWords().size();
            }
        }
        for (int i = partitions.size() - 1; i >= 0; i--) {
            if (partitions.get(i).getWords().size() < max) {
                partitions.remove(i);
            }
        }
    }

    private List<String> getWordsFromOptimalPartition(List<Partition> partitions) {
        int max = 0;
        int ind = 0;
        for (int i = 0; i < partitions.size(); i++) {
            Partition pt = new Partition(wordList.get(i));
            int u = pt.getPatternDashCount();
            if (u > max) {
                max = u;
                ind = i;
            } else {
                max = max;
            }
        }
        return wordList;
    }

    private void substitute(String found, String letter) {
        String AF = "";
        char ch[] = solution.toCharArray();
        for (int i = 0; i < found.length(); i++) {
            if (found.substring(i, i + 1).equals(ch[i] + "")) {
                ch[i] = found.charAt(i);
            }
        }
        solution = "";
        for (int i = 0; i < ch.length; i++) {
            solution += ch[i];
        }
    }
}
