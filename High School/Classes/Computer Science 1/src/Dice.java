
import java.util.*;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Dice {

    public static void main(String[] args) throws Exception {
        Suit();
        out.println();
        out.println();
        Two();
    }

    public static void Suit() {
        int vd = 10000;
        Random rnd = new Random();
        int b[] = new int[vd];
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        for (int y = 0; y < vd; y++) {
            int a = rnd.nextInt(6) + 1;
            b[y] = a;
        }
        int y[] = new int[50];
        Arrays.sort(b);
        for (int n = 0; n < vd; n++) {
            switch (b[n]) {
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
            }
        }
        int min = 10000;
        int yab[] = {one, two, three, four, five, six};
        Arrays.sort(yab);
        min = yab[0] - 15;
        one -= min;
        two -= min;
        three -= min;
        four -= min;
        five -= min;
        six -= min;
        out.print("One = ");
        for (int ya = 0; ya < one; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Two = ");
        for (int ya = 0; ya < two; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Three = ");
        for (int ya = 0; ya < three; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Four = ");
        for (int ya = 0; ya < four; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Five = ");
        for (int ya = 0; ya < five; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Six = ");
        for (int ya = 0; ya < six; ya++) {
            out.print("*");
        }
        out.println();
    }

    public static void Two() {
        Random rnd = new Random();
        Random rn = new Random();
        int roll = 1000;
        int a[] = new int[roll];
        int b[] = new int[roll];
        int c[] = new int[roll];
        for (int i = 0; i < roll; i++) {
            a[i] = rnd.nextInt(6) + 1;
            b[i] = rn.nextInt(6) + 1;
        }
        for (int u = 0; u < roll; u++) {
            c[u] = a[u] + b[u];
        }
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int ten = 0;
        int eleven = 0;
        int twelve = 0;
        for (int n = 0; n < roll; n++) {
            switch (c[n]) {
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;
                case 10:
                    ten++;
                    break;
                case 11:
                    eleven++;
                    break;
                case 12:
                    twelve++;
                    break;
            }
        }
        int yab[] = {two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        Arrays.sort(yab);
        int min = yab[0] - 15;
        two -= min;
        three -= min;
        four -= min;
        five -= min;
        six -= min;
        seven -= min;
        eight -= min;
        nine -= min;
        ten -= min;
        eleven -= min;
        twelve -= min;
        out.print("Two = ");
        for (int ya = 0; ya < two; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Three = ");
        for (int ya = 0; ya < three; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Four = ");
        for (int ya = 0; ya < four; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Five = ");
        for (int ya = 0; ya < five; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Six = ");
        for (int ya = 0; ya < six; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Seven = ");
        for (int ya = 0; ya < seven; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Eight = ");
        for (int ya = 0; ya < eight; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Nine = ");
        for (int ya = 0; ya < nine; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Ten = ");
        for (int ya = 0; ya < ten; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Eleven = ");
        for (int ya = 0; ya < eleven; ya++) {
            out.print("*");
        }
        out.println();
        out.print("Twelve = ");
        for (int ya = 0; ya < twelve; ya++) {
            out.print("*");
        }
        out.println();
    }
}

/**
 *
 * @author Jacob
 */
class Die {

    private int Fac;
    private int val;

    public Die(int Faces) {
        Fac = Faces;
        roll();
    }

    public Die() {
        this(6);
    }

    public int value() {
        return val;
    }

    public int roll() {
        Random rnd = new Random();
        val = rnd.nextInt(Fac) + 1;
        return val;
    }
}
