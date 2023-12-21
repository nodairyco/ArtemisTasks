package fop.w9colony;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class PenguinColony {

    private HashSet<Penguin> penguins;

    public PenguinColony(HashSet<Penguin> penguins) {
        this.penguins = penguins;
    }

    public HashSet<Penguin> getPenguins() {
        return penguins;
    }

    public void setPenguins(HashSet<Penguin> penguins) {
        this.penguins = penguins;
    }

    public void uniteColonies(PenguinColony otherColony) {
        // TODO
        HashSet<Penguin> temp = new HashSet<>();
        for(Penguin i : penguins){
            temp.add(i);
        }
        for(Penguin i : otherColony.penguins){
            temp.add(i);
        }
        otherColony.penguins.clear();
        this.penguins = temp;
    }

    public PenguinColony splitColony(Predicate<? super Penguin> pred) {
        // TODO
        HashSet<Penguin> result = new HashSet<>();
        for(Penguin i : penguins){
            if(pred.test(i))
                result.add(i);
        }
        return new PenguinColony(result);
    }

    public Penguin findFirstFriend(LinkedList<Penguin> penguinFriends) {
        // TODO
        Penguin check = null;
        for(Penguin i : penguins){
            for(Penguin j : penguinFriends){
                if (i.hashCode() == j.hashCode()){
                    check = i;
                    break;
                }
            }
        }
        return check;
    }

    public boolean canFeedPenguinsWithProperty(Predicate<? super Penguin> pred, Set<Fish> fishes) {
        // TODO
        Set<Penguin> predSatisfied = this.splitColony(pred).getPenguins();
        boolean satisfies = false;
        for(Penguin i : predSatisfied){
            if(!(fishes.contains(i.getFavoriteFish()))) {
                satisfies = false;
                break;
            }else
                satisfies = true;

        }
        return satisfies;
    }

    public int computeSum(Function<? super Penguin, Integer> fun) {
        // TODO
        int sum = 0;
        for(Penguin i : penguins){
            sum += fun.apply(i);
        }
        return sum;
    }
}
