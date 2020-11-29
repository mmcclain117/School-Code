
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Master Ward
 */
public class Prob09 {

    public static void main(String[] args) throws Exception {
//        Problem: A Sorted Affair
//        Difficulty: Medium
//        Subject: HashMap
        Scanner scan = new Scanner(new File("prob09.txt"));
        String line = scan.nextLine();
        Map<Integer, Integer> tsm = new HashMap(); // Team Score Map
        while (line != null && !"0 0".equals(line)) {
            String numb[] = line.split("\\s+");
            int t = Integer.parseInt(numb[0]); // Team
            int p = Integer.parseInt(numb[1]); // points
            Integer e = tsm.get(t);
            if (e == null) {
                e = p;
            } else {
                e += p;
            }
            tsm.put(t, e);
            line = scan.nextLine();
        }

        Set<Integer> keys = tsm.keySet();
        List<Integer> scores = new ArrayList<>(keys.size());
        Map<Integer, Integer> scoreTeamMap = new HashMap<>(keys.size());
        for (Integer key : keys) {
//                System.out.println("Team " + key + " final score " + teamScoreMap.get(key));
            scores.add(tsm.get(key));
            scoreTeamMap.put(tsm.get(key), key);
        }
        Collections.sort(scores);
        for (int i = 0; i < 5; i++) {
            int index = (scores.size() - i - 1);
            System.out.println((i + 1) + " " + scoreTeamMap.get(scores.get(index)) + " " + scores.get(index));
        }
    }
}
