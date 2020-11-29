package Assigned;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class AustralianVoting {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
//            scan.nextLine();
            int a = scan.nextInt();
            String[] name = new String[a];
            scan.nextLine();
            for (int p = 0; p < a; p++) {
                name[p] = scan.nextLine();
            }
            ArrayList<String> line = new ArrayList();
            String ne = scan.nextLine();
            while (!"".equals(ne)) {
                line.add(ne);
                ne = scan.nextLine();
            }
//            int con[] = new int[a];
            ArrayList<Integer> cur = new ArrayList();
            int set[][] = new int[line.size()][a];
            for (int x = 0; x < line.size(); x++) {
                String dp[] = line.get(x).split("\\s+");
                for (int y = 0; y < a; y++) {
                    int temp = Integer.parseInt(dp[y]);
                    set[x][y] = temp;
                    cur.add(temp);
//                    con[temp--]++;
                }
            }
            int win = (int) (Math.ceil(line.size() / 2));
            while (!(isWinner(cur, a))) {
                cur = count(cur, a);
//                out.println(Arrays.toString(cur.toArray()));
            }
            out.println(name[isWin(cur, a)]);

//            out.println(Arrays.toString(set[4]));
        }
    }

    private static ArrayList<Integer> count(ArrayList<Integer> cur, int numb) {
        int number[] = getNumbCount(cur, numb);
        int min = Integer.MAX_VALUE;
        int mpl = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] < min) {
                min = number[i];
                mpl = i;
            }
        }
        for (int i = 0; i < cur.size() - 1; i++) {
            if (cur.get(i).equals(mpl)) {
                cur.set(i + 1, 0);
            }
        }
        return cur;
    }

    public static int[] getNumbCount(ArrayList<Integer> cur, int numb) {
        int number[] = new int[numb];
        for (int i = 0; i < cur.size() / numb; i++) {
//            for (int p = 0; p < numb; p++) {
            boolean set = true;
            int cure = i;
            while (set) {
//                out.println(cur.get(cure));
                if (cure > cur.size() - 1) {
                    break;
                } else if (cur.get(cure) == 0) {
                    cure += numb;
                } else {
                    number[cur.get(cure) - 1]++;
                    set = false;
//                    break;
                }
//                }
            }
//            out.print(Arrays.toString(number));
        }
        return number;
    }

    public static int isWin(ArrayList<Integer> cur, int a) {
        int numb[] = getNumbCount(cur, a);
        int max = 0;
        int mp = 0;
        for (int i = 0; i < numb.length; i++) {
            if (numb[i] > max) {
                max = numb[i];
                mp = i;
            }
        }
//        out.println(numb[mp]);
        return mp;
    }

    public static boolean isWinner(ArrayList<Integer> cur, int a) {
        int numb[] = getNumbCount(cur, a);
//        int win = (int) Math.ceil(numb.length / 2);
        int win = (int) Math.ceil(numb.length / 2);
//        out.println(win);
        int max = 0;
        int mp = 0;
        for (int i = 0; i < numb.length; i++) {
            if (numb[i] > max) {
                max = numb[i];
                mp = i;
            }
        }
//        out.println(numb[mp]);
        return numb[mp] >= win;
    }
}
