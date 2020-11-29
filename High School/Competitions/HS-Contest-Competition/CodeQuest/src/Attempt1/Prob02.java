package Attempt1;


import java.util.*;
import java.io.*;
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class Prob02 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("Prob02.in.txt"));
        String sp = " ";
        int u = 1;
        while (scan.hasNext()) {
            String a = scan.nextLine();
            out.println("HAND " + u);
            u++;
            Scanner in = new Scanner(a);
            ArrayList ar = new ArrayList();
            while (in.hasNext()) {
                ar.add(in.next());
            }
            Collections.sort(ar);
            BR(ar);
            SUIT(ar);
//            Num(ar);
        }
    }

    public static void BR(ArrayList a) {
        int black = 0;
        int red = 0;
        String saq = Arrays.toString(a.toArray());
        String sa[] = saq.split("[ ]+");
        int coun = 0;
        while (coun < sa.length) {
            String uu = sa[coun];
            if (uu.contains("H") || uu.contains("D")) {
                red++;
                coun++;
            } else {
                black++;
                coun++;
            }
        }
        out.println(red + "-REDS");
        out.println(black + "-BLACKS");
    }

    public static void SUIT(ArrayList a) {
        int club = 0;
        int Diamond = 0;
        int heart = 0;
        int spades = 0;
        String saq = Arrays.toString(a.toArray());
        String sa[] = saq.split("[ ]+");
        int coun = 0;
        while (coun < sa.length) {
            String uu = sa[coun];
            if (uu.substring(1).contains("C")) {
                club++;
                coun++;
            } else if (uu.substring(1).contains("D")) {
                Diamond++;
                coun++;
            } else if (uu.substring(1).contains("H")) {
                heart++;
                coun++;
            } else if (uu.substring(1).contains("S")) {
                spades++;
                coun++;
            }
        }
        out.println(club + "-CLUBS");
        out.println(Diamond + "-DIAMONDS");
        out.println(heart + "-HEARTS");
        out.println(spades + "-SPADES");
    }

    public static void Num(ArrayList a) {
        ArrayList c = new ArrayList();
        ArrayList cr = new ArrayList();
        Collections.sort(a);
        String vy[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (int b = 0; b < a.size(); b++) {
            String hg = (String) a.get(b);
            String gh = hg.substring(0, hg.length() - 1);
            c.add(gh);
            int ace = 0;
            int two = 0;
            int three = 0;
            int four = 0;
            int five = 0;
            int six = 0;
            int seven = 0;
            int eight = 0;
            int nine = 0;
            int ten = 0;
            int jack = 0;
            int queen = 0;
            int king = 0;
            int y = 0;
            while (y < c.size()) {
                switch ((String) c.get(y)) {
                    case "2":
                        two++;
                        y++;
                        break;
                    case "3":
                        three++;
                        y++;
                        break;
                    case "4":
                        four++;
                        y++;
                        break;
                    case "5":
                        five++;
                        y++;
                        break;
                    case "6":
                        six++;
                        y++;
                        break;
                    case "7":
                        seven++;
                        y++;
                        break;
                    case "8":
                        eight++;
                        y++;
                        break;
                    case "9":
                        nine++;
                        y++;
                        break;
                    case "10":
                        ten++;
                        y++;
                        break;
                    case "J":
                        jack++;
                        y++;
                        break;
                    case "Q":
                        queen++;
                        y++;
                        break;
                    case "K":
                        king++;
                        y++;
                        break;
                    case "A":
                        ace++;
                        y++;
                        break;
                }
            }
            cr.add(two);
            out.println(cr.get(0) + "-" + "two card");
            cr.add(ace);
            cr.add(two);
            cr.add(three);
            cr.add(four);
            cr.add(five);
            cr.add(six);
            cr.add(seven);
            cr.add(eight);
            cr.add(nine);
            cr.add(ten);
            cr.add(jack);
            cr.add(queen);
            cr.add(king);
        }
        int yy = 0;
        out.println(cr.size());
        for (int p = 0; p < cr.size(); p++) {
            int ry = (int) cr.get(p);
            if (ry == 1) {
                out.println("1-" + vy[yy] + " card");
                ry = 0;
                yy++;
                break;
            } else if (ry > 1) {
                out.print(cr.get(p) + "-" + vy[yy] + " cards");
                ry = 0;
                yy++;
                break;
            } else {
                yy++;
            }
        }
    }
}
