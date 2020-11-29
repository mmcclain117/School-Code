
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob07 {

    public static void main(String[] args) throws Exception {
//        Problem: Music
//        Points: 6
        Scanner scan = new Scanner(new File("prob07.txt"));
        String fchord[] = {"C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};; // Flat Chords
        String schord[] = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"}; // Sharp Chords
//        Minor 3 up, 4 up; Major 4 up, 3 up
        while (scan.hasNext()) {
            String s = scan.nextLine(); // Preforming
            String c[] = s.split("[ ]+"); // 2 parts of it
            String note = c[0];
            if (note.length() == 2) { // First letter Capilization
                note = note.substring(0, 1).toUpperCase() + note.substring(1);
            }
            String tc = c[1]; // Type of Chord
            int inote = 0; // Index of note
            if (note.contains("b")) {
                inote = noteIndex(fchord, note);
                MajMin(note, inote, fchord, tc);
            } else {
                inote = noteIndex(schord, note);
                MajMin(note, inote, schord, tc);
            }
        }
    }

    /* Gets the index of the note */
    private static int noteIndex(String a[], String note) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equalsIgnoreCase(note)) {
                return i;
            }
        }
        return -1;
    }

    private static void MajMin(String note, int index, String[] notes, String tc) {
        if (tc.equalsIgnoreCase("major")) {
            System.out.println(note + "-" + notes[(index + 4) % 12] + "-" + notes[(index + 7) % 12]);
        } else if (tc.equalsIgnoreCase("minor")) {
            System.out.println(note + "-" + notes[(index + 3) % 12] + "-" + notes[(index + 7) % 12]);
        }
    }
}
