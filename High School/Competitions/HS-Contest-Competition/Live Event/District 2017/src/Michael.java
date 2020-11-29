
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Michael {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Michael.dat"));
        while (scan.hasNext()) {
            int test = scan.nextInt();
            String a = scan.nextLine();
            String b[] = a.split("[ ]+");
            String gr[][] = new String[8][8];
            int i = 1;
            for (int con = 0; con < test; con++) {
                String form = b[i]; // Formation
                i++;
                int x = Integer.parseInt(b[i]) - 1;
                i++;
                int y = 8 - Integer.parseInt(b[i]);
                i++;
//				System.out.println(form);
                if (form.equals("A")) {
                    gr = ty(gr, x, y, "R");
                    gr = ty(gr, x, y + 1, "A");
                    gr = ty(gr, x, y + 2, "A");
                    gr = ty(gr, x + 1, y + 2, "A");
                    gr = ty(gr, x + 2, y + 2, "A");
//					try {
//						gr[y][x] = "R";
//						gr[y + 1][x] = "A";
//						gr[y + 2][x] = "A";
//						gr[y + 1][x + 1] = "A";
//						gr[y + 2][x + 2] = "A";
//					} catch (ArrayIndexOutOfBoundsException e) {
//						System.out.println("A: " + x + " " + y + " Is not in the grid");
//					}
                } else if (form.equals("B")) {
                    gr = ty(gr, x, y, "R");
                    gr = ty(gr, x + 1, y, "B");
                    gr = ty(gr, x, y + 1, "B");
                    gr = ty(gr, x + 1, y + 1, "B");
                    gr = ty(gr, x, y + 2, "B");
//					try {
//						gr[y][x] = "R";
//						gr[y][x + 1] = "B";
//						gr[y + 1][x] = "B";
//						gr[y + 1][x + 1] = "B";
//						gr[y + 2][x] = "B";
//					} catch (ArrayIndexOutOfBoundsException e) {
//						System.out.println("B: " + x + " " + y + " Is not in the grid");
//					}
                } else if (form.equals("C")) {
                    gr = ty(gr, x, y, "R");
                    gr = ty(gr, x - 1, y, "C");
                    gr = ty(gr, x - 2, y, "C");
                    gr = ty(gr, x - 3, y, "C");
                    gr = ty(gr, x, y - 1, "C");
//					try {
//						gr[y][x] = "R";
//						gr[y][x - 1] = "C";
//						gr[y][x - 2] = "C";
//						gr[y][x - 3] = "C";
//						gr[y - 1][x] = "C";
//					} catch (ArrayIndexOutOfBoundsException e) {
//						System.out.println("C: " + x + " " + y + " Is not in the grid");
//					}
                }
            }
            int con = 0;
            for (int yy = 0; yy < 8; yy++) {
                for (int xx = 0; xx < 8; xx++) {
                    if (gr[yy][xx] == null) {
                        con++;
                    }
//					System.out.print((gr[yy][xx] == null ? "?":gr[yy][xx]));
                }
//				System.out.println();
            }
            System.out.println(64 - con);
        }
    }

    private static String[][] ty(String gr[][], int x, int y, String a) {
        try {
            gr[y][x] = a;
        } catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("C: " + x + " " + y + " Is not in the grid");
        }
        return gr;
    }
}
