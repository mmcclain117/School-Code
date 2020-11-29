
public class Guit2 {

    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        double[] strings = new double[37];
        for (int i = 0; i < 37; ++i) {
            strings[i] = 110 * Math.pow(1.05956, i - 24);
        }
        GuitarString stringplay = new GuitarString(440);

        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();
                int note = keyboard.indexOf(key);
                System.out.println(note);
                if (note == -1) {
                    System.out.println("This Key Is Not Bound To A Note");
                } else {
                    System.out.println(strings[note]);
                    double frequency = strings[note];

                    stringplay = new GuitarString(frequency);
                    stringplay.pluck();
                }
            }

            // compute the superposition of the samples
            double sample = stringplay.sample();

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            stringplay.tic();
        }
    }
}
