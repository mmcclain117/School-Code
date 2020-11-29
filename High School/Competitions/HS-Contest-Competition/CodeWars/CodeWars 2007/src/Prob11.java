
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob11.txt"));
        String line = scan.nextLine();
        String[][][] Leds = {
            {{"1234567"}, {"B"}},
            {{"123457"}, {"A"}},
            {{"123459"}, {"R"}},
            {{"123567"}, {"O"}},
            {{"135790"}, {"W"}},
            {{"12347"}, {"Q"}},
            {{"12357"}, {"M"}},
            {{"12456"}, {"E"}},
            {{"12467"}, {"S"}},
            {{"12569"}, {"G"}},
            {{"13457"}, {"H"}},
            {{"13459"}, {"K"}},
            {{"13567"}, {"U"}},
            {{"23456"}, {"Z"}},
            {{"1249"}, {"F"}},
            {{"1347"}, {"Y"}},
            {{"1379"}, {"V"}},
            {{"1458"}, {"P"}},
            {{"1580"}, {"D"}},
            {{"3567"}, {"J"}},
            {{"3579"}, {"N"}},
            {{"156"}, {"L"}},
            {{"278"}, {"T"}},
            {{"456"}, {"C"}},
            {{"37"}, {"I"}},
            {{"90"}, {"X"}},
            {{"0"}, {" "}}
        };
        for (String[][] Led : Leds) {
            /* substitute all codes from longest to shortest */
            line = line.replaceAll(Led[0][0], Led[1][0]);
        }
        System.out.println(line);
    }
}
