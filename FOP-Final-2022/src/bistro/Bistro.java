package bistro;

public class Bistro{
    private int seats;
    private Thread order, meal, waiter;
    public Bistro(int n){
        Runnable wait = () -> {
            try {
                while (!waiter.isInterrupted()) {
                    serve();
                }
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        };
        waiter = new Thread(wait);
        seats = n;
        waiter.start();
    }

    public synchronized void dine(int price){
        while(seats <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        seats--;
        while(order != null){
            try {
                wait();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        order = Thread.currentThread();
        System.out.println("Guest " + Thread.currentThread().getName() + " orders for " + price + " lari");
        notify();

        while(meal == null){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        meal = null;
        System.out.println("Guest " + Thread.currentThread().getName() + " eats...");

        seats++;
        notifyAll();
    }

    public synchronized void serve() throws InterruptedException{
        while(order == null)
            wait();
        System.out.println("Enjoy!");
        Thread thread = order;
        order = null;
        while(meal != null)
            wait();
        meal = thread;
        notifyAll();
    }

    public void shutDown(){
        waiter.interrupt();
    }
}


