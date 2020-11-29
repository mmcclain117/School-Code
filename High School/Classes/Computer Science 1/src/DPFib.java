
import static java.lang.System.out;

/**
 * Dynamically Programmed Fibbonacci
 *
 * @author Master
 */
public class DPFib {

    public static void main(String[] args) {
        int n = 9;
        int last = 1;
        int las = 1;
        int answer = 1;
        for (int a = 2; a < n; a++) {
            las = last;
            last = answer;
            answer = las + last;
        }
        out.println(answer);
    }
}
