package fop.w9colony;

import java.util.Objects;

public class Penguin {
    private final int birthYear;
    private final String name;
    private final Gender gender;
    private Fish favoriteFish;

    public Penguin(int birthYear, String name, Gender gender, Fish favoriteFish) {
        this.birthYear = birthYear;
        this.name = name;
        this.gender = gender;
        this.favoriteFish = favoriteFish;
    }

    public boolean equals(Object other) {
        // TODO
        if(other == null)
            return false;
        if(!(other instanceof Penguin))
            return false;
        Penguin temp = (Penguin) other;
        return temp.hashCode() == this.hashCode();
    }

    public int hashCode() {
        // TODO
        return Objects.hash(name, birthYear, gender.toString());
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Fish getFavoriteFish() {
        return favoriteFish;
    }

    public void setFavoriteFish(Fish favoriteFish) {
        this.favoriteFish = favoriteFish;
    }

}
