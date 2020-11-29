
/**
 *
 * @author Master
 */
class Circle {

    public double radius;

    public Circle(double r) {
        radius = r;
    }

    public double area() {
        double a = Math.PI * radius * 2;
        return a;
    }

    public double circumference() {
        double c = 2 * Math.PI * radius;
        return c;
    }

    public double diameter() {
        double d = radius * 2;
        return d;
    }
}
