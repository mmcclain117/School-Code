
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.imageio.ImageIO;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Master
 */
public class encoding {

    public static void main(String[] args) throws Exception {
        FileWriter f = new FileWriter(new File("test.txt"));
        f.write("This is the things that i am encoding\ncan it be long\n"
                + "who knows\ni just know that htis works");
        f.flush();
        f.close();
        Scanner scan = new Scanner(new File("test.txt"));
        String fin = "";
        while (scan.hasNext()) {
            fin += scan.nextLine() + "\n";
        }
        byte[] b = fin.getBytes();
        System.out.println(Arrays.toString(b));
        BASE64Encoder encode = new BASE64Encoder();
        BASE64Decoder decode = new BASE64Decoder();
        String x = encode.encode(b);
        FileWriter fw = new FileWriter(new File("en.txt"));
        fw.write(x);
        fw.flush();
        fw.close();
        byte[] db = decode.decodeBuffer(x); // Decoded
        String end = "";
        for (byte bx : db) {
            end += (char) bx;
        }
        System.out.println(end);

//        String y = Arrays.toString(decode.decodeBuffer(x));
//        System.out.println(y);
    }

    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }
}
