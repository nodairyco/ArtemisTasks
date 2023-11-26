package pgdp.collections;

public class DataStructureLink<T>{
    private DataStructureConnector<T> first;
    private DataStructureConnector<T> second;
    public DataStructureLink(DataStructureConnector<T> first, DataStructureConnector<T> second){
        this.first = first;
        this.second = second;
    }
    public boolean moveNextFromAToB(){
        T temp = first.removeNextElement();
        second.addElement(temp);
        return true;
    }
    public String toString(){
        return first.toString() + second.toString();
    }
    public void moveAllFromAToB(){
        T temp = null;
        while(first.hasNextElement()) {
            temp = first.removeNextElement();
            second.addElement(temp);
        }
    }
}
