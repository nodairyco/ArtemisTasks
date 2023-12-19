import java.util.Objects;

public class Bolt implements Marketable{
    private final String type;
    private final int price;
    public Bolt(String type, int price)throws IllegalArgumentException{
        if(type == null || price < 0)
            throw new IllegalArgumentException("Illegal argument");
        this.type = type;
        this.price = price;
    }

    @Override
    public int hashCode(){
        return Objects.hash(type);
    }

    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(!(other instanceof Bolt))
            return false;
        Bolt temp = (Bolt) other;
        return temp.hashCode() == this.hashCode();
    }

    public String getType(){
        return type;
    }

    public int getPrice(){
        return price;
    }
}
