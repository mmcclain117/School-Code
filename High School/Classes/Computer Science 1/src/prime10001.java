
/**
 *
 * @author Master
 */
public class prime10001 {

    public static void main(String[] args) {

        int number = 3;
        int answer = 0;
        int count = 1;
        while (count < 10001) {
            if (getPrime(number)) {
                count++;
                answer = number;
            }
            number++;
        }
        System.out.println(answer);
    }

    public static boolean getPrime(int i) {
        long check = i;
        for (int k = 2; k <= Math.sqrt(check); k++) {
            if (check % k == 0) {
                return false;
            }
        }
        return true;
    }
}
