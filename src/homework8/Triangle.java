package homework8;

public class Triangle implements Shape {
    private double base = 0;
    private double height = 0;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }
}
