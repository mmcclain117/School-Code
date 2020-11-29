
import java.io.File;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Adam {

    public static void main(String args[]) throws Exception {
        Scanner f = new Scanner(new File("adam.dat"));
        BiFunction<Integer, Integer, Boolean> match
                = (Integer a, Integer b) -> a.compareTo(b) > 0;
        while (f.hasNext()) {
            Integer x = f.nextInt();
            Integer y = f.nextInt();
            System.out.println(match.apply(x, y));
        }
    }
}
