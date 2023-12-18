public class Mechanic extends Customer{
    private int reduction;
    public Mechanic(String name, int money, int reduction){
        super(name, money);
        if(reduction > 100)
            throw new IllegalArgumentException("Reduction percentage can't be more than 1");
        this.reduction = reduction;
    }

    @Override
    public boolean buyItemsFromCart(){
        int moneyToBePaidByMechanic = super.getCart().calculatePrice() -
                (super.getCart().calculatePrice() * (reduction/100));
        if(super.getMoney() < moneyToBePaidByMechanic)
            return false;
        super.setMoney(super.getMoney() - moneyToBePaidByMechanic);
        super.getCart().checkout(moneyToBePaidByMechanic);
        return true;
    }
}
