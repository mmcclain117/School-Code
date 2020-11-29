
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 *
 * @author Master
 */
public class PaliNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("pal.txt"));
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int sum = a;
            boolean cont = true;
            int con = 0;
            int cur = a;
            int tu= 0;
            while (cont && con < 5) {
                
                con++;
            }
        }
    }
    public static int rev(int a ){
        String s = a + "";
        ArrayList p = new ArrayList();
        char ch[] = s.toCharArray();
        for(char c: ch) {
            
        }
        Collections.reverse(p);
        String fin = "";
        for(int i =0;i < p.size(); i++){
            
        
        fin+= p.get(i) + "";
        }
        return Integer.parseInt(fin);
    }
}
