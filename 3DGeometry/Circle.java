public class Circle extends BaseArea{
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI*Math.pow(this.radius, 2);
    }
    @Override
    public double circumference() {
        return Math.PI*2*this.radius;
    }
    public String toString() {
        return "Circle: { Radius:" + this.radius + "}";
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
