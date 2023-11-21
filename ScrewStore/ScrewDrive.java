public enum ScrewDrive {
    /*SlotDrive, Cross, Hex, Torx;
    @Override
    public String toString(){
        return switch(this){
            case Hex -> "hex";
            case Cross -> "Cross";
            case Torx -> "Torx";
            case SlotDrive -> "Slot Drive";
        };
    }*/
    //Though this worked Helmut said: "Fruitless be thine endevourse!", and made me do this:
    SlotDrive {
        @Override
        public String toString() {
            return "schlitz";
        }
    },

    Cross {
        @Override
        public String toString() {
            return "kreuzschlitz";
        }
    },

    Hex {
        @Override
        public String toString() {
            return "sechskant";
        }
    },

    Torx {
        @Override
        public String toString() {
            return "torx";
        }
    };

    @Override
    public abstract String toString();
}


