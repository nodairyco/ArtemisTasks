package pgdp.collections;

public interface DataStructureConnector<T> {
    default boolean hasNextElement(){
        return true;
    }
    void addElement(T t);
    T removeNextElement();
}
