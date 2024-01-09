package indexedtree;

import indexedtree.Leaf;

public class Inner<T> implements Node<T> {
    Node<T> left;
    Node<T> right;
    int lsize;
    int rsize;
    public Inner(Leaf<T> left, Leaf<T> right){
        this.left = left;
        this.right = right;
        lsize = left.size();
        rsize = right.size();
    }
    @Override
    public int size(){
        return lsize + rsize;
    }

    @Override
    public T get(int i) {
        return (i < lsize)? left.get(i) : right.get(i - lsize);
    }
    @Override
    public Node<T> insert(int i, T x){
        if(i < 0)
            return insert(0, x);
        if(i >= size())
            return insert(size(), x);
        return (i < lsize)? left.insert(i, x) : right.insert(i - lsize, x);
    }
    @Override
    public Node<T> remove(int i){
        if(i > size() || i < 0)
            throw new IndexOutOfBoundsException(i);
        return (i < lsize)? left.remove(i) : right.remove(i - lsize);
    }
    @Override
    public void update(int i, T x){
        if (i < lsize) {
            left.update(i, x);
        } else {
            right.update(i - lsize, x);
        }
    }
}
