
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class prob10 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob10-1-in.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < a; i++) {
            String b = scan.nextLine();
            int lon = 1;
            for (int st = 0; st < b.length() - 1; st++) {
                for (int end = b.length(); end > st + 1; end--) {
                    if (isPalindrome(b.substring(st, end))) {
                        System.out.println(b.substring(st, end));
                        if (end - st > lon) {
                            lon = end - st;
                        }
                    }
                }
            }
            System.out.println(lon);
        }
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < (n / 2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
//            String dub = b;
//            String x = longestPalindrome(dub);
//            int lon = x.length();
////	    System.out.println(b + " "+ x+ " \n"+b.substring(lon));
//            int end = dub.indexOf(x.substring(0, 1));
////            System.out.println(x.substring(0));
////            System.out.println(end);
//            boolean work = true;
//            String ends = "";
//            for (int ii = 0; ii < end; ii++) {
//                System.out.println(dub.substring(ii, ii + lon));
//                if (isPal(dub.substring(ii, ii + lon))) {
//                    ends = dub.substring(ii, ii + lon - 1);
//                    System.out.println(dub.substring(ii, ii + lon));
//                    work = false;
//                    break;
//                }
//            }
////            System.out.println(ends);
//            System.out.println(b.substring(0, lon));
//            if (work) {
////		System.out.println(x.trim());
//            }
//        }
//    }
//
//    public static boolean isPal(String vy) {
//        String s = vy.replaceAll("^[a-zA-Z]+", "");
////        s = s.replaceAll("[^a-zA-Z]+", "");
//        ArrayList<Character> v = new ArrayList();
//        char ch[] = s.toCharArray();
//        for (char c : ch) {
//            v.add(c);
//        }
//        Collections.reverse(v);
//        String fin = "";
//        for (char u : v) {
//            fin += u;
//        }
//        return fin.equals(s);
//    }
//
//    public static String longestPalindrome(String vy) {
//        String s = vy.toUpperCase();
//        s = s.replaceAll("[^A-Z]+", "");
////        s = s.replace("^[a-zA-Z]+", "");
//        if (s.isEmpty()) {
//            return "NO";
//        }
//        if (s.length() == 1) {
//            return "NO PALIDROME";
//        }
//        String longest = s.substring(0, 1);
//        for (int i = 0; i < s.length(); i++) {
//            // get longest palindrome with center of i
//            String tmp = helper(s, i, i);
//            if (tmp.length() > longest.length()) {
//                longest = tmp;
//            }
//            // get longest palindrome with center of i, i+1
//            tmp = helper(s, i, i - 1);
//            if (tmp.length() > longest.length()) {
//                longest = tmp;
//            }
//        }
//        return longest;
//    }
//
//// Given a center, either one letter or two letter, 
//// Find longest palindrome
//    public static String helper(String s, int begin, int end) {
//        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
//            begin--;
//            end++;
//        }
//        return s.substring(begin, end + 1);
}
