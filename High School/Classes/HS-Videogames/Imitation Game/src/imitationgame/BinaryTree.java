package imitationgame;

import java.util.*;

/**
 *
 * @author 143352
 */
public class BinaryTree {

    ArrayList<Node> list;
    Node root;
    String code;
    Node current;

    public BinaryTree(Set<Map.Entry> entrySet) {
        createTree(entrySet);
        root = list.get(0);
    }

    private void createTree(Set<Map.Entry> entrySet) {
        list = new ArrayList<>();

        Iterator itr = entrySet.iterator();
        while (itr.hasNext()) {
            list.add(new Node(itr.next().toString()));
        }

        while (list.size() > 1) {
            Node min = list.get(0);

            for (Node n : list) {
                if (n.getInst() <= min.getInst()) {
                    min = n;
                }
            }
            list.remove(min);

            Node min2 = list.get(0);
            for (Node n : list) {
                if (n.getInst() <= min2.getInst()) {
                    min2 = n;
                }
            }
            list.remove(min2);

            Node n = new Node(min2, min);
            list.add(n);
            //System.out.println(n.toString());
        }

    }

    public String encode(char find) {
        code = "";
        code(find, root, "");
        return code;
    }

    public void code(char find, Node n, String s) {
        Node temp = n;
        //System.out.println(s);
        if (temp.getChar() == find) {
            code = s;
        }
        if (temp.left != null) {
            code(find, temp.left, s + "0");
        }
        if (temp.right != null) {
            code(find, temp.right, s + "1");
        }

    }

    public Node decode(int bit) {

        if (current != null && current.isLeaf()) {
            Node c = current;
            current = root;
            return c;
        }

        if (bit == 0) {
            current = current.left;
        } else if (bit == 1) {
            current = current.right;
        }

        return null;

    }

    public char search(String s) {
        return 's';
    }

    public class Node {

        private char ch;
        int n = 0;

        Node parent = null;
        Node left = null;
        Node right = null;

        public Node(String s) {
            ch = s.charAt(0);
            n = Integer.parseInt(s.substring(2));
        }

        public Node(Node left, Node right) {
            ch = (char) 127;
            this.left = left;
            this.right = right;
            this.left.parent = this;
            this.right.parent = this;
            n = left.getInst() + right.getInst();
        }

        @Override
        public String toString() {
            return (ch + ", " + n);
        }

        public char getChar() {
            return ch;
        }

        public int getInst() {
            return n;
        }

        public boolean isLeaf() {
            return right == null && left == null;
        }
    }
}
