
import java.io.File;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob11 {

    public static void main(String[] args) throws Exception {
//        Problem: Chineese Remainder Theorm
//        Points: 7
        Scanner scan = new Scanner(new File("prob11.txt"));
        String line = scan.nextLine();
        while (!"-1 -1 -1 -1 -1 -1".equals(line.trim())) {
            String d[] = line.split("\\s+");
            int a = Integer.parseInt(d[0]);
            int b = Integer.parseInt(d[1]);
            int c = Integer.parseInt(d[2]);
            int x = Integer.parseInt(d[3]);
            int y = Integer.parseInt(d[4]);
            int z = Integer.parseInt(d[5]);
            int n = a;
            boolean f = true; // First (X)
            boolean s = true; // Second (Y)
            boolean l = true; // Last (Z)
            if (x == 0 && y == 0 && z == 0) {
                while (true) {
                    if (n % a == 0 && n % b == 0 && n % c == 0) {
                        break;
                    } else {
                        n += a;
                    }
                }
            } else {
                while (true) {
                    if (f) {
                        if (x != n % a) {
                            n++;
                        } else {
                            f = false;
                        }
                    } else if (s) {
                        if (y != n % b) {
                            n++;
                        } else {
                            s = false;
                        }
                    } else if (l) {
                        if (z != n % c) {
                            n++;
                        } else //                        l = false;
                        {
                            if (x == n % a && y == n % b && z == n % c) {
                                break;
                            } else {
                                f = true;
                                s = true;
                                l = true;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            System.out.println(n);
            line = scan.nextLine();
        }
    }

}
