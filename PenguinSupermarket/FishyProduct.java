package pgdp.collections;

public class FishyProduct{
    private final String name;
    private final int price;
    public FishyProduct(String name, int price){
        if(name == null){
            ExceptionUtil.illegalArgument("Name can't be null");
        }
        if(price <= 0) {
            ExceptionUtil.illegalArgument("Price can't be negative or zero");
        }
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return "Name: " + name +", " + "price: " + price + ".";
    }
}
