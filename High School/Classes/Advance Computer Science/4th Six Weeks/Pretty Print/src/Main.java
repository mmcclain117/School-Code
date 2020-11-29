
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double l[] = {9.0, 1.0, 3.0, 6.0, 5.0, 2.0, 12.0, 29.0};
        BST bin = new BST(l[0]);
        for (int i = 1; i < l.length; i++) {
            bin.insert(l[i]);
        }
        ArrayList<String> li = new ArrayList();
        Node temp = bin.getRoot();
        System.out.println(temp.getData());
        while (true) {
            if (temp.getLeft() != null) {
                if (temp.getRight() != null) {
                    li.add(temp.getLeft().getData() + " " + temp.getRight().getData());
                    temp = temp.getRight();
                } else {
                    temp = temp.getLeft();
                }
            } else {
                break;
            }
        }
        bin.inorder();
        System.out.println();
        bin.printLevels(bin.getRoot(), bin.height(bin.getRoot()));
        System.out.println();
        System.out.println(bin.nodeCount());
        System.out.println(Arrays.toString(li.toArray()));
    }
}
