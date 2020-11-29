
import java.io.File;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class prob10 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob10.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; a > i; i++) {
            int b = scan.nextInt();
            String c = scan.nextLine();
            String[] d = c.split("[ ]+");
            read(b, d);
        }
    }

    public static void read(int x, String[] b) {
        int y = b.length;
        int z = 0;
        while (y > z) {
            switch (b[z]) {
                case "81":
                    out.print("a");
                    break;
                case "82":
                    out.print("b");
                    break;
                case "83":
                    out.print("c");
                    break;
                case "84":
                    out.print("d");
                    break;
                case "85":
                    out.print("e");
                    break;
                case "86":
                    out.print("f");
                    break;
                case "87":
                    out.print("g");
                    break;
                case "88":
                    out.print("h");
                    break;
                case "89":
                    out.print("i");
                    break;
                case "91":
                    out.print("j");
                    break;
                case "92":
                    out.print("k");
                    break;
                case "93":
                    out.print("l");
                    break;
                case "94":
                    out.print("m");
                    break;
                case "95":
                    out.print("n");
                    break;
                case "96":
                    out.print("o");
                    break;
                case "97":
                    out.print("p");
                    break;
                case "98":
                    out.print("q");
                    break;
                case "99":
                    out.print("r");
                    break;
                case "A2":
                    out.print("s");
                    break;
                case "A3":
                    out.print("t");
                    break;
                case "A4":
                    out.print("u");
                    break;
                case "A5":
                    out.print("v");
                    break;
                case "A6":
                    out.print("w");
                    break;
                case "A7":
                    out.print("x");
                    break;
                case "A8":
                    out.print("y");
                    break;
                case "A9":
                    out.print("z");
                    break;
                case "C1":
                    out.print("A");
                    break;
                case "C2":
                    out.print("B");
                    break;
                case "C3":
                    out.print("C");
                    break;
                case "C4":
                    out.print("D");
                    break;
                case "C5":
                    out.print("E");
                    break;
                case "C6":
                    out.print("F");
                    break;
                case "C7":
                    out.print("G");
                    break;
                case "C8":
                    out.print("H");
                    break;
                case "C9":
                    out.print("I");
                    break;
                case "D1":
                    out.print("J");
                    break;
                case "D2":
                    out.print("K");
                    break;
                case "D3":
                    out.print("L");
                    break;
                case "D4":
                    out.print("M");
                    break;
                case "D5":
                    out.print("N");
                    break;
                case "D6":
                    out.print("O");
                    break;
                case "D7":
                    out.print("P");
                    break;
                case "D8":
                    out.print("Q");
                    break;
                case "D9":
                    out.print("R");
                    break;
                case "E2":
                    out.print("S");
                    break;
                case "E3":
                    out.print("T");
                    break;
                case "E4":
                    out.print("U");
                    break;
                case "E5":
                    out.print("V");
                    break;
                case "E6":
                    out.print("W");
                    break;
                case "E7":
                    out.print("X");
                    break;
                case "E8":
                    out.print("Y");
                    break;
                case "E9":
                    out.print("Z");
                    break;
                case "40":
                    out.print(" ");
                    break;
                case "4B":
                    out.print(".");
                    break;
                case "6B":
                    out.print(",");
                    break;
                case "5A":
                    out.print("!");
                    break;
            }
            z++;
        }
        out.println("");
    }
}
