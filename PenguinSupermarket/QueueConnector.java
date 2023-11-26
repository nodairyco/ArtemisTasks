package pgdp.collections;

public class QueueConnector<T> implements DataStructureConnector<T>{
    private LinkedQueue<T> linkedQueue;
    public QueueConnector(LinkedQueue<T> linkedQueue){
        this.linkedQueue = linkedQueue;
    }
    @Override
    public void addElement(T element){
        linkedQueue.enqueue(element);
    }
    @Override
    public T removeNextElement(){
        if(linkedQueue.isEmpty()){
            return null;
        } else{
            return linkedQueue.dequeue();
        }
    }
    public String toString(){
        return linkedQueue.toString();
    }
    @Override
    public boolean hasNextElement(){
        return !linkedQueue.isEmpty();
    }
    public LinkedQueue<T> getLinkedQueue(){
        return linkedQueue;
    }
}
