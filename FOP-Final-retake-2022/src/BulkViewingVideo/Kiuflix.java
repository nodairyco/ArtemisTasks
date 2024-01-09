package BulkViewingVideo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;
import java.nio.file.*;

public class Kiuflix<V extends Video> {
    private Stream<V> stream;
    private List<V> downloads;
    private int budget, cost;
    public Kiuflix(Stream<V> s, int b, int c){
        stream = s;
        budget = b;
        cost = c;
    }

    public void bulkView(Predicate<V> pred){
        var list = stream.filter(pred)
                .toList();
        List<V> tempList = new ArrayList<>();
        int tempBudget = budget;
        for(V v : list){
            budget -= cost;
            if(budget >= 0){
                tempList.add(v);
            }
        }
        budget = tempBudget;
        tempList.forEach(t -> {
            t.view();
            budget -= cost;
        });

        System.out.printf("\nRemaining budget:\t" + budget);
    }

    public static void main(String[] args) throws IOException {
        Kiuflix<MyVideo> kiuflix = new Kiuflix<>(Files.lines(Path.of(args[0]))
                .map(MyVideo::new), 100, 15);
        kiuflix.bulkView((t) -> t.title().length() % 4 == 1);
    }

    public static class MyVideo implements Video {
        private String title;
        public MyVideo(String title){
            this.title = title;
        }

        @Override
        public String title(){
            return title;
        }

        @Override
        public void view(){
            System.out.println(title);
        }

        @Override
        public void skip(){}
    }
}
