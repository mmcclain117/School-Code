
import java.util.*;
import java.io.*;

public class prob09 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob09-1-in.txt"));

        char[][] arr = new char[12][60];

        for (char[] c : arr) {
            Arrays.fill(c, ' ');
        }

        Stack<String> stack = new Stack<>();

        while (scan.hasNextLine()) {
            stack.add(scan.nextLine());
        }

        while (!stack.isEmpty()) {
            scan = new Scanner(stack.pop());
            int x = scan.nextInt(), size = scan.nextInt();

            int start = x - (size - 1), end = x + size;

            for (int y = size; y >= 0; y--) {
                if (start >= 0) {
                    arr[y][start++] = '/';
                }
                if (end > size) {
                    arr[y][end--] = '\\';
                }

                for (int i = start + 1; i < end; i++) {
                    if (i > 0 && i < size) {
                        arr[y][i] = ' ';
                    }
                }

                if (start >= end) {
                    break;
                }
            }
        }

        for (char[] c : arr) {
            String s = new String(c);
            if (s.trim().length() == 0) {
                continue;
            }

            System.out.println(s);
        }

        String s = new String(arr[11]);

        for (int i = 0; i < s.lastIndexOf("\\") / 10; i++) {
            System.out.print("1234567890");
        }
    }

}
