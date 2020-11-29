
import static java.lang.System.out;

/**
 *
 * @author Master
 */
public class GameC {

    public static void main(String[] args) {
        Deck deck = new Deck();
        out.println(deck.toString());
        deck.shuffle();
        out.println(deck.toString());
        for (int i = 0; i < 5; i++) {
            out.println(deck.drawCard());
        }

    }
//        Scanner scan = new Scanner(System.in);
//        out.println("Player 1          Player 2");
////        Deck dec = new Deck();
//////        Card car = new Card("");
////        Deck sec = new Deck();
////        Card car = new Card("Ar" , "ar");
////        sec.draw();
////        car.getVal();
////        car.getSuit();
////        out.println((car.getVal()+car.getSuit()));
//        ArrayList ar = new ArrayList();
//        ArrayList us = new ArrayList();
//        ladd(ar);
//        int p1s = 0;
//        int p2s = 0;
//        out.println(ar.toString());
//        String a = draw(ar);
//        String b = draw(ar);
//        String c = draw(ar);
//        String d = draw(ar);
//        int yu[] = cp1s(a);
//        p1s += yu[0];
//        yu = cp1s(b);
//        p1s += yu[0];
//        int uy[];
//        uy = cp2s(c);
//        p2s += uy[0];
//        uy = cp2s(d);
//        p2s += uy[0];
//        out.println(a + "   " + b + "   " + "/t/t/t" + c + "   " + d);
//        out.println("Hit or Stay");
//        while (!scan.hasNext("Stay")) {
//            if (p1s == 11 || p1s == 21) {
//                out.println("Blackjack");
//                break;
//            }
//            String hit = scan.nextLine();
//            if (hit.toUpperCase().contains("HIT")) {
//                String sr = draw(ar);
//                cp1s(sr);
//            } else if (bu(p1s)) {
//                out.println("You Busted");
//                break;
//            } else {
//                out.println("TOTAL " + FiS(p1s, yu));
//            }
//        }
//    }
//
//    private static int FiS(int pl, int[] u) {
//        int fin = 0;
//        if (pl <= 11) {
//            fin += pl + u[1];
//        } else {
//            return pl;
//        }
//        return fin;
//    }
//
//    private static void ladd(ArrayList ar) {
//        String y[] = {"Spades", "Diamonds", "Hearts", "Clubs"};
//        String x[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
//        for (int a = 0; a < 52; a++) {
//            int hg = a / 13;
//            int gh = a % 13;
//            ar.add(x[gh] + y[hg]);
//        }
//    }
//
//    private static String draw(ArrayList ar) {
//        Random rnd = new Random();
//        int a = rnd.nextInt(51);
//        String yt = (String) ar.get(a);
//        ar.remove(a);
//        return yt;
//    }
//
//    private static int[] cp1s(String a) {
//        int p1s = 0;
//        int alter = 0;
//        if (a.contains("Jack") || a.contains("Queen") || a.contains("King")) {
//            p1s += 10;
//        } else if (a.contains("Ace")) {
//            p1s += 1;
//            alter += 10;
//        } else {
//            p1s += Integer.getInteger(a);
//        }
//        int u[] = new int[2];
//        u[0] = p1s;
//        u[1] = alter;
//        return u;
//    }
//
//    private static int[] cp2s(String a) {
//        int p2s = 0;
//        int alter = 0;
//        if (a.contains("Jack") || a.contains("Queen") || a.contains("King")) {
//            p2s += 10;
//        } else if (a.contains("Ace")) {
//            p2s += 1;
//            alter += 10;
//        } else {
//            p2s += Integer.parseInt(a);
//        }
//        int u[] = new int[2];
//        u[0] = p2s;
//        u[1] = alter;
//        return u;
//    }
//
//    public static boolean bu(int a) {
//        return a > 21;
//    }
}
