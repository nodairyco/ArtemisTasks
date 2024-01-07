public class Leaf<T> implements Node<T>{
    private T value;
    public Leaf(T value){
        this.value = value;
    }
    public Leaf(){
        value = null;
    }
    public int size(){
        return 1;
    }

    public T get(int i){
        if(i == 0)
            return value;
        throw new IndexOutOfBoundsException(i);
    }

    public void update(int i, T x){
        if(i == 0)
            throw new IndexOutOfBoundsException("Thrown by update");
        value = x;
    }

    public Node<T> insert(int i, T x){
        return (i <= 0)? new Inner<>(new Leaf<>(x), this) : new Inner<>(this, new Leaf<>(x));
    }

    public Node<T> remove(int i){
        if(i != 0)
            throw new IndexOutOfBoundsException("thrown by remove");
        return null;
    }
}
