
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward, x45Clamibot
 */
public class Prob18 {

    public static void main(String[] args) throws Exception {
//        Problem: Musical Transposition
//        Points: 16
        Scanner scan = new Scanner(new File("prob18.txt"));
        String instrument = scan.nextLine(); // Target Instrument
        String keysig = scan.nextLine(); // Key Signature
        instrument = instrument.substring(8);
        System.out.println("INSTRUMENT: " + instrument);
        keysig = keysig.substring(15, 17);// Assume 2 Characters Since A Key signature Can Have Up To 2 Characters
        String tuning = instrument.substring(0, instrument.indexOf(" ")); // Tuning Of Instrument
        switch (tuning)// Transpose The Key
        {
            case "Bb":
                switch (keysig) {
                    case "Ab":
                        keysig = "Bb";
                        break;
                    case "A ":
                        keysig = "B";
                        break;
                    case "A#":
                        keysig = "C";
                        break;
                    case "Bb":
                        keysig = "C";
                        break;
                    case "B ":
                        keysig = "C#";
                        break;
                    case "C ":
                        keysig = "D";
                        break;
                    case "C#":
                        keysig = "D#";
                        break;
                    case "Db":
                        keysig = "Eb";
                        break;
                    case "D ":
                        keysig = "E";
                        break;
                    case "D#":
                        keysig = "F";
                        break;
                    case "Eb":
                        keysig = "F";
                        break;
                    case "E ":
                        keysig = "F#";
                        break;
                    case "F ":
                        keysig = "G";
                        break;
                    case "F#":
                        keysig = "G#";
                        break;
                    case "Gb":
                        keysig = "Ab";
                        break;
                    case "G ":
                        keysig = "A";
                        break;
                    case "G#":
                        keysig = "A#";
                        break;
                    default:
                        keysig = "ERROR";
                        break;
                }
                break;
            case "D":
                switch (keysig) {
                    case "Ab":
                        keysig = "Gb";
                        break;
                    case "A ":
                        keysig = "G";
                        break;
                    case "A#":
                        keysig = "G#";
                        break;
                    case "Bb":
                        keysig = "Ab";
                        break;
                    case "B ":
                        keysig = "A";
                        break;
                    case "C ":
                        keysig = "A#/Bb";
                        break;
                    case "C#":
                        keysig = "B";
                        break;
                    case "Db":
                        keysig = "B";
                        break;
                    case "D ":
                        keysig = "C";
                        break;
                    case "D#":
                        keysig = "C#";
                        break;
                    case "Eb":
                        keysig = "Db";
                        break;
                    case "E ":
                        keysig = "D";
                        break;
                    case "F ":
                        keysig = "D#/Eb";
                        break;
                    case "F#":
                        keysig = "E";
                        break;
                    case "Gb":
                        keysig = "E";
                        break;
                    case "G ":
                        keysig = "F";
                        break;
                    case "G#":
                        keysig = "F#";
                        break;
                    default:
                        keysig = "ERROR";
                        break;
                }
                break;
            case "Eb":
                switch (keysig) {
                    case "Ab":
                        keysig = "F";
                        break;
                    case "A ":
                        keysig = "F#/Gb";
                        break;
                    case "A#":
                        keysig = "G";
                        break;
                    case "Bb":
                        keysig = "G";
                        break;
                    case "B ":
                        keysig = "G#/Ab";
                        break;
                    case "C ":
                        keysig = "A";
                        break;
                    case "C#":
                        keysig = "A#";
                        break;
                    case "Db":
                        keysig = "Bb";
                        break;
                    case "D ":
                        keysig = "B";
                        break;
                    case "D#":
                        keysig = "C";
                        break;
                    case "Eb":
                        keysig = "C";
                        break;
                    case "E ":
                        keysig = "C#/Db";
                        break;
                    case "F ":
                        keysig = "D";
                        break;
                    case "F#":
                        keysig = "D#";
                        break;
                    case "Gb":
                        keysig = "Eb";
                        break;
                    case "G ":
                        keysig = "E";
                        break;
                    case "G#":
                        keysig = "F";
                        break;
                    default:
                        keysig = "ERROR";
                        break;
                }
                break;
        }
        System.out.println("TRANSPOSED KEY SIGNATURE: " + keysig); // Transposition To Concert Pitch
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String notes[] = line.split(" ");
            for (int i = 0; i < notes.length; i++) {
                char octave[] = notes[i].substring(notes[i].length() - 1, notes[i].length()).toCharArray();
                switch (tuning)// Transpose The Notes
                {
                    case "Bb":
                        if (notes[i].length() == 2) {
                            switch (notes[i].substring(0, 1)) {
                                case "A":
                                    notes[i] = "B";
                                    break;
                                case "B":
                                    notes[i] = "C#";
                                    break;
                                case "C":
                                    notes[i] = "D";
                                    break;
                                case "D":
                                    notes[i] = "E";
                                    break;
                                case "E":
                                    notes[i] = "F#";
                                    break;
                                case "F":
                                    notes[i] = "G";
                                    break;
                                case "G":
                                    notes[i] = "A";
                                    octave[0] += 1;
                                    break;
                            }
                        } else {
                            switch (notes[i].substring(0, 2)) {
                                case "Ab":
                                    notes[i] = "Bb";
                                    octave[0] += 1;
                                    break;
                                case "A#":
                                    notes[i] = "C";
                                    break;
                                case "Bb":
                                    notes[i] = "C";
                                    break;
                                case "C#":
                                    notes[i] = "D#";
                                    break;
                                case "Db":
                                    notes[i] = "Eb";
                                    break;
                                case "D#":
                                    notes[i] = "F";
                                    break;
                                case "Eb":
                                    notes[i] = "F";
                                    break;
                                case "F#":
                                    notes[i] = "G#";
                                    break;
                                case "Gb":
                                    notes[i] = "Ab";
                                    break;
                                case "G#":
                                    notes[i] = "A#";
                                    octave[0] += 1;
                                    break;
                                default:
                                    notes[i] = "ERROR";
                                    break;
                            }
                        }
                        break;
                    case "D":
                        if (notes[i].length() == 2) {
                            switch (notes[i].substring(0, 1)) {
                                case "A":
                                    notes[i] = "G";
                                    octave[0] -= 1;
                                    break;
                                case "B":
                                    notes[i] = "A";
                                    break;
                                case "C":
                                    notes[i] = "A#/Bb";
                                    break;
                                case "D":
                                    notes[i] = "C";
                                    break;
                                case "E":
                                    notes[i] = "D";
                                    break;
                                case "F":
                                    notes[i] = "D#/Eb";
                                    break;
                                case "G":
                                    notes[i] = "F";
                                    break;
                            }
                        } else {
                            switch (notes[i].substring(0, 2)) {
                                case "Ab":
                                    notes[i] = "Gb";
                                    break;
                                case "A#":
                                    notes[i] = "G#";
                                    octave[0] -= 1;
                                    break;
                                case "Bb":
                                    notes[i] = "Ab";
                                    octave[0] -= 1;
                                    break;
                                case "C#":
                                    notes[i] = "B";
                                    break;
                                case "Db":
                                    notes[i] = "B";
                                    break;
                                case "D#":
                                    notes[i] = "C#";
                                    break;
                                case "Eb":
                                    notes[i] = "Db";
                                    break;
                                case "F#":
                                    notes[i] = "E";
                                    break;
                                case "Gb":
                                    notes[i] = "E";
                                    break;
                                case "G#":
                                    notes[i] = "F#";
                                    break;
                                default:
                                    notes[i] = "ERROR";
                                    break;
                            }
                        }
                        break;
                    case "Eb":
                        if (notes[i].length() == 2) {
                            switch (notes[i].substring(0, 1)) {
                                case "A":
                                    notes[i] = "F#/Gb";
                                    octave[0] -= 1;
                                    break;
                                case "B":
                                    notes[i] = "G#/Ab";
                                    break;
                                case "C":
                                    notes[i] = "A";
                                    break;
                                case "D":
                                    notes[i] = "B";
                                    break;
                                case "E":
                                    notes[i] = "C#/Db";
                                    break;
                                case "F":
                                    notes[i] = "D";
                                    break;
                                case "G ":
                                    notes[i] = "E";
                                    break;
                            }
                        } else {
                            switch (notes[i].substring(0, 2)) {
                                case "Ab":
                                    notes[i] = "F";
                                    break;
                                case "A#":
                                    notes[i] = "G";
                                    octave[0] -= 1;
                                    break;
                                case "Bb":
                                    notes[i] = "G";
                                    octave[0] -= 1;
                                    break;
                                case "C#":
                                    notes[i] = "A#";
                                    break;
                                case "Db":
                                    notes[i] = "Bb";
                                    break;
                                case "D#":
                                    notes[i] = "C";
                                    break;
                                case "Eb":
                                    notes[i] = "C";
                                    break;
                                case "F#":
                                    notes[i] = "D#";
                                    break;
                                case "Gb":
                                    notes[i] = "Eb";
                                    break;
                                case "G#":
                                    notes[i] = "F";
                                    break;
                                default:
                                    notes[i] = "ERROR";
                                    break;
                            }
                        }
                }
                System.out.print(notes[i] + String.valueOf(octave) + " ");
            }
            System.out.println();
        }
    }

}
