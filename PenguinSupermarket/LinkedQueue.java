package pgdp.collections;

public class LinkedQueue<T> implements Queue<T>{
    private List<T> first, last;
    public LinkedQueue(T element){
        first = new List<>(element);
        last = first;
    }
    public void enqueue(T element){
        if(first == null){
            first = new List<>(element);
            last = first;
        } else{
            last.setNext(new List<>(element));
            last = last.getNext();
        }
    }
    public T dequeue(){
        T result = first.getInfo();
        if(last == first){
            last = null;
        }
        first = first.getNext();
        return result;
    }
    public int size(){
        int result = 0;
        for(List<T> i = first; i != null; i = i.getNext()){
            result ++;
        }
        return result;
    }
    @Override
    public boolean isEmpty(){
        return first == null;
    }
    public List<T> getFirst(){
        return first;
    }
    public List<T> getLast(){
        return last;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(List<T> i = first; i != null; i = i.getNext()){
            if(i.getNext() != null){
                sb.append(i.getInfo()).append(", ");
            } else{
                sb.append(i.getInfo());
            }
        }
        return sb.append("]").toString();
    }
}
