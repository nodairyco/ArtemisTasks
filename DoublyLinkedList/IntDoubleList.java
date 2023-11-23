public class IntDoubleList {
    private IntDoubleListElement head;
    private IntDoubleListElement tail = null;
    public IntDoubleList(){
        this.head = null;
    }
    public IntDoubleListElement getFirstElement(){
        return head;
    }
    public IntDoubleListElement getLastElement(){
        return tail;
    }
    public void append(int info){
        IntDoubleListElement temp = new IntDoubleListElement(info);
        if(head == null){
            head = temp;
            tail = temp;
        } else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }
    public int size(){
        int temp = 0;
        for(IntDoubleListElement i = head; i != null; i = i.next){
            temp++;
        }
        return temp;
    }
    public int get(int pos){
        if(pos < 0){
            throw new IndexOutOfBoundsException("Position cannot be negative: " + pos);
        }
        IntDoubleListElement current = head;
        int temp = 0;
        while(current != null){
            if(temp == pos){
                return current.getInfo();
            }
            temp ++;
            current = current.next;
        }
        return -1;
    }
    public void remove(int pos){
        IntDoubleListElement current = head;
        int temp = 0;
        while(current != null){
            if(temp == pos){
                if(current.prev != null){
                    current.prev.next = current.next;
                }else{
                    head = current.next;
                }
                if(current.next != null){
                    current.next.prev = current.prev;
                }else{
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
            temp++;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        IntDoubleListElement current = head;
        while(current != null){
            if(current.next != null){
                sb.append(current.getInfo()).append(", ");
            } else{
                sb.append(current.getInfo());
            }
            current = current.next;
        }
        return sb.append(']').toString();
    }
    public boolean isEqual(IntDoubleList other){
        IntDoubleListElement current = head;
        IntDoubleListElement otherCurrent = other.head;
        if(current == null && otherCurrent == null){
            return true;
        }else if(current == null || otherCurrent == null){
            return false;
        }

        while(current != null && otherCurrent != null){
            if(current.getInfo() != otherCurrent.getInfo()){
                return false;
            }

            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return current == null && otherCurrent == null;
    }
    public int sum(){
        int sum = 0;
        for(IntDoubleListElement i = head; i != null; i = i.next){
            sum += i.getInfo();
        }
        return sum;
    }
    public IntDoubleList copy(){
        IntDoubleList result = new IntDoubleList();
        for(IntDoubleListElement i = head; i != null; i = i.next){
            result.append(i.getInfo());
        }
        return result;
    }
    public IntDoubleListElement[] search(int value){
        int resultSize = 0;
        for(IntDoubleListElement i = head; i != null; i = i.next){
            if(i.getInfo() == value){
                resultSize++;
            }
        }
        IntDoubleListElement[] result = new IntDoubleListElement[resultSize];
        IntDoubleListElement current = head;
        int temp = 0;
        while(current != null && temp < resultSize){
            if(current.getInfo() == value){
                result[temp] = current;
                temp++;
            }
            current = current.next;
        }
        return result;
    }
}
