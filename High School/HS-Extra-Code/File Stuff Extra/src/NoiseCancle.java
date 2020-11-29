
import java.io.ByteArrayOutputStream;
import javax.sound.sampled.*;

/**
 *
 * @author Jacob
 */
public class NoiseCancle {

    private static boolean stopped;

    public static void main(String[] args) {
        TargetDataLine line = null;
        AudioFormat format = null;
        DataLine.Info info = new DataLine.Info(TargetDataLine.class,
                format); // format is an AudioFormat object
        if (!AudioSystem.isLineSupported(info)) {
//        Handle the error ... 

        }
//        Obtain and open the line.
        try {
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
        } catch (LineUnavailableException ex) {
//        Handle the error ... 
        }
//        Assume that the TargetDataLine, line, has already
//        been obtained and opened.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int numBytesRead;
        byte[] data = new byte[line.getBufferSize() / 5];

//        Begin audio capture.
        line.start();

//        Here, stopped is a global boolean set by another thread.
        while (!stopped) {
//            Read the next chunk of data from the TargetDataLine.
            numBytesRead = line.read(data, 0, data.length);
//            Save this chunk of data.
            out.write(data, 0, numBytesRead);
        }
    }

}
