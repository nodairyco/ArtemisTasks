import java.util.*;
public class Cart<T extends MarketItem> {
    private Map<Integer, List<T>> itemsInCart = new HashMap<>();

    public void addItem(T item, int n) {
        if (item == null || n < 0)
            throw new IllegalArgumentException();
        int hashCodeOfItem = item.hashCode();
        if (!(itemsInCart.containsKey(hashCodeOfItem))) {
            List<T> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                temp.add(item);
            }
            itemsInCart.put(hashCodeOfItem, temp);
        } else {
            List<T> temp = itemsInCart.get(hashCodeOfItem);
            for (int i = 0; i < n; i++) {
                temp.add(item);
            }
            itemsInCart.put(hashCodeOfItem, temp);
        }
    }

    public boolean removeItem(T item, int n) {

        if (item == null || n <= 0)
            throw new IllegalArgumentException("Item is null, or n <= 0");
        if (!(itemsInCart.containsKey(item.hashCode())))
            throw new IllegalArgumentException("Item isn't in cart");
        if (n > itemsInCart.get(item.hashCode()).size())
            throw new IllegalArgumentException("n is larger than the number of items");

        List<T> temp = itemsInCart.get(item.hashCode());
        int amountOfCertainItems = 0;

        for(T t : temp) {
            if (item.equals(t))
                amountOfCertainItems += 1;
        }
        if(amountOfCertainItems < n)
            return false;

        if (n == temp.size()) {
            itemsInCart.remove(item.hashCode());
            return true;
        }
        for (int i = 0; i < n; i++) {
            temp.remove(item);
        }
        return true;
    }

    public int calculatePrice() {
        int price = 0;
        for(Map.Entry<Integer, List<T>> i : itemsInCart.entrySet()){
            for(T t : i.getValue()){
                price += t.getPrice();
            }
        }
        return price;
    }

    public int checkout(int money){
        if(money >= calculatePrice()){
            int temp = calculatePrice();
            itemsInCart.clear();
            return money - temp;
        }
        throw new IllegalArgumentException("Not enough money");
    }

    public Map<Integer, List<T>> getItemsInCart() {
        return itemsInCart;
    }
}
