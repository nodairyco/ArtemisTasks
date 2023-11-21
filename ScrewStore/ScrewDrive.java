package fop.w9store;

public enum ScrewDrive {
    SlotDrive, Cross, Hex, Torx;
    @Override
    public String toString(){
        return switch(this){
            case Hex -> "hex";
            case Cross -> "Cross";
            case Torx -> "Torx";
            case SlotDrive -> "Slot Drive";
        };
    }
    //I understand this does nothing,
    //but at the same time I don't know the Georgian translations
}
