package Dictionary;
import java.util.*;

public class Dictionary<T> {
    private Map<Character, Dictionary<T>> map;
    private T value;
    public Dictionary(){
        map = new HashMap<>();
    }
    public void record(String s, T value){
        if(s.length() == 1){
            return;
        }
        Character firstCharOfString = s.charAt(0);
        String tempString = s.substring(1);
        if(this.value == null){
            Dictionary<T> dict = new Dictionary<T>();
            dict.value = value;
            map.put(firstCharOfString, dict);
            dict.record(tempString, value);
        }
        if(map.containsKey(firstCharOfString)){
            map.get(firstCharOfString).record(tempString, value);
        } else{
            Dictionary<T> dictionary = new Dictionary<T>();
            map.put(firstCharOfString, dictionary);
            dictionary.record(tempString, value);
        }
    }

    public T lookup(String s){
        if(s.isEmpty()){
            return null;
        }
        var tempString = (s.length() >= 2)? s.substring(1) : s;
        Character firstCharOfString = s.charAt(0);
        if(map.containsKey(firstCharOfString)){
            return map.get(firstCharOfString).value;
        } else {
            var temp = map.get(firstCharOfString);
            return temp.lookup(tempString);
        }
    }

    public T remove(String s){
        if(s == null || s.isEmpty()){
            return null;
        }
        var tempString = (s.length() >= 2)? s.substring(1) : s;
        Character firstCharOfString = s.charAt(0);
        if(map.containsKey(firstCharOfString)){
            return map.remove(firstCharOfString).value;
        } else {
            var temp = map.get(firstCharOfString);
            return temp.remove(tempString);
        }
    }

    public boolean isEmpty(){
        return value == null && map.isEmpty();
    }
    public static void main(String[] args) {
        Dictionary<Meaning<Integer>> temp = new Dictionary<Meaning<Integer>>();
        temp.record(args[0], () -> 0);
        temp.record(args[1], () -> 1);
        temp.record(args[2], () -> 2);
        System.out.println(temp.isEmpty());
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i] + ": " + temp.remove(args[i]).meaning());
        }
        System.out.println(temp.isEmpty());
    }
}
