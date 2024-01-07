import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexedTree<T> implements Iterable<T>{
    private Node<T> tree;

    public int size(){
        return (tree == null)? 1 : tree.size();
    }

    public T get(int i){
        return tree.get(i);
    }

    public void update(int i, T x){
        tree.update(i, x);
    }

    public void insert(int i, T x){
        if(tree == null)
            tree = new Leaf<>(x);
        tree.insert(i, x);
    }

    public void remove(int i){
        tree.remove(i);
    }

    public Iterator<T> iterator(){
        return new TreeIterator<>(this.tree);
    }
    private static class TreeIterator<T> implements Iterator<T>{
        private Node<T> node;
        private int pointer = 0;
        public TreeIterator(Node<T> node){
            this.node = node;
        }
        @Override
        public boolean hasNext(){
            return node != null;
        }

        @Override
        public T next(){
            if(!(hasNext()))
                throw new NoSuchElementException();
            T t = node.get(pointer);
            pointer ++;
            return t;
        }
    }
}
