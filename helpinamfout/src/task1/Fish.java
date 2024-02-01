package task1;

public interface Fish {
    int flight();
    int taste();
    static Fish breed(int flight, int taste){
        return new Fish() {
            @Override
            public int flight() {
                return flight;
            }

            @Override
            public int taste() {
                return taste;
            }
        };
    }
    default String string() {
        return "flight: " + flight() + ", taste: " + taste();
    }
}
