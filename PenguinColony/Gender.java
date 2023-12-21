package fop.w9colony;

public enum Gender {
    FEMALE, MALE
    public String toString(){
        return switch(this){
            case MALE -> "male";
            case FEMALE -> "female";
        };
    }
}
