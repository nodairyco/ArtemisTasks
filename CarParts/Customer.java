public class Customer {
    private final String name;
    private int money;
    private Cart<MarketItem> cart;
    public Customer(String name, int money){
        if(name == null || money<0)
            throw new IllegalArgumentException("Name can't be null and money has to be >= 0");
        this.name = name;
        this.money = money;
        cart = new Cart<>();
    }

    public void addItemToCart(MarketItem item, int n){
        cart.addItem(item, n);
    }

    public boolean removeItemFromCart(MarketItem item, int n){
        return cart.removeItem(item, n);
    }

    public boolean buyItemsFromCart(){
        if(money < cart.calculatePrice()){
            return false;
        }
        money = cart.checkout(money);
        return true;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Cart<MarketItem> getCart() {
        return cart;
    }

    public void setMoney(int money){
        this.money = money;
    }
}
