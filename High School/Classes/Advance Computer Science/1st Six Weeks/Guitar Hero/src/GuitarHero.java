
public class GuitarHero {

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        int index = 0;
        GuitarString[] notes = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            notes[i] = new GuitarString(440 * Math.pow(1.05956, i - 24));
        }
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                index = keyboard.indexOf(key);
                if (!(index == -1)) {
                    notes[index].pluck();
                }
            }
            if (!(index == -1)) {
                double sample = notes[index].sample();
                StdAudio.play(sample);
                notes[index].tic();
            }
        }
    }

}
