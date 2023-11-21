import java.util.Objects;

public class Screw {
    private final double diameter;
    private final double length;
    private double price;
    private final ScrewDrive head;

    public Screw(ScrewDrive head,double diameter, double length, double price) {
        this.head = head;
        this.diameter = diameter;
        this.length = length;
        this.price = price;
    }
    @Override
    public int hashCode(){
        return Objects.hash(head, length);
    }
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        } else if(other == null || other.getClass() != this.getClass()){
            return false;
        } else {
            Screw temp = (Screw) other;

            return this.getHead().toString().equals(temp.getHead().toString());
        }
    }
    public ScrewDrive getHead() {
        return head;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
