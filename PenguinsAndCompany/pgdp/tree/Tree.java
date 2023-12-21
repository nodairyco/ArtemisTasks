package pgdp.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T> {

    private Node<T> root;

    public Tree (T data) {
        root = new Node<>(data);
    }

    public void insert(T value, T parent) {
       // TODO
        Node<T> temp = root.findNode(new Node<>(parent));
        if(temp == null)
            throw new IllegalArgumentException("Parent not found");
        temp.insert(new Node<>(value));
    }

    public void remove(T value) {
        // TODO
        Node<T> temp = root.findNode(new Node<>(value));
        if(temp != null)
            temp.remove();
    }
      public T LCA(T a, T b) {
        // TO-DO
        Node<T> nodeA = root.findNode(new Node<>(a));
        Node<T> nodeB = root.findNode(new Node<>(b));
        Node<T> result = null;

        LinkedList<Node<T>> ancestorsA = new LinkedList<>();

        while(nodeA != null){
            ancestorsA.add(nodeA);
            nodeA = nodeA.getParent();
        }

        while(nodeB != null){
            if(ancestorsA.contains(nodeB)){
                result = nodeB;
                break;
            }

            nodeB = nodeB.getParent();
        }
        if(result != null)
            return result.getData();
        else
            return null;
    }

    public int distanceBetweenNodes(T a, T b) {
        // TO-DO
        T lcaVal = LCA(a, b);
        Node<T> ancestor = root.findNode(new Node<>(lcaVal));
        Node<T> nodeA = root.findNode(new Node<>(a));
        Node<T> nodeB = root.findNode(new Node<>(b));
        int counterA = 0;
        int counterB = 0;
        while(nodeA != ancestor){
            ++counterA;
            nodeA = nodeA.getParent();
        }

        while(nodeB != ancestor){
            ++counterB;
            nodeB = nodeB.getParent();
        }

        return counterA + counterB;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public boolean containsKey(T key) {
        // TODO
        return root.findNode(new Node<>(key)) != null;
    }

    public void traversal() {
        // TODO
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<T> temp = queue.poll();
            System.out.println(temp.getData());
            queue.addAll(temp.getChildren());
        }
    }

}
