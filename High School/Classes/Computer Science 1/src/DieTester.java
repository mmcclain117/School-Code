
import java.util.Arrays;

public class DieTester {

    public static void main(String args[]) {
        Die die1 = new Die(6);
        Die die2 = new Die(6);
        int valueCount[] = new int[13];

        for (int i = 0; i < 3600; i++) {
            die1.roll();
            die2.roll();
            valueCount[die1.roll() + die2.roll()]++;
        }

        System.out.println();
        System.out.println(Arrays.toString(valueCount));

        for (int j = 1; j < valueCount.length; j++) {
            int Xs = valueCount[j] / 10;

            System.out.print(j + ":\t");
            for (int k = 0; k < Xs; k++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
