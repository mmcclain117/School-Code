
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Compress4 {

    public static HashMap<String, Character> hs = new HashMap();

    public static void main(String[] args) throws Exception {
//        String files[] = {"f.txt", "dream.txt", "Amendments to the Constitution.txt", "Communist Manifesto.txt", "Magna Carta.txt",
//            "Much Ado About Nothing.txt", "Aesop's Fables.txt", "Treasure Island.txt", "Tom Sawyer.txt", "Tale of Two Cities.txt",
//            "Little Women.txt", "Moby Dick.txt", "The Three Musketeers.txt", "Anna Karenina.txt", "War and Peace.txt"};
//        for (int ix = 0; ix < files.length; ix++) {
        long start = System.currentTimeMillis();
//            String filename = files[ix];
        String filename = "Magna Carta";
        Scanner scan = new Scanner(new File(filename + ".txt"));
        String fin = "";
        while (scan.hasNext()) {
            fin += scan.nextLine() + "\n";
        }
//        char ccccc[] = fin.toCharArray();
//        Arrays.sort(ccccc);
//        System.out.println(Arrays.toString(ccccc));
        scan.close();
//        char cccc[] = fin.toCharArray();
//        for(char cl: cccc) {
//            System.out.println((int)cl);
//        }
        char CF[] = new char[256]; // Frequency
        for (char c : fin.toCharArray()) {
            CF[c]++;
        }
        HuffmanTree hm = BuildTree(CF);
        p(hm, "");
//            System.out.println(Arrays.toString(hs.entrySet().toArray()));
//            System.out.println(Arrays.toString(hs.keySet().toArray()));
        String fina = ""; // Bits compression
        Set s = hs.entrySet();
//            Set ks = hs.keySet();
//            System.out.println(Arrays.toString(ks.toArray()));
        String tee = "this";

        BitOutputStream bos = new BitOutputStream("Compress\\" + filename + ".bin");

        char ch[] = fin.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            Iterator it = s.iterator();
            while (it.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) it.next();
                if ((c + "").equals(mentry2.getValue().toString())) {
                    fina += mentry2.getKey().toString();
//                    bos.write((mentry2.getKey().toString()).getBytes());
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
//        System.out.println(Files.size(new File("g.bin").toPath()));
//        FileWriter fw = new FileWriter(new File("Compress\\" + filename + ".txt"));
//        File fs = new File(filename + ".bin");
//        fs.createNewFile();
        BitInputStream bis = new BitInputStream(new File("Compress\\" + filename + ".bin"));
//        fw.write(fina);
//        fw.flush();
//        fw.close();
        String phrase = "";
        int con = 0;
        HuffmanTree temper = hm;
//        System.out.println(bis.readBits(1));
        while (con < fina.length() - 1) {
            if (temper instanceof Leaf) { // Is a leaf
                char tq = ((Leaf) temper).value;
//                System.out.println(((int)tq) + " "+ tq );
                phrase += (tq == '\n' ? "\r\n" : tq);
//                System.out.println(((Leaf) temper).value);
                temper = hm;
                con--;
            } else if (temper instanceof Node) {
//                    char bit = (char) (fina.charAt(con) - 48); // Each bit
//                int bit = (fina.charAt(con) - 48); // Each bit
                int bit = bis.readBits(1);
//                System.out.print((int) bit);
                if (bit == 1) {
                    temper = ((Node) temper).right;
                } else if (bit == 0) {
                    temper = ((Node) temper).left;
                }
            }
            con++;
        }

//        FileWriter tesss = new FileWriter(new File("DeCompress\\" + filename + ".txt"));
//        tesss.write(tee);
//        tesss.flush();
//        tesss.close();
        int simcon = 0; // Similar Count
        int numb = Math.min(fin.length(), phrase.length()); // Smaller Document
        char chp[] = phrase.toCharArray();
        for (int iv = 0; iv < numb; iv++) {
            simcon += chp[iv] == ch[iv] ? 1 : 0;
        }
        FileWriter fww = new FileWriter(new File("Stat\\" + filename + ".txt"));
        FileWriter fws = new FileWriter(new File("DeCompress\\" + filename + ".txt"));
        fws.write(phrase);
        fws.flush();
        fws.close();
        long os = Files.size(new File(filename + ".txt").toPath()); // Original File Size
        long ns = Files.size(new File("Compress\\" + filename + ".bin").toPath()); // Compressed size

//        fww.write("Compressed Length: " + fina.length() + "\nOriginal: " + phrase.length() + "\n");
        fww.write("Compressed Size: " + ns + "\nOriginal Size: " + os + "\n");
//            System.out.println(files[ix]);
//            System.out.println("Compressed Length: " + fina.length() + "\nOriginal: " + phrase.length());
//        double comp = (100.00 * (fina.length() - phrase.length())) / fina.length();
        double comp = (os - ns) / 100;
        fww.write("Compressed by : " + comp + "%\n");
//            System.out.println("Compressed by : " + comp + "%");
        long end = System.currentTimeMillis();
//            System.out.println("Time: " + (end - start));
        fww.write("Time: " + (end - start) + "\n");
        fww.write("Similarity: " + simcon + "\n");
        fww.write("Similarity Percentage: " + (100.00 - ((fin.length() - simcon) / fin.length())) + "%");
        fww.flush();
        fww.close();
        System.gc();
//        }
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
}
