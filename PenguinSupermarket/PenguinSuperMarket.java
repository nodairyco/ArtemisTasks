package pgdp.collections;

public class PenguinSuperMarket {
    private Checkout[] checkouts;
    public PenguinSuperMarket(int checkoutAmount){
        if(checkoutAmount <= 0){
            ExceptionUtil.illegalArgument("Number cannot be lower than 0");
        }
        checkouts = new Checkout[checkoutAmount];
        for(int i = 0; i < checkoutAmount; i ++){
            checkouts[i] = new Checkout();
        }
    }
    public Checkout getCheckOutWithSmallestQueue(){
        Checkout temp = new Checkout();
        for(Checkout i : checkouts){
            if(i.queueLength() < temp.queueLength()){
                temp = i;
            }
        }
        return temp;
    }
    public void closeCheckout(int index){
        if(checkouts[index] == null){
            ExceptionUtil.unsupportedOperation("Checkout doesn't exist");
        }
        if(checkouts.length == 1){
            ExceptionUtil.unsupportedOperation("Can't close the last checkout");
        }
        Checkout toBeClosed = checkouts[index];
        Checkout[] afterClosing = new Checkout[checkouts.length - 1];
        int bIndex = 0;
        for (int i = 0; i< checkouts.length; i++){
            if(i == index) continue;
            afterClosing[bIndex++] = checkouts[i];
        }
        checkouts = afterClosing;
        Stack<PenguinCostumer> afterMoving = new LinkedStack<>();
        StackConnector<PenguinCostumer> moving = new StackConnector<>(afterMoving);
        QueueConnector<PenguinCostumer> toMove = new QueueConnector<>(toBeClosed.getQueue());
        DataStructureLink<PenguinCostumer> actuallyMoving = new DataStructureLink<>(toMove, moving);
        actuallyMoving.moveAllFromAToB();
        while(actuallyMoving.getSecond().hasNextElement()){
            afterMoving.pop().goToCheckOut(this);
        }
    }
    public void serveCostumer(){
        for(Checkout i : checkouts){
            if(i.getQueue() != null){
                i.serveNextCostumer();
            }
        }
    }
}
