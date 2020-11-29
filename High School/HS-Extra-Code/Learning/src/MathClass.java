
import static java.lang.System.out;
import java.util.Random;

/**
 *
 * @author Master
 */
public class MathClass {

    public static void main(String[] args) {
        Random r = new Random(10);
        double mast = 12.5;
        out.println("Number: " + mast);
        out.println("Returns Double");
        Double(mast);
        out.println("Returns Int");
        Int(mast);
        out.println("Returns Anything");
        Any(mast);
        out.println();
        NotUsed(mast);
    }

    private static void Double(double mast) {
        rounding(mast);
        triginomics(mast);
        root(mast);
        next(mast);
        logarithem(mast);
        other(mast);
        double a = Math.E;
        double b = Math.PI;
//        double d = mast;
        out.println("Math.E || e: " + a);
        out.println("Math.PI || pi: " + b);
    }

    public static void rounding(double d) {
//        out.println("Rounding: " + d);
        double j = Math.ceil(d); // Round up
        double p = Math.floor(d); // Round down
        double ab = Math.rint(d);
        out.println("Round Up: " + j);
        out.println("Round Down: " + p);
        out.println("Round to closest Double: " + ab); // Closest Integer to a double
//        out.println();
    }

    private static void triginomics(double d) {
//        out.println("Trig: " + d);
        double l = Math.cos(d); // Cosine
        double ae = Math.sin(d); // Sine
        double ah = Math.tan(d); // Tangent
        out.println("Cosine: " + l);
        out.println("Sine: " + ae);
        out.println("Tangent: " + ah);
//        out.println(l + " " + ae + " " + ah);
        double e = Math.acos(d); // Arc Cosine  0.0 - PI
        out.println("Arc Cosine: " + e);
        double f = Math.asin(d); // Arc Sine   -PI/2 - PI/2
        out.println("Arc Sine: " + f);
        double g = Math.atan(d); // Arc Tangent   -PI/2 - PI/2
        out.println("Arc Tangent: " + g);
//        out.println(e + " " + f + " " + g);
        double m = Math.cosh(d); // Hyperbolic Cosine
        double af = Math.sinh(d); // Hyperbolic Sine
        double ai = Math.tanh(d); // Hyperbolic Tangent
        out.println("Hyperbolic Cosine: " + m);
        out.println("Hyperbolic Sine: " + af);
        out.println("Hyperbolic Tangent: " + ai);
//        out.println(m + " " + af + " " + ai);
        double h = Math.atan2(d, d);
        out.println("Theta from (x,y) to (r, Theta): " + h);
//        out.println();
    }

    private static void root(double d) {
        out.println("Root: " + d);
        double ag = Math.sqrt(d); // Square root
        double i = Math.cbrt(d); // Cube root
        out.println("Square Root: " + ag);
        out.println("Cube Root: " + i);
//        out.println();
    }

    private static void next(double d) {
        out.println("Next");
        double w = Math.nextAfter(d, d);
        double x = Math.nextDown(d);
        double y = Math.nextUp(d);
        out.println("Next After: " + w);
        out.println("Next Down: " + x);
        out.println("Next Up: " + y);
    }

    private static void logarithem(double d) {
        double r = Math.log(d);
        out.println("Logarithem Base e: " + r);
        double s = Math.log10(d);
        out.println("Logarithem Base 10: " + s);
        double t = Math.log1p(d);
        out.println("Logarithem Sum 1: " + t); // natural logarithm of the sum of the argument and 1
    }

    private static void other(double d) {
        out.println("Other");
        double n = Math.exp(d);
        out.println("Eulers e^d: " + n);
        double o = Math.expm1(d);
        out.println("e^d - 1: " + o);
        double q = Math.hypot(d, d); // Hypotonuse
        out.println("Sqrt(x ^2 + y^2): " + q);
        double z = Math.pow(2, d);
        out.println("2 ^ d: " + z); // To the power
        double aa = Math.random();
        out.println("0 <= Random < 1: " + aa);
        double ac = Math.scalb(d, 10); // (double d , int scalefactor)
        out.println("d * 2 ^ 10(SF): " + ac); // SF = scalefactor
        double ad = Math.signum(d); // if(d == 0){0} if(d > 0){1.0} else if(d < 0) {-1.0}
        out.println("Signum: " + ad);
        double aj = Math.toDegrees(d);
        out.println("Radians to Degrees: " + aj);
        double ak = Math.toRadians(d);
        out.println("Degrees to Radians: " + ak);
    }

    private static void Int(double d) {
        int f = Math.getExponent(d);
        int l = Math.round(((int) d));
        out.println("Get exponent: " + f);
        out.println("Round: " + l); // Rounding up to closest int 
    }

    private static void Any(double d) {
        double a = Math.abs(d); // Returns the absolute
        int b = Math.max(15, (int) d); // Returns greater of 2
        int c = Math.min((int) d, 15); // Returns lesser of 2
        out.println("Any: " + d);
        out.println("Absolute: " + a);
        out.println("Max 15: " + b);
        out.println("Min 15: " + c);
    }

    private static void NotUsed(double d) {
        out.println("NotUsed");
//        double c = Math.IEEEremainder(10.0, 11.0);
//        double k = Math.copySign(d, -1);
        out.println("Copy Sign: Copies sign I think");
        out.println("IEEEremainder:  Gets remainder two doubles by the IEEE 754 standard");
        out.println("ULP: Have no clue");
        out.println("Anything that is Exactly: Just use the operations");
    }
}
