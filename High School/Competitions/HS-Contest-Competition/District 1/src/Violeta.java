

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class Violeta {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("violeta.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine();
//            System.out.println(b);
            System.out.println(longestPalindrome(b));
        }
    }

//    public static boolean isPalindrome(String str) {
//        return str.equals(new StringBuilder(str).reverse().toString());
//    }
//
//    private static String perm(String b) {
//        for (int ip = 0; ip < b.length() - 1; ip++) {
//            for (int j = 0; j < b.length() - ip; j++) {
//                if (isPalindrome(b.substring(ip, b.length() - j))) {
//                    return b.substring(ip, b.length() - j);
//                }
//            }
//        }
//        return "";
//    }
//
    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

// Given a center, either one letter or two letter, 
// Find longest palindrome
    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
}
