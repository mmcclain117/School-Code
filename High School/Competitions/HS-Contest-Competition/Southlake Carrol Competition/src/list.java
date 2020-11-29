
import java.io.*;
import static java.lang.System.out;
import java.util.*;

/**
 *
 * @author Master Ward
 */
public class list {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("list.dat"));
        int a = scan.nextInt();
        scan.nextLine();
        for (int p = 0; p < a; p++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
//            out.println(x + " "+ y);
            double sum = 0;
            HashMap<String, Double> cos = new HashMap();
            HashMap<String, Double> num = new HashMap();
            scan.nextLine();
            for (int r = 0; r < x; ++r) {
                String as = scan.nextLine();
                String yt[] = as.split("[,]+");
                double d = 0;
                String re = yt[0];
                double numb = Double.parseDouble(yt[1]);
                double pri = Double.parseDouble(yt[2]);
                d = (pri / numb);
                cos.put(re, pri);
                num.put(re, numb);
            }
            for (int r = 0; r < y; ++r) {
                String as = scan.nextLine().trim();
                String yt[] = as.split("[,]+");
                String re = yt[0].trim();
                int number = (int) (Math.ceil(num.get(re)));
                int in = (int) (Double.parseDouble(yt[1]));
//                out.println(number + " " + in + " " + number / in + " " + in / number);
                int cou = in / number;
                cou += in % number == 0 ? 0 : 1;
                sum += cos.get(re) * cou;
//                double t = Double.parseDouble(yt[1]);
////                out.println(hm.get(re));
////                out.println(t );
//                out.println(re);
//                out.println(number);
//                double w = hm.get(re);
//                out.println(w * t);
//                sum += w * t;
////                out.println(sum);
            }
//            out.println(hm.toString());
//            sum *= 2;
            out.print("Joe's trip to the store costs him $ ");
            out.printf("%.2f", (sum * 1.0625));
//            out.println(sum);
            out.println();
//            out.println(sum * .0625);
        }
    }
}
