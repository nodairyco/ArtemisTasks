package pgdp.collections;

public class PenguinCostumer{
    private final String name;
    private int availableMoney;
    private Stack<FishyProduct> products;
    public PenguinCostumer(String name, int availableMoney){
        this.name = name;
        this.availableMoney = availableMoney;
        this.products = new LinkedStack<>();
    }
    public Stack<FishyProduct> getProducts(){
        return products;
    }
    public String getName(){
        return name;
    }
    public int getMoney(){
        return availableMoney;
    }
    public void addProduct(FishyProduct other){
        products.push(other);
    }
    public void placeAllProductsOnBand(Queue<FishyProduct> band){
        DataStructureConnector<FishyProduct> fishQueue = new QueueConnector<>(band);
        DataStructureConnector<FishyProduct> productsStack = new StackConnector<>(products);
        DataStructureLink<FishyProduct> returnValue = new DataStructureLink<>(productsStack, fishQueue);
        returnValue.moveAllFromAToB();
    }
    public void takeAllProductsFromBand(Queue<FishyProduct> band){
        DataStructureConnector<FishyProduct> first = new QueueConnector<>(band);
        DataStructureConnector<FishyProduct> second = new QueueConnector<>(new LinkedQueue<>(new FishyProduct("hi", 3)));
        DataStructureLink<FishyProduct> comb = new DataStructureLink<>(first, second);
        comb.moveAllFromAToB();
    }
    public void pay(int toPay){
        if(toPay > availableMoney){
            ExceptionUtil.unsupportedOperation("Not enough money to pay the bill");
        }
        else {
            availableMoney = availableMoney - toPay;
        }
    }
    public void goToCheckOut(PenguinSuperMarket coolShop){
        coolShop.getCheckOutWithSmallestQueue().getQueue().enqueue(this);
    }
    public String toString(){
        return "Name: " + name + ", Available Money: " + availableMoney;
    }
}
