
class Leaf extends HuffmanTree {

    public final char value; // the character this leaf represents

    public Leaf(int freq, char val) {
        super(freq);
        value = val;
    }
}
