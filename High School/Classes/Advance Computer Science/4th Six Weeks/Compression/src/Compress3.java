
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Compress3 {

    public static HashMap<String, Character> hs = new HashMap();

    public static void main(String[] args) throws Exception {
//        FileReader fr = new FileReader(new File("f.txt"));
//        FileReader fr = new FileReader(new File("A Tale of Two Cities.txt"));
//        String filename = "Treasure Island.txt";
//        String filename = "A Tale of Two Cities.txt";
//        String filename = "Anna Kareninaf.txt";

        String filename = "Magna Carta.txt";
//        Scanner scan = new Scanner(new File("f.txt"));
//        Scanner scan = new Scanner(new File("A Tale of Two Cities.txt"));
        Scanner scan = new Scanner(new File(filename));
        String fin = "";
        while (scan.hasNext()) {
//        while (fr.ready()) {y
            fin += scan.nextLine();
//            fin += (char) fr.read();
        }
        scan.close();
//        System.out.println("Here");
//        fr.close();
//        letComp(fin);
        char CF[] = new char[256]; // Frequency
        for (char c : fin.toCharArray()) {
            CF[c]++;
        }
//        System.out.println(fin);
        HuffmanTree hm = BuildTree(CF);
        p(hm, "");
        System.out.println(Arrays.toString(hs.entrySet().toArray()));
        System.out.println(Arrays.toString(hs.keySet().toArray()));

        String fina = "";
        Set s = hs.entrySet();
        Set ks = hs.keySet();
        System.out.println(Arrays.toString(ks.toArray()));
        char ch[] = fin.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            Iterator it = s.iterator();
            while (it.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) it.next();
                if ((c + "").equals(mentry2.getValue().toString())) {
                    fina += mentry2.getKey().toString();
//                    System.out.println(mentry2.getKey());
                    break;
                }
            }
        }
        FileWriter fw = new FileWriter(new File("Compress\\" + filename));
        fw.write(fina);
        fw.flush();
        fw.close();
//        BitOutputStream bos = new BitOutputStream(new FileOutputStream(new File("g.bin")));
//        System.out.println(fina);
//        bos.write(fina.getBytes());
//        bos.flush();
//        bos.close();
        String phrase = "";
//        BitInputStream bis = new BitInputStream(new FileInputStream(new File("g.bin")));
//        String b = "";
        int con = 0;
//        String ttt = "";
        HuffmanTree temper = hm;
//        int cont = 0;
        while (con < fina.length() - 1) {
            if (temper instanceof Leaf) { // Is a leaf
                phrase += ((Leaf) temper).value;
                System.out.print(((Leaf) temper).value);
                temper = hm;
//                con--;
            } else if (temper instanceof Node) {
                char bit = (char) (fina.charAt(con) - 48);
//                byte bit = (byte) bis.readBits(cont++);
                if (bit == 1) {
                    temper = ((Node) temper).right;
                } else if (bit == 0) {
                    temper = ((Node) temper).left;
                }
            }
            con++;
        }
//        System.out.println(phrase);
        System.out.println(fina.length() + " " + phrase.length());
//        System.out.println((100.00 *(phrase.length() - fina.length())) / fina.length());
        System.out.println((100.00 * (fina.length() - phrase.length())) / fina.length());
//        System.out.println(ttt);
//        System.out.println(Arrays.toString(ks.toArray()));
//        System.out.println(phrase);
//        System.out.println(ttt);
    }

//    private static void letComp(String f) {
//        char CF[] = new char[256]; // Frequency
//        for (char c : f.toCharArray()) {
//            CF[c]++;
//        }
//        HuffmanTree hm = BuildTree(CF);
//        p(hm, "");
//        System.out.println(Arrays.toString(hs.entrySet().toArray()));
//        System.out.println(Arrays.toString(hs.keySet().toArray()));
//    }
    private static HuffmanTree BuildTree(char[] CF) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        for (int i = 0; i < CF.length; i++) {
            if (CF[i] > 0) { // Check if empty and add leaf
                trees.offer(new Leaf(CF[i], (char) i));
            }
        }
        while (trees.size() > 1) {// Loops until only one tree
            HuffmanTree a = trees.poll(); // Least
            HuffmanTree b = trees.poll(); // Second least
            trees.offer(new Node(a, b)); // Puts new node into tree
        }
        return trees.poll();
    }

    public static void p(HuffmanTree tree, String pre) {
        if (tree instanceof Leaf) {
            Leaf leaf = (Leaf) tree;
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + pre);
            hs.put(pre, leaf.value);
        } else if (tree instanceof Node) {
            Node node = (Node) tree;
            pre += "0"; // Left
            p(node.left, pre);
            pre = pre.substring(0, pre.length() - 1);
            pre += "1"; // Right
            p(node.right, pre);
            pre = pre.substring(0, pre.length() - 1);
        }
    }

//    private static boolean search(HuffmanTree tree, String pre) {
//        
//        if (tree instanceof Leaf) {
//            Leaf leaf = (Leaf) tree;
//            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + pre);
//            hs.put(pre, leaf.value);
//            return true;
//        } else if (tree instanceof Node) {
//            Node node = (Node) tree;
//            pre += "0"; // Left
//            p(node.left, pre);
//            pre = pre.substring(0, pre.length() - 1);
//            pre += "1"; // Right
//            p(node.right, pre);
//            pre = pre.substring(0, pre.length() - 1);
//            return true;
//        } else {
//            return false;
//        }
//    }
}
