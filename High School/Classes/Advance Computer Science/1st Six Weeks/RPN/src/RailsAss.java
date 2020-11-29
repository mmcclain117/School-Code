
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RailsAss {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("rails.txt"));
        ArrayList<String> uu = new ArrayList<>();
        while (scan.hasNext()) {
            String ty = scan.nextLine();
            uu.add(ty);
        }
        int num = 0;
        while (!uu.isEmpty()) {
            String temp = uu.remove(0);
            if (temp.length() == 1) {
                num = Integer.parseInt(temp);
                if (temp.equals("0")) {
                    out.println();
                    if (uu.get(0).equals("0")) {
                        break;
                    }
                }
            } else {
                String yup[] = temp.split("\\s+");
                ArrayList<Integer> number = new ArrayList<>();
                int arr[] = new int[num];
                ArrayList<Integer> ar = new ArrayList();
                for (int i = 0; i < num; i++) {
                    number.add(i + 1);
                    arr[i] = Integer.parseInt(yup[i]);
                    ar.add(arr[i]);
                }
                ArrayStack k = new ArrayStack();
                while (!(ar.isEmpty() || number.isEmpty())) {
                    if (ar.get(0).equals(number.get(0))) {
                        ar.remove(0);
                        number.remove(0);
                        while ((k.size() > 0)) {
                            if (ar.get(0).equals((int) k.peek())) {
                                k.pop();
                                ar.remove(0);
                            } else {
                                break;
                            }
                        }
                    } else {
                        k.push(number.remove(0));
                        while ((k.size() >= 0 || ar.size() >= 0)) {
                            if ((double) ar.get(0) == k.peek()) {
                                k.pop();
                                ar.remove(0);
                            } else {
                                break;
                            }
                        }
                    }
                }
                boolean works = ar.isEmpty();
                if (works) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            }
        }
    }
}
