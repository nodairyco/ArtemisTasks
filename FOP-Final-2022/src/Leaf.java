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
            throw new IndexOutOfBoundsException("This exception was thrown by get");
        return value;
    }

    public void update(int i, T x){
        if(i == 0)
            throw new IndexOutOfBoundsException("Thrown by update");
        value = x;
    }

    public Node<T> insert(int i, T x){
        Inner<T> temp = new Inner<>(value);
        if(i <= 0){
            temp.setLeft(new Leaf<>(x));
            temp.setRight(this);
        } else {
            temp.setRight(new Leaf<>(x));
            temp.setLeft(this);
        }
        return temp;
    }

    public Node<T> remove(int i){
        if(i != 0)
            throw new IndexOutOfBoundsException("thrown by remove");
        return null;
    }
}
