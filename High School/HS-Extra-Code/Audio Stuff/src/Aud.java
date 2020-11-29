
import com.sun.media.jfxmedia.track.Track;
import com.sun.media.jfxmedia.track.Track.Encoding;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Arrays;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

/**
 *
 * @author Master Ward
 */
public class Aud {

    public static void main(String[] args) throws Exception {
//        File file = new File("C:\\Users\\Master\\Dropbox\\Random Connect\\Test Read\\All I Do.mp4");
        File file = new File("C:\\Users\\Jacob Ward\\Dropbox\\Random Connect\\Test Read\\All I Do.mp3");
        File fac = new File("C:\\Users\\Jacob Ward\\Dropbox\\Random Connect\\Test Read\\All I do.aac");
        try {
//            AudioInputStream aui = AudioSystem.getAudioInputStream(file);
            out.println(Arrays.toString(AudioSystem.getAudioFileTypes()));

            out.println(Port.Info.LINE_IN);
            out.println(Port.Info.LINE_OUT);
            out.println(Port.Info.MICROPHONE);
            out.println(Port.Info.SPEAKER);
            Encoding d = Encoding.AAC;
            out.println(Track.Encoding.CUSTOM);
            out.println(d.NONE);
            FileInputStream fis = new FileInputStream(file);
            out.println("Channel " + fis.getChannel());
            DataInputStream dis = new DataInputStream(fis);
            out.println(dis.read());
            out.println(dis.available());
            out.println(dis.readUnsignedByte());
            out.println(dis.readUnsignedByte());
            Write(dis, fis);
            Writer(fac);
//            AudioInputStream s = AudioSystem.getAudioInputStream(AudioFormat.Encoding.PCM_SIGNED, aui);
        } catch (Exception e) {
            out.println("Nope");
        }
//        AudioInputStream as = AudioSystem.getAudioInputStream(d,aui);
        /*
        AudioFormat format = aui.getFormat();
        long audioFrameLength = file.length();
        int frameSize = format.getFrameSize();
        float frameRate = format.getFrameRate();
        float durationInSeconds = (audioFrameLength / (frameSize * frameRate));
        out.println("Audio File Length " + audioFrameLength);
        out.println("Frame Size " + frameSize);
        out.println("Frame Rate " + frameRate);
        out.println("Duration " + durationInSeconds);
         */
    }

    private static void Write(DataInputStream dis, FileInputStream fs) throws IOException {
        byte[] headerData = new byte[0xFF8];
        dis.read(headerData);

        int lengthTotal = dis.readInt();
        System.out.println("Length of After == " + lengthTotal);
        dis.readInt();

        byte[] data = new byte[dis.available()];

        dis.readFully(data);
        dis.close();
        dis = null;
        fs.close();
        fs = null;

        fs = new FileInputStream("./res/continue.aac");
        dis = new DataInputStream(fs);

        dis.skipBytes(0xFF8);

        int length = dis.readInt();
        System.out.println("Length of Ahead == " + length);
        lengthTotal = lengthTotal + length - 8;
        System.out.println("Total Length== " + lengthTotal);
        dis.readInt();
        byte[] newData = new byte[dis.available()];
        dis.read(newData);

        FileOutputStream fos = new FileOutputStream("./res/combine.aac");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.write(headerData);
        dos.writeInt(lengthTotal);
        dos.writeBytes("mdat");
        dos.write(data);
        dos.write(newData);
    }

    private static void Writer(File fac) throws IOException {
        FileInputStream fs = new FileInputStream(fac);
        DataInputStream dis = new DataInputStream(fs);

        byte[] headerData = new byte[0xFF8];
        dis.read(headerData);

        int lengthTotal = dis.readInt();
        System.out.println("Length of After == " + lengthTotal);
        dis.readInt();

        byte[] data = new byte[dis.available()];

        dis.readFully(data);
        dis.close();
        dis = null;
        fs.close();
        fs = null;

        fs = new FileInputStream("./res/continue.aac");
        dis = new DataInputStream(fs);

        dis.skipBytes(0xFF8);

        int length = dis.readInt();
        System.out.println("Length of Ahead == " + length);
        lengthTotal = lengthTotal + length - 8;
        System.out.println("Total Length== " + lengthTotal);
        dis.readInt();
        byte[] newData = new byte[dis.available()];
        dis.read(newData);

        FileOutputStream fos = new FileOutputStream("./res/combine.aac");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.write(headerData);
        dos.writeInt(lengthTotal);
        dos.writeBytes("mdat");
        dos.write(data);
        dos.write(newData);
    }
}
