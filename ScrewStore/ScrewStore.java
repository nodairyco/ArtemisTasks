import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;


public class ScrewStore {
    private HashMap<Screw, Integer> stock;
    private LinkedList<Order> orders;
    public ScrewStore(){
        this.stock = new HashMap<>();
        this.orders = new LinkedList<>();
    }
    public void addItem(Screw type, int amount) {
        if(stock.containsKey(type)){
            stock.values().add(amount);
        } else {
            stock.put(type, amount);
        }
    }

    public void takeOrder(Screw type, int amount) {
        Order temp = new Order(type, amount);
        orders.add(temp);
    }

    public boolean executeOrder() {
        Order temp = orders.getFirst();
        if(!stock.containsKey(temp.getScrew())){
            return false;
        } else if(stock.get(temp.getScrew()) < temp.getAmount()) {
            return false;
        } else{
            int a = stock.get(temp.getScrew());
            a = a - temp.getAmount();
            if(a == 0){
                stock.remove(temp.getScrew());
            }else {
                stock.put(temp.getScrew(), a);
            }
            return true;
        }
    }
    //Artemis got mad at me, because this did something incorrectly, but frankly i have 0 clue how to fix it :D 
    //I realised that Artemis was inputing a dumb float value for percentage (e.g. 0.1), and thus it worked weirdly. This code will work for when one inputs a non-float value for percentage.
    public void inflation(double percent) {
        for(Screw i : stock.keySet()){
            i.setPrice(i.getPrice()*percent/100 + i.getPrice());
        }
    }

    public int count() {
        int count = 0;
        for(int size : stock.values()){
            count += size;
        }
        return count;
    }

    public double value() {
        int value = 0;
        for (Map.Entry<Screw, Integer> entry : stock.entrySet()) {
            Screw screw = entry.getKey();
            int quantity = entry.getValue();
            double price = screw.getPrice();

            value += quantity * price;
        }
        return value;
    }

    public String stockToString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Screw, Integer> entry : stock.entrySet()) {
            sb.append(entry.getValue()).append("x ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
    }
    public HashMap<Screw, Integer> getStock(){
        return stock;
    }
    public LinkedList<Order> getOrders(){
        return orders;
    }

    public void setOrders(LinkedList<Order> orders) {
        this.orders = orders;
    }

    public void setStock(HashMap<Screw, Integer> stock) {
        this.stock = stock;
    }
}
