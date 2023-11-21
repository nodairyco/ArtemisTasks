public class Rectangle extends BaseArea{
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public Square toSquare() {
        if(width == height) {
            return new Square(height);
        } else {
            return null;
        }
    }
    @Override
    public boolean isSquare() {
        return this.width == this.height;
    }
    @Override
    public double circumference() {
        return (width + height)*2;
    }
    @Override
    public double area() {
        return width*height;
    }

    @Override
    public String toString() {
        return "Rectangle: { Width: " + this.width + ", Height: " + this.height + super.toString() + '}';
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
