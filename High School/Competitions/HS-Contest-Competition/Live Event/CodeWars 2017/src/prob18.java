
import java.util.*;
import java.io.*;

public class prob18 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob18-1-in.txt"));
        int a = scan.nextInt();
        scan.nextLine();
        ArrayList<Poke> ani = new ArrayList();
        ArrayList<String> na = new ArrayList();
        for (int i = 0; i < a; i++) {
            String s = scan.nextLine();
            ani.add(new Poke(s));
            na.add(s.split(" ")[0]);
        }
        int b = scan.nextInt();
        for (int i = 0; i < b; i++) {
            String c = scan.next();
            String d = scan.next();
            int sc = na.indexOf(c);
            int sd = na.indexOf(d);
//            System.out.println(sc + " " + sd);
            attack(ani.get(sc), ani.get(sd));
        }
    }

    private static void attack(Poke a, Poke b) {
        int hp1 = a.getHP();
        int hp2 = b.getHP();
        int c1p = a.pc2; // Power Count a
        int c2p = a.pc2; // Power Count b
        int dm1[] = a.getDamage(b);
        int dm2[] = b.getDamage(a);
        int p1 = 0; // Power 1 Count
        int p2 = 0; // Power 2 Count
        while (hp1 > 0 && hp2 > 0) {

        }
        if (hp2 < 0) {
            System.out.println(a.getName() + " deafeated " + b.getName() + " with " + hp1 + " HP left");
        }
        if (hp1 < 0) {
            System.out.println(b.getName() + " deafeated " + a.getName() + " with " + hp2 + " HP left");
        }
    }
}

class Poke {

    private String name;
//    Earth, Air, Fire, Water, Battle, Nature, Light, Metal, Shadow, Plasmaa
    private String type;
    private String weakness;
    private String resistance;
    private int HP;
//    Attack 1
    private String aname1;
    public int pc1; // Power Charge for attack
    private int damage1; // Damage Dealt
//    Attack 2
    private String aname2;
    public int pc2; // Power Charge for attack
    private int damage2; // Damage Dealt

    public Poke(String s) {
        String b[] = s.split("\\s+");
//        System.out.println(Arrays.toString(b));
        name = b[0];
        type = b[1];
        weakness = b[2];
        resistance = b[3];
        HP = Integer.parseInt(b[4]);
        aname1 = b[5];
        pc1 = Integer.parseInt(b[6]);
        damage1 = Integer.parseInt(b[7]);
        aname2 = b[8];
        pc2 = Integer.parseInt(b[9]);
        damage2 = Integer.parseInt(b[10]);
    }

    public int getHP() {
        return HP;
    }

    public int[] getDamage(Poke b) {
        int a[] = new int[2];
        int per = 1;
        if (this.weakness.equals(b.type)) {
            per += 1;
        }
        if (this.resistance.equals(b.type)) {
            per *= .5;
        }
        a[0] = this.damage1 * per;
        a[1] = this.damage2 * per;
        return a;
    }

    public int getPc() {
        return pc2;
    }

    public String getName() {
        return name;
    }
}
