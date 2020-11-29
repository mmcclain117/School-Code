
import java.util.*;
import java.io.*;

public class prob14a {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("prob14-1-in.txt"));
        int x = scan.nextInt();
        int y = scan.nextInt();
        while (x != 0 && y != 0) {
            scan.nextLine();
            char ch[][] = new char[y][x];
            for (int yy = 0; yy < y; yy++) {
                String te = scan.nextLine();
//                System.out.println(te);
                ch[yy] = te.toCharArray();
            }
            int con = 0;
            LinkedList<LinkedList<Node>> ll = new LinkedList();
            LinkedList l = new LinkedList();
            l.add(new Node(0, 0));
            ll.add(l);
            while (!ll.isEmpty()) {
                LinkedList<Node> ty = ll.removeFirst();
                LinkedList<Node> te = ty;
//                System.out.println("TE SIZE: " + te.size());
                Node temp = ty.getLast();
//                System.out.println(temp.x + " " + temp.y);
                if (temp.x == x - 1 && temp.y == y - 1 && checkPos(ch, temp)) {
                    con++;
//                    System.out.println(te.size());
                    break;
                } else if (checkPos((ch), temp)) {
//                    System.out.println("LL SIZE: " + ll.size() + " " + con);
//                    System.out.println(temp.x + " " + temp.y);
//                    System.out.println(Arrays.toString(ll.toArray()));
                    if (temp.y - 1 > 0) { // Up
                        if (check(ch, temp.x, temp.y - 1) && cont(ty, temp.x, temp.y - 1)) {
                            ty.addLast(new Node(temp.x, temp.y - 1));
                            ll.addLast(ty);
                            ty = te;
//                            ty.removeFirst();
                        }
                    }
                    if (temp.x - 1 > 0) { // Left
                        if (check(ch, temp.x - 1, temp.y) && cont(ty, temp.x - 1, temp.y)) {
                            ty.addLast(new Node(temp.x - 1, temp.y));
                            ll.addLast(ty);
                            ty = te;
//                            te.removeFirst();
                        }
                    }
                    if (temp.x + 1 < x) { // Right
                        if (check(ch, temp.x + 1, temp.y) && cont(ty, temp.x + 1, temp.y)) {
                            ty.addLast(new Node(temp.x + 1, temp.y));
                            ll.addLast(ty);
                            ty = te;
//                            te.removeFirst();
                        }
                    }
                    if (temp.y + 1 < y) { // Down
                        if (check(ch, temp.x, temp.y + 1) && cont(ty, temp.x, temp.y + 1)) {
                            ty.add(new Node(temp.x, temp.y + 1));
                            ll.addLast(ty);
                            ty = te;
//                            te.removeLast();
                        }
                    }
                }
            }
//            System.out.println(ll.getFirst().size());
//            System.out.println(con);
            x = scan.nextInt();
            y = scan.nextInt();
        }
    }

    private static boolean checkPos(char[][] ch, Node temp) {
        return ch[temp.y][temp.x] != '#';
    }

    private static boolean check(char[][] ch, int x, int y) {
        return ch[y][x] != '#';
    }

    private static boolean cont(LinkedList<Node> te, int x, int y) {
//        System.out.println(te.size());
        for (int i = 0; i < te.size(); i++) {
            Node temp = te.get(i);
            if (temp.x == x && temp.y == y) {
                return false;
            }
        }
        return true;
//        return te.contains(new Node(x, y));
    }
}

class Node {

    public int x;
    public int y;

    public Node(int a, int b) {
        x = a;
        y = b;
    }
}
