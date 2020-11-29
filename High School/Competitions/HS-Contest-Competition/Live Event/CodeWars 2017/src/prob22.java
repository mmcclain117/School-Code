
import java.util.*;
import java.io.*;

public class prob22 {

    static int xFact = 0, yFact = 0;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob22-1-in.txt"));

        char arr[][] = new char[80][80];
        int dir = scan.nextInt(), it = scan.nextInt();

        if (it % 2 != 0) {
            dir += 1;
        }

        dir %= 8;

        processDir(dir);

        int x = 40, y = 40;

        for (int i = 0; i < it + 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr[y][x] = '#';
                x += xFact;
                y += yFact;
            }

            dir += 2;
            dir %= 8;
            processDir(dir);
        }

        for (char[] c : arr) {
            System.out.println(new String(c));
        }
    }

    static void processDir(int num) {
        switch (num) {
            case 1:
                xFact = -1;
                yFact = -1;
                break;
            case 2:
                xFact = 1;
                yFact = 0;
                break;
            case 3:
                xFact = -1;
                yFact = 1;
                break;
            case 4:
                xFact = 0;
                yFact = 1;
                break;
            case 5:
                xFact = 1;
                yFact = 1;
                break;
            case 6:
                xFact = 1;
                yFact = 0;
                break;
            case 7:
                xFact = 1;
                yFact = -1;
                break;
            case 8:
                xFact = 0;
                yFact = -1;
                break;

        }
    }

}
