

import java.util.*;
import java.io.*;

/**
 *
 * @author Master
 */
public class Madison {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("madison.dat"));
//        scan.nextLine();
        while (scan.hasNextLine()) {
            String string = scan.nextLine();
            String st[] = string.split("\\s+");
            String state = st[0];
            char ch[] = st[1].toCharArray();
            for (int i = 0; i < ch.length; i++) {
                state = state.replaceAll(((char) (i + 65)) + "", ch[i] + "");
            }
//            System.out.println("Before " +state);
            while (state.contains("(")) {
                int a = state.indexOf("(");
                int b = state.indexOf(")");
                String te = state.substring(a + 1, b);
//                System.out.println(te);
                if (te.contains("*")) {
                    if (te.charAt(0) == '0' || te.charAt(2) == '0') {
                        state = state.substring(0, a) + "0" + state.substring(b + 1);
                    } else {
                        state = state.substring(0, a) + "1" + state.substring(b + 1);
                    }
                } else if (te.contains("+")) {
                    if (te.charAt(0) == '1' || te.charAt(2) == '1') {
                        state = state.substring(0, a) + "1" + state.substring(b + 1);
                    } else {
                        state = state.substring(0, a) + "1" + state.substring(b + 1);
                    }
                } else if (te.contains("^")) {
                    if (te.charAt(0) == '1' && te.charAt(2) == '1') {
                        state = state.substring(0, a) + "0" + state.substring(b + 1);
                    } else if (te.charAt(0) == '1' || te.charAt(2) == '1') {
                        state = state.substring(0, a) + "1" + state.substring(b + 1);
                    } else {
                        state = state.substring(0, a) + "0" + state.substring(b + 1);
                    }
                }
            }
//            System.out.println("Fin " + state);
            while (state.contains("*") || state.contains("+") || state.contains("^")) {
                char c = state.charAt(1);
                switch (c) {
                    case '*':
                        if (state.charAt(0) == '0' || state.charAt(2) == '0') {
                            state = "0" + state.substring(3);
                        } else {
                            state = "1" + state.substring(3);
                        }
                        break;
                    case '+':
                        if (state.charAt(0) == '1' || state.charAt(2) == '1') {
                            state = "1" + state.substring(3);
                        } else {
                            state = "0" + state.substring(3);
                        }
//                } else if (c == '^') {
                        break;
                    default:
                        if (state.charAt(0) == '1' && state.charAt(2) == '1') {
                            state = "0" + state.substring(3);
                        } else if (state.charAt(0) == '1' || state.charAt(2) == '1') {
                            state = "1" + state.substring(3);
                        } else {
                            state = "0" + state.substring(3);
                        }
                        break;
                }
            }
            while (state.contains("!")) {
                int s = state.indexOf("!");
                if (state.charAt(s + 1) == '1') {
                    state = state.substring(0, s) + "0";
//                    state = state.substring(0, s) + "0" + state.substring(s + 1);
                } else {
//                    state = state.substring(0, s) + "1" + state.substring(s + 1);
                    state = state.substring(0, s) + "1";
                }
            }
            System.out.println("1".equals(state));
//            System.out.println(state.substring(0, 3));
//            while (state.length() >= 3) {
//                String te = state.substring(0, 3);
//                if (te.charAt(1) == '*') {
//                    if (te.charAt(0) == '0' || te.charAt(2) == '0') {
//                        state = "0" + state.substring(2);
//                    } else {
//                        state = "1" + state.substring(2);
//                    }
//                }
//                System.out.println(te);
//                if (te.contains("*")) {
//                    if (te.charAt(0) == '0' || te.charAt(2) == '0') {
//                        state = state.substring(0, a) + "0" + state.substring(b + 1);
//                    } else {
//                        state = state.substring(0, a) + "1" + state.substring(b + 1);
//                    }
//                } else if (te.contains("+")) {
//                    if (te.charAt(0) == '1' || te.charAt(2) == '1') {
//                        state = state.substring(0, a) + "1" + state.substring(b + 1);
//                    } else {
//                        state = state.substring(0, a) + "1" + state.substring(b + 1);
//                    }
//                } else if (te.contains("^")) {
//                    if (te.charAt(0) == '1' && te.charAt(2) == '1') {
//                        state = state.substring(0, a) + "0" + state.substring(b + 1);
//                    } else if (te.charAt(0) == '1' || te.charAt(2) == '1') {
//                        state = state.substring(0, a) + "1" + state.substring(b + 1);
//                    } else {
//                        state = state.substring(0, a) + "0" + state.substring(b + 1);
//                    }
//                }
//        }
//            String vars = string.toUpperCase().split("\\s+")[0].replaceAll("[A-Z]+", "");
//            vars.replaceAll("\\(", "").replaceAll("\\)", "");
//            System.out.println(vars);
//            System.out.println(vars);
        }
    }
}
