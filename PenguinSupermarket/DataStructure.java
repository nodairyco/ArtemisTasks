package pgdp.collections;

public interface DataStructure {
    public int size();
    default boolean isEmpty(){
        return false;
    }
}
