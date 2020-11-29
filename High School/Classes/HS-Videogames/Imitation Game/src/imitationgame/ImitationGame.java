package imitationgame;

import imitationgame.BinaryTree.Node;
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author 143352
 */
public class ImitationGame {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        String fileName = "Moby Dick";
        char endFile = (char) 127;

        HashMap hm = new HashMap();
        Scanner in = new Scanner(new File(fileName + ".txt"));
        while (in.hasNext()) {
            char[] line = in.nextLine().toCharArray();
            for (int i = 0; i < line.length; i++) {
                char key = line[i];
                if (hm.containsKey(key)) {
                    hm.put(key, (Integer) hm.get(key) + 1);
                } else {
                    hm.put(key, 1);
                }
            }
        }
        hm.put(endFile, 1);
        //in.close();
        out.println(hm.keySet());
        out.println(hm.entrySet());

        BinaryTree bt = new BinaryTree(hm.entrySet());

        HashMap<Character, String> code = new HashMap<>();
        Iterator itr = hm.keySet().iterator();
        while (itr.hasNext()) {
            Character c = (Character) itr.next();
            code.put(c, bt.encode(c));
            out.println(c + " " + bt.encode(c));
        }

        BitOutputStream bos = new BitOutputStream("code");

        in = new Scanner(new File(fileName + ".txt"));
        while (in.hasNext()) {
            for (char c : in.nextLine().toCharArray()) {
                String s = bt.encode(c);
                bos.writeBits(s.length(), Integer.parseInt(s, 2));
                //out.println(s+" "+s.length()+" "+Integer.parseInt(s, 2));
            }
        }
        String s = bt.encode(endFile);
        bos.writeBits(s.length(), Integer.parseInt(s, 2));
        bos.close();

        BitInputStream bis = new BitInputStream("code");
        PrintWriter pw = new PrintWriter(new File("decode.txt"));
        int bit = bis.readBits(1);
        Node current = bt.root;

        out.println(bt.root.left.getChar());
        out.println(bt.root.left.left == null);
        out.println(bt.root.left.right == null);
        out.println(bt.root.left.isLeaf());

        while (bit >= 0) {
            //out.print(bit);
            if (current.isLeaf()) {
                //out.println(current.getChar());
                if (current.getChar() == endFile) {
                    break;
                }
                pw.write(current.getChar());
                current = bt.root;

            }
            if (bit == 0) {
                current = current.left;
            } else if (bit == 1) {
                current = current.right;
            }

            bit = bis.readBits(1);

        }
        bis.close();
        pw.close();
    }
}
