package fop.w8inter;

public class Penguin extends Animal implements Comparable, Copyable{
    public String name;
    public double height;
    public Penguin(int age, String name, double height){
        super(age);
        this.name = name;
        this.height = height;
    }
    public Penguin copy(){
        return new Penguin(age, name, height);
    }
    @Override
    public int compareTo(Penguin other){
        if(other.age > this.age){
            return -1;
        } else if(other.age < this.age){
            return 1;
        } else{
            if(other.height > this.height){
                return -1;
            } else if(other.height < this.height){
                return 1;
            } else{
                if(other.name.compareTo(this.name) < 0){
                    return 1;
                } else if(other.name.compareTo(this.name) > 0){
                    return -1;
                } else{
                    return 0;
                }
            }
        }
    }
}
