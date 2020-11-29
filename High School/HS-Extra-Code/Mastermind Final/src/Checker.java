
import java.util.ArrayList;

/**
 *
 * @author Master, Christian Rameriaz, and Cody Chang
 */
public class Checker {

    public Checker() {
    }

    public void check(final int answers[], ArrayList guess, int iii) {
        ArrayList bw = MainPanels.blwh;
        ArrayList blackwhite = MainPanels.blwh;
        int[] answer = new int[4];
        for (int o = 0; o < 4; o++) {
            answer[o] = answers[o];
        }
        int position = 0;
        int black = 0;
        int row = 0;
        int white = 0;
        int t = iii;
        for (int ii = 0; ii < 4; ii++) {

            for (int i = 0; i < 4; i++) {

                if (answer[i] == (int) guess.get(ii)) {

                    if (answer[i] == (int) guess.get(i)) {

                        blackwhite.set(position, 2);
                        black++;

                        position++;
                        answer[i] = 10;
                    } else {
                        blackwhite.set(position, 1);
                        white++;
                        answer[i] = 10;
                    }
                }
            }
        }

        MainPanels.it[t] = black;
        MainPanels.it[t + 1] = white;
    }
}
