
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Compress2 {

    private static HashMap<String, String> hs = new HashMap();

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();
        String filename = "Much Ado About Nothing";
        Scanner scan = new Scanner(new File(filename + ".txt"));
        String book = "";
        HashMap<String, Integer> FreqHM = new HashMap();
        while (scan.hasNext()) { // File Scanner
            String currents = scan.nextLine() + " $ ";
            Scanner input = new Scanner(currents);
            while (input.hasNext()) { // Line Scanner
                String current = input.next();
                current += input.hasNext() ? " " : ""; // Spaces at the end
                if (FreqHM.containsKey(current)) {
                    FreqHM.put(current, FreqHM.get(current) + 1);
                } else {
                    FreqHM.put(current, 1);
                }
            }
            book += currents;
        }
        scan.close();
        HuffmanTree hm = BuildTree(FreqHM);
        print(hm, "");
        String fina = ""; // Bits compression
        Set s = hs.entrySet();
        BitOutputStream bos = new BitOutputStream("Compress\\" + filename + ".bin");
        String ch[] = book.split(" ");
        for (int i = 0; i < ch.length; i++) {
            ch[i] += " ";
        }
        Iterator its = s.iterator();
        String sp = ""; // Space
        while (its.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) its.next();
            if ((" ").equals(mentry2.getValue().toString())) {
                sp = mentry2.getValue().toString();
                break;
            }
        }
        for (int i = 0; i < ch.length; i++) {
            String c = ch[i];
            Iterator it = s.iterator();
            while (it.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) it.next();
                if ((c).equals(mentry2.getValue().toString())) {
                    fina += mentry2.getKey().toString() + sp;
                    break;
                }
            }
        }
        String ix = fina;
        int ip = 0;
        while (ip < ix.length() - 8) {
            bos.write((byte) Integer.parseInt(ix.substring(ip, ip + 8), 2));
            ip += 8;
        }
        bos.flush();
        bos.close();
        BitInputStream bis = new BitInputStream(new File("Compress\\" + filename + ".bin"));
        String phrase = "";
        int con = 0;
        HuffmanTree temperHT = hm;
        while (con < fina.length() - 1) {
            if (temperHT instanceof Leaf) { // Is a leaf
                String tq = ((Leaf) temperHT).value;
                System.out.println(tq);
                phrase += ("$ ".equals(tq) ? "\r\n" : tq);
                temperHT = hm;
                con--;
            } else if (temperHT instanceof Node) {
                int bit = bis.readBits(1);
                if (bit == 1) {
                    temperHT = ((Node) temperHT).right;
                } else if (bit == 0) {
                    temperHT = ((Node) temperHT).left;
                }
            }
            con++;
        }
        long end = System.nanoTime();

        FileWriter fww = new FileWriter(new File("Stat\\" + filename + ".txt"));
        FileWriter fws = new FileWriter(new File("DeCompress\\" + filename + ".txt"));
        fws.write(phrase);
        fws.flush();
        fws.close();
        long os = Files.size(new File(filename + ".txt").toPath()); // Original File Size
        long ns = Files.size(new File("Compress\\" + filename + ".bin").toPath()); // Compressed size
        fww.write("Compressed Size: " + ns + "\nOriginal Size: " + os + "\r\n");
        double comp = (os - ns) / 100;
        fww.write("Compressed by : " + comp + "%\r\n");
        fww.write("Time: " + (end - start) + "\r\n");
        fww.flush();
        fww.close();
    }

    private static HuffmanTree BuildTree(HashMap<String, Integer> CF) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        Set s = CF.keySet();
        Iterator r = s.iterator();
        for (int i = 0; i < s.size(); i++) {
            Object o = r.next();
            trees.offer(new Leaf(CF.get(o.toString()), o.toString()));
        }
        while (trees.size() > 1) {// Loops until only one tree
            HuffmanTree a = trees.poll(); // Least
            HuffmanTree b = trees.poll(); // Second least
            trees.offer(new Node(a, b)); // Puts new node into tree
        }
        return trees.poll();
    }

    private static void print(HuffmanTree tree, String pre) {
        if (tree instanceof Leaf) {
            Leaf leaf = (Leaf) tree;
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + pre);
            hs.put(pre, leaf.value);
        } else if (tree instanceof Node) {
            Node node = (Node) tree;
            pre += "0"; // Left
            print(node.left, pre);
            pre = pre.substring(0, pre.length() - 1);
            pre += "1"; // Right
            print(node.right, pre);
            pre = pre.substring(0, pre.length() - 1);
        }
    }
}
