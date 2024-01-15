package PeguinElections;
import java.util.*;
public class PenguinVoters {
    private List<Penguin> voters;
    public PenguinVoters(){
        voters = new LinkedList<>();
    }

    public synchronized void register(Penguin p){
        voters.add(p);
        notifyAll();
    }

    public synchronized Penguin admit(){
        while(voters.isEmpty()){
            try{
                wait();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        Random random = new Random();
        int rand = random.nextInt(voters.size());
        Penguin p = voters.remove(rand);
        return p;
    }
}
