
import java.util.*;
import java.io.*;

/**
 *
 * @author Kyle Fromm
 */
public class Prob08 {

    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();
        Scanner scan = new Scanner(new File("DataSet\\prob08-1-in.txt"));
        while (true) {
            long start = scan.nextLong();
            long end = scan.nextLong();
            if (end == 0) {
                break;
            }
            long counter = 0;
            for (long i = 0; i <= end - start; i++) {
                long even = hammingWeight(start + i);
//				long even = Long.bitCount(start + i);
                if (even % 2 == 0) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
        System.out.println((double) ((System.currentTimeMillis() - time) / 1000) / 60);
    }

    public static long hammingWeight(long n) {
        long count = 0;
        for (int i = 0; i < 64; ++i) {
            if (((n >>> i) & 1) == 1) {
                ++count;
            }
        }
        return count;
    }
}
