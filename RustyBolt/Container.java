import java.util.*;
public class Container<T extends Marketable> {
    private Map<Integer, List<T>> items = new HashMap<>();
    public void addItem(T item){
        if(item == null)
            throw new IllegalArgumentException();
        if(!items.containsKey(items.hashCode())){
            List<T> current = new ArrayList<>();
            current.add(item);
            items.put(items.hashCode(), current);
            return;
        }
        List<T> current = items.get(items.hashCode());
        current.add(item);
        items.put(items.hashCode(), current);
    }

    public void remove(T item){
        if(item == null)
            throw new IllegalArgumentException();
        if(!(items.containsKey(item.hashCode())))
            throw new IllegalArgumentException();
        List<T> current = items.get(item.hashCode());
        if(current.size() == 1){
            items.remove(item.hashCode());
            return;
        }
        current.remove(item);
        items.put(item.hashCode(), current);
    }

    public int checkout(){
        return items.values().stream()
                .mapToInt(t -> t.size() * t.stream().mapToInt(m -> m.getPrice()).sum())
                .sum();
    }
    public static void main(String[] args) {
        Bolt a = new Bolt("hi",19);
        Bolt b = new Bolt("hi", 10);
    }
}

