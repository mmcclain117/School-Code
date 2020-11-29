
/**
 *
 * @author x45Clamibot
 */
import java.util.*;

public class GuitarString {

    RingBuffer buffer;
    int tick = 0;

    GuitarString(double frequency) {
        int capacity = (int) Math.ceil((44100 / frequency));
        buffer = new RingBuffer(capacity);
        for (int i = 0; i < buffer.size() - 1; ++i) {
            buffer.enqueue(0);
        }
    }

    GuitarString(double[] init) {
        buffer = new RingBuffer(init.length);
        for (int i = 0; i < init.length; ++i) {
            buffer.enqueue(init[i]);
        }
    }

    void pluck() {
        Random generate = new Random();
        double temp = generate.nextDouble() * .5;
        if (temp < .5) {
            temp = temp * -1;
        } else if (temp >= .5) {
            temp = temp - .5;
        }
        buffer.enqueue(temp);
        for (int i = 0; i < buffer.size(); ++i) {
            if (temp < .5) {
                temp = temp * -1;
            } else if (temp >= .5) {
                temp = temp - .5;
            }
            buffer.enqueue(temp);
        }
    }

    void tic() {
        double temp1 = buffer.dequeue();
        double temp2 = buffer.peek();
        double average = ((temp1 + temp2) / 2) * .994;
        buffer.enqueue(average);
        ++tick;
    }

    double sample() {
        return buffer.peek();
    }

    int time() {
        return tick;
    }
}
