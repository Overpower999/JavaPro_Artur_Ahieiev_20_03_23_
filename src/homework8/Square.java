package homework8;

public class Square implements Shape {
    private double side = 0;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String getName() {
        return "Square";
    }
}

