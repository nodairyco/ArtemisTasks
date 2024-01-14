public class Lane extends Thread{
    private SwimWaitingQueue queue;
    public Lane(SwimWaitingQueue bw){
        queue = bw;
    }

    @Override
    public void run(){
        Runnable r = null;
        while(!interrupted()){
            try {
                r = queue.assign();
                r.run();
            } catch (RuntimeException e){
                //ignore
            }
        }
    }

    public synchronized void doStop(){
        this.interrupt();
    }
}
