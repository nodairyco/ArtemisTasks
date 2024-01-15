package PeguinElections;

public class Machine extends Thread{
    private PenguinVoters voters;
    public Machine(PenguinVoters penguinVoters){
        voters = penguinVoters;
    }

    public void run(){
        try{
            Penguin toVote = voters.admit();
            toVote.vote();
        } catch (InterruptedException e){
            return;
        } catch (Exception e){
            //ignore;
        }
    }
}
