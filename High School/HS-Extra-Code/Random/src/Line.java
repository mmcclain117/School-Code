
/**
 *
 * @author x45clamibot
 */
import java.util.*;

public class Line {

    public static void main(String args[]) {
        //A=2
        //B=5
        //C=3
        //Ax+By+C=0
        //Ax+By=-C
        //Ax=-By-C
        //A=-By-C/x

        //By = ((A + C) / X)
        // B = ((5) / X) / Y
        // 5 = (( 5 ) / X / Y
        //x=-By-C/A
        //By=-Ax-C
        //B=-Ax-C/y
        //y=-Ax-C/B
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Value Of Integer A");
        int a = in.nextInt();
        System.out.println("Enter Value Of Integer B");
        int b = in.nextInt();
        System.out.println("Enter Value Of Integer C");
        int c = in.nextInt();
        int Ax = -b - c;
        int By = -Ax - c;
        int x = (-By - c) / a;
        int y = (-Ax - c) / b;
        System.out.println("The Coordinates Of The Point Are: (" + x + "," + y + ")");
    }
}
