
import java.util.*;
import java.io.*;

public class Htoo {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("htoo.dat"));

        int times = scan.nextInt();
        scan.nextLine();

        for (int j = 0; j < times; j++) {
            int[][] arr;
            ArrayList<Integer> xs = new ArrayList<>(),
                    ys = new ArrayList<>();

            String s1 = scan.nextLine(), s2 = scan.nextLine();
            int t = 0;

            for (char c : s1.toCharArray()) {
                if (Character.isDigit(c)) {
                    if (t % 2 == 0) {
                        xs.add(Integer.valueOf(c + ""));
                        t++;
                    } else {
                        ys.add(Integer.valueOf(c + ""));
                        t++;
                    }
                }
            }

            t = 0;

            for (char c : s2.toCharArray()) {
                if (Character.isDigit(c)) {
                    if (t % 2 == 0) {
                        xs.add(Integer.valueOf(c + ""));
                        t++;
                    } else {
                        ys.add(Integer.valueOf(c + ""));
                        t++;
                    }
                }
            }

            System.out.println(xs + "\n" + ys);

            arr = new int[max(ys)][max(xs)];

            int xFact = -1;

            if (xs.get(0) < xs.get(1)) {
                xFact = 1;
            }
            if (xs.get(0) == xs.get(1)) {
                xFact = 0;
            }

            int yFact = -1;

            if (ys.get(0) < ys.get(1)) {
                yFact = 1;
            }
            if (xs.get(0) == ys.get(1)) {
                yFact = 0;
            }

            int amt = 1;

            if (ys.get(0) != ys.get(1)) {
                while (ys.get(0) + (yFact * amt) != ys.get(1)) {
                    arr[ys.get(0) + (yFact * amt++)][xs.get(0) + (xFact * amt)]++;
                }
            } else {
                while (xs.get(0) + (yFact * amt) != xs.get(1)) {
                    arr[ys.get(0)][xs.get(0) + (xFact * amt++)]++;
                }
            }

            boolean two = false;
            for (int[] ints : arr) {
                for (int i : ints) {
                    System.out.print(i);
                    if (i == 2) {
                        two = true;
                        break;
                    }
                }
                System.out.println();
                if (two) {
                    break;
                }
            }

            System.out.println((two ? "INTERSECT" : "NO INTERSECTION"));
        }
    }

    public static int max(ArrayList<Integer> ints) {
        int max = Integer.MIN_VALUE;
        for (int i : ints) {
            max = max < i ? i : max;
        }

        System.out.println(max);

        return max + 1;
    }
}
