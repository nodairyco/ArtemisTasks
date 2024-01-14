import java.util.*;

public class SwimWaitingQueue {
    private List<Runnable> queue = new LinkedList<>();
    public synchronized Runnable assign(){
        while(queue.isEmpty()){
            try{
                wait();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }


       return queue.removeFirst();
    }

    public synchronized void enqueue(Runnable r){
        queue.add(r);
        notifyAll();
    }
}
