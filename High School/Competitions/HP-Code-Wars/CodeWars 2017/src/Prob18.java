

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Master Ward
 */
public class Prob18 {

    public static void main(String[] args) throws Exception {
//        Problem: PonyMon
//        Points: 11
        Scanner scan = new Scanner(new File("prob18.txt"));
        int n = scan.nextInt(); // Number of ponies
        scan.nextLine();
        List<PonyMon> ponymons = new ArrayList<>(); // Database of Ponies
        /* Reading in the ponies */
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String split[] = line.split("[ ]+");
            PonyMon tmp = new PonyMon(split[0], split[1].charAt(0), split[2].charAt(0), split[3].charAt(0), Integer.parseInt(split[4]));
            tmp.addAttack(split[5], Integer.parseInt(split[6]), Integer.parseInt(split[7]));
            tmp.addAttack(split[8], Integer.parseInt(split[9]), Integer.parseInt(split[10]));
            ponymons.add(tmp); // Adds to database
        }
        int battles = scan.nextInt();
        for (int i = 0; i < battles; i++) {
            String f = scan.next(); // First pony name
            String s = scan.next(); // Second pony name
            PonyMon first = null;
            PonyMon second = null;

            /* Find qualities of ponies in database */
            for (PonyMon p : ponymons) {
                if (p.name.equals(f)) {
                    first = p;
                } else if (p.name.equals(s)) {
                    second = p;
                }
            }

            float fm = 1;
            float sm = 1;
            if (first.type == second.weakness) {
                fm = 2;
            } else if (first.type == second.resistance) {
                fm = 0.5f;
            }
            if (second.type == first.weakness) {
                sm = 2;
            } else if (second.type == first.resistance) {
                sm = 0.5f;
            }

            Attack firstAttack = first.sameTurns() ? first.getMostDamage() : first.getLeastTurns();
            Attack secondAttack = second.sameTurns() ? second.getMostDamage() : second.getLeastTurns();

            double fc = Math.ceil((first.health / (secondAttack.damage * sm))) * secondAttack.charge; // Second to kill First
            double sc = Math.ceil((second.health / (firstAttack.damage * fm))) * firstAttack.charge; // First to kill Second

            if (fc > sc) {
                System.out.println(f + " defeats " + s + " with " + (int) (first.health - (Math.floor((sc - 1)) / secondAttack.charge) * (secondAttack.damage * sm)) + " HP remaining.");
            } else {
                System.out.println(s + " defeats " + f + " with " + (int) (second.health - Math.floor(fc / firstAttack.charge) * (firstAttack.damage * fm)) + " HP remaining.");
            }
        }
    }

    public static class PonyMon {

        private String name;
        private char type;
        private char weakness;
        private char resistance;
        private int health;
        Attack[] attacks;

        PonyMon(String n, char t, char w, char r, int h) {
            name = n;
            type = t;
            weakness = w;
            resistance = r;
            health = h;
            attacks = new Attack[2];
        }

        Attack getLeastTurns() {
            if (attacks[0].charge < attacks[1].charge) {
                return attacks[0];
            } else {
                return attacks[1];
            }
        }

        public boolean sameTurns() {
            return attacks[0].charge == attacks[1].charge;
        }

        /* gets the most damaging attack */
        public Attack getMostDamage() {
            if (attacks[0].damage > attacks[1].damage) {
                return attacks[0];
            } else {
                return attacks[1];
            }
        }

        /* adds an attack to the pony */
        public void addAttack(String n, int c, int d) {
            Attack tmp = new Attack(n, c, d);
            if (attacks[0] == null) {
                attacks[0] = tmp;
            } else {
                attacks[1] = tmp;
            }
        }
    }

    public static class Attack {

        private String name;
        private int charge;
        private int damage;

        public Attack(String n, int c, int d) {
            name = n;
            charge = c;
            damage = d;
        }
    }
}
