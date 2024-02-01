package task1;

public class Hunting implements Runnable {
    private Ocean ocean;
    private int speed;
    public Hunting(Ocean ocean, int speed){
        this.ocean = ocean;
        this.speed = speed;
    }

    public synchronized void run(){

            ocean.hunt(speed);
            notifyAll();
            while(!Thread.currentThread().isInterrupted()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }

    public static void main(String[] args) {
        Ocean ocean = new Ocean(
                Fish.breed(10, 0),
                Fish.breed(5,3),
                Fish.breed(42,1),
                Fish.breed(10,7)
        );
        Thread ping = new Thread(new Hunting(ocean, 15));
        Thread pong = new Thread(new Hunting(ocean, 20));
        Thread pung = new Thread(new Hunting(ocean, 25));
        ping.start();
        pong.start();
        pung.start();
        ping.interrupt();
        pong.interrupt();
        pung.interrupt();

        try{
            ping.join();
            pong.join();
            pung.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
