public class Inner<T> implements Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;
    private int lsize;
    private int rsize;

    public Inner(T value){
        this.value = value;
        this.left = new Leaf<>();
        this.right = new Leaf<>();
        lsize = left.size();
        rsize = right.size();
    }

    public int size(){
        return lsize + rsize;
    }

    public T get(int i){
        if(i <= 0 || i >= size())
            throw new IndexOutOfBoundsException();
        if(i < left.size())
            return left.get(i);
        else if(i == left.size())
            return this.value;
        else{
            int j = i - left.size() + 1;
            return right.get(j);
        }
    }

    public void update(int i, T x){
        if(i <= 0 || i >= size())
            throw new IndexOutOfBoundsException();
        if(i < left.size())
            left.update(i, x);
        else if(i == left.size()){
            this.value = x;
        } else{
            int j = i - left.size() - 1;
            right.update(j,x);
        }
    }

    public Node<T> insert(int i, T x) {
        if (i < 0){
            this.value = x;
            return this;
        }
        if(i >= size()){
            Leaf<T> temp = new Leaf<>(x);
            return temp.insert(i, x);
        }
        if(i == left.size()){
            this.value = x;
            return this;
        }
        else if(i < left.size())
            return left.insert(i, x);
        else{
            int j = i - left.size() +1;
            return right.insert(j,x);
        }
    }

    public Node<T> remove(int i){
        if(i <= 0 || i >= size())
            throw new IndexOutOfBoundsException();
        if (i == left.size()){
            ((Inner<T>)right).setLeft(this.left);
            Inner<T> temp = (Inner<T>) right;
            right = this;

        }
    }

    private Node<T> merge()
    public void setLeft(Node<T> left){
        this.left = left;
    }

    public void setRight(Node<T> right){
        this.right = right;
    }
}
