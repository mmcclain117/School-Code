
import java.awt.Color;
import static java.lang.Math.pow;
import static java.lang.System.out;
import java.util.Arrays;

/**
 *
 * @author 180869
 */
public class GuitarHeroVisualizer {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String type = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/'";
        char ch[] = type.toCharArray();
        double k[] = new double[ch.length];
        for (int i = 0; i < ch.length; i++) {
            k[i] = 440 * (pow(1.05956, (i - 24)));
        }
        GuitarString stringB = new GuitarString(440);

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                int c = type.indexOf(key);
                if (c >= 0) {
                    double f = k[c];
                    stringB = new GuitarString(f);
                    stringB.pluck();
                    double ll[] = stringB.buffer.buffer;
                    out.println(Arrays.toString(k));
//                    StdDraw.setCanvasSize(1000, 1000);
//StdDraw.line(0, 10, 20, 100);
//                    StdDraw.setPenColor(Color.black);
//                    StdDraw.line(0, 0, 1, 1);
                    StdDraw.setPenColor(Color.BLUE);
//out.println(StdDraw.mouseX());
//out.println(StdDraw.mouseY());
                    for (int i = 0; i < stringB.buffer.size() - 1; i++) {
//                        out.println(i + " " + ll[i]);
                        for (int op = 0; op < 20; op++) {
//                        StdDraw.line((i * .010), ll[i] + .5, ((i + 1) * .010), ll[i + 1] + .5);
                            StdDraw.line((op * .010), ll[i] + .5, (op * .010), ll[i + 1] + .5);
//                        StdDraw.clear();
                        }
                        StdDraw.clear();
                    }
//                    StdDraw.clear();
                }
            }
            double sample = stringB.sample();
            StdAudio.play(sample);
            stringB.tic();
        }
    }
}
