
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author Master Ward
 */
public class Main {

    public static ArrayList<String> ar = new ArrayList<>();
    public final static ArrayList<String> fin = new ArrayList<>();
//    public static File f[];
    public static ArrayList<String> temp = new ArrayList<>();
    public static int con = 0;

    public static void main(String[] args) throws IOException {
        String folder = "C:\\Users\\Jacob\\Desktop\\Compare\\R1";
        File f[] = new File(folder).listFiles();
//        ArrayList<String> ar = new ArrayList<>();
//        out.println(Arrays.toString(f));
        for (int c = 0; c < f.length; c++) {
//            out.println("F");
//            list(f[c].getPath() , c);
            ar.add(f[c].getPath());
        }
//        out.println(Arrays.toString(ar.toArray()));
        while (true) {
            ar.addAll(ex());
            if (ar.size() > 100000) {
                break;
            }
//            out.println(fin.size());
//            out.println(Arrays.toString(ar.toArray()));
            /*
             if(con % 100 == 0) {
             out.print((con / 100)+ " ");
             }
             */
        }
        out.println(con);
    }

    /*
     public static String list(String s, int o) {
     //        out.println(1);
     for (int u = o ; u < f.length - 1 ; u++) {
     if (f[u].getPath().contains(".") && !f[u].getPath().contains(".zip")) {
     ar.add(f[u].getPath());
     out.println("add");
     } else {
     out.println("DID it");
     return list(f[u].getPath(), u + 1);
     }
     }
     return null;
     }
     */
    public static ArrayList ex() {
        con++;
////        File f[];
        for (int i = 0; i < ar.size(); i++) {
            String temper = ar.get(i);
////            f = new File(temper).listFiles();
//            if (temper.contains(".") && !(temper.contains(".zip"))) {
            if (temper.contains(".")) {
////                out.println(Arrays.toString(f));
                fin.add(temper);
            } else {
                temp.add(temper);
            }
        }
        ar.clear();
        return temp;
    }
}
