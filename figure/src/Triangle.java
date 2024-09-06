public final class Triangle extends Figure{
    private double A;
    private double B;
    private double C;
    public Triangle(double x, double y, double A, double B, double C) {
        super(x, y);
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public double area() {
        return (B*C)/2;
    }
}
