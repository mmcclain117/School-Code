
import java.util.*;
import java.io.*;

/**
 * @author Master Ward
 */
public class Prob15 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob15.txt"));
        String a = scan.nextLine();
        while (!"X X X 0 0 0".equals(a)) {
            String b[] = a.split("\\s+");
            System.out.println(b[0] + " " + b[1] + " " + b[2]);
            HashMap<Integer, Integer> hm = new HashMap();
            if ("X".equals(b[0])) { // First Dice is X
                int d1[] = diceType(b[1]); // Dice 1
                int d2[] = diceType(b[2]); // Dice 2
                hm = comb(d1, d2);
                double size = (double) .36;
                print(hm, b[3], size); // First Number
                print(hm, b[4], size); // Second Number
                print(hm, b[5], size); // Third Number
            } else if ("X".equals(b[1])) { // Second Dice is X
                int d1[] = diceType(b[0]); // Dice 1
                int d2[] = diceType(b[2]); // Dice 2
                hm = comb(d1, d2);
                double size = (double) .36;
                print(hm, b[3], size); // First Number
                print(hm, b[4], size); // Second Number
                print(hm, b[5], size); // Third Number
            } else if ("X".equals(b[2])) { // Third Dice is X
                int d1[] = diceType(b[0]); // Dice 1
                int d2[] = diceType(b[1]); // Dice 2
                hm = comb(d1, d2);
                double size = (double) .36;
                print(hm, b[3], size); // First Number
                print(hm, b[4], size); // Second Number
                print(hm, b[5], size); // Third Number
            } else { // There are 3 dices
                int d1[] = diceType(b[0]); // Dice 1
                int d2[] = diceType(b[1]); // Dice 2
                int d3[] = diceType(b[2]); // Dice 3
                hm = comb(d1, d2);
                ArrayList<Integer> fixing = new ArrayList(); // Add all the rolls
                Iterator it = hm.entrySet().iterator();
                for (int i = 0; i < hm.size(); i++) {
                    Map.Entry cur = (Map.Entry) it.next();
                    int ke = (int) cur.getKey(); // Current Key
                    int val = (int) cur.getValue(); // Current Value
                    for (int ix = 0; ix < val; ix++) {
                        fixing.add(ke);
                    }
                }
                hm.clear();
                int fixingAr[] = new int[fixing.size()];
                for (int i = 0; i < fixing.size(); i++) {
                    fixingAr[i] = fixing.get(i);
                }
                hm = comb(fixingAr, d3);
                it = hm.entrySet().iterator();
//                double size = (double) .216; // Maybe error here on number of dice possibilities
                double size = (double) 2.16;
                print(hm, b[3], size); // First Number
                print(hm, b[4], size); // Second Number
                print(hm, b[5], size); // Third Number
            }
            a = scan.nextLine();
        }
    }

    private static HashMap<Integer, Integer> comb(int a[], int b[]) {
        HashMap<Integer, Integer> hm = new HashMap();
//        System.out.println(b.length + " " + Arrays.toString(b));
        for (int i = 0; i < a.length; i++) { // a iterator
            for (int ii = 0; ii < b.length; ii++) { // b iterator
                int val = a[i] + b[ii]; // Current dice roll
//                System.out.println(a[i] + " " + b[ii] + " " + val);
                if (hm.containsKey(val)) {
                    hm.put(val, hm.get(val) + 1);
                } else {
                    hm.put(val, 1);
                }
            }
        }
        return hm;
    }

    private static int[] diceType(String a) {
        if (a.equals("L")) { // If Linear
            int c[] = {1, 2, 3, 4, 5, 6};
            return c;
        } else if (a.equals("F")) { // If fibonacci
            int c[] = {0, 1, 1, 2, 3, 5};
            return c;
        } else if (a.equals("T")) { // If tribonacci
            int c[] = {0, 0, 1, 1, 2, 4};
            return c;
        } else if (a.equals("N")) { // If Normal
            int c[] = {1, 2, 2, 3, 3, 4};
            return c;
        } else if (a.equals("Z")) { // If Zipf
            int c[] = {1, 1, 1, 2, 2, 3};
            return c;
        } else if (a.equals("P")) { // if Prime
            int c[] = {0, 1, 2, 3, 5, 7};
            return c;
        } else { // If Guassian
            int c[] = {1, 2, 3, 3, 4, 5};
            return c;
        }
    }

    private static void print(HashMap<Integer, Integer> hm, String string, double size) {
        Iterator it = hm.entrySet().iterator();
        for (int i = 0; i < hm.size(); i++) { // First Number
            Map.Entry cur = (Map.Entry) it.next();
            if ((int) cur.getKey() == Integer.parseInt(string)) { // If the first number
                System.out.printf("%S   %d\t%.2f%%\n", string.trim(), (int) cur.getValue(), (int) cur.getValue() / size);
            }
        }
    }
}
