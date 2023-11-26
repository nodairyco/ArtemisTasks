package pgdp.collections;

public class StackConnector<T> implements DataStructureConnector<T>{
    private LinkedStack<T> linkedStack;
    public StackConnector(LinkedStack<T> linkedStack){
        this.linkedStack = linkedStack;
    }
    @Override
    public boolean hasNextElement(){
        return !linkedStack.isEmpty();
    }
    @Override
    public void addElement(T element){
        linkedStack.push(element);
    }
    @Override
    public T removeNextElement(){
        return linkedStack.pop();
    }
    public String toString(){
        return linkedStack.toString();
    }
    public LinkedStack<T> getLinkedStack(){
        return linkedStack;
    }
}
