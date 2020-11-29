package BinaryTree;

import java.util.Random;

public class BinaryTreeTest {

    public static void main(String[] args) {
        new BinaryTreeTest().run();
    }

    static class Node {

        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void run() {
        // build the simple tree from chapter 11.
        Node root = new Node(185);
        System.out.println("Binary Search Tree Example");
        System.out.println("Building tree with root value " + root.value);
//        insert(root, 1);
//        insert(root, 8);
//        insert(root, 6);
//        insert(root, 3);
//        insert(root, 9);

//        Random rg = new Random(1); // Random Generate
//        int par = 200; // Random parameter
//        for (int i = 0; i < 20; i++) {
//            int p = rg.nextInt(par);
//            insert(root, p);
//        }
//        System.out.println("Traversing tree in order");
//        printInOrder(root);
//        System.out.println("Traversing tree front-to-back from location 7");
//        printFrontToBack(root, 185);
        root = new Node(8);
        int b[] = {2, 9, 6, 5, 12, 3, 7};
        for (int i = 0; i < b.length; i++) {
            insert(root, b[i]);
        }
        printFrontToBack(root, 8);
        printInOrder(root);
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of "
                        + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.value);
                node.right = new Node(value);
            }
        }
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("  Traversed " + node.value);
            printInOrder(node.right);
        }
    }

    /**
     * uses in-order traversal when the origin is less than the node's value
     *
     * uses reverse-order traversal when the origin is greater than the node's
     * order
     */
    public void printFrontToBack(Node node, int camera) {
        if (node == null) {
            return;
        }
        if (node.value > camera) {
            // print in order
            printFrontToBack(node.left, camera);
            System.out.println("  Traversed " + node.value);
            printFrontToBack(node.right, camera);
        } else if (node.value < camera) {
            // print reverse order
            printFrontToBack(node.right, camera);
            System.out.println("  Traversed " + node.value);
            printFrontToBack(node.left, camera);
        } else {
            // order doesn't matter
            printFrontToBack(node.left, camera);
            printFrontToBack(node.right, camera);
        }
    }

}
