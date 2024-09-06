public final class Circle extends Figure {
    private double radios;

    public Circle(double x, double y, double radios) {
        super(x, y);
        this.radios = radios;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radios, 2);
    }
}
