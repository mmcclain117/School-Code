
import java.util.List;
import java.util.ArrayList;

public class Partition {

    private String wordPattern;
    private List<String> wordList;

    public Partition(String pattern) {
        wordPattern = pattern;
        wordList = new ArrayList();
    }

    Partition(String pattern, String word) {
        wordPattern = pattern;
        wordList = new ArrayList();
        wordList.add(word);
    }

    public boolean addIfMatches(String pattern, String word) {
        boolean k = false;
        if (word.contains(wordPattern)) {
            wordList.add(word);
            k = true;
        }
        return k;
    }

    public List<String> getWords() {
        return wordList;
    }

    public int getPatternDashCount() {
        int a = 0;
        char ch[] = wordPattern.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '-') {
                a++;
            }
        }
        return a;
    }
}
