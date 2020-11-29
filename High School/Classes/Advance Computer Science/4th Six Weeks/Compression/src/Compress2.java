
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Compress2 {

    public static HashMap<String, Character> hs = new HashMap();

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader(new File("f.txt"));
        String fin = "";
        while (fr.ready()) {
            fin += (char) fr.read();
        }
        letComp(fin);
        FileWriter fw = new FileWriter(new File("g.bin"));
//        String fina = fin;
        String fina = "";
        HashMap<Integer, Character> h = new HashMap();
        Set s = hs.entrySet();
        Set ks = hs.keySet();
//        Iterator it = s.iterator();
        char ch[] = fin.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            Iterator it = s.iterator();
            while (it.hasNext()) {
//                System.out.print(c);
                Map.Entry mentry2 = (Map.Entry) it.next();
                if ((c + "").equals(mentry2.getValue().toString())) {
                    fina += mentry2.getKey().toString();
                    System.out.println(mentry2.getKey());
                    break;
                }
//                fina = fina.replaceAll(mentry2.getValue().toString(), mentry2.getKey().toString());
//                System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
//                System.out.println(mentry2.getValue());
            }
        }
//        BitOutputStream bos = new BitOutputStream(new OutputStream(new File("g.bin")));
        BitOutputStream bos = new BitOutputStream(new FileOutputStream(new File("g.bin")));
        System.out.println(fina);
        fw.write(fina);
        fw.flush();
        fw.close();
        bos.write(fina.getBytes());
        bos.flush();
        bos.close();
        String phrase = "";
        BitInputStream bis = new BitInputStream(new FileInputStream(new File("g.bin")));
//        byte b = 0;
        String b = "";
        int con = 0;
        String ttt = "";
        while (++con < fina.length() - 2) {
            ttt += bis.readBits(1);
        }
        System.out.println(ttt);
        System.out.println(Arrays.toString(ks.toArray()));
        while (++con < fina.length() - 2) {
            b += bis.readBits(8);
            if (ks.contains(b)) {
                Iterator it = ks.iterator();
                while (it.hasNext()) {
//                System.out.print(c);
                    Object obj = it.next();
//                    Map.Entry mentry2 = (Map.Entry) it.next();
//                    if ((b + "").equals(mentry2.getKey().toString())) {
                    String te = it.next().toString();
                    ttt = ttt.replaceAll("0101", obj.toString());
                    if (b.equals(te)) {
                        phrase += te;
//                        System.out.println(mentry2.getKey());
                        break;
                    }
//                fina = fina.replaceAll(mentry2.getValue().toString(), mentry2.getKey().toString());
//                System.out.print("Key is: " + mentry2.getKey() + " & Value is: ");
//                System.out.println(mentry2.getValue());
                }
                b = "";
            }
        }
        System.out.println(phrase);
        System.out.println(ttt);

//        rebuild();
    }

    private static void letComp(String f) {
        char CF[] = new char[256]; // Frequency
        for (char c : f.toCharArray()) {
            CF[c]++;
        }
        HuffmanTree hm = BuildTree(CF);
//        printCodes(hm, new StringBuffer());
        p(hm, "");
        System.out.println(Arrays.toString(hs.entrySet().toArray()));
        System.out.println(Arrays.toString(hs.keySet().toArray()));
    }

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

//    public static HashMap<String, Character> p(HuffmanTree tree, String pre) {
    public static void p(HuffmanTree tree, String pre) {
//        HashMap<String, Character> hm = new HashMap();
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
//        return hm;
    }

    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        if (tree instanceof Leaf) {
            Leaf leaf = (Leaf) tree;
            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);
        } else if (tree instanceof Node) {
            Node node = (Node) tree;
            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
//            System.out.println(prefix.charAt(prefix.length() - 1));
            prefix.deleteCharAt(prefix.length() - 1);
            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private static void rebuild() {

    }
}
