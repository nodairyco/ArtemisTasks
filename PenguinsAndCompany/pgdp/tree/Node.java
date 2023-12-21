package pgdp.tree;

import java.util.*;
import java.util.List;

public class Node<T>{
    private T data;
    private List<Node<T>> children;
    private Node<T> parent;

    public Node(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
    public void insert(Node<T> value) {
        // TODO
        this.children.add(value);
        value.parent = this;
    }

    public boolean isLeaf() {
        // TODO
        return children.isEmpty();
    }

    public int size() {
       // TODO
       int maxSize = 0;
       if(this.isLeaf())
           return maxSize + 1;
       else {
           for (Node<T> i : children) {
               maxSize += i.size();
           }
       }
       return maxSize + 1;
    }

    public void remove() {
       // TODO
        if(this.parent != null)
            this.parent.children.remove(this);
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }
    public Node<T> traversal(Node<T> target) {
        if(this.getData().equals(target.getData()))
            return this;
        else {
            for (Node<T> i : children) {
                Node<T> temp = i.traversal(target);
                if(temp != null)
                    return temp;
            }
        }
        return null;
    }
    public Node<T> findNode(Node<T> target){
        return this.traversal(target);
    }
}
