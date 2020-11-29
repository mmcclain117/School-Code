
public class RingBuffer {

    public int capacity;
    private int first = 0;
    private int last;
    double[] buffer;

    RingBuffer(int capacity) {
        buffer = new double[capacity];
        this.capacity = capacity;
    }

    int size() {
        return buffer.length;
    }

    boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull() {
        if (size() == capacity) {
            return true;
        } else {
            return false;
        }
    }

    void enqueue(double x) {
        if (last == capacity) {
            last = 0;
        }
        buffer[last] = x;
        last++;

    }

    double dequeue() {
        if (!(isEmpty())) {
            if (first == capacity) {
                first = 0;
            }
            double val = buffer[first];
            buffer[first] = 0;
            first++;
            return val;
        }
        return 0;
    }

    double peek() {
        if (first == capacity) {
            first = 0;
        }
        return buffer[first];
    }
}
