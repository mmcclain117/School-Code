
public class GuitarString {

    int time = 0;
    RingBuffer buffer;

    public GuitarString(double frequency) {
        buffer = new RingBuffer((int) (44100 / frequency + .5));
        for (int i = 0; i < buffer.size(); i++) {
            buffer.enqueue(0);
        }
    }

    public GuitarString(double[] init) {
        buffer = new RingBuffer(init.length);
        for (int i = 0; i < buffer.size(); i++) {
            buffer.enqueue(init[i]);
        }
    }

    public void pluck() {
        for (int i = 0; i < buffer.size(); i++) {
            buffer.enqueue(Math.random() - .5);
        }
    }

    public void tic() {
        if (!(buffer.isEmpty())) {
            double first = buffer.dequeue();
            double second = buffer.peek();
            double tic = ((first + second) / 2) * .994;
            buffer.enqueue(tic);
            time++;
        }
    }

    public double sample() {
        return buffer.peek();
    }

    public int time() {
        return time;
    }
}
