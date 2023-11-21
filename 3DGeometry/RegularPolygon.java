public class RegularPolygon extends BaseArea{
    private int n;
    private double length;
    public RegularPolygon(int numberOfSides, double length) {
        this.n = numberOfSides;
        this.length = length;
    }
    @Override
    public double circumference() {
        return length*n;
    }
    @Override
    public double area() {
        double aDouble = n*Math.pow(length,2);
        double divisor = 4*Math.tan(Math.PI/n);
        return aDouble/divisor;
    }
    @Override
    public Square toSquare() {
        if (this.n == 4) {
            return new Square(this.length);
        } else {
            return null;
        }
    }
    @Override
    public boolean isSquare() {
        return this.n == 4;
    }

    @Override
    public String toString() {
        return "Regular polygon: {Number of sides" + this.n + ", The length of sides" + this.length + "}";
    }

    public double getLength() {
        return length;
    }
    public int getNumberOfSides() {
        return n;
    }
    public void setNumberOfSides(int n) {
        this.n = n;
    }
    public void setLength(double length) {
        this.length = length;
    }
}
