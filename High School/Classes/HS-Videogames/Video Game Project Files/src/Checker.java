
import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Master Ward
 */
public class Checker {

    public int position = 0;

    public Checker() {

    }

    public void check(int answer[], ArrayList guess) {
        ArrayList bw = MainPanels.blwh;
        ArrayList blackwhite = MainPanels.blwh;
        int position = 0;
        int black = 0;
        int row = 0;
        int white = 0;
        for (int ii = 0; ii < 4; ii++) {
            for (int i = 0; i < 4; i++) {
                if (answer[i] == (int) guess.get(ii)) {
                    if (answer[i] == (int) guess.get(i)) {
                        blackwhite.set(position, 2);
                        white++;
                        black--;
                        position++;
                    } else if (guess.indexOf(answer[i]) > 0) {
                        blackwhite.set(position, 1);
                        black++;
                    }
                }
            }
        }
        out.println(bw.size());
        position = row * 40;
        row = position;
        bw.clear();
        bw.addAll(bw);
        bw.addAll(blackwhite);
        out.println(bw.size());
    }
}
