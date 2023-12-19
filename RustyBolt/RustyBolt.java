import java.util.Objects;

public class RustyBolt extends Bolt implements Marketable{
    private final int reduction;
    public RustyBolt(String type, int price, int reduction) throws IllegalArgumentException{
        super(type, price);
        if(reduction > 100 || reduction < 0)
            throw new IllegalArgumentException("Illegal Argument");
        this.reduction = reduction;
    }

    @Override
    public int getPrice(){
        return super.getPrice() - super.getPrice()*(reduction/100);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.getType());
    }

    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(!(other instanceof RustyBolt))
            return false;
        RustyBolt temp = (RustyBolt) other;
        return temp.hashCode() == other.hashCode();
    }
}

