package mazerunner;

/**
 *
 * @author 143352
 */
public class Heap {

    private int[] heap;
    public int size;
    private final int FRONT = 1;

    public Heap() {
        this.size = 0;
        heap = new int[1001];
        heap[0] = Integer.MIN_VALUE;
    }

    public int getParent(int pos) {
        return heap[pos / 2];
    }

    public int getLeft(int pos) {
        return heap[2 * pos];
    }

    public int getRight(int pos) {
        return heap[2 * pos + 1];
    }

    public boolean isLeaf(int pos) {
        return !(getLeft(pos) == 0 || getRight(pos) == 0);
    }

    public void heapify(int pos) {
        if (!isLeaf(pos)) {
            System.out.print("SADOS");
            if (heap[pos] > getLeft(pos) || heap[pos] > getRight(pos)) {
                if (getLeft(pos) < getRight(pos)) {
                    swap(pos, pos * 2);
                    heapify(pos * 2);
                } else {
                    swap(pos, pos * 2 + 1);
                    heapify(pos * 2 + 1);
                }
            }
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            heapify(pos);
        }
    }

    public void insert(int e) {
        heap[++size] = e;
        //System.out.println("element = " + heap[size] + " should be " + e);
        int current = size;
        //System.out.println("Size " + size);
        while (heap[current] < getParent(current)) {
            swap(current, current / 2);
            current = current / 2;
        }
    }

    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        heap[size + 1] = 0;
        System.out.println("FR: " + heap[FRONT]);
        heapify(FRONT);
        System.out.println("FR 2: " + heap[FRONT]);
        System.out.println("PO: " + popped);
        return popped;
    }

    public void swap(int fpos, int spos) {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.println(i + " " + heap[i]);
        }
    }
}
