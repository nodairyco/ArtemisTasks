public abstract class BaseArea {
    public abstract double circumference();
    public abstract double area();
    public String toString() {
        return "circumference: " + circumference() +"; area: " + area();
    }
    public boolean isSquare() {
        return false;
    }
    public Square toSquare(){
        return null;
    }
}
