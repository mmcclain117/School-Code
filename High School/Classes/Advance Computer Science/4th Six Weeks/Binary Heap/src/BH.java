
import java.util.ArrayList;
import java.util.Arrays;

public class BH {

    private ArrayList<Integer> a;
    public int[] min;

    public BH() {
        a = new ArrayList();
        a.add(Integer.MIN_VALUE);
        min = new int[1];
    }

    public void add(int b) {
        a.add(b);
        Object mins[] = a.toArray();
        int min[] = new int[mins.length];
        for (int i = 0; i < mins.length; i++) {
            min[i] = (int) mins[i];
        }
//        Object min[] = a.toArray();
        int te = a.size() - 2;
        int sq = (te) / 2;
        if (te % 2 == 1) {
            sq++;
        }
//        while (Integer.parseInt(min[te + 1].toString()) < Integer.parseInt(min[sq].toString())) {
        while (min[te + 1] < min[sq]) {
            int tem = (int) min[sq];
            min[sq] = min[te + 1];
            min[te + 1] = tem;
            te /= 2;
            sq = te / 2;
            if (te % 2 == 1) {
                sq++;
            }
        }
//        System.out.println(te + " " + Arrays.toString(min));
        a.clear();
        for (int ii = 0; ii < min.length; ii++) {
            a.add(min[ii]);
        }
        this.min = min;
    }

    public int[] getMin() {
//        Object mins[] = a.toArray();
//        int min[] = new int[mins.length];
//        for (int i = 0; i < mins.length; i++) {
//            min[i] = (int) mins[i];
//        }
        return min;
    }

    public boolean check() {
//        System.out.println(Arrays.toString(min));
//        return min[1] == min[2] || min[1] == min[3] || min[2] == min[3];
//        return min[1] == min[2] & min[1] == min[3] & min[2] == min[3];
        try {
            if (min[1] == min[2]) {
                if (min[1] == min[3]) {
                    return true;
//            } else if (min[1] == min[3]) {
//                return true;
                }
//            return false;
                return true;
            } else {
                if (min[1] == min[3]) {
//                if (min[2] == min[3]) {
                    return true;
//                }
//                return false;
//                return true;
                }
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    public String toString() {
        return Arrays.toString(a.toArray());
    }
}
