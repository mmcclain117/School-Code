
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Master
 */
public class Forgoten {

    public static void main(String[] args) throws Exception {
        WriteBitmap();
        WritePlatform();
        WriteResources();
        WriteRook();
        WriteRoundRobin();
    }

    public static void WritePlatform() throws Exception {
        FileWriter fw = new FileWriter("platform.dat");
        fw.write("3\n"
                + "1 5\n"
                + "x>..x\n"
                + "3 3\n"
                + "x>v\n"
                + "xv<\n"
                + "^<x\n"
                + "7 7\n"
                + "x>....v\n"
                + "xv.>.v.\n"
                + "...^...\n"
                + "...x..<\n"
                + "...>..v\n"
                + "...^.<.\n"
                + ".>..x.x");
        fw.flush();
        fw.close();
    }

    public static void WriteBitmap() throws Exception {
        FileWriter fw = new FileWriter("bitmap.dat");
        fw.write("5 24\n"
                + "11001001000001111111011001000110 \n"
                + "00101000100110111110100011010111 \n"
                + "10011110101110000100001100101100 \n"
                + "10110101110101010111110100000110 \n"
                + "00110110110111000010001100110101");
        fw.flush();
        fw.close();
    }

    public static void WriteResources() throws Exception {
        FileWriter fw = new FileWriter("resources.dat");
        fw.write("2\n"
                + "32 3\n"
                + "22 10 5\n"
                + "9 13 1\n"
                + "1 12 2\n"
                + "640 4\n"
                + "630 0 60\n"
                + "630 60 60\n"
                + "630 120 60\n"
                + "11 59 2");
        fw.flush();
        fw.close();
    }

    public static void WriteRook() throws IOException {
        FileWriter fw = new FileWriter("rook.dat");
        fw.write("3\n"
                + "2 2 1\n"
                + "0 0\n"
                + "2 2 2\n"
                + "0 0\n"
                + "1 0\n"
                + "3 3 1\n"
                + "1 1");
        fw.flush();
        fw.close();
    }

    public static void WriteRoundRobin() throws IOException {
        FileWriter fw = new FileWriter("roundrobin.dat");
        fw.write("3\n"
                + "3 3\n"
                + "University of Texas\n"
                + "Texas A&M\n"
                + "Rice University\n"
                + "1 v 3\n"
                + "3 v 2\n"
                + "2 v 1\n"
                + "4 5\n"
                + "Harvard\n"
                + "Princeton\n"
                + "Cornell\n"
                + "Dartmouth\n"
                + "1 v 2\n"
                + "3 v 1\n"
                + "4 v 3\n"
                + "2 v 1\n"
                + "1 v 4\n"
                + "1 1\n"
                + "Lonely Guy\n"
                + "1 v 1");
        fw.flush();
        fw.close();
    }
}
