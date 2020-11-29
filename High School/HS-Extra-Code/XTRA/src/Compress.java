
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Compress {

    private static HashMap<String, String> hs = new HashMap();

    public static void main(String[] args) throws Exception {
//        String files[] = {"f.txt", "dream.txt", "Amendments to the Constitution.txt", "Communist Manifesto.txt", "Magna Carta.txt",
//            "Much Ado About Nothing.txt", "Aesop's Fables.txt", "Treasure Island.txt", "Tom Sawyer.txt", "Tale of Two Cities.txt",
//            "Little Women.txt", "Moby Dick.txt", "The Three Musketeers.txt", "Anna Karenina.txt", "War and Peace.txt"};
        long start = System.nanoTime();
        String filename = "A Tale of Two Cities";
        Scanner scan = new Scanner(new File(filename + ".txt"));
        String fin = "";
//        while (scan.hasNext()) {
//            fin += scan.nextLine() + "\n";
//        }
//        scan.close();
//        ArrayList<String> cf = new ArrayList();
        HashMap<String, Integer> hsi = new HashMap();
//        String pos[] = fin.split("\\s");
        int consta = 0;
        while (scan.hasNext()) {
            String currents = scan.nextLine() + " $ ";
            Scanner input = new Scanner(currents);
            while (input.hasNext()) {
                String current = input.next() + " ";
                if (hsi.containsKey(current)) {
                    hsi.put(current, hsi.get(current) + 1);
                } else {
                    hsi.put(current, 1);
                }
            }
            fin += currents;
            consta++;
        }
        scan.close();
        System.out.println(consta + " " + hsi.size());
        /*
         for (int i = 0; i < pos.length; i++) {
         if (hsi.containsKey(pos[i])) {
         hsi.put(pos[i], hsi.get(pos[i]) + 1);
         } else {
         hsi.put(pos[i], 1);
         }
         }
         */
//        hsi.put(" ", pos.length);
//        System.out.println(hsi.size());
        HuffmanTree hm = BuildTree(hsi);
        p(hm, "");
        String fina = ""; // Bits compression
        Set s = hs.entrySet();
//        String tee = "this";
        BitOutputStream bos = new BitOutputStream("Compress\\" + filename + ".bin");
//        char ch[] = fin.toCharArray();
        String ch[] = fin.split(" ");
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
//        System.out.println(Arrays.toString(ch));
        for (int i = 0; i < ch.length; i++) {
//            char c = ch[i];
            String c = ch[i];
            Iterator it = s.iterator();
            while (it.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) it.next();
//                System.out.println(mentry2.getKey().toString() + " "+ c);
                if ((c).equals(mentry2.getValue().toString())) {
                    fina += mentry2.getKey().toString() + sp;
//                    System.out.println("1");
                    break;
                }
            }
        }
        String ix = fina;
        int ip = 0;
//        System.out.println(ix);
        while (ip < ix.length() - 8) {
            bos.write((byte) Integer.parseInt(ix.substring(ip, ip + 8), 2));
            ip += 8;
        }
        bos.flush();
        bos.close();
        BitInputStream bis = new BitInputStream(new File("Compress\\" + filename + ".bin"));
        String phrase = "";
        int con = 0;
        HuffmanTree temper = hm;
        while (con < fina.length() - 1) {
            if (temper instanceof Leaf) { // Is a leaf
                String tq = ((Leaf) temper).value;
//                phrase += tq;
                System.out.println(tq);
                phrase += ("$ ".equals(tq) ? "\r\n" : tq);
                temper = hm;
                con--;
            } else if (temper instanceof Node) {
                int bit = bis.readBits(1);
                if (bit == 1) {
                    temper = ((Node) temper).right;
                } else if (bit == 0) {
                    temper = ((Node) temper).left;
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

    private static void p(HuffmanTree tree, String pre) {
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
}
