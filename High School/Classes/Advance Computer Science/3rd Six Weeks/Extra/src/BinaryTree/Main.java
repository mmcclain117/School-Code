package BinaryTree;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BT bt = new BT();
        BinaryTreeTest btt = new BinaryTreeTest();
        System.out.println("Binary Tree Test\n");
        ArrayList<Integer> ma = new ArrayList();
        HashSet<Integer> hs = new HashSet();
        Random rg = new Random(1); // Random Generate
        Random rs = new Random(0); // Random search
        int par = 200; // Random parameter
//        Node root = new Node(5);
        for (int i = 0; i < 20; i++) {
            int p = rg.nextInt(par);
            ma.add(p);
            bt.insert(p);
//            hs.add(p);
        }

        hs.addAll(ma);
//        ma.add(1);
        out.println("ArrayList:  " + Arrays.toString(ma.toArray()));
        out.println("HashSet:    " + Arrays.toString(hs.toArray()));
        for (int i = 0; i < 5; i++) { // Searching
            int p = rs.nextInt(par);
            out.println("Search result for " + p + ": " + (bt.search(p) ? "Found" : "Not Found"));
        }
        out.println("Number of Nodes: " + bt.countNodes());
//        System.out.println("1. Insert"); // Ma
//        System.out.println("2. Search"); // rs
//        System.out.println("3. Count nodes");
//        System.out.println("4. Check empty");
//        System.out.println("Enter integer element to insert");
//        bt.insert(scan.nextInt());
//        System.out.println("Enter integer element to search");
//        System.out.println("Search result : " + bt.search(scan.nextInt()));
//        System.out.println("Nodes = " + bt.countNodes());
//        System.out.println("Empty status = " + bt.isEmpty());
//        System.out.println("Wrong Entry \n ");
        System.out.print("\nPost order: ");
        bt.postorder();
        System.out.print("\nPre order: ");
        bt.preorder();
        System.out.print("\nIn order: ");
        bt.inorder();
        System.out.println();
    }
}
