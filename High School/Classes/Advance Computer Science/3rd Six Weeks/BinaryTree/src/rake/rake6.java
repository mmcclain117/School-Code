package rake;

import java.io.File;
import static java.lang.System.out;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class rake6 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("rake.dat"));
//        int cases = scan.nextInt();
//        scan.nextLine();
//        for (int i = 0; i < cases; i++) {
        String line = scan.nextLine();
        while (!line.equals("-1")) {
            String n[] = line.split("\\s+");
            BT bt = new BT();
            for (int i = 0; i < n.length; i++) {
                bt.insert(Integer.parseInt(n[i]));
            }
            Tree root = bt.root;
            int he = bt.height(root);
//            bt.printLevels(bt.root, he);
            System.out.println("Height: " + he);
            bt.levelOrderQueue(root);
            line = scan.nextLine();
            System.out.println("\n");
            while (root != null) {
                System.out.print(root.data + " ");
                root = root.getLeft();
            }
            System.out.println("\n");
        }
    }

}

class BT { // Binary Tree to handle insertion

    public Tree root;

    public BT() {
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Tree insert(Tree node, int data) {
        if (node == null || node.data == -1) {
            node = new Tree(data);
        } else {
            if (node.getRight() == null) {
                node.setRight(insert(node.right, data));
            } else {
                node.left = insert(node.left, data);
            }
        }
        return node;
    }

    public void printLevels(Tree root, int h) {
        if (root == null) {
            return;
        }
        if (h == 1) {
            System.out.print(" " + root.data);
        } else {
            printLevels(root.left, h - 1);
            printLevels(root.right, h - 1);
        }
    }

    public int height(Tree root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void levelOrderQueue(Tree root) {
        Queue q = new LinkedList();
        int levelNodes = 0;
        if (root == null) {
            return;
        }
        q.add(root);
        while (!q.isEmpty()) {
            levelNodes = q.size();
            while (levelNodes > 0) {
                Tree n = (Tree) q.remove();
                System.out.print(" " + n.data);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
                levelNodes--;
            }
            System.out.println("");
        }
    }
}

class Tree {

    public Tree left, right;
    public int data;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

//    public Tree(int data, Tree left, Tree right) {
//        this.data = data;
//        this.left = left;
//        this.right = right;
//    }
    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

}
