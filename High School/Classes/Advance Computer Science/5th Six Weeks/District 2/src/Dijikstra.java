/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package graphtheory;

/**
 *
 * @author x45Clamibot
 */
import java.util.*;

public class Dijikstra {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        for (int cycle = 0; cycle < cases; ++cycle) {
            int n = in.nextInt();
            int m = in.nextInt();
            Node[] graph = new Node[n + 1];
            for (int i = 1; i < n + 1; ++i) {
                graph[i] = new Node(i);
            }
            for (int i = 0; i < m; ++i) {
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                int w = in.nextInt();
                graph[n1].addNeighbor(new Vertex(n1, n2, w));
                graph[n2].addNeighbor(new Vertex(n2, n1, w));
            }
            int beginnode = in.nextInt();
            int endnode = in.nextInt();
            boolean search = true;

            int totalWeight = 0;
            ArrayList<Integer> set = new ArrayList<Integer>();
            PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();

            graph[1].update(0, 1);
            pq.addAll(graph[1].nbrs);

            Node target = graph[1];
            set.add(target.id);

            while (set.size() != n) {
                for (int i = 1; i < graph.length; ++i) {
                    if (graph[i] == null) {
                        search = false;
                    }
                }
                if (search == false) {
                    System.out.println("NO");
                    break;
                }
                for (int j = 0; j < target.nbrs.size(); ++j) {
                    Vertex v = target.nbrs.get(j);
                    if (!set.contains(v.n2)) {
                        graph[v.n2].update(v.weight, target.id);
                    }
                    pq.add(v);
                }

                target = graph[pq.poll().n2];
                if (target == null) {
                    break;
                }
                while (set.contains(target.id)) {
                    target = graph[pq.poll().n2];
                    if (target == null) {
                        break;
                    }
                }

                set.add(target.id);
            }

            for (int i : set) {
                totalWeight += graph[i].weight;
            }

            if (search != false) {
                System.out.println(totalWeight);
            }
        }
    }
}
/*
class Node {

    int id;
    int parent = 0;
    int weight = Integer.MAX_VALUE;

    ArrayList<Vertex> nbrs = new ArrayList<Vertex>();

    public Node(int id) {
        this.id = id;
    }

    public boolean update(int weight, int parent) {
        if (weight < this.weight) {
            this.parent = parent;
            this.weight = weight;
            return true;
        }
        return false;
    }

    public void addNeighbor(Vertex v) {
        nbrs.add(v);
    }
}

class Vertex implements Comparable {

    int n1;
    int n2;
    int weight;

    public Vertex(int n1, int n2, int weight) {
        this.n1 = n1;
        this.n2 = n2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Vertex v = (Vertex) o;
        if (weight < v.weight) {
            return -1;
        } else {
            return 1;
        }
    }
}
*/