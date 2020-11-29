
import java.util.*;
import java.io.*;

public class prob08 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob08-1-in.txt"));
        long start = 1;
        long end = 1;
        while (end != 0) {
            start = scan.nextInt();
            end = scan.nextLong();
            int counter = 0;
            int con = 0;
            for (long i = 0; i <= end - start; i++) {
                long even = Long.bitCount(start + i);
//                long even = bitCount(start + i);
//                String binary = Long.toBinaryString(start + i);
//                binary = binary.replaceAll("0", "");
//                long even = 0;
//                System.out.print(binary.length() + " ");
//                even = binary.length();
                if (even % 2 == 0) {
                    counter++;
                }
            }
            System.out.println(counter);
            System.gc();
        }

    }

    public static long bitCount(long x) {
        return (x == 0) ? 0 : (x & 1 + bitCount(x / 2));
    }

}
