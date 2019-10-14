package shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return 3.14159*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*3.14159*radius;
    }
}
