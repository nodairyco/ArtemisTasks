package pgdp.collections;

public class Checkout {
    private Queue<PenguinCostumer> penguinCostumers;
    private Queue<FishyProduct> toCheckout;
    private Queue<FishyProduct> afterCheckout;
    public Checkout(){
        penguinCostumers = new LinkedQueue<>();
        toCheckout = new LinkedQueue<>();
        afterCheckout = new LinkedQueue<>();
    }
    public void serveNextCostumer(){
        if(penguinCostumers == null){
            return;
        }
        LinkedQueue<FishyProduct> temp =(LinkedQueue<FishyProduct>) toCheckout;
        int price = 0;
        for(List<FishyProduct> i = temp.getFirst(); i != null; i = i.getNext()){
            price += i.getInfo().getPrice();
        }
        PenguinCostumer costumerToServe = penguinCostumers.dequeue();
        costumerToServe.placeAllProductsOnBand(toCheckout);
        costumerToServe.takeAllProductsFromBand(afterCheckout);
        costumerToServe.pay(price);
    }
    public int queueLength(){
        return penguinCostumers.size();
    }
    public Queue<PenguinCostumer> getQueue(){
        return penguinCostumers;
    }
    public Queue<FishyProduct> getBandBeforeCashier(){
        return toCheckout;
    }
    public Queue<FishyProduct> getBandAfterCashier(){
        return afterCheckout;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "penguinCostumers=" + penguinCostumers +
                ", toCheckout=" + toCheckout +
                ", afterCheckout=" + afterCheckout +
                '}';
    }
}

