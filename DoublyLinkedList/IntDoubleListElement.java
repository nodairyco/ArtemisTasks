public class IntDoubleListElement{
    private int info;
    public IntDoubleListElement next;
    public IntDoubleListElement prev;
    public IntDoubleListElement(int info){
        this.info = info;
        next = null;
        prev = null;
    }
    public IntDoubleListElement(int info, IntDoubleListElement next){
        this.info = info;
        this.next = next;
        prev = null;
    }
    public IntDoubleListElement(int info, IntDoubleListElement next, IntDoubleListElement prev){
        this.info = info;
        this.next = next;
        this.prev = prev;
    }
    public int getInfo(){
        return info;
    }
    public void setInfo(int info){
        this.info = info;
    }
    public boolean isEqual(IntDoubleListElement other) {
        if(other == null)return false;
        return other.getInfo() == this.info;
    }
}
