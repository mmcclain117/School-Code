package DecentlyBad;

import java.io.File;
import static java.lang.System.out;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Squeezebox {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("squeezebox.dat"));
        String a = scan.nextLine(); // Line 1
        String b = ""; // Line 2
        ArrayDeque aq = new ArrayDeque();
        while (!(a.equals("#"))) {
            b = scan.nextLine();
            String aa[] = a.split("[ ]+");
            String bb[] = b.split("[ ]+");
            ArrayList<Card> xx = new ArrayList();
            out.println(aa.length);
            for (int i = 0; i < aa.length; i++) {
                Card tempA = makeCard(aa[i]);
                Card tempB = makeCard(bb[i]);
                xx.add(tempA);
//                boolean rem = true;
                if (tempB.getNumb() == tempA.getNumb()) {
                    out.println("1");
                } else if (tempB.getSuit() == tempA.getSuit()) {
                    out.println("2");
                } else {
                    xx.remove(tempA);
                    xx.add(tempB);
                }
                /*                while (rem) {
                    if (xx.size() > 3) {
                        Card p = xx.get(xx.size() - 3); // Third to the left
                        if (xx.get(xx.size() - 1).getNumb() == p.getNumb()) {
                            xx.remove(xx.size() - 1);
                        } else if (xx.get(xx.size() - 3).getSuit() == p.getSuit()) {
//                            xx.remove(xx.size() - 3);
                            out.println("Same " + xx.get(xx.size() - 3).getSuit() + " " + p.getSuit());
                            xx.set(xx.size() - 3, p);
                        } else {
                            rem = false;
                        }
                    } else if (xx.size() > 1) {
                        Card p = xx.get(xx.size() - 1);
                        if (xx.get(xx.size() - 1).getNumb() == p.getNumb()) {
                            xx.remove(xx.size() - 1);
                        } else if (xx.get(xx.size() - 1).getNumb() == p.getNumb()) {
                            xx.remove(xx.size() - 1);
                        } else {
                            rem = false;
                        }
                    } else {
                        rem = false;
                    }
                }
                 */
            }
            a = scan.nextLine();
            out.println();
            /*
            for (Card cc : xx) {
                out.println(cc.getNumb() + " " + cc.getSuit());
            }
             */
            out.println("size " + xx.size());
        }
    }

    public static Card makeCard(String a) {
        String tem = a.substring(0, 1);
        String temp = a.substring(1);
        int suit = 0;
        int numb = 0;
        switch (tem) {
            case "A":
                numb = 1;
                break;
            case "T":
                numb = 10;
                break;
            case "J":
                numb = 11;
                break;
            case "Q":
                numb = 12;
                break;
            case "K":
                numb = 13;
                break;
            default:
                numb = Integer.parseInt(tem);
                break;
        }
        switch (temp) {
            case "C":
                suit = 1;
                break;
            case "D":
                suit = 2;
                break;
            case "H":
                suit = 3;
                break;
            case "S":
                suit = 4;
                break;
            default:
                break;
        }
        return new Card(suit, numb);
    }
}

class Card {

    private int su;
    private int numb;

    public Card(int suit, int number) {
        su = suit;
        numb = number;
    }

    public int getSuit() {
        return su;
    }

    public int getNumb() {
        return numb;
    }

    public String toString() {
        return numb + " " + su;
    }
}
