
class Node extends HuffmanTree {

    public final HuffmanTree left, right; // subtrees

    public Node(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
