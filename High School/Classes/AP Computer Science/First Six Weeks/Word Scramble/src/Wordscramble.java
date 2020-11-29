
import java.io.File;
import static java.lang.System.out;
import java.util.*;

public class Wordscramble {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("WordScrambleInput.txt"));
        while (scan.hasNext()) {
            String a = scan.nextLine();
            Scanner in = new Scanner(a);
            while (in.hasNext()) {
                ArrayList<Character> ar = new ArrayList<>();
                String before = "";
                String after = "";
                String word = in.next();
                if (word.length() <= 3) {
                    out.print(word + " ");
                } else {
                    char ch[] = word.toCharArray();
                    for (int i = 0; i < word.length(); i++) {
                        ar.add((char) ch[i]);
                    }
                    int u = 0;
                    while (!Character.isAlphabetic(ar.get(u))) {
                        before += ar.get(u);
                        u++;
                    }
                    before += ar.get(u);
                    int ba = u;
                    u = 1;
                    while (!Character.isAlphabetic(ar.get(ch.length - u))) {
                        after += ar.get(ch.length - u);
                        u++;
                    }
                    int aa = u;
                    after += ar.get(ch.length - u);
                    String attemptnumberitistimetogiveup = word.substring(ba + 1, ch.length - aa);
                    String thisisoneofthelongeststringnamesthatonepersonhasuser = mixWord(attemptnumberitistimetogiveup);
                    out.print(before + thisisoneofthelongeststringnamesthatonepersonhasuser);
                    if (after.length() >= 2) {
                        for (int i = after.length(); i > 0; i--) {
                            out.print(after.substring(i - 1, i));
                        }
                    } else {
                        out.print(after);
                    }
                    out.print(" ");
                    ar.clear();
                }
            }
            out.println();
            in.close();
        }
        scan.close();
    }

    private static String mixWord(String a) {
        ArrayList<Character> ay = new ArrayList<>();
        char ch[] = a.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            ay.add(ch[i]);
        }
        Collections.shuffle(ay);
        String yyyyy = "";
        for (int i = 0; i < a.length(); i++) {
            yyyyy += ay.get(i);
        }
        return yyyyy;
    }
}
