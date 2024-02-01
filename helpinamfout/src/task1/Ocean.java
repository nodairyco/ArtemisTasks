package task1;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class Ocean {
    private Collection<Fish> ocean;
    public Ocean(Fish...fa){
        ocean = new ArrayList<>();
        ocean.addAll(Arrays.asList(fa));
    }

    public void hunt(int speed){
        Optional<Fish> monitor = ocean.stream()
                .filter(e -> e.flight()<speed && e.taste()!=0)
                .findFirst();
        if ((monitor.isPresent())) {
            ocean.remove(monitor.get());
            System.out.println(monitor.get().string());
        } else {
            System.out.println("Nothing!");
        }
    }
}
