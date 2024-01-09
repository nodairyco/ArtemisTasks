package indexedtree;

public interface Node<T> {
    int size();
    T get(int index);
    void update(int index, T value);
    Node<T> insert(int index, T value);
    Node<T> remove(int index);
}
