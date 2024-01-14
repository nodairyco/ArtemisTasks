public class SwimmingPool {
    private Lane[] lanes;
    private SwimWaitingQueue swimmers;
    private boolean isStopped = false;
    public SwimmingPool(int n){
        lanes = new Lane[n];
        swimmers = new SwimWaitingQueue();
        for (int i = 0; i < n; i++) {
            lanes[i] = new Lane(swimmers);
            lanes[i].start();
        }
    }

    public synchronized void reserve(Runnable task) throws Exception{
        if(!isStopped){
            swimmers.enqueue(task);
            return;
        }
        throw new IllegalStateException("Swimming pool is stopped");
    }

    public synchronized void stop(){
        isStopped = true;
        for(Lane lane : lanes){
            lane.doStop();
        }
    }
}
