package pgdp.collections;

public class LinkedStack<T> implements Stack<T> {
    private List<T> linkedStack;
    private List<T> tail;

    public LinkedStack(T firstStackCharacter) {
        linkedStack = new List<>(firstStackCharacter);
        tail = linkedStack;
    }

    public void push(T data) {
        List<T> newNode = new List<>(data);

        if (tail == null) {
            tail = newNode;
        }
        else {
            List<T> temp = tail;
            tail = newNode;
            newNode.setNext(temp);
        }
    }

    public T pop(){
        if (isEmpty()) {
             ExceptionUtil.illegalArgument("List is empty");
        }
        T temp = tail.getInfo();
        tail = tail.getNext();
        return temp;
    }

    public int size() {
        int result = 0;
        for (List<T> i = tail; i != null; i = i.getNext()) {
            result++;
        }
        return result;
    }

    public boolean isEmpty() {
        return tail == null;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(List<T> i = tail; i != null; i = i.getNext()){
            if(i.getNext() !=null) {
                sb.append(i.getInfo()).append(", ");
            }else{
                sb.append(i.getInfo());
            }
        }
        return sb.append("]").toString();
    }
    public List<T> getLinkedStack() {
        return linkedStack;
    }
    public List<T> getTail(){
        return tail;
    }
}

