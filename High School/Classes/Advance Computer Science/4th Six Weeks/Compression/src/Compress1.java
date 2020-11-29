
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Compress1 {

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader(new File("f.txt"));
        String fin = "";
        while (fr.ready()) {
            fin += (char) fr.read();
        }
//        System.out.println(fin);
        letComp(fin);
//        worComp(fin.split("\\s+"));
    }

    private static void letComp(String f) {
        char CF[] = new char[256]; // Frequency
        for (char c : f.toCharArray()) {
            CF[c]++;
        }
        Map<Character, Integer> chmap = new TreeMap();
        char ch[] = f.toCharArray();
        for (char c : ch) {
            if (chmap.containsKey(c)) {
                int cnt = chmap.get(c);
                chmap.put(c, ++cnt);
            } else {
                chmap.put(c, 1);
            }
        }
//        print(chmap);
        Object o[] = chmap.entrySet().toArray();
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (Object l : o) {
            int a = l.toString().indexOf("=");
            pq.add(Integer.parseInt(l.toString().substring(a + 1)));
        }
//        LinkedList<Node> r = new LinkedList();
//        Node start = new Node();

        while (true) {

        }
//        System.out.println(Arrays.toString(pq.toArray()));
//        System.out.println(Arrays.toString(chmap.entrySet().toArray()));
//        HashMap<String, Integer> hm = makeTree(pq);
    }

    private static void worComp(String[] split) {
        Map<String, Integer> chmap = new HashMap();
        for (String f : split) {
            if (chmap.containsKey(f)) {
                int cnt = chmap.get(f);
                chmap.put(f, ++cnt);
            } else {
                chmap.put(f, 1);
            }
        }
        print(chmap);
    }

    private static void print(Map chmap) {
        Object o[] = chmap.entrySet().toArray();
        for (Object l : o) {
            System.out.println(l.toString());
        }

    }

    private static HashMap<String, Integer> makeTree(PriorityQueue<String> pq) {
        LinkedList ll = new LinkedList();
        HashMap<String, Integer> hm = new HashMap();

        return hm;
    }
}
/*
abstract class HuffmanTree implements Comparable<HuffmanTree> {

    public final int frequency; // the frequency of this tree

    public HuffmanTree(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends HuffmanTree {

    public final char value; // the character this leaf represents

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}

class HuffmanNode extends HuffmanTree {

    public final HuffmanTree left, right; // subtrees

    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}*/

//class Node {
//
//    private Node left;
//    private Node right;
//    private String letter;
//    private int data;
//
//    public Node(String s) {
//        left = null;
//        right = null;
//        letter = s;
//        data = 0;
//    }
//
//    public Node() {
//        left = null;
//        right = null;
//    }
//
//    public void setLeft(Node r) {
//        left = r;
//    }
//
//    public void setRight(Node r) {
//        right = r;
//    }
//
//    public Node getLeft() {
//        return left;
//    }
//
//    public Node getRight() {
//        return right;
//    }
//
//    public int getData() {
//        return data;
//    }
//
//    public String getLetter() {
//        return letter;
//    }
//}
