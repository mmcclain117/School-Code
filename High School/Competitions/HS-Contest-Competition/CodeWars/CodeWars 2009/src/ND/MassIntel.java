package ND;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Master Ward
 */
public class MassIntel {

    static class Atom {

        public String symbol;
        public double mass;

        Atom(String newSymbol, double newMass) {
            symbol = newSymbol;
            mass = newMass;
        }
    }

    static class PeriodicTable {

        private static Vector<Atom> atomList;

        public PeriodicTable() {
            this.atomList = new Vector();
            atomList.add(new Atom("H", 1.008));
            atomList.add(new Atom("He", 4.003));
            atomList.add(new Atom("Li", 6.941));
            atomList.add(new Atom("Be", 9.012));
            atomList.add(new Atom("B", 10.81));
            atomList.add(new Atom("C", 12.01));
            atomList.add(new Atom("N", 14.01));
            atomList.add(new Atom("O", 16.00));
            atomList.add(new Atom("F", 19.00));
            atomList.add(new Atom("Ne", 20.18));
            atomList.add(new Atom("Na", 22.99));
            atomList.add(new Atom("Mg", 24.31));
            atomList.add(new Atom("Al", 26.98));
            atomList.add(new Atom("Si", 28.09));
            atomList.add(new Atom("P", 30.97));
            atomList.add(new Atom("S", 32.07));
            atomList.add(new Atom("Cl", 35.45));
            atomList.add(new Atom("Ar", 39.95));
        }

        public static double GetMass(String s) {
            for (int i = 0; i < atomList.size(); i++) {
                if (s.equals(atomList.get(i).symbol)) {
                    return atomList.get(i).mass;
                }
            }
            return 999.99;
        }
    };

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(new File("prob11.txt"));
        PeriodicTable table = new PeriodicTable();
        String formula = scan.nextLine();
        char c;
        String symbol = "";
        double count = 0.0;
        double mass = 0.0;
        while (!formula.equals("END")) {
            char ch[] = formula.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                c = ch[i];
                if (c >= 'A' && c <= 'Z') {
//                    if (symbol.length()) {
                    if (count == 0.0) {
                        count = 1.0;
                    }
                    mass += count * table.GetMass(c + "");
                    count = 0.0;
//                    }
                    symbol = c + "";
                } else if (c >= 'a' && c <= 'z') {
                    symbol += c;
                } else if (c >= '0' && c <= '9') {
                    count = 10 * count + (c - '0');
//                    count += (c- '0');
                    System.out.println(count);
                }
            }
            if (count == 0.0) {
                count = 1.0;
            }
            mass += count * table.GetMass(symbol);
            System.out.println(formula + " " + mass);
            symbol = "";
            count = 0.0;
            mass = 0.0;
            formula = scan.nextLine();
        }
    }
}
