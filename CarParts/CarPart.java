import java.util.Objects;

public class CarPart implements MarketItem{
    private final String name;
    private final int price;
    public CarPart(String name, int price){
        if(name == null || price <= 0)
            throw new IllegalArgumentException();
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(!(other instanceof CarPart))
            return false;
        CarPart temp = (CarPart) other;
        return temp.hashCode() == this.hashCode();
    }
    public int getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }
}
