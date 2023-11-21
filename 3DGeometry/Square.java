public class Square extends BaseArea{
    private double length;
    public Square(double length) {
        this.length = length;
    }
    @Override
    public Square toSquare() {
        return new Square(length);
    }
    @Override
    public double circumference() {
        return this.length*4;
    }
    @Override
    public double area() {
        return Math.pow(this.length, 2);
    }
    @Override
    public String toString() {
        return "Square: {Side's Length: " + this.length + super.toString() +"}";
    }
    @Override
    public boolean isSquare() {
        return true;
    }
    public double getLength() {
        return this.length;
    }
    public void setLength(double length) {
        this.length = length;
    }
}
