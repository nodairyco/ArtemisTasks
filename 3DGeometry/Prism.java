public class Prism {
    private BaseArea base;
    private double height;

    public Prism(BaseArea base,double height) {
        this.base = base;
        this.height = height;
    }
    public double surface() {
        return base.area()*2 + base.circumference()*this.height;
    }
    public double volume() {
        return base.area()*height;
    }
    public boolean isCube() {
        return base.isSquare() && base.toSquare() != null && height == base.toSquare().getLength();
    }
    public BaseArea getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
