
class Leaf extends HuffmanTree {

    public final String value; // the character this leaf represents

    public Leaf(int freq, String val) {
        super(freq);
        value = val;
    }
}
