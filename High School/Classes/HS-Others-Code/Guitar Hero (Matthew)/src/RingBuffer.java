
/**
 *
 * @author x45Clamibot
 */
public class RingBuffer {

    private int first;
    private int last;
    double[] buffer;

    RingBuffer(int capacity) {
        buffer = new double[capacity];
        first = 0;
        last = 0;
    }

    int size() {
        int returnsize = 0;
        for (int i = 0; i < buffer.length - 1; ++i) {
            if (buffer[i] != 0) {
                ++returnsize;
            }
        }
        return returnsize;
    }

    boolean isEmpty() {
        boolean returnresponse = false;
        double count = 0;
        for (int i = 0; i < buffer.length - 1; ++i) {
            count = count + buffer[i];
        }
        if (count == 0) {
            returnresponse = false;
        }
        return returnresponse;
    }

    boolean isFull() {
        boolean returnresponse = false;
        if (size() == buffer.length) {
            returnresponse = true;
        }
        return returnresponse;
    }

    void enqueue(double x) {
        if (last == buffer.length - 1) {
            last = 0;
        } else {
            ++last;
        }
        buffer[last] = x;
        //System.out.println("Number in: " + x);
    }

    double dequeue() {
        double returnval = buffer[first];
        //System.out.println("Number out: " + returnval);
        if (first == buffer.length - 1) {
            first = 0;
        } else {
            ++first;
        }
        return returnval;
    }

    double peek() {
        return buffer[first];
    }
}
